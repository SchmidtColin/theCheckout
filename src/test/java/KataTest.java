package test.java;

import main.java.model.Checkout;
import main.java.model.Item;
import main.java.model.Rule;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class KataTest {

    private Checkout checkout;
    private Item itemA;
    private Item itemB;
    private Item itemC;
    private Item itemD;


    @Before
    public void setUp() {
        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(new Rule("A", 50,3,130));
        rules.add(new Rule("B",30,2, 45));
        rules.add(new Rule("C", 20));
        rules.add(new Rule("D", 15));
        checkout = new Checkout(rules);
        itemA = new Item("A");
        itemB = new Item("B");
        itemC = new Item("C");
        itemD = new Item("D");
    }

    @Test
    public void totalsTest() {

        assertEquals(130, checkout.sumPrices(itemA,itemA,itemB));
        assertEquals(  0, checkout.sumPrices());
        assertEquals( 50, checkout.sumPrices(itemA));
        assertEquals( 80, checkout.sumPrices(itemA, itemB));
        assertEquals(115, checkout.sumPrices(itemC, itemD, itemB, itemA));

        assertEquals(100, checkout.sumPrices(itemA,itemA));
        assertEquals(130, checkout.sumPrices(itemA,itemA,itemA));
        assertEquals(180, checkout.sumPrices(itemA,itemA,itemA,itemA));
        assertEquals(230, checkout.sumPrices(itemA,itemA,itemA,itemA,itemA));
        assertEquals(260, checkout.sumPrices(itemA,itemA,itemA,itemA,itemA,itemA));

        assertEquals(160, checkout.sumPrices(itemA,itemA,itemA,itemB));
        assertEquals(175, checkout.sumPrices(itemA,itemA,itemA,itemB,itemB));
        assertEquals(190, checkout.sumPrices(itemA,itemA,itemA,itemB,itemB,itemD));
        assertEquals(190, checkout.sumPrices(itemD,itemA,itemB,itemA,itemB,itemA));

        assertEquals(130, checkout.sumPrices("AAA"));
        assertEquals(0, checkout.sumPrices(""));
        assertEquals(50, checkout.sumPrices("A"));
        assertEquals( 80, checkout.sumPrices("AB"));
        assertEquals(115, checkout.sumPrices("CDBA"));

        assertEquals(100, checkout.sumPrices("AA"));
        assertEquals(130, checkout.sumPrices("AAA"));
        assertEquals(180, checkout.sumPrices("AAAA"));
        assertEquals(230, checkout.sumPrices("AAAAA"));
        assertEquals(260, checkout.sumPrices("AAAAAA"));

        assertEquals(160, checkout.sumPrices("AAAB"));
        assertEquals(175, checkout.sumPrices("AAABB"));
        assertEquals(190, checkout.sumPrices("AAABBD"));
        assertEquals(190, checkout.sumPrices("DABABA"));

    }

    @Test
    public void incrementalTest(){
        checkout.scan(itemA);
        assertEquals(50, checkout.getTotal());
        checkout.scan(itemB);
        assertEquals(80, checkout.getTotal());
        checkout.scan(itemA);
        assertEquals(130, checkout.getTotal());
        checkout.scan(itemA);
        assertEquals(160, checkout.getTotal());
        checkout.scan(itemB);
        assertEquals(175, checkout.getTotal());
    }

    @Test
    public void incrementalBySringTest(){
        checkout.scan("A");
        assertEquals(50, checkout.getTotal());
        checkout.scan("B");
        assertEquals(80, checkout.getTotal());
        checkout.scan("A");
        assertEquals(130, checkout.getTotal());
        checkout.scan("A");
        assertEquals(160, checkout.getTotal());
        checkout.scan("B");
        assertEquals(175, checkout.getTotal());

    }

}
