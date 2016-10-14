/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mybankmachine;

/**
 * Works like a bank account, except it's called an ATM.
 * @author DaTho7561
 */
public class ATM {
    
    public static final double DEFAULT_INTEREST = 0.015;
    
    private double balance;
    private String bankName;
    private double yearlyInterest;
    
    /**
     * Creates a new ATM with the specified balance, bank name, and yearly interest.
     * @param accountBalance
     * @param nameOfBank 
     * @param yearInterest 
     */    
    public ATM(double accountBalance, String nameOfBank, double yearInterest) {
        balance = accountBalance;
        bankName = nameOfBank;
        yearlyInterest = yearInterest;
    }
    
    /**
     * Creates a new ATM with the specified balance and bank name.
     * A default interest of 1.5%
     * @param accountBalance 
     * @param nameOfBank 
     */    
    public ATM(double accountBalance, String nameOfBank) {
        this(accountBalance, nameOfBank, DEFAULT_INTEREST);
    }
    
    /**
     * Creates a new ATM with the specified balance and bank name.
     * @param nameOfBank 
     */    
    public ATM(String nameOfBank) {
        this(0, nameOfBank, DEFAULT_INTEREST);
    }
    
    /**
     * Creates a new ATM with a balance of zero and a blank bank name. <br />
     * pre: none <br />
     * post: new ATM created <br />
     */
    public ATM() {
        this("");
    }
    
    /**
     * Deposits the specified amount of money into the ATM. <br />
     * pre: amount must be positive <br />
     * post: amount is deposited
     * @param amount a positive amount to be deposited
     */
    public void deposit(double amount) {        
        if (amount > 0) {
            balance += amount;
        } else {
            System.err.println("Please enter a positive amount to deposit.");
        }
    }
    
    /**
     * 
     * @param amount The amount of money to withdraw
     * @return a String that creates a message indicating the level of
     * success of the withdrawal
     */
    public String withdraw(double amount) {
        if (amount > 0 && balance - amount > 0) {
            balance -= amount;
            return ("Withdrew $" + amount);
        } else if(!(amount > 0)) {
            System.err.println("Please enter a positive amount to withdraw.");
            return "Please enter a positive amount to withdraw.";
        } else {
            System.err.println("Insufficient funds to withdraw");
            return "Insufficient funds to withdraw";
        }
    }
    
    /**
     * Applies interest given the number of days and the annual interest rate. <br />
     * pre: <code>days</code> is a positive integer, and <code>annualInterestRate</code>
     * is a decimal number<br />
     * post: Interest rate is applied
     * @param days The number of days of interest to apply
     * @param annualInterestRate the annual interest rate, as a decimal
     */
    public void applyInterest(int days, double annualInterestRate) {
        
        if (days > 0) {
            double initialAmount, finalAmount;
            
            initialAmount = balance;
            
            finalAmount = initialAmount * Math.pow((1 + (annualInterestRate) / 365.25), days);
            
            balance = finalAmount;
        } else {
            System.err.println("Please enter a positive, non-zero day number");
        }
        
    }
    
    /**
     * Applies interest given the number of days to apply
     * @param days 
     */
    public void applyInterest(int days) {
        this.applyInterest(days, yearlyInterest);
    }
    
    /**
     * Returns the balance of this bank account.
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
    
    
}
