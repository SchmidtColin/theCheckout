package main.java.service;

import main.java.model.Rule;

public class RuleService {

    public String getRuleText(Rule rule) {
        return ""+rule.getAmount()+" for " + rule.getPrice();
    }
}
