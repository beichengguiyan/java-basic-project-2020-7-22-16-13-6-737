package creditcard;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Date;


public class PointsCalculatorTest {
    @Test
    public void should_return_0_when_given_amount_8(){
        //given
        BigDecimal expected = new BigDecimal("0");
        BigDecimal amount = new BigDecimal("8");
        Consumption consumption01= new Consumption(PaymentType.POS,amount);
        //when
        PointsCalculator pointsCalculator = new PointsCalculator();
        BigDecimal actual = pointsCalculator.calculate(consumption01);
        //then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void should_return_10_when_given_amount_108(){
        //given
        BigDecimal expected = new BigDecimal("10");
        BigDecimal amount = new BigDecimal("108");
        Consumption consumption01= new Consumption(PaymentType.POS,amount);
        //when
        PointsCalculator pointsCalculator = new PointsCalculator();
        BigDecimal actual = pointsCalculator.calculate(consumption01);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_return_30_when_given_amount_8_108_208(){
        //given
        BigDecimal expected = new BigDecimal("30");
        User user = new User();
        PointsCalculator pointsCalculator = new PointsCalculator();

        //when
        Consumption consumption01= new Consumption(PaymentType.POS,new BigDecimal("8"));
        BigDecimal points01 = pointsCalculator.calculate(consumption01);
        consumption01.setPoints(points01);
        user.addConsumeRecord(consumption01);

        Consumption consumption02= new Consumption(PaymentType.POS,new BigDecimal("108"));
        BigDecimal points02 = pointsCalculator.calculate(consumption02);
        consumption02.setPoints(points02);
        user.addConsumeRecord(consumption02);

        Consumption consumption03= new Consumption(PaymentType.POS,new BigDecimal("208"));
        BigDecimal points03 = pointsCalculator.calculate(consumption03);
        consumption03.setPoints(points03);
        user.addConsumeRecord(consumption03);

        pointsCalculator.totalPointsCalculate(user);
        BigDecimal actual = user.getTotalPoints();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_return_1_when_given_amount_25_by_wechat(){
        //given
        BigDecimal expected = new BigDecimal("1");
        BigDecimal amount = new BigDecimal("25");
        Consumption consumption01= new Consumption(PaymentType.WECHAT,amount);
        //when
        PointsCalculator pointsCalculator = new PointsCalculator();
        BigDecimal actual = pointsCalculator.calculate(consumption01);
        //then
        Assert.assertEquals(expected, actual);
    }

}