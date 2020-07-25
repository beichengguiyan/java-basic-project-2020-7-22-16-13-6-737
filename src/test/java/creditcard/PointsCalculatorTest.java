package creditcard;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;


public class PointsCalculatorTest {
    @Test
    public void should_return_0_when_given_amout_8(){
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

}