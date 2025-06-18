package khoankd.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CatchGenericExceptionExample {

    private static final Logger logger = Logger.getLogger(CatchGenericExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            String s = "Hello"; // giờ s.length() sẽ là 5

            if (s != null && logger.isLoggable(Level.INFO)) {
                logger.info(String.format("Length: %d", s.length()));
            }


        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Something went wrong", ex);
        }
    }
}
