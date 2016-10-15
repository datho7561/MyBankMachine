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
     * Creates a new ATM with the specified balance, bank name, and yearly interest. <br />
     * <b> pre: </b> <code> accountBalance </code> is 0 or greater, otherwise it
     * will be set to 0. <code> yearlyInterest </code> must be between 0 and 1,
     * otherwise, it will be set to the default value.<br />
     * <b> post: </b> A new ATM is created.
     * @param accountBalance The initial amount of money the account has.
     * @param nameOfBank The name of the bank this ATM represents.
     * @param yearInterest The yearly interest rate, expressed as a decimal (between 0 and 1)
     */    
    public ATM(double accountBalance, String nameOfBank, double yearInterest) {
        balance = (accountBalance >= 0)? accountBalance: 0;
        bankName = nameOfBank;
        yearlyInterest = (yearInterest > 0 && yearInterest < 1)? yearInterest: DEFAULT_INTEREST;
    }
    
    /**
     * Creates a new ATM with the specified balance and bank name.
     * Has the default interest of 1.5% <br />
     * <b> pre: </b> accountBalance is 0 or greater, otherwise it will be set to 0. <br />
     * <b> post: </b> A new ATM is created. <br />
     * @param accountBalance The initial amount of money the account has.
     * @param nameOfBank The name of the bank this ATM represents.
     */    
    public ATM(double accountBalance, String nameOfBank) {
        this(accountBalance, nameOfBank, DEFAULT_INTEREST);
    }
    
    /**
     * Creates a new ATM with the specified bank name. <br />
     * <b> pre: </b> none <br />
     * <b> post: </b> New ATM created.
     * @param nameOfBank The name of the bank this ATM represents.
     */    
    public ATM(String nameOfBank) {
        this(0, nameOfBank, DEFAULT_INTEREST);
    }
    
    /**
     * Creates a new ATM with a balance of zero, default interest rate, and a blank bank name. <br />
     * <b> pre: </b> none <br />
     * <b> post: </b> new ATM created <br />
     */
    public ATM() {
        this("");
    }
    
    /**
     * Deposits the specified amount of money into the ATM. <br />
     * <b> pre: </b> amount must be positive <br />
     * <b> post: </b> amount is deposited
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
     * Withdraws the specified amount of money from the ATM if doing so doesn't
     * make the balance negative. <br />
     * <b> pre: </b> <code>amount</code> is a positive number that is less than or equal
     * to the balance. <br />
     * <b> post: </b> The ATM's balance is adjusted accordingly, and a <code>String</code>
     * is returned representing the success of the withdrawal.
     * @param amount The amount of money to withdraw. This must be positive.
     * @return a <code>String</code> that creates a message indicating the level of
     * success of the withdrawal.
     */
    public String withdraw(double amount) {
        if (amount > 0 && balance - amount >= 0) {
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
     * <b> pre: </b> <code>days</code> is a positive integer, and <code>annualInterestRate</code>
     * is a decimal number<br />
     * <b> post: </b> Interest rate is applied
     * @param days The number of days of interest to apply
     * @param annualInterestRate the annual interest rate, as a decimal
     */
    public void applyInterest(int days, double annualInterestRate) {
        
        if (days > 0) {
            double initialAmount, finalAmount;
            
            initialAmount = balance;
            
            finalAmount = initialAmount * Math.pow((1 + (annualInterestRate) / 365.25), days);
            
            finalAmount = ((int)(finalAmount*100))/100.0;
            
            balance = finalAmount;
        } else {
            System.err.println("Please enter a positive, non-zero day number");
        }
        
    }
    
    /**
     * Applies interest given the number of days. <br />
     * <b> pre: </b> <code>days</code> is a positive integer, and <code>annualInterestRate</code>
     * is a decimal number.<br />
     * <b> post: </b> Interest rate is applied
     * @param days Number of days of interest to apply.
     */
    public void applyInterest(int days) {
        this.applyInterest(days, yearlyInterest);
    }
    
    /**
     * Sets a new yearly interest rate value for this ATM. <br />
     * <b> pre: </b> The <code>newRate</code> is between 0 and 1. <br />
     * <b> post: </b> The interest rate of this ATM is changed.
     * @param newRate A decimal interest rate between 0 and 1 exclusively
     */
    public void setInterestRate(double newRate) {
        yearlyInterest = (newRate < 1 && newRate >0)? newRate: yearlyInterest;
    }
    
    /**
     * Returns the balance of this bank account. <br />
     * <b> pre: </b> none <br />
     * <b> post: </b> Balance is returned
     * @return This ATM's <code>balance</code>
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns this ATM's interest rate. <br />
     * <b> pre: </b> none <br />
     * <b> post: </b> interest rate returned.
     * @return this ATM's interest rate
     */
    public double getInterestRate() {
        return yearlyInterest;
    }
    
    
}
