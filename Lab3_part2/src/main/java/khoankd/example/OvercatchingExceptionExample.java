package khoankd.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OvercatchingExceptionExample {

    private static final Logger logger = Logger.getLogger(OvercatchingExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            int[] arr = new int[5];

            if (logger.isLoggable(Level.INFO)) {
                logger.info(String.format("Accessing index 10: %d", arr[10])); // sẽ ném lỗi
            }

        } catch (ArrayIndexOutOfBoundsException ex) {
            logger.log(Level.SEVERE, String.format("Array index out of bounds: %s", ex.getMessage()), ex);
        }
    }
}
