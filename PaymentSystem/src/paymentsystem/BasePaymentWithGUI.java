package paymentsystem;

import javax.swing.*;

public abstract class BasePaymentWithGUI extends BasePayment {

    protected JTextArea messageArea;

    public BasePaymentWithGUI(double amount) {
        super(amount);
    }

    public void setMessageArea(JTextArea area) {
        this.messageArea = area;
    }

    protected void showMessage(String msg) {
        if (messageArea != null) {
            messageArea.append(msg + "\n");
            messageArea.setCaretPosition(messageArea.getDocument().getLength());
        }
    }
}