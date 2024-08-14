package io.github.toniidev.toniidevdsmoney.items;

import io.github.toniidev.toniidevdsmoney.classes.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class CreditCard extends CustomItem {
    private String number;
    private String password;
    private double money;
    private boolean active;

    private void initializeAsItemStack(){
        this.setType(Material.AMETHYST_SHARD);
        this.rename("Carta di credito", true);
        this.addLore("§l[CODICE] " + this.number);
        this.addLore("§l[STATO CARTA] " + (this.active ? "Attivata" : "Disattivata"));
        this.setSpecialEnchanted(true);
    }

    public CreditCard(String number, String password, double money, boolean active) {
        this.number = number;
        this.password = password;
        this.money = money;
        this.active = active;

        initializeAsItemStack();
    }

    public CreditCard(){
        // number
        Random random = new Random();
        StringBuilder sb = new StringBuilder("5333 ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(random.nextInt(10));
            }
            if (i < 2) {
                sb.append(" ");
            }
        }

        this.number = sb.toString();
        this.active = false;
        this.money = 0;

        initializeAsItemStack();
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public double getMoney() {
        return money;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void addMoney(double amount){
        money += amount;
    }

    public void removeMoney(double amount){
        money -= amount;
    }

    public void activate(String password){
        this.password = password;
        this.active = true;
    }

    public void disable(){
        this.active = false;
    }

    public boolean getStatus(){
        return active;
    }
}
