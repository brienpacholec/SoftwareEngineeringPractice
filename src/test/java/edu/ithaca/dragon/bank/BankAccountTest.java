package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {

        //Over withdrawal
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(201);
        assertEquals(200, bankAccount.getBalance());

        //Valid withdrawal
        bankAccount.withdraw(50);
        assertEquals(150,bankAccount.getBalance());

        //Invalid withdrawal
        bankAccount.withdraw(-100);
        assertEquals(150, bankAccount.getBalance());

        //Valid withdrawal
        bankAccount.withdraw(150);
        assertEquals(0, bankAccount.getBalance());

        //Insufficient funds
        bankAccount.withdraw(100);
        assertEquals(0, bankAccount.getBalance());
    }


    @Test
    void isEmailValidTest(){

        assertTrue(BankAccount.isEmailValid("ab@gmail.com"));
        assertTrue(BankAccount.isEmailValid("a@b.com"));

        assertFalse(BankAccount.isEmailValid("a@yahoo.you"));
        assertFalse(BankAccount.isEmailValid("@gmail.com"));
        assertFalse(BankAccount.isEmailValid("lame<@gmail.com"));
        assertFalse(BankAccount.isEmailValid("lame>@gmail.edu"));
        assertFalse(BankAccount.isEmailValid("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com"));
        assertFalse(BankAccount.isEmailValid("a@@gmail.com"));
    }

    @Test
    void isAmountValidTest(){

        //Valid Amounts
        assertTrue(BankAccount.isAmountValid(1));
        assertTrue(BankAccount.isAmountValid(100.1));
        assertTrue(BankAccount.isAmountValid(1.21));
        assertTrue(BankAccount.isAmountValid(.38));

        //Invalid Amounts
        assertFalse(BankAccount.isAmountValid(1.234));
        assertFalse(BankAccount.isAmountValid(-1));
        assertFalse(BankAccount.isAmountValid(112.2341));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -1000));
    }

}