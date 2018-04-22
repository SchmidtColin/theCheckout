package main.java.service;

import main.java.model.Item;
import main.java.model.Rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckoutService {

    private HashMap<String, Integer> counter;

    public HashMap<String, Integer> getCounter() {
        return counter;
    }

    public int scanItem(Item... items) {
        int sum = 0;
        for (Item item : items) {
            sum = sum+item.getPrice();
        }
        return sum;
    }

    public int sumPrices(Item... items) {
        int total = getSpecialPrice(items) + getNormalPrice(items);
        counter.clear();
        return total;

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
        List<String> countItems = new ArrayList<>();
        if (counter == null) {
            counter = new HashMap<>();
        }
        counter.clear();
        countItems(items);
        int specialPrice = 0;
        for (Item item : items) {
            if (item.getRule() != null && counter.get(item.getName()) / item.getRule().getAmount() != 0 && !countItems.contains(item.getName())) {
                specialPrice = specialPrice + (counter.get(item.getName()) / item.getRule().getAmount()) * item.getRule().getSpecialPrice();
            }
            countItems.add(item.getName());
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
            if (item.getSpecialPrice() != 0 && !countItems.contains(item.getName())) {
                normalPrice = normalPrice+(counter.get(item.getName()) % item.getRule().getAmount()) * scanItem(item);
            }else if(item.getSpecialPrice() == 0){
                normalPrice = normalPrice +scanItem(item);
            }
            countItems.add(item.getName());
        }
        return normalPrice;
    }

    public int incrementPrices(Item item) {
        if (counter == null) {
            counter = new HashMap<>();
        }
        countItems(item);
        int incrementalPrice = 0;
        if(item.getSpecialPrice() != 0 && counter.get(item.getName()) / item.getRule().getAmount() != 0){
            incrementalPrice = -((item.getRule().getAmount()-1)*scanItem(item));
            incrementalPrice = incrementalPrice + (counter.get(item.getName()) / item.getRule().getAmount()) * item.getRule().getSpecialPrice();
        }else{
            incrementalPrice = incrementalPrice +scanItem(item);
        }
        return incrementalPrice;
    }



    public Item fillItemByRule(char itemName, List<Rule> rules) {
        Item scannedItem = null;
        for (Rule rule : rules) {
            if(rule.getItemName().charAt(0) == itemName){
                scannedItem = new Item(""+itemName);
                scannedItem.setRule(rule);
                scannedItem.setPrice(rule.getNormalPrice());
                scannedItem.setSpecialPrice(rule.getSpecialPrice());
            }
        }
        return scannedItem;
    }
}
