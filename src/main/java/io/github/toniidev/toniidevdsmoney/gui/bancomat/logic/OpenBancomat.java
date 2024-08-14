package io.github.toniidev.toniidevdsmoney.gui.bancomat.logic;

import io.github.toniidev.toniidevdsmoney.blocks.Bancomat;
import io.github.toniidev.toniidevdsmoney.gui.bancomat.BancomatHome;
import io.github.toniidev.toniidevdsmoney.helpers.ChatHelper;
import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OpenBancomat implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        ItemStack itemInMainHand = e.getPlayer()
                .getInventory().getItemInMainHand();

        if(!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if(Bancomat.getBancomats().stream()
                .filter(x -> x.getBlock().equals(e.getClickedBlock()))
                .findFirst()
                .orElse(null) == null) return;

        if(!(itemInMainHand instanceof CreditCard)){
            ChatHelper.sendMessage("bancomat",
                    "Per accedere al bancomat, devi avere una carta" +
                            "di credito in mano", e.getPlayer());

            return;
        }

        CreditCard card = (CreditCard) itemInMainHand;

        if(!card.getStatus()){
            ChatHelper.sendMessage("bancomat",
                    "La carta di credito che stai utilizzando" +
                            "non è attiva", e.getPlayer());

            return;
        }

        e.getPlayer().openInventory(new BancomatHome(card).initialize());
    }
}
