package main.java.model;

import main.java.service.RuleService;

public class Rule {

    private int amount;
    private int specialPrice;
    private RuleService service;
    private String itemName;
    private int normalPrice;

    public Rule(String itemName, int normalPrice, int amount, int specialPrice) {
        this.service=new RuleService();
        this.itemName = itemName;
        this.normalPrice = normalPrice;
        this.amount = amount;
        this.specialPrice = specialPrice;
    }

    public Rule(String name, int normalPrice) {
        this.service=new RuleService();
        this.itemName = name;
        this.normalPrice = normalPrice;
        this.amount = 1;
        this.specialPrice = 0;
    }


    public int getAmount() {
        return amount;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }

    public RuleService getService() {
        return  service;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getNormalPrice() {
        return this.normalPrice;
    }
}
