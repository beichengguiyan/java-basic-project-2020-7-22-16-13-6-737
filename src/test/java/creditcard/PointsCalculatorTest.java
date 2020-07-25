package creditcard;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;


public class PointsCalculatorTest {
        @Test
    public void should_return_0_when_given_amount_8() {
        //given
        BigDecimal expected = new BigDecimal("0");
        BigDecimal amount = new BigDecimal("8");
        Consumption consumption = new Consumption(PaymentType.POS, amount);
            User user = new User();
            user.setCurrentConsume(consumption);
        //when
        PointsCalculator pointsCalculator = new PointsCalculator();
        BigDecimal actual = pointsCalculator.calculate(user);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_return_10_when_given_amount_108() {
        //given
        BigDecimal expected = new BigDecimal("10");
        BigDecimal amount = new BigDecimal("108");
        Consumption consumption = new Consumption(PaymentType.POS, amount);
        User user = new User();
        user.setCurrentConsume(consumption);
        //when
        PointsCalculator pointsCalculator = new PointsCalculator();
        BigDecimal actual = pointsCalculator.calculate(user);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_return_30_when_given_amount_8_108_208() {

        //given
        BigDecimal expected = new BigDecimal("30");
        User user = new User();
        PointsCalculator pointsCalculator = new PointsCalculator();
        PaymentType[] paymentType = {
                PaymentType.POS,
                PaymentType.POS,
                PaymentType.POS};
        int[] inputAmounts = {
                8,
                108,
                208,};
        //when
        for (int i = 0; i < inputAmounts.length; i++) {
            Consumption consumption = new Consumption(paymentType[i], new BigDecimal(inputAmounts[i]));
            user.setCurrentConsume(consumption);
            BigDecimal points = pointsCalculator.calculate(user);
            consumption.setPoints(points);
            user.addConsumeRecord(consumption);
        }

        pointsCalculator.totalPointsCalculate(user);
        BigDecimal actual = user.getTotalPoints();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_return_1_when_given_amount_25_by_wechat() {
        //given
        BigDecimal expected = new BigDecimal("1");
        BigDecimal amount = new BigDecimal("25");
        Consumption consumption = new Consumption(PaymentType.WECHAT, amount);
        User user = new User();
        user.setCurrentConsume(consumption);
        //when
        PointsCalculator pointsCalculator = new PointsCalculator();
        BigDecimal actual = pointsCalculator.calculate(user);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_return_32_when_given_amount_by_mix() {
        //given
        BigDecimal expected = new BigDecimal("32");
        User user = new User();
        PointsCalculator pointsCalculator = new PointsCalculator();
        PaymentType[] paymentType = {
                PaymentType.WECHAT,
                PaymentType.WECHAT,
                PaymentType.POS,
                PaymentType.WECHAT,
                PaymentType.WECHAT,
                PaymentType.POS};
        int[] inputAmounts = {
                25,
                18,
                108,
                10,
                22,
                208};
        //when
        for (int i = 0; i < inputAmounts.length; i++) {
            Consumption consumption = new Consumption(paymentType[i], new BigDecimal(inputAmounts[i]));
            user.setCurrentConsume(consumption);
            BigDecimal points = pointsCalculator.calculate(user);
            consumption.setPoints(points);
            user.addConsumeRecord(consumption);
        }

        pointsCalculator.totalPointsCalculate(user);
        BigDecimal actual = user.getTotalPoints();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_return_30_when_given_amount_208_by_creditcardexpress() {
        //given
        BigDecimal expected = new BigDecimal("30");
        BigDecimal amount = new BigDecimal("208");
        Consumption consumption = new Consumption(PaymentType.CREDITCARDEXPRESS, amount);
        PointsCalculator pointsCalculator = new PointsCalculator();
        User user = new User();
        user.setCurrentConsume(consumption);
        //when
        BigDecimal actual = pointsCalculator.calculate(user);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_return_382_when_given_amount_by_mix_three() {
        //given
        BigDecimal expected = new BigDecimal("382");
        User user = new User();
        PointsCalculator pointsCalculator = new PointsCalculator();
        PaymentType[] paymentType = {
                PaymentType.WECHAT,
                PaymentType.WECHAT,
                PaymentType.POS,
                PaymentType.WECHAT,
                PaymentType.WECHAT,
                PaymentType.POS,
                PaymentType.CREDITCARDEXPRESS,
                PaymentType.CREDITCARDEXPRESS};
        int[] inputAmounts = {
                25,
                18,
                108,
                10,
                22,
                208,
                208,
                2208};
        //when
        for (int i = 0; i < inputAmounts.length; i++) {
            Consumption consumption = new Consumption(paymentType[i], new BigDecimal(inputAmounts[i]));
            user.setCurrentConsume(consumption);
            BigDecimal points = pointsCalculator.calculate(user);
            consumption.setPoints(points);
            user.addConsumeRecord(consumption);
        }

        pointsCalculator.totalPointsCalculate(user);
        BigDecimal actual = user.getTotalPoints();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_return_740_when_given_amount_6400_by_shoppingbystages() {
        //given
        BigDecimal expected = new BigDecimal("740");
        BigDecimal amount = new BigDecimal("6400");
        Consumption consumption = new Consumption(PaymentType.SHOPPINGBYSTAGES, amount);
        PointsCalculator pointsCalculator = new PointsCalculator();
        User user = new User();

        //when
        user.setCurrentConsume(consumption);
        BigDecimal actual = pointsCalculator.calculate(user);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_return_1122_when_given_amount_by_mix_four() {
        //given
        BigDecimal expected = new BigDecimal("1122");
        User user = new User();
        PointsCalculator pointsCalculator = new PointsCalculator();
        PaymentType[] paymentType = {
                PaymentType.WECHAT,
                PaymentType.WECHAT,
                PaymentType.POS,
                PaymentType.WECHAT,
                PaymentType.WECHAT,
                PaymentType.POS,
                PaymentType.CREDITCARDEXPRESS,
                PaymentType.CREDITCARDEXPRESS,
                PaymentType.SHOPPINGBYSTAGES};
        int[] inputAmounts = {
                25,
                18,
                108,
                10,
                22,
                208,
                208,
                2208,
                6400};
        //when
        for (int i = 0; i < inputAmounts.length; i++) {
            Consumption consumption = new Consumption(paymentType[i], new BigDecimal(inputAmounts[i]));
            user.setCurrentConsume(consumption);
            BigDecimal points = pointsCalculator.calculate(user);
            consumption.setPoints(points);
            user.addConsumeRecord(consumption);
        }

        pointsCalculator.totalPointsCalculate(user);
        BigDecimal actual = user.getTotalPoints();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void should_return_15_when_given_amount_108_by_pos() {
        //given
        BigDecimal expected = new BigDecimal("15");
        BigDecimal amount = new BigDecimal("108");
        Consumption consumption = new Consumption(PaymentType.POS, amount);
        PointsCalculator pointsCalculator = new PointsCalculator();
        User user = new User();
        user.setCustomerRank(CustomerRank.GOLDENCARD);
        user.setCurrentConsume(consumption);

        //when
        BigDecimal actual = pointsCalculator.calculate(user);

        //then
        Assert.assertEquals(expected, actual);
    }

}