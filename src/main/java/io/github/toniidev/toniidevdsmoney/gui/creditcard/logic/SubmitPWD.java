package io.github.toniidev.toniidevdsmoney.gui.creditcard.logic;

import io.github.toniidev.toniidevdsmoney.classes.CustomItemStack;
import io.github.toniidev.toniidevdsmoney.helpers.ChatHelper;
import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SubmitPWD implements Listener {
    String inventoryTitle = "Scegli una password";
    CreditCard card = new CreditCard();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (!e.getView().getTitle().equals(inventoryTitle)) return;
        if(e.getClickedInventory().equals(e.getWhoClicked().getInventory())) {
            e.setCancelled(true);
            return;
        }
        if (e.getRawSlot() != 8) return;

        Player p = (Player) e.getWhoClicked();
        card = CreditCard.parse(p.getInventory().getItemInMainHand());

        CustomItemStack sign = CustomItemStack.parse(e.getClickedInventory().getItem(4));
        e.getWhoClicked().getInventory()
                .setItem(e.getWhoClicked().getInventory().getHeldItemSlot(),
                        card.activate(sign.getLore().get(0)
                                .replace("§f§l[PASSWORD SCELTA] ", "")));

        p.closeInventory();
        ChatHelper.sendMessage("CARTA DI CREDITO",
                "Password impostata con successo: §o" + card.getPassword(), p);
    }
}
