package paymentsystem;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private static List<String> history = new ArrayList<>();

    public static void addTransaction(String record) {
        history.add(record);
    }

    public static List<String> getHistory() {
        return new ArrayList<>(history);
    }
}