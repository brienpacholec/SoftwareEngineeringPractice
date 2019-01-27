package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        balance -= amount;

    }

    /**
     * isEmailValid checks to determine if a desired input is valid
     * It may have any character excluding '~ ` < >'
     * It cannot start with @
     * It must then followed by an @ and then a .edu, .com, .org, or .gov
     * Emails cannot be over 32 characters in length
     */
    public static boolean isEmailValid(String email){

        if (email.length() > 32 || email.length()==-1){
            return false;
        }

        else {

            if (email.indexOf('@') == -1 || email.indexOf('@') == 0) {
                return false;
            }
            if (email.indexOf('~') != -1 || email.indexOf('`') != -1 || email.indexOf('<') != -1 || email.indexOf('>') != -1) {
                return false;
            }
            if (!email.endsWith(".edu") || !email.endsWith(".com") || !email.endsWith(".org") || !email.endsWith(".gov")) {
                return false;
            }

            return true;
        }




    }
}
