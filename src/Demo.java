

import models.Drive;

public class Demo {
   
    private static void currentStatus(Drive drive)
    {
        System.out.println("======\n");
        drive.getCurrentBalance();
        drive.getCurrentAnualInterest();
        drive.getCurrentNumberOfDeposits();
        drive.getCurrentNumberOfWithdraw();
        System.out.println("======\n");
    }

    public static void main(String[] args) {
        System.out.println("\n");
        Drive d = new Drive(true, true);

        //Initializating an account
        d.init_account(50, 5);

        //Current Status
        currentStatus(d);

        //Make a deposit
        d.deposit(10);

        //Make a withdraw
        d.withdraw(10);

        currentStatus(d);

        d.monthlyProcess();

        currentStatus(d);
    }
}
