package creditcard;

import java.math.BigDecimal;
import java.util.Date;

public class Consumption {
    private Date date;
    private PaymentType paymentType;
    private BigDecimal amount;
    private BigDecimal points;
    public Consumption(PaymentType paymentType, BigDecimal amount) {
        this.paymentType = paymentType;
        this.amount = amount;
        this.date = new Date();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }
}
