package models;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class Log {
    
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static String logAccountCreation(SavingAccount account, boolean save)
    {
        String message =  "Account: {Balance: "+ account.getCurrentBalance()+
        " Interest: " + account.getCurrentAnualInterest()+"} was successfully created \n";

        if(save) SaveMessage(message);
        return message;
    }


    public static String logDeposit(double amount, boolean save)
    {
        String message =  "Deposit of " + amount + " was successfuly made.\n";

        if(save) SaveMessage(message);
        return message;
    }


    public static String logWithdraw(double amount, boolean save)
    {
        String message =  "Withdraw of " + amount + " was successfuly made.\n";

        if(save) SaveMessage(message);
        return message;
    }


    public static String logCurrentBalance(SavingAccount account, boolean save)
    {
        String message =  "Your account has a balance of $" + df.format(account.getCurrentBalance()) + "\n"; 

        if(save) SaveMessage(message);
        return message;
    }


    public static String logCurrentAnualInterest(SavingAccount account, boolean save)
    {
        String message =  "Your account has an anual interest of $"+ df.format(account.getCurrentAnualInterest()) + "\n";
        
        if(save) SaveMessage(message);
        return message;
    }


    public static String logCurrentNumberOfDeposits(SavingAccount account, boolean save)
    {
        String message =  "You have perfomed " + account.getCurrentNumberOfDeposits() + " deposits during this month.\n";

        if(save) SaveMessage(message);
        return message;
    }


    public static String logCurrentNumberOfWithdraws(SavingAccount account, boolean save)
    {
        String message =  "You have perfomed " + account.getCurrentNumberOfWithdraw() + " withdraws during this month.\n";

        if(save) SaveMessage(message);
        return message;
    }

    
    public static String logError(String messageToAdd, boolean save)
    {
        String message =  "Error Ocurred. " + messageToAdd + ".\n";

        if(save) SaveMessage(message);
        return message;
    }


    public static String logMonthlyProcess(boolean save)
    {
        String message = "Your monthly process have been completed";

        if(save) SaveMessage(message);
        return message;
    }


    /**
     * Save message passed by parameter in the log file
     * @param message
     */
    public static void SaveMessage(String message)
    {
        try {
            
            FileWriter file = new FileWriter("Log.txt", true);

            file.write(message);
            file.close();

        } catch (IOException e) {
            
        }
    }
}
