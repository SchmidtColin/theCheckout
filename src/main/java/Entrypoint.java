package main.java;

import main.java.model.Rule;
import main.java.service.RuleService;

public class Entrypoint {

    public static void main(String args[]){
        Rule rule = new Rule(4, 50);
        RuleService service = new RuleService();
        System.out.println(service.getRuleText(rule));

        System.out.println(7%3);

    }

}
