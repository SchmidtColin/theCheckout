package main.java.model.enumeration;

public enum ITEM {

    A(50),
    B(30),
    C(20),
    D(15);

    private int price;

    ITEM(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

}
