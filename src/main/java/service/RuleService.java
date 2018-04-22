package main.java.service;

import main.java.model.Rule;

public class RuleService {

    public String getRuleText(Rule rule) {
        String response;
        if(rule.getSpecialPrice() != 0){
            response=rule.getItemName()+"       "+rule.getNormalPrice()+"               "+rule.getAmount()+" for " + rule.getSpecialPrice();
        }else{
            response=rule.getItemName()+"       "+rule.getNormalPrice()+"";
        }
        return response;
    }
}
