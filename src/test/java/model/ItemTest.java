package test.java.model;

import main.java.model.Item;
import main.java.model.Rule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    private Item item;

    @Before
    public void setUp() {
        item = new Item("C");
    }

    @Test
    public void getNameTest() {
        assertEquals("C", item.getName());
    }

    @Test
    public void getAndSetRuleTest() {
        Rule rule = new Rule("P",785,3, 130);
        item.setRule(rule);
        assertEquals(rule, item.getRule());
    }

    @Test
    public void getAndSetPriceTest() {
        Item i = new Item("R");
        i.setPrice(50);
        assertEquals(50, i.getPrice());
    }

    @Test
    public void getAndSetSpecialPriceTest() {
        Item i = new Item("R");
        i.setSpecialPrice(501231);
        assertEquals(501231, i.getSpecialPrice());
    }
}