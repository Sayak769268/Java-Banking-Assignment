package paymentsystem;

public class WithdrawPayment extends BasePaymentWithGUI {

    public WithdrawPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        String record = "Withdraw | Amount: ₹" + getAmount();
        showMessage("Processing Withdrawal...");
        showMessage(record);
        showMessage("Withdrawal Successful!");
        TransactionManager.addTransaction(record);
    }
}