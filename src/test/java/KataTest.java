package test.java;

import main.java.model.Item;
import main.java.model.Rule;
import main.java.model.enumeration.ITEM;
import main.java.service.CheckoutService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    /*
        assert_equal(  0, price(""))
    assert_equal( 50, price("A"))
    assert_equal( 80, price("AB"))
    assert_equal(115, price("CDBA"))

    assert_equal(100, price("AA"))
    assert_equal(130, price("AAA"))
    assert_equal(180, price("AAAA"))
    assert_equal(230, price("AAAAA"))
    assert_equal(260, price("AAAAAA"))

    assert_equal(160, price("AAAB"))
    assert_equal(175, price("AAABB"))
    assert_equal(190, price("AAABBD"))
    assert_equal(190, price("DABABA"))
     */
    private CheckoutService service;

    @Before
    public void setUp() {
        service = new CheckoutService();
    }

    @Test
    public void sumPricesTest() {
        Item itemA = new Item(ITEM.A);
        Item itemB = new Item(ITEM.B);
        itemA.setRule(new Rule(3,130));
        itemB.setRule(new Rule(2, 45));
        assertEquals(130, service.sumPrices(itemA,itemA,itemB));
    }
}
