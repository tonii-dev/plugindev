package io.github.toniidev.toniidevdsmoney.items;

import io.github.toniidev.toniidevdsmoney.classes.CustomItem;

public class Money extends CustomItem {
    private double value;

    public Money(double amount, CustomItem item) {
        this.value = amount;
    }

    public double getValue() {
        return value;
    }
}
