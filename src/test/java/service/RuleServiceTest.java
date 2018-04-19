package test.java.service;

import main.java.model.Rule;
import main.java.service.RuleService;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RuleServiceTest {

    private RuleService service;

    @Before
    public void setUp() {
        service = new RuleService();
    }

    @Test
    public void getRuleTextTest() {
        Rule ruleA = new Rule(3, 130);
        Rule ruleB = new Rule(2, 45);
        assertEquals("3 for 130", service.getRuleText(ruleA));
        assertEquals("2 for 45", service.getRuleText(ruleB));
    }

}
