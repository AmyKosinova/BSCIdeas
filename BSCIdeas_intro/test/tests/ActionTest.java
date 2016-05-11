package tests;

import java.io.File;
import model.Currency;
import model.Payments;
import model.actions.Action;
import model.actions.AddPayment;
import model.actions.Executor;
import model.actions.LoadData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionTest {

    Executor executor = Executor.getInstance();

    @Before
    public void init() {
        Payments.getInstance().getAllPayments().clear();
    }

    @Test
    public void executorSingletonTest() {
        Executor ex1 = Executor.getInstance();
        Assert.assertTrue(ex1.equals(Executor.getInstance()));
    }

    @Test
    public void addPaymentTest() {
        Action addPayment = new AddPayment(12.44, Currency.getCurrency("www"));
        executor.execute(addPayment);
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());

        addPayment = new AddPayment(12.44, Currency.getCurrency("EU"));
        executor.execute(addPayment);
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());
        
        addPayment = new AddPayment(12.44, null);
        executor.execute(addPayment);
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());

        addPayment = new AddPayment(12.44, Currency.getCurrency("EUR"));
        executor.execute(addPayment);
        Assert.assertFalse(Payments.getInstance().getAllPayments().isEmpty());
    }

    @Test
    public void loadDataTest() {
        Action loadData = new LoadData(new File("test/resources/payments_injection.txt"));
        executor.execute(loadData);
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());

        loadData = new LoadData(new File("test/resources/payments_wrong_currency.txt"));
        executor.execute(loadData);
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());

        loadData = new LoadData(new File("test/resources/payments_wrong_format.txt"));
        executor.execute(loadData);
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());

        loadData = new LoadData(null);
        executor.execute(loadData);
        Assert.assertTrue(Payments.getInstance().getAllPayments().isEmpty());

        loadData = new LoadData(new File("test/resources/payments_correct.txt"));
        executor.execute(loadData);
        Assert.assertFalse(Payments.getInstance().getAllPayments().isEmpty());
    }

    @Test
    public void executionTest() {
        executor.execute(null);
    }

}
