package main.java.service;

import main.java.model.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckoutService {

    private HashMap<String, Integer> counter;

    public HashMap<String, Integer> getCounter() {
        return counter;
    }

    public int scanItem(Item item) {
        return item.getPrice();
    }

    public int sumPrices(Item... items) {
        return getSpecialPrice(items) + getNormalPrice(items);
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
            }else{
                specialPrice = 0;
            }
        }
        return specialPrice;
    }

    public int getNormalPrice(Item... items) {
        List<String> countItems = new ArrayList<>();
        if (counter == null) {
            counter = new HashMap<>();
        }
        counter.clear();
        countItems(items);
        int normalPrice = 0;
        for (Item item : items) {
            if (item.getRule() != null && !countItems.contains(item.getName())) {
                normalPrice = normalPrice+(counter.get(item.getName()) % item.getRule().getAmount()) * scanItem(item);
            }else if(item.getRule() == null){
                normalPrice = normalPrice +scanItem(item);
            }
            countItems.add(item.getName());
        }
        return normalPrice;
    }
}
