package main.java.model;

public class Rule {

    private int amount;
    private int price;

    public Rule(int amount, int price) {

        this.amount = amount;
        this.price = price;
    }

    public void setAmount(int amount) {
    this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
