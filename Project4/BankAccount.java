/**
 * Assignment: Program 4 | BankingSystem
 * Instructions: A banking system designed to read in 3 files and use ArrayLists to store the data and use them to create an ArrayList of BankAccounts
 * Design Notes: No additional design changes were added
 * Version: 1.0, 10/2/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
public class BankAccount {

    private String name;
    private double savingsBalance;
    private double checkingBalance;


    public BankAccount(String newName, double amt1, double amt2) {
        name = newName;
        checkingBalance = amt1;
        savingsBalance = amt2;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName( ) { 
        return name;
    }

    public void setChecking(double amt) {
        checkingBalance = amt;
    }

    public double getChecking( ) {
        return checkingBalance;
    }

    public void setSavings(double amt) {
        savingsBalance = amt;
    }

    public double getSavings( ) {
        return savingsBalance;
    }

    public void depositChecking(double amt) {
        if (amt > 0) {
            checkingBalance += amt;
        }
    }

    public void depositSavings(double amt) {
        if (amt > 0) {
            savingsBalance += amt;
        }
    }

    public void withdrawChecking(double amt) {
        if (amt > 0) {
            checkingBalance -= amt;
        }
    }

    public void withdrawSavings(double amt) {
        if (amt > 0) {
            savingsBalance -= amt;
        }
    }

    public void transferToSavings(double amt) {
        if (amt > 0) {
            checkingBalance -= amt;
            savingsBalance += amt;
        }
    }

	// main
    public static void main(String args[]) {
        BankAccount account = new BankAccount("Mickey", 500.00, 1000.00);
        account.setChecking(500);
        account.setSavings(500);
        account.withdrawSavings(100);
        account.withdrawChecking(100);
        account.transferToSavings(300);

        System.out.println(account.getName()); // Expected Mickey
        System.out.printf("$%.2f\n", account.getChecking()); // Expected 100.0
        System.out.printf("$%.2f\n", account.getSavings()); // Expected 700.0
    } 
}