package io.github.toniidev.toniidevdsmoney.items;

import io.github.toniidev.toniidevdsmoney.classes.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreditCard extends CustomItemStack {
    private String number;
    private String password;
    private double money;
    private boolean active;

    private void initializeAsItemStack(){
        this.rename("Carta di credito", true);
        this.addLore("§l[CODICE] §r§o" + this.number);
        this.addLore("§l[STATO CARTA] §r§o" + (this.active ? "Attivata" : "Disattivata"));
        this.setSpecialEnchanted(true);
    }

    public static CreditCard parse(CustomItemStack stack){
        String number = stack.getLore().get(0).replace("§l[CODICE] §r§o", "");
        boolean active = stack.getLore().get(1).replace("§l[STATO CARTA] §r§o", "")
                .equals("Attivata");

        CreditCard cc = CreditCard.ccs.stream()
                .filter(x -> x.getNumber().equals(number))
                .filter(x -> x.getStatus() == active)
                .findFirst().orElse(null);

        return cc;
    }

    public static CreditCard parse(ItemStack stack){
        String number = stack.getItemMeta().getLore().get(0).replace("§f§l[CODICE] §r§o", "");
        boolean active = stack.getItemMeta().getLore().get(1).replace("§f§l[STATO CARTA] §r§o", "")
                .equals("Attivata");

        System.out.println(number);

        for(CreditCard credc : ccs) System.out.println(credc.getNumber());

        CreditCard cc = CreditCard.ccs.stream()
                .filter(x -> x.getNumber().equals(number))
                .filter(x -> x.getStatus() == active)
                .findFirst().orElse(null);

        return cc;
    }

    public static boolean check(ItemStack item){
        System.out.println(item.getItemMeta().getDisplayName());

        return item.getItemMeta().getDisplayName().endsWith("§fCarta di credito") &&
                CustomItemStack.parse(item).isSpecialEnchanted();
    }

    public CreditCard(String number, String password, double money, boolean active) {
        super(Material.AMETHYST_SHARD);
        this.number = number;
        this.password = password;
        this.money = money;
        this.active = active;

        initializeAsItemStack();
    }

    public CreditCard(){
        super(Material.AMETHYST_SHARD);
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
        CreditCard.ccs.add(this);
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
        this.setLore(this.
                replaceLoreLine(1, this.getLore().get(1).replace("Disattivata", "Attivata")));
        this.active = true;
    }

    public void disable(){
        this.replaceLoreLine(1, this.getLore().get(1).replace("Attivata", "Disattivata"));
        this.active = false;
    }

    public boolean getStatus(){
        return active;
    }

    private static List<CreditCard> ccs = new ArrayList<>();
}
