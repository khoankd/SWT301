package khoankd.example;

import java.util.logging.Logger;

class User {
    private static final Logger logger = Logger.getLogger(User.class.getName());

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        logger.info(String.format("Name: %s  Age: %d", name, age));
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

