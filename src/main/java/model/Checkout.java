package main.java.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Checkout {

    private List<Rule> rules;

    public Checkout(ArrayList<Rule> rules) {
        this.rules = rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Rule> getRules() {
        return rules;
    }


}
