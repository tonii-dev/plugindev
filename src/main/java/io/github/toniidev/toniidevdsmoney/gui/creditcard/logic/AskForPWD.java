package io.github.toniidev.toniidevdsmoney.gui.creditcard.logic;

import io.github.toniidev.toniidevdsmoney.gui.creditcard.CreditCardSetPWD;
import io.github.toniidev.toniidevdsmoney.handlers.MessageHandler;
import io.github.toniidev.toniidevdsmoney.helpers.ChatHelper;
import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import io.github.toniidev.toniidevdsmoney.listeners.ChatListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AskForPWD implements MessageHandler, Listener {
    String inventoryTitle = "Scegli una password";
    CreditCard card = new CreditCard();
    Plugin plugin;

    public AskForPWD(Plugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(!e.getView().getTitle().equals(inventoryTitle)) return;
        if(e.getRawSlot() != 4) return;

        Player p = (Player) e.getWhoClicked();
        card = CreditCard.parse(p.getInventory().getItemInMainHand());

        p.closeInventory();
        ChatHelper.sendMessage("CARTA DI CREDITO",
                "Scrivi in chat una password per la tua carta di credito", p);
        ChatListener.startWatchingPlayer(p);
    }

    @Override
    public void pinHandler(String message, Player sender) {
        new BukkitRunnable(){
            @Override
            public void run(){
                sender.openInventory(new CreditCardSetPWD(card, message).initialize());
            }
        }.runTask(plugin);
    }
}
