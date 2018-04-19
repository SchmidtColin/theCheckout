package test.java.model;

import main.java.model.Item;
import main.java.model.Rule;
import main.java.model.enumeration.ITEM;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    private Item item;

    @Before
    public void setUp() {
        item = new Item(ITEM.C);
    }

    @Test
    public void getAndSetPriceTest() {
        assertEquals(20, item.getPrice());
    }

    @Test
    public void getAndSetNameTest() {
        assertEquals("C", item.getName());
    }

    @Test
    public void getAndSetRuleTest() {
        Rule rule = new Rule(3, 130);
        item.setRule(rule);
        assertEquals(rule, item.getRule());
    }
}