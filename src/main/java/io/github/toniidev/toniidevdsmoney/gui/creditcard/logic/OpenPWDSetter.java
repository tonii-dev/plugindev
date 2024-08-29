package io.github.toniidev.toniidevdsmoney.gui.creditcard.logic;

import io.github.toniidev.toniidevdsmoney.classes.CustomItemStack;
import io.github.toniidev.toniidevdsmoney.gui.bancomat.BancomatHome;
import io.github.toniidev.toniidevdsmoney.gui.creditcard.CreditCardSetPWD;
import io.github.toniidev.toniidevdsmoney.helpers.ChatHelper;
import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OpenPWDSetter implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        ItemStack itemInMainHand = e.getPlayer()
                .getInventory().getItemInMainHand();

        if(!CreditCard.check(itemInMainHand))
            return;

        CreditCard card = CreditCard.parse(itemInMainHand);

        if(card.getStatus()){
            ChatHelper.sendMessage("CARTA DI CREDITO",
                    "Questa carta di credito è già attiva.",
                    e.getPlayer());

            return;
        }

        e.getPlayer().openInventory(new CreditCardSetPWD(card).initialize());
    }
}
