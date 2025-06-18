package khoankd.example;

import java.util.logging.Logger;

public class NullPointerExample {

    private static final Logger logger = Logger.getLogger(NullPointerExample.class.getName());

    public static void main(String[] args) {
        String text = "Hello"; // Gán giá trị hợp lệ

        @SuppressWarnings("java:S2583") /* ignore always true expression warning */
        if (text != null && !text.isEmpty()) {
            logger.info("Text is not empty");
        }

    }
}
