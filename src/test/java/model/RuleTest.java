package test.java.model;

import main.java.model.Rule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RuleTest {

    private Rule rule;

    @Before
    public void setUp() {
        rule = new Rule(3, 140);
    }

    @Test
    public void getAndSetAmountTest() {
        rule.setAmount(3);
        assertEquals(3, rule.getAmount());
    }

    @Test
    public void getAndSetPriceTest() {
        rule.setPrice(140);
        assertEquals(140, rule.getPrice());
    }

}
