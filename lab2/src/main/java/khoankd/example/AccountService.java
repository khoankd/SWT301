package khoankd.example;

public class AccountService {

    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.isEmpty()) return false;
        if (password == null || password.length() <= 6) return false;
        return isValidEmail(email);
    }

    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$");
    }

    public boolean isStrongPassword(String password) {
        if (password == null || password.length() <= 6) return false;
        return password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{7,}");
    }

    public String normalizeEmail(String email) {
        return email == null ? null : email.trim().toLowerCase();
    }
}
