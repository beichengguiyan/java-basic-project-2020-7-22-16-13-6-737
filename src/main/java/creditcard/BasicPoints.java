package creditcard;

import java.math.BigDecimal;

public class BasicPoints extends Points {
    @Override
    protected BigDecimal getDefaultPoints(User user) {
        Consumption consumption =user.getCurrentConsume();
        if (consumption.getPaymentType() == PaymentType.POS) {
            return posCalculate(consumption);
        } else if (consumption.getPaymentType() == PaymentType.WECHAT) {
            return wechatCalculate(consumption);
        } else if (consumption.getPaymentType() == PaymentType.CREDITCARDEXPRESS) {
            return creditCardExpressCalculate(consumption);
        } else if (consumption.getPaymentType() == PaymentType.SHOPPINGBYSTAGES) {
            return shoppingByStagesCalculate(consumption);
        }
        return null;
    }

    @Override
    protected Boolean inPointsScope(User user) {
        return true;
    }

    public BigDecimal posCalculate(Consumption consumption) {
        BigDecimal result = consumption.getAmount().divide(new BigDecimal("10")).setScale(0, BigDecimal.ROUND_DOWN);
        return result;
    }

    public BigDecimal wechatCalculate(Consumption consumption) {
        BigDecimal result = consumption.getAmount().divide(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_DOWN);
        return result;
    }

    public BigDecimal creditCardExpressCalculate(Consumption consumption) {
        BigDecimal result = consumption.getAmount().divide(new BigDecimal("10")).setScale(0, BigDecimal.ROUND_DOWN);
        if (consumption.getAmount().compareTo(new BigDecimal("100")) > 0) {
            if (consumption.getAmount().compareTo(new BigDecimal("2000")) <= 0) {
                result = result.add(consumption.getAmount().divide(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_DOWN).multiply(new BigDecimal("5")));
            } else {
                result = result.add(new BigDecimal("100"));
            }
        }
        return result;
    }

    public BigDecimal shoppingByStagesCalculate(Consumption consumption) {
        BigDecimal result = consumption.getAmount().divide(new BigDecimal("10")).setScale(0, BigDecimal.ROUND_DOWN);
        if (consumption.getAmount().compareTo(new BigDecimal("5000")) > 0) {
            result = result.add(new BigDecimal("100"));
        }
        return result;
    }

}
