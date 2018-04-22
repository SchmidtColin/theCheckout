package test.java.model;

import main.java.model.Checkout;
import main.java.model.Item;
import main.java.model.Rule;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class CheckoutTest {

    private Checkout checkout;

    @Before
    public void setUp() {
        checkout = new Checkout(new ArrayList<>());
    }

    @Test
    public void getAndSetRulesTest() {
        List<Rule> rules = new ArrayList<>();
        rules.add(new Rule("Q",155,13, 1200));
        checkout.setRules(rules);
        assertEquals(rules, checkout.getRules());
    }

    @Test
    public void getServiceTest() {
        assertNotNull(checkout.getService());
    }

    @Test
    public void getTotal(){
        Item item = new Item("A");
        item.setPrice(50);
        checkout.scan(item);
        assertEquals(50, checkout.getTotal());
    }
}
