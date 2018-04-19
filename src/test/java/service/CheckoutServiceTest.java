package test.java.service;

import main.java.model.Item;
import main.java.model.Rule;
import main.java.model.enumeration.ITEM;
import main.java.service.CheckoutService;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CheckoutServiceTest {

    private CheckoutService service;

    @Before
    public void setUp() {
        service = new CheckoutService();
    }

    @Test
    public void getCounterTest() {
        assertNull(service.getCounter());
    }

    @Test
    public void scanItemTest() {
        assertEquals(50, service.scanItem(new Item(ITEM.A)));
    }

    @Test
    public void sumPricesTest() {
        assertEquals(130, service.sumPrices(new Item(ITEM.A), new Item(ITEM.A), new Item(ITEM.B)));
    }

//    @Test
//    public void sumPricesWithRulesTest() {
//        Item itemA = new Item(ITEM.A);
//        Item itemB = new Item(ITEM.B);
//        itemA.setRule(new Rule(3, 130));
//        itemB.setRule(new Rule(2, 45));
//        assertEquals(145, service.sumPrices(itemA, itemA, itemB, itemB));
//    }

    @Test
    public void countItemsTest() {
        HashMap<String, Integer> testCounter = service.countItems(new Item(ITEM.A));

        assertTrue(testCounter.containsKey(ITEM.A.toString()));
        assertEquals(1, testCounter.get(ITEM.A.toString()).intValue());
    }

    @Test
    public void countDoubleItemsTest() {
        HashMap<String, Integer> testCounter = service.countItems(new Item(ITEM.A), new Item(ITEM.A));

        assertTrue(testCounter.containsKey(ITEM.A.toString()));
        assertEquals(2, testCounter.get(ITEM.A.toString()).intValue());
    }

    @Test
    public void countDifferentItemsTest() {
        HashMap<String, Integer> testCounter = service.countItems(new Item(ITEM.A), new Item(ITEM.B));

        assertTrue(testCounter.containsKey(ITEM.A.toString()));
        assertTrue(testCounter.containsKey(ITEM.B.toString()));
        assertEquals(1, testCounter.get(ITEM.A.toString()).intValue());
        assertEquals(2, testCounter.size());
    }

    @Test
    public void countSameItemsTest() {
        HashMap<String, Integer> testCounter = service.countItems(new Item(ITEM.A), new Item(ITEM.A), new Item(ITEM.B));

        assertTrue(testCounter.containsKey(ITEM.A.toString()));
        assertTrue(testCounter.containsKey(ITEM.B.toString()));
        assertEquals(2, testCounter.get(ITEM.A.toString()).intValue());
        assertEquals(2, testCounter.size());
    }

    @Test
    public void getSpecialPriceTest() {
        Item item = new Item(ITEM.B);
        item.setRule(new Rule(2, 45));
        assertEquals(45, service.getSpecialPrice(item, item, item));
        assertEquals(90, service.getSpecialPrice(item, item, item, item));
        assertEquals(135, service.getSpecialPrice(item, item, item, item, item, item, item));
    }

}
