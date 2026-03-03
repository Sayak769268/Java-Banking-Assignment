package paymentsystem;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    private static Map<String, String> users = new HashMap<>();

    public static boolean createAccount(String username, String password) {

        if (users.containsKey(username)) {
            return false; // user already exists
        }

        users.put(username, password);
        return true;
    }

    public static boolean login(String username, String password) {

        if (!users.containsKey(username)) {
            return false;
        }

        return users.get(username).equals(password);
    }
}