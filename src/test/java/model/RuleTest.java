package test.java.model;

import main.java.model.Rule;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class RuleTest {

    private Rule specialRule;

    @Before
    public void setUp() {
        specialRule = new Rule("A", 50, 3, 130);
    }

    @Test
    public void getItemNameTest() {
        assertEquals("A", specialRule.getItemName());
    }

    @Test
    public void getNormalPriceTest() {
        assertEquals(50, specialRule.getNormalPrice());
    }

    @Test
    public void getAmountTest() {
        assertEquals(3, specialRule.getAmount());
    }

    @Test
    public void getSpecialPriceTest() {
        assertEquals(130, specialRule.getSpecialPrice());
    }

    @Test
    public void getServiceTest(){
        assertNotNull(specialRule.getService());
    }

}
