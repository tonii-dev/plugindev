package io.github.toniidev.toniidevdsmoney.gui.creditcard.logic;

import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClosePWD implements Listener {
    String inventoryTitle = "Scegli una password";

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().equals(inventoryTitle)) return;
        if (e.getRawSlot() != 7) return;

        e.getWhoClicked().closeInventory();
    }
}
