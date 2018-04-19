package main.java.model;

import main.java.model.enumeration.ITEM;

public class Item {

    private ITEM item;
    private Rule rule;

    public Item(ITEM item) {
        this.item = item;
    }

    public int getPrice() {
        return item.getPrice();
    }

    public String getName() {
        return item.toString();
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }
}
