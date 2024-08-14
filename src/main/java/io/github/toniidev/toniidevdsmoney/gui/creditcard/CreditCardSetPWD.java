package io.github.toniidev.toniidevdsmoney.gui.creditcard;

import io.github.toniidev.toniidevdsmoney.classes.CustomItem;
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
        inv.setItem(4, new CustomItem(Material.BIRCH_SIGN)
                .rename("§oScegli una password", false)
                .setLore("§l[PASSWORD SCELTA] " + (pwd.equals(" ") ? "--" : pwd)));
        inv.setItem(7, new CustomItem(Material.RED_CONCRETE)
                .rename("§lINDIETRO", false));
        inv.setItem(8, new CustomItem(Material.GREEN_CONCRETE)
                .rename("§lCONFERMA", false));

        InvHelper.disableClicks(inv);
        InvHelper.fillWithGlass(inv);
        return inv;
    }
}
