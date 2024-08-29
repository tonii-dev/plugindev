package io.github.toniidev.toniidevdsmoney.items;

import io.github.toniidev.toniidevdsmoney.classes.CustomItemStack;

public class Money extends CustomItemStack {
    private double value;

    public Money(double amount, CustomItemStack item) {
        super(item.getType());
        this.value = amount;
    }

    public double getValue() {
        return value;
    }
}
