package io.github.toniidev.toniidevdsmoney.helpers.inventory;

import io.github.toniidev.toniidevdsmoney.items.CreditCard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InvHelper implements Listener {
    private static final List<Inventory> disabled = new ArrayList<>();
    private static final List<HashMap<Inventory, HashMap<Integer, Inventory>>> redirects = new ArrayList<>();

    @EventHandler
    public void disableClicksHandler(InventoryClickEvent e){
        if(disabled.contains(e.getClickedInventory())) e.setCancelled(true);
    }

    @EventHandler
    public void manageRedirects(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        int slot = e.getRawSlot();

        for (HashMap<Inventory, HashMap<Integer, Inventory>> obj : redirects) {
            if (obj.containsKey(inv)) {
                HashMap<Integer, Inventory> slotMap = obj.get(inv);
                if (slotMap.containsKey(slot)) {
                    Inventory redirectInventory = slotMap.get(slot);
                    e.getWhoClicked().openInventory(redirectInventory);
                    break;
                }
            }
        }
    }

    public static void disableClicksHandler(Inventory inventory){
        disabled.add(inventory);
    }

    public static void addRedirect(int slot, Inventory redirect, Inventory currentInventory){
        HashMap<Integer, Inventory> first = new HashMap<>();
        first.put(slot, redirect);

        HashMap<Inventory, HashMap<Integer, Inventory>> second = new HashMap<>();
        second.put(currentInventory, first);

        redirects.add(second);
    }

    public static void fillWithGlass(Inventory inv){
        for(int i = 0; i < inv.getSize(); i++){
            if(inv.getItem(i) == null) inv.setItem(i, InvItems.glass);
        }
    }

    public static void refreshCreditCardSlot(Inventory inv){
        for(int i = 0; i < inv.getSize(); i++){
            if(inv.getItem(i) instanceof CreditCard) {
                CreditCard creditCard = (CreditCard) inv.getItem(i);
                inv.setItem(i, creditCard.addLore("§l[SALDO]§r " +
                        creditCard.getMoney() + "€"));
            }
        }
    }
}
