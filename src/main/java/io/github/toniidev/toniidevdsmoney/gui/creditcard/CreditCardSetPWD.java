package io.github.toniidev.toniidevdsmoney.gui.creditcard;

import io.github.toniidev.toniidevdsmoney.classes.CustomItemStack;
import io.github.toniidev.toniidevdsmoney.helpers.inventory.InvHelper;
import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class CreditCardSetPWD {
    private CreditCard creditCard;
    private String pwd = " ";

    public CreditCardSetPWD(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public CreditCardSetPWD(CreditCard creditCard, String pwd) {
        this.creditCard = creditCard;
        this.pwd = pwd;
    }

    public Inventory initialize(){
        String title = "Scegli una password";

        Inventory inv = Bukkit.createInventory(null, 9, title);
        inv.setItem(4, new CustomItemStack(Material.BIRCH_SIGN)
                .rename("§oScegli una password", false)
                .setLore("§l[PASSWORD SCELTA] §r" + (pwd.equals(" ") ? "--" : pwd)));
        inv.setItem(7, new CustomItemStack(Material.RED_CONCRETE)
                .rename("§r§lINDIETRO", false));
        inv.setItem(8, new CustomItemStack(Material.GREEN_CONCRETE)
                .rename("§r§lCONFERMA", false));

        InvHelper.disableClicksHandler(inv);
        InvHelper.fillWithGlass(inv);
        return inv;
    }
}
