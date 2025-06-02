package khoankd.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    private static final String INPUT_FILE = "test-data.csv";
    private static final String OUTPUT_FILE = "UnitTest.txt";
    private static final AccountService service = new AccountService();

    @Test
    @DisplayName("Test registerAccount from CSV and write results to file")
    void testRegisterAccountFromCSV() throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream("test-data.csv");
        assertNotNull(is, "CSV file not found!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        List<String> lines = reader.lines().toList();

        List<String> outputLines = new ArrayList<>();
        outputLines.add("username,password,email,expected,result,pass");

        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",", -1);
            String username = parts[0];
            String password = parts[1];
            String email = parts[2];
            boolean expected = Boolean.parseBoolean(parts[3]);

            boolean result = service.registerAccount(username, password, email);
            boolean passed = result == expected;

            outputLines.add(String.format("%s,%s,%s,%s,%s,%s",
                    username, password, email, expected, result, passed ? "PASS" : "FAIL"));

            assertEquals(expected, result, "Mismatch on line: " + (i + 1));
        }

        // Ghi kết quả ra file
        Files.write(Paths.get("UnitTest.txt"), outputLines,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    @ParameterizedTest
    @CsvSource({
            "Password123!,true",
            "abc123,false",
            "pass!,false",
            "Strong@Pass1,true",
            "weak,false"
    })
    @DisplayName("Test isStrongPassword method")
    void testIsStrongPassword(String password, boolean expected) {
        assertEquals(expected, service.isStrongPassword(password));
    }

    @ParameterizedTest
    @CsvSource({
            "' John@Example.com ',john@example.com",
            "'ALICE@MAIL.COM',alice@mail.com",
            "'  test@domain.org',test@domain.org"
    })
    @DisplayName("Test normalizeEmail method")
    void testNormalizeEmail(String input, String expected) {
        assertEquals(expected, service.normalizeEmail(input));
    }


}
