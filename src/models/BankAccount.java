package models;

public abstract class BankAccount {

    protected double balance;
    protected int numberOfDepositsThisMonth;
    protected int numberOfWithdrawals;
    protected double annualInterestRate;
    protected double monthlyServiceCharges;

    public BankAccount(
        double balance,
        double annualInterestRate
        ) {
            this.balance            = balance;
            this.annualInterestRate = annualInterestRate;
    }

    /**
     * A method that accepts an argument for the amount of deposit. 
     * The method should add the argument to the account balance. 
     * It should also increment the variable holding the number of 
     * deposits.
     */
    public void deposit(double amount)
    {
        balance += amount;
        numberOfDepositsThisMonth ++;
    }

    /**
     * A method that accepts an argument for the amount of the
     * withdrawal. The method should subtract the argument from 
     * the balance. It should also increment the variable holding 
     * the number of withdrawals.
     *
     */
    public void withdraw(double amount)
    {
        balance -= amount;
        numberOfWithdrawals ++;
    }

    /**
     * A method that updates the balance by calculating the monthly 
     * interest earned by the account, and adding this interest to 
     * the balance.
     *
     * This is performed by the following formulas:
     *
     * Monthly Interest Rate = (Annual Interest Rate/12)
     * Monthly Interest = Balance * Monthly Interest Rate
     * Balance = Balance + Monthly Interest
     */
    public void calcInterest()
    {
        double monthlyInterestRate  = annualInterestRate / 12;
        double monthlyInterest      = balance * monthlyInterestRate;
        balance                     = balance + monthlyInterest;
    }

    /**
     * A method that subtracts the monthly service charges from the 
     * balance, calls the calcInterest method, and then sets the 
     * variable that holds the number of withdrawals, number of 
     * deposits, and monthly service charge to zero.
     */
    public void monthlyProcess()
    {
        balance -= monthlyServiceCharges;
        calcInterest();

        numberOfWithdrawals         = 0;
        numberOfDepositsThisMonth   = 0;
        monthlyServiceCharges       = 0;
    }
}