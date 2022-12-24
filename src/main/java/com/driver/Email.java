package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        // Change password only if the oldPassword is equal to current password and the
        // new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any cha racter apart from
        // alphabets and digits is a special character
        if (getPassword().equals(oldPassword)) {
            Boolean eight = false;
            Boolean upper = false;
            Boolean lower = false;
            Boolean digit = false;
            Boolean special = false;

            for (int i = 0; i < newPassword.length(); i++) {
                if (newPassword.length() >= 8)
                    eight = true;
                if (newPassword.charAt(i) >= 'A' && newPassword.charAt(i) <= 'Z')
                    upper = true;
                else if (newPassword.charAt(i) >= 'a' && newPassword.charAt(i) <= 'z')
                    lower = true;
                else if (Character.getNumericValue(newPassword.charAt(i)) >= 0
                        && Character.getNumericValue(newPassword.charAt(i)) <= 9)
                    digit = true;
                else
                    special = true;
            }

            if (eight && upper && lower && digit && special) {
                setPassword(newPassword);
            }
        }
    }
}
