package test.java.model;

import main.java.model.Checkout;
import main.java.model.Rule;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        rules.add(new Rule(3, 120));
        checkout.setRules(rules);
        assertEquals(rules, checkout.getRules());
    }

}
