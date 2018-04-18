package test.java.model;

import main.java.model.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    private Item item;

    @Before
    public void setUp(){
        item = new Item();
    }

    @Test
    public void getAndSetPriceTest(){
        item.setPrice(50);
        assertEquals(50, item.getPrice());
    }
}
