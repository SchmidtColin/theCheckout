package main.java.model;


public class Item {

    private Rule rule;
    private String name;
    private int price;
    private int specialPrice;

    public Item(String name) {
        this.name = name;
    }

    public int getPrice(){
        switch (name){
            default : return price;
        }
    }

    public String getName() {
        return name;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSpecialPrice(int specialPrice) {
        this.specialPrice = specialPrice;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }
}
