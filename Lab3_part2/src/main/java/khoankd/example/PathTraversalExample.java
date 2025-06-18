package khoankd.example;

import java.io.*;
import java.util.logging.Logger;

import static khoankd.example.HardcodedCredentialsExample.logger;

public class PathTraversalExample {
    public static void main(String[] args) throws IOException {
        String userInput = "../secret.txt";
        File file = new File(userInput);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            logger.info("Reading file: " + file.getPath());
            reader.close();
        }
    }
}

