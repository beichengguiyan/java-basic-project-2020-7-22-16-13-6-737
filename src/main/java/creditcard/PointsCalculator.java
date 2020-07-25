package creditcard;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PointsCalculator {

    public BigDecimal calculate(Consumption consumption) {
        if (consumption.getPaymentType() == PaymentType.POS) {
            return posCalculate(consumption);
        } else if (consumption.getPaymentType() == PaymentType.WECHAT) {
            return wechatCalculate(consumption);
        } else if (consumption.getPaymentType() == PaymentType.CREDITCARDEXPRESS) {
            return creditCardExpressCalculate(consumption);
        }
        return null;
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


    public void totalPointsCalculate(User user) {
        BigDecimal result = new BigDecimal("0");
        for (Consumption consumption : user.getConsumeRecord()) {
            result = result.add(consumption.getPoints());
        }
        user.setTotalPoints(result);
    }

}
