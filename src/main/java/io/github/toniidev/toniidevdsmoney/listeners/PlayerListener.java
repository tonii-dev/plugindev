package io.github.toniidev.toniidevdsmoney.listeners;

import io.github.toniidev.toniidevdsmoney.blocks.Bancomat;
import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Bancomat.giveBancomat(e.getPlayer());
        e.getPlayer().getInventory().addItem(new CreditCard());
    }
}
