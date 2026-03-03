package paymentsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PaymentFactory {

    private static final Map<String, BiFunction<Double, String, Payment>> registry = new HashMap<>();

    static {
        // Register existing payment types
        register("CreditCard", (amount, detail) -> new CreditCardPayment(amount, detail));
        register("UPI", (amount, detail) -> new UPIPayment(amount, detail));
        register("Withdraw", (amount, detail) -> new WithdrawPayment(amount));
    }

    public static void register(String type,
                                BiFunction<Double, String, Payment> creator) {
        registry.put(type, creator);
    }

    public static Payment createPayment(String type,
                                        double amount,
                                        String detail) {

        BiFunction<Double, String, Payment> creator = registry.get(type);

        if (creator == null) {
            throw new IllegalArgumentException("Invalid payment type");
        }

        return creator.apply(amount, detail);
    }
}