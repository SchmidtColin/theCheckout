package main.java.service;

import main.java.model.Item;

import java.util.HashMap;

public class CheckoutService {

    private HashMap<String, Integer> counter;

    public HashMap<String, Integer> getCounter() {
        return counter;
    }

    public int scanItem(Item item) {
        return item.getPrice();
    }

    public int sumPrices(Item... items) {
        int sum;
        sum = getSpecialPrice(items);
        for (Item item : items) {
            if(item.getRule() != null){
                sum = sum + (counter.get(item.getName())%item.getRule().getAmount())*scanItem(item);
            }else{
                sum = sum + scanItem(item);
            }

        }
        return sum;
    }

    public HashMap<String, Integer> countItems(Item... items) {
        if (counter == null) {
            counter = new HashMap<>();
        }
        for (Item item : items) {
            if (!counter.containsKey(item.getName())) {
                counter.put(item.getName(), 1);
            } else {
                counter.put(item.getName(), counter.get(item.getName()) + 1);
            }
        }
        return counter;
    }

    public int getSpecialPrice(Item... items) {
        if (counter == null) {
            counter = new HashMap<>();
        }
        counter.clear();
        countItems(items);
        int specialPrice = 0;
        for (Item item : items) {
            if (item.getRule() != null) {
                specialPrice = (counter.get(item.getName()) / item.getRule().getAmount()) * item.getRule().getPrice();
            }
        }
        return specialPrice;
    }
}
