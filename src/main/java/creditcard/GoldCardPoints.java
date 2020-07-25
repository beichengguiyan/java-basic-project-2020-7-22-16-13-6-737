package creditcard;

import java.math.BigDecimal;

public class GoldCardPoints extends Points {
    @Override
    protected BigDecimal getDefaultPoints(User user) {
        Consumption consumption = user.getCurrentConsume();
        return calculate(consumption);
    }

    @Override
    protected Boolean inPointsScope(User user) {
        return user.isGoldCard();
    }

    public BigDecimal calculate(Consumption consumption) {
        if (consumption.getAmount().compareTo(new BigDecimal("20")) >= 0) {
            if (consumption.getPaymentType() == PaymentType.POS || consumption.getPaymentType() == PaymentType.SHOPPINGBYSTAGES || consumption.getPaymentType() == PaymentType.CREDITCARDEXPRESS) {
                return consumption.getAmount().divide(new BigDecimal("10")).multiply(new BigDecimal("0.5")).setScale(0, BigDecimal.ROUND_DOWN);

            } else if (consumption.getPaymentType() == PaymentType.WECHAT) {
                return consumption.getAmount().divide(new BigDecimal("20")).multiply(new BigDecimal("0.5")).setScale(0, BigDecimal.ROUND_DOWN);
            }
        }
        return new BigDecimal("0");
    }
}