package main.java;

import main.java.model.Checkout;
import main.java.model.Item;
import main.java.model.Rule;

import java.util.ArrayList;
import java.util.List;

public class Entrypoint {

    public static void main(String args[]){
        ArrayList<Rule> rules = new ArrayList<>();
        Rule ruleA = new Rule("A", 50,3,130);
        Rule ruleB = new Rule("B", 30, 2, 45);
        Rule ruleC = new Rule("C", 20);
        Rule ruleD = new Rule("D", 15);
        rules.add(ruleA);
        rules.add(ruleB);
        rules.add(ruleC);
        rules.add(ruleD);

        Checkout checkout = new Checkout(rules);

        System.out.println("Item  |  Unit Price  |  Special Price");
        System.out.println("-------------------------------------");
        for (Rule curRule : rules) {
            System.out.println(curRule.getService().getRuleText(curRule));
        }
        System.out.println();
        System.out.println("1 mal A kostet: " +checkout.scan("A"));
        System.out.println("2 Mal Ware A macht zusammen: " + checkout.sumPrices("AA"));
        System.out.println("Ja, richtig, 2 mal A für nur: " + checkout.sumPrices(new Item("A"), new Item("A")));
        System.out.println("Oder Sie kaufen gleich 3 für: " + checkout.sumPrices("AAA"));
    }
}
