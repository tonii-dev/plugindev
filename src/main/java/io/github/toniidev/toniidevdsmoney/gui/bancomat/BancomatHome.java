package io.github.toniidev.toniidevdsmoney.gui.bancomat;

import io.github.toniidev.toniidevdsmoney.classes.CustomItem;
import io.github.toniidev.toniidevdsmoney.helpers.inventory.InvHelper;
import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class BancomatHome {
    private CreditCard creditCard;

    public BancomatHome(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Inventory initialize(){
        String title = "§o/bancomat/home";

        Inventory inv = Bukkit.createInventory(null, 9, title);
        inv.setItem(4, new CustomItem(Material.GREEN_CONCRETE)
                .rename("§lPRELEVA", false));
        inv.setItem(8, creditCard.addLore("§l[SALDO]§r " +
                creditCard.getMoney() + "€"));

        InvHelper.fillWithGlass(inv);
        InvHelper.disableClicksHandler(inv);
        InvHelper.addRedirect(4, new BancomatWithdraw(creditCard).initialize(), inv);
        return inv;
    }
}
