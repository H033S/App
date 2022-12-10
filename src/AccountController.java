/**
 * Sample Skeleton for 'Account.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Drive;
import models.Log;

public class AccountController {

    Drive drive;
    String message;
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnConfirmDeposit"
    private Button btnConfirmDeposit; // Value injected by FXMLLoader

    @FXML // fx:id="btnConfirmWithdraw"
    private Button btnConfirmWithdraw; // Value injected by FXMLLoader

    @FXML // fx:id="btnInitialize"
    private Button btnInitialize; // Value injected by FXMLLoader

    @FXML // fx:id="tFlowLog"
    private TextArea tFlowLog; // Value injected by FXMLLoader

    @FXML // fx:id="tboxAccountBalance"
    private TextField tboxAccountBalance; // Value injected by FXMLLoader

    @FXML // fx:id="tboxAccountInterest"
    private TextField tboxAccountInterest; // Value injected by FXMLLoader

    @FXML // fx:id="tboxDepositAmount"
    private TextField tboxDepositAmount; // Value injected by FXMLLoader

    @FXML // fx:id="tboxWithdrawAmount"
    private TextField tboxWithdrawAmount; // Value injected by FXMLLoader


//=========================================================
    /**
     * Check if the account has been initialized already
     * @return return true if so, false otherwise
     */
    private boolean checkInitialization()
    {
        if(!drive.isAccountInitialized())
        {
            setNotInitializedError();
            return false;
        }

        return true;
    }

    /*
     * Method create a message for not initialization error,
     * and call the method save log
     */
    private void setNotInitializedError()
    {
        String message = Log.logError("Account has not been initialized.",false);
        saveLog(message);
    }

    /**
     * Insert the message passed by parameter in the text
     * area 
     * @param message String you want to insert in the text area
     */
    private void addMessageToTextLog(String message)
    {
        tFlowLog.setText(message + tFlowLog.getText());
    }

    /**
     * This method is in charge to save the message
     * by calling addMessageToTextLog and saveMessage to log
     * to store the message in the Log.txt
     * @param message
     */
    private void saveLog(String message)
    {
        Log.SaveMessage(message);
        addMessageToTextLog(message);
    }
//=========================================================

    public AccountController() {
        if(drive == null)
            drive = new Drive(false, false);
    }

    @FXML
    /**
     * Event for the confirm button from deposit
     * @param event
     */
    void confirmDeposit(ActionEvent event) {
        if(!checkInitialization()) return;

        try {

            double amount = Double.parseDouble(tboxDepositAmount.getText());
            drive.deposit(amount);

            message = Log.logDeposit(amount, false);
            saveLog(message);

        } catch (Exception e) {

            message = Log.logError("Amount must be a number", false);
            saveLog(message);
        }
    }

    @FXML
    /**
     * Event for the confirm button from withdraw
     * @param event
     */
    void confirmWithdraw(ActionEvent event) {
        if(!checkInitialization()) return;

        try {

            if(drive.getCurrentBalance() <= 25)
            {
                message = Log.logError("Balance is not active", false);
                saveLog(message);
                return;
            }

            double amount = Double.parseDouble(tboxWithdrawAmount.getText());
            drive.withdraw(amount);

            message = Log.logWithdraw(amount, false);
            saveLog(message);

        } catch (Exception e) {

            message = Log.logError("Amount must be a number", false);
            saveLog(message);

        }
    }

    @FXML
    /**
     * Event for get balance
     * @param event
     */
    void getCurrentBalance(ActionEvent event) {
        if(!checkInitialization()) return;

        message = Log.logCurrentBalance(drive.geAccount(),false);
        saveLog(message);
    }

    @FXML
    /**
     * Event for get CurrentInterest
     * @param event
     */
    void getCurrentInterest(ActionEvent event) {
        if(!checkInitialization()) return;

        message = Log.logCurrentAnualInterest(drive.geAccount(),false);
        saveLog(message);
    }

    @FXML
    /**
     * Event for get numberOfDeposits
     * @param event
     */
    void getNumberOfDeposits(ActionEvent event) {
        if(!checkInitialization()) return;

        message = Log.logCurrentNumberOfDeposits(drive.geAccount(), false);
        saveLog(message);
    }

    @FXML
    /**
     * Event for get numberOfWithdraw
     * @param event
     */
    void getNumberOfWithdraws(ActionEvent event) {
        if(!checkInitialization()) return;

        message = Log.logCurrentNumberOfWithdraws(drive.geAccount(), false);
        saveLog(message);
    }

    @FXML
    /**
     * Event to initiate a Saving Account
     * @param event
     */
    void initializeAccount(ActionEvent event) {
        try {
            double balance  = Double.parseDouble(tboxAccountBalance.getText());
            double interest = Double.parseDouble(tboxAccountInterest.getText());

            drive.init_account(balance, interest);

            message = Log.logAccountCreation(drive.geAccount(), false);
            saveLog(message);

        } catch (Exception e) {

            message = Log.logError("Balance and Interest must be numbers", false);
            saveLog(message);
        }
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnConfirmDeposit != null : "fx:id=\"btnConfirmDeposit\" was not injected: check your FXML file 'Account.fxml'.";
        assert btnConfirmWithdraw != null : "fx:id=\"btnConfirmWithdraw\" was not injected: check your FXML file 'Account.fxml'.";
        assert btnInitialize != null : "fx:id=\"btnInitialize\" was not injected: check your FXML file 'Account.fxml'.";
        assert tFlowLog != null : "fx:id=\"tFlowLog\" was not injected: check your FXML file 'Account.fxml'.";
        assert tboxAccountBalance != null : "fx:id=\"tboxAccountBalance\" was not injected: check your FXML file 'Account.fxml'.";
        assert tboxAccountInterest != null : "fx:id=\"tboxAccountInterest\" was not injected: check your FXML file 'Account.fxml'.";
        assert tboxDepositAmount != null : "fx:id=\"tboxDepositAmount\" was not injected: check your FXML file 'Account.fxml'.";
        assert tboxWithdrawAmount != null : "fx:id=\"tboxWithdrawAmount\" was not injected: check your FXML file 'Account.fxml'.";

    }

}
