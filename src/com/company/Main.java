package com.company;

public class Main {
    public static void main(String[] args) {
        boolean result = Validator.check("Test_99", "zon123_a", "zon123_a");
        if (result) {
            System.out.println("Логин и пароль корректные");
        } else {
            System.out.println("Логин и/или пароль не корректный");
        }
    }

}