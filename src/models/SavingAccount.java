package models;

public class SavingAccount extends BankAccount {

    public SavingAccount(double balance, double annualInterestRate) {
        super(balance, annualInterestRate);
    }
    
    protected boolean accountIsActive()
    {
        return super.balance > 25;
    }

    /**
     * A method that determines whether the account is inactive 
     * before a withdrawal is made. No withdrawal will be allowed 
     * if the account is not active. A withdrawal is then made by 
     * calling the super-class version of the method
     */
    @Override
    public void withdraw(double amount) {
        if(accountIsActive())
            super.withdraw(amount);
    }

    /**
     * Before the super-class method is called, this method checks the 
     * number of withdrawals. If the number of withdrawals for the month 
     * is more than 4, a service charge of $1 for each withdrawal above 
     * 4 is added to the super-class fields that hold the monthly 
     * service charges. (Don’t forget the check the account balance after the service charge is taken. If the balance falls below $25, the account becomes inactive.)
     */
    @Override
    public void monthlyProcess() {
        if(super.numberOfWithdrawals > 4)
            super.monthlyServiceCharges += numberOfWithdrawals - 4;
        
        super.monthlyProcess();
    }

    public double getCurrentBalance() { return super.balance; }
    public double getCurrentAnualInterest() { return super.annualInterestRate; }
    public int getCurrentNumberOfDeposits() { return super.numberOfDepositsThisMonth;}
    public int getCurrentNumberOfWithdraw() { return super.numberOfWithdrawals; }

}
