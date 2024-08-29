package io.github.toniidev.toniidevdsmoney;

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
import org.bukkit.plugin.java.JavaPlugin;

public final class ToniiDevDSMoney extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(new AskForPWD(this)), this);
        Bukkit.getPluginManager().registerEvents(new InvHelper(), this);
        Bukkit.getPluginManager().registerEvents(new OpenBancomat(), this);
        Bukkit.getPluginManager().registerEvents(new Withdraw(new CreditCard()), this);
        Bukkit.getPluginManager().registerEvents(new AskForPWD(this), this);
        Bukkit.getPluginManager().registerEvents(new ClosePWD(), this);
        Bukkit.getPluginManager().registerEvents(new OpenPWDSetter(), this);
        Bukkit.getPluginManager().registerEvents(new SubmitPWD(), this);
        Bukkit.getPluginManager().registerEvents(new Bancomat(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
