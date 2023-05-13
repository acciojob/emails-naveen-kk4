package com.driver;

public class Email {

    private String emailId;
    private String password;
    // 1 sec , why is mails class having green colour ?
    // is that a problem ?


    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }
    public boolean isValid(String a){
        if(a.length()<8)return false;
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean special = false;
        for(int i = 0;i<a.length();i++){
            char ch = a.charAt(i);
            if(ch>='a' && ch<='z')lower = true;
            else if(ch>='A' && ch<='Z')upper = true;
            else if(ch>='0' && ch<='9')digit=true;
            else special = true;

        }
        return upper && lower && digit && special;
    }

    public void changePassword(String oldPassword, String newPassword){
       if(!oldPassword.equals(password))return;
        if(!isValid(newPassword))return;
        this.password = newPassword;
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
