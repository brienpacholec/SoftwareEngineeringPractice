package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email) && isAmountValid(startingBalance)){
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
     * Checks to see if the balance is appropriate
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        if(isAmountValid(amount)) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
            }
        }
    }

    /**
     * isEmailValid checks to determine if a desired input is valid
     * It may have any character excluding '~ ` < >'
     * It cannot start with @
     * It must then followed by an @ and then a .edu, .com, .org, or .gov
     * Emails cannot be over 32 characters in length
     * @param email a string that is the desired email
     *
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
            if (email.endsWith(".com") || email.endsWith(".edu") || email.endsWith(".gov") || email.endsWith(".org")) {

                return true;
            }

            return false;

        }




    }


    /**
     * isAmountValid checks to see if the double in question is both positive and only has two or less decimal places
     * @param amount the double in question
     * @return a boolean to see if the amount is valid
     *
     */
    public static boolean isAmountValid(double amount){
        if(amount>0){
            String word = Double.toString(amount);
            int len = word.length();

            for (int i = 0; i < len; i++) {
                if (word.charAt(i) == '.'){
                    if(len-i-1 > 2){
                        return false;
                    }
                }
            }
            return true;
        }

        return false;
    }
}
