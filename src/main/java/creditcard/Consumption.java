package creditcard;

import java.math.BigDecimal;

public class Consumption {
    private PaymentType paymentType;
    private BigDecimal amount;
    public Consumption(PaymentType paymentType, BigDecimal amount) {
        this.paymentType = paymentType;
        this.amount = amount;
    }
}
