package io.github.toniidev.toniidevdsmoney.gui.bancomat.logic;

import io.github.toniidev.toniidevdsmoney.helpers.inventory.InvHelper;
import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import io.github.toniidev.toniidevdsmoney.items.Money;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Withdraw implements Listener {
    private final CreditCard creditCard;

    public Withdraw(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getClickedInventory() == null) return;
        if(!(e.getCurrentItem() instanceof Money)) return;

        Money item = (Money) e.getCurrentItem();
        double amount = item.getValue();

        if(creditCard.getMoney() >= amount){
            creditCard.removeMoney(amount);
            e.getWhoClicked().getInventory().addItem(item);
            InvHelper.refreshCreditCardSlot(e.getClickedInventory());
        }
    }
}
