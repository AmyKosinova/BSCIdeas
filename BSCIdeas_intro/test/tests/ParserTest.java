package tests;

import java.math.BigDecimal;
import main.Parser;
import model.Currency;
import model.Payment;
import model.Payments;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {

    @Before
    public void init() {
        Payments.getInstance().getAllPayments().clear();
    }

    @Test
    public void testCorrectInput() {
        Assert.assertTrue(Parser.parseInput("USD 789"));
        Assert.assertFalse(Payments.getInstance().getAllPayments().isEmpty());

        Payments.getInstance().getAllPayments().clear();
        Assert.assertTrue(Parser.parseInput("load test/resources/payments_correct.txt"));
        Assert.assertFalse(Payments.getInstance().getAllPayments().isEmpty());

        Assert.assertFalse(Parser.parseInput("quit"));
    }

    @Test
    public void testDecimals() {
        String currency = "USD";
        BigDecimal amount = new BigDecimal(789.123);
        Assert.assertTrue(Parser.parseInput(currency + amount));
        Assert.assertTrue(Payments.getInstance().getAllPayments().contains(new Payment(amount, Currency.getCurrency(currency))));
    }

    @Test
    public void testNegative() {
        String currency = "EUR";
        BigDecimal amount = new BigDecimal(-789.123);
        Assert.assertTrue(Parser.parseInput(currency + amount));
        Assert.assertTrue(Payments.getInstance().getAllPayments().contains(new Payment(amount, Currency.getCurrency(currency))));
    }

    @Test
    public void testWrongInput() {
        Assert.assertTrue(Parser.parseInput("USD qq"));
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());

        Assert.assertTrue(Parser.parseInput("USDD 11"));
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());

        Assert.assertTrue(Parser.parseInput("US 11"));
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());

        Assert.assertTrue(Parser.parseInput("load test/resources/payments_wrong_currency.txt"));
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());

        Assert.assertTrue(Parser.parseInput("load test/resources/payments_wrong_format.txt"));
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());

        Assert.assertTrue(Parser.parseInput("load test/resources/payments_injection.txt"));
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());
    }

}
