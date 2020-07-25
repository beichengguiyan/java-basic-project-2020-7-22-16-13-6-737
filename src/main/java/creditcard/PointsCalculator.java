package creditcard;

import java.math.BigDecimal;

public class PointsCalculator {
    public BigDecimal calculate(Consumption consumption) {
        BigDecimal result = consumption.getAmount().divide(new  BigDecimal("10")).setScale(0, BigDecimal.ROUND_DOWN);
        return result;
    }
}
