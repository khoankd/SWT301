package khoankd.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InsecureLoginTest {

    @Test
    void testLoginSuccess() {
        // Tạm thời chỉ kiểm tra không ném exception, có thể mock logger để kiểm tra sau
        assertDoesNotThrow(() -> InsecureLogin.login("admin", System.getenv("ADMIN_PASSWORD")));
    }

    @Test
    void testLoginFail() {
        assertDoesNotThrow(() -> InsecureLogin.login("user", "wrongpassword"));
    }

    @Test
    void testPrintUserInfo() {
        InsecureLogin insecureLogin = new InsecureLogin();
        assertDoesNotThrow(() -> insecureLogin.printUserInfo("John Doe"));
    }
}
