package main.java.model;

import main.java.service.CheckoutService;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private List<Rule> rules;
    private CheckoutService service;
    private int total;

    public Checkout(ArrayList<Rule> rules) {
        this.service = new CheckoutService();
        this.rules = rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public CheckoutService getService() {
        return service;
    }

    public int getTotal() {
        return this.total;
    }

    public int scan(Item item) {
        for (Rule rule : rules) {
            if (item.getName().equals(rule.getItemName())) {
                item.setRule(rule);
                item.setPrice(rule.getNormalPrice());
                item.setSpecialPrice(rule.getSpecialPrice());
            }
        }
        total = total + service.incrementPrices(item);
        return total;
    }

    public int scan(String item) {
        Item i = null;
        for (char c : item.toCharArray()) {
            i = service.fillItemByRule(c, rules);
        }
        total = total + service.incrementPrices(i);
        return total;
    }

    public int sumPrices(Item... items) {
        for (Item item : items) {
            for (Rule rule : rules) {
                if (item.getName().equals(rule.getItemName())) {
                    item.setRule(rule);
                    item.setPrice(rule.getNormalPrice());
                    item.setSpecialPrice(rule.getSpecialPrice());
                }
            }
        }
        return service.sumPrices(items);
    }


    public int sumPrices(String items) {

        List<Item> itemList = new ArrayList<>();
        for (char item : items.toCharArray()) {
            itemList.add(service.fillItemByRule(item, rules));
        }

        return service.sumPrices(itemList.toArray(new Item[0]));
    }


}
