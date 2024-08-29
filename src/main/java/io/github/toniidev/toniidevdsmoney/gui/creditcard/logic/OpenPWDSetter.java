package io.github.toniidev.toniidevdsmoney.gui.creditcard.logic;

import io.github.toniidev.toniidevdsmoney.classes.CustomItemStack;
import io.github.toniidev.toniidevdsmoney.gui.bancomat.BancomatHome;
import io.github.toniidev.toniidevdsmoney.gui.creditcard.CreditCardSetPWD;
import io.github.toniidev.toniidevdsmoney.helpers.ChatHelper;
import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
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
            if(e.getAction().equals(Action.RIGHT_CLICK_AIR)){
                ChatHelper.sendMessage("CARTA DI CREDITO",
                        "Questa carta di credito è già attiva.",
                        e.getPlayer());

                return;
            }

            if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                if(!e.getClickedBlock().getType().equals(Material.CHISELED_QUARTZ_BLOCK)){
                    ChatHelper.sendMessage("CARTA DI CREDITO",
                            "Questa carta di credito è già attiva.",
                            e.getPlayer());

                    return;
                }
            }

            return;
        }

        e.getPlayer().openInventory(new CreditCardSetPWD(card).initialize());
    }
}
