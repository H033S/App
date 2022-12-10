package models;

public class Drive {
    private SavingAccount account;
    private String message;
    private boolean printToConsole;
    private boolean saveToTXT;

    //CTR
    public Drive(boolean printToConsole, boolean saveToTXT) {
        super();

        this.printToConsole = printToConsole;
        this.saveToTXT      = saveToTXT;
    }

    /**
     * Return True is account is not null, false otherwise
     * @return
     */
    public boolean isAccountInitialized() {return account != null;}

    /**
     * Initiate a Saving account 
     * @param balance
     * @param annualInterestRate
     */
    public void init_account(
        double balance,
        double annualInterestRate)
    {
        account = new SavingAccount(balance, annualInterestRate);
        message = Log.logAccountCreation(account, saveToTXT);

        if(printToConsole) PrintLog(message);
    }

    /**
     * Deposit an amount in the initialized 
     * saving account by calling the saving account 
     * deposit method
     * @param amount
     */
    public void deposit(double amount)
    {
        account.deposit(amount);
        message = Log.logDeposit(amount, saveToTXT);

        if(printToConsole) PrintLog(message);
    }

    /**
     * Withdraw an amount in the initialized 
     * saving account by calling the saving account 
     * withdraw method
     * @param amount
     */
    public void withdraw(double amount)
    {
        account.withdraw(amount);
        message = Log.logWithdraw(amount, saveToTXT);
    
        if(printToConsole) PrintLog(message);
    }

    /**
     * Monthly process
     */
    public void monthlyProcess()
    {
        account.monthlyProcess();
        message = Log.logMonthlyProcess(saveToTXT);

        if(printToConsole) PrintLog(message);
    }


    /**
     * Return the current balance 
     * @return
     */
    public double getCurrentBalance() { 

        message = Log.logCurrentBalance(account, saveToTXT);
        
        if(printToConsole) PrintLog(message);
        return account.getCurrentBalance();

    }


    /**
     * Return the current anual interest 
     * @return
     */
    public double getCurrentAnualInterest() { 

        message = Log.logCurrentAnualInterest(account, saveToTXT);
        
        if(printToConsole) PrintLog(message);
        return account.getCurrentAnualInterest();
    }

    /**
     * Return the current number of deposits 
     * @return
     */
    public int getCurrentNumberOfDeposits() { 
        
        message = Log.logCurrentNumberOfDeposits(account, saveToTXT);
        
        if(printToConsole) PrintLog(message);
        return account.getCurrentNumberOfDeposits();

    }

    /**
     * Return the number of withdraws  
     * @return
     */
    public int getCurrentNumberOfWithdraw() { 
        
        message = Log.logCurrentNumberOfWithdraws(account, saveToTXT);
        
        if(printToConsole) PrintLog(message);
        return account.getCurrentNumberOfWithdraw();
    }

    /**
     * Return the the intance of account 
     * @return
     */
    public SavingAccount geAccount()
    {
        return account;
    }

    /**
     * Print the message to the console
     */
    private void PrintLog(String message)
    {
        System.out.print(message);
    }
}
