package khoankd.example;

import java.util.logging.Logger;

public class InterfaceFieldModificationExample {

    private static final Logger logger = Logger.getLogger(InterfaceFieldModificationExample.class.getName());

    public static void main(String[] args) {
        logger.info(String.format("Max users allowed: %d", Constants.MAX_USERS));
    }
}
