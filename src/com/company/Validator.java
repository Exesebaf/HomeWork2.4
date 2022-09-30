package com.company;

public class Validator {

    private static final String VALID_SHARACTERS = "0123456789_absdefghiklmnopqrstuvwxyz_ABSDEFGHIKLMNOPQRSTUVWXYZ";


    private Validator() {
    }


    public static boolean check(String login,
                                String password,
                                String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void validate(String login,
                                 String password,
                                 String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() <= 3 || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть ,больше 3 при этом меньше или равна 20");
        }
        if (password == null || password.length() >= 20) {
            throw new WrongPasswordException("Длина пароля должна быть меньше 20");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать");
        }


        validateCharacters(login, true);
        validateCharacters(password, false);

    }

    private static void validateCharacters(String s,
                                           boolean isLogin) throws WrongLoginException, WrongPasswordException {
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_SHARACTERS.contains(String.valueOf(s.charAt(i)))) {
                if (isLogin) {
                    throw new WrongLoginException("В логине содержаться некорректные символ " + s.charAt(i) + "!");
                } else {
                    throw new WrongPasswordException("В пароле содержаться некорректные символ " + s.charAt(i) + "!");
                }
            }
        }
    }


}
