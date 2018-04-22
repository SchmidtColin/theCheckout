package test.java.service;

import main.java.model.Item;
import main.java.model.Rule;
import main.java.service.CheckoutService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CheckoutServiceTest {

    private CheckoutService service;
    private Item itemA;
    private Item itemB;

    @Before
    public void setUp() {
        service = new CheckoutService();
        itemA = new Item("A");
        itemA.setPrice(50);
        itemB = new Item("B");
        itemB.setPrice(30);
        itemA.setRule(new Rule("A", 50, 3, 130));
        itemB.setRule(new Rule("B", 30, 2, 45));
    }

    @Test
    public void getCounterTest() {
        assertNull(service.getCounter());
    }

    @Test
    public void scanItemTest() {
        assertEquals(50, service.scanItem(itemA));
    }

    @Test
    public void sumPricesTest() {

        assertEquals(130, service.sumPrices(itemA, itemA, itemB));
    }

    @Test
    public void sumPricesWithAndWithoutRuleTest() {
        assertEquals(130, service.sumPrices(itemA, itemA, itemB));
    }

    @Test
    public void sumPricesWithRulesTest() {
        itemA.setSpecialPrice(1);
        itemB.setSpecialPrice(13242);
        assertEquals(145, service.sumPrices(itemA, itemA, itemB, itemB));
    }

    @Test
    public void countItemsTest() {
        HashMap<String, Integer> testCounter = service.countItems(new Item("A"));

        assertTrue(testCounter.containsKey("A"));
        assertEquals(1, testCounter.get("A").intValue());
    }

    @Test
    public void countDoubleItemsTest() {
        HashMap<String, Integer> testCounter = service.countItems(new Item("A"), new Item("A"));

        assertTrue(testCounter.containsKey("A"));
        assertEquals(2, testCounter.get("A").intValue());
    }

    @Test
    public void countDifferentItemsTest() {
        HashMap<String, Integer> testCounter = service.countItems(new Item("A"), new Item("B"));

        assertTrue(testCounter.containsKey("A"));
        assertTrue(testCounter.containsKey("B"));
        assertEquals(1, testCounter.get("A").intValue());
        assertEquals(2, testCounter.size());
    }

    @Test
    public void countSameItemsTest() {
        HashMap<String, Integer> testCounter = service.countItems(new Item("A"), new Item("A"), new Item("B"));

        assertTrue(testCounter.containsKey("A"));
        assertTrue(testCounter.containsKey("B"));
        assertEquals(2, testCounter.get("A").intValue());
        assertEquals(2, testCounter.size());
    }

    @Test
    public void getNormalPriceTest() {
        itemB.setSpecialPrice(23);
        assertEquals(30, service.getNormalPrice(itemB, itemB, itemB));
        assertEquals(0, service.getNormalPrice(itemB, itemB, itemB, itemB));
        assertEquals(30, service.getNormalPrice(itemB, itemB, itemB, itemB, itemB, itemB, itemB));
    }

    @Test
    public void getSpecialPriceTest() {
        Item item = new Item("B");
        item.setRule(new Rule("B", 30, 2, 45));
        assertEquals(45, service.getSpecialPrice(item, item, item));
        assertEquals(90, service.getSpecialPrice(item, item, item, item));
        assertEquals(135, service.getSpecialPrice(item, item, item, item, item, item, item));
    }

    @Test
    public void fillItemByRuleTest() {
        List<Rule> rules = new ArrayList<>();
        Rule rule = new Rule("A", 50, 3, 130);
        rules.add(rule);
        assertEquals("A", service.fillItemByRule(rule.getItemName().charAt(0), rules).getName());
        assertEquals(50, service.fillItemByRule(rule.getItemName().charAt(0), rules).getPrice());
        assertEquals(130, service.fillItemByRule(rule.getItemName().charAt(0), rules).getSpecialPrice());
    }

}
