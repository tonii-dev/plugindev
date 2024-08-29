package io.github.toniidev.toniidevdsmoney.blocks;

import io.github.toniidev.toniidevdsmoney.classes.CustomBlock;
import io.github.toniidev.toniidevdsmoney.classes.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.List;

public class Bancomat implements Listener {
    private static List<CustomBlock> bancomats = new ArrayList<>();

    public static void addBancomat(CustomBlock bancomat){
        Bancomat.bancomats.add(bancomat);
    }

    public static void removeBancomat(CustomBlock bancomat){
        Bancomat.bancomats.remove(bancomat);
    }

    public static List<CustomBlock> getBancomats(){
        return bancomats;
    }

    private static CustomItemStack linkedItem = new CustomItemStack(Material.CHISELED_QUARTZ_BLOCK)
            .rename("Bancomat", true)
            .setSpecialEnchanted(true);

    public static void giveBancomat(Player player){
        player.getInventory().addItem(linkedItem);
    }

    @EventHandler
    public void handlePlacing(BlockPlaceEvent e){
        if(!e.getPlayer().getInventory().getItemInMainHand().isSimilar(linkedItem)) return;
        addBancomat(new CustomBlock(e.getBlockPlaced(), "Bancomat"));
    }

    @EventHandler
    public void handleBreak(BlockBreakEvent e){
        CustomBlock fetched = getBancomats().stream()
                .filter(x -> x.getBlock().equals(e.getBlock()))
                .findFirst()
                .orElse(null);

        if(fetched == null) return;
        removeBancomat(fetched);
    }
}
