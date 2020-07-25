package creditcard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointsCalculator {

    private List<Points> pointsList = new ArrayList<>(Arrays.asList(new BasicPoints(), new GoldCardPoints()));

    public BigDecimal calculate(User user) {
        BigDecimal result = new BigDecimal("0");
        for (Points points: pointsList) {
            result = result.add(points.getPoints(user));
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
