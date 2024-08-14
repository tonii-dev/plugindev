package io.github.toniidev.toniidevdsmoney.gui.bancomat;

import io.github.toniidev.toniidevdsmoney.classes.CustomItem;
import io.github.toniidev.toniidevdsmoney.helpers.inventory.InvHelper;
import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import io.github.toniidev.toniidevdsmoney.items.premade.MoneyInstances;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class BancomatWithdraw {
    private CreditCard creditCard;

    public BancomatWithdraw(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Inventory initialize(){
        String title = "§o/bancomat/preleva";

        Inventory inv = Bukkit.createInventory(null, 45, title);
        inv.setItem(9, MoneyInstances.FIFTY_CENTS);
        inv.setItem(10, MoneyInstances.ONE_EURO);
        inv.setItem(11, MoneyInstances.TWO_EUROS);
        inv.setItem(12, MoneyInstances.FIVE_EUROS);
        inv.setItem(13, MoneyInstances.TEN_EUROS);
        inv.setItem(14, MoneyInstances.TWENTY_EUROS);
        inv.setItem(15, MoneyInstances.FIFTY_EUROS);
        inv.setItem(16, MoneyInstances.ONE_HUNDRED_EUROS);
        inv.setItem(17, MoneyInstances.FIVE_HUNDRED_EUROS);

        inv.setItem(29, new CustomItem(Material.STICK)
                .rename("§lINDIETRO", false));
        inv.setItem(31, creditCard.addLore("§l[SALDO]§r " +
                creditCard.getMoney() + "€"));
        inv.setItem(33, new CustomItem(Material.ARROW)
                .rename("§lESCI", false));

        InvHelper.disableClicks(inv);
        InvHelper.addRedirect(29, new BancomatHome(creditCard).initialize(), inv);
        return inv;
    }
}
