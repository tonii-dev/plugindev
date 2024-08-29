package io.github.toniidev.toniidevdsmoney.helpers;

import io.github.toniidev.toniidevdsmoney.blocks.Bancomat;
import io.github.toniidev.toniidevdsmoney.gui.bancomat.logic.OpenBancomat;
import io.github.toniidev.toniidevdsmoney.gui.bancomat.logic.Withdraw;
import io.github.toniidev.toniidevdsmoney.gui.creditcard.logic.AskForPWD;
import io.github.toniidev.toniidevdsmoney.gui.creditcard.logic.ClosePWD;
import io.github.toniidev.toniidevdsmoney.gui.creditcard.logic.OpenPWDSetter;
import io.github.toniidev.toniidevdsmoney.gui.creditcard.logic.SubmitPWD;
import io.github.toniidev.toniidevdsmoney.helpers.inventory.InvHelper;
import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import io.github.toniidev.toniidevdsmoney.listeners.ChatListener;
import io.github.toniidev.toniidevdsmoney.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class EventsLoaderHelper {
    private Plugin plugin;

    public EventsLoaderHelper(Plugin p){
        this.plugin = p;
    }

    public void load(){
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new ChatListener(new AskForPWD(plugin)), plugin);
        Bukkit.getPluginManager().registerEvents(new InvHelper(), plugin);
        Bukkit.getPluginManager().registerEvents(new OpenBancomat(), plugin);
        Bukkit.getPluginManager().registerEvents(new Withdraw(new CreditCard()), plugin);
        Bukkit.getPluginManager().registerEvents(new AskForPWD(plugin), plugin);
        Bukkit.getPluginManager().registerEvents(new ClosePWD(), plugin);
        Bukkit.getPluginManager().registerEvents(new OpenPWDSetter(), plugin);
        Bukkit.getPluginManager().registerEvents(new SubmitPWD(), plugin);
        Bukkit.getPluginManager().registerEvents(new Bancomat(), plugin);
    }
}
