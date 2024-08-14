package io.github.toniidev.toniidevdsmoney.classes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomItem extends ItemStack {
    public CustomItem() {
    }

    public CustomItem(Material type) {
        super(type);
    }

    public CustomItem(Material type, int amount) {
        super(type, amount);
    }

    public CustomItem(ItemStack stack) throws IllegalArgumentException {
        super(stack);
    }

    private void sendMissingItemMetaWarning(){
        Bukkit.getLogger()
                .warning("Unable to edit " + this.getType() +
                        ": No ItemMeta");
    }

    public CustomItem rename(String newName, boolean special){
        if(!this.hasItemMeta()) {
            sendMissingItemMetaWarning();
            return this;
        }

        String specialName = "";
        if(special){
            char first = newName.toCharArray()[0];
            specialName = "[§k" + first + "§r] " + newName;
        }

        ItemMeta meta = this.getItemMeta();
        meta.setDisplayName(special ? specialName : newName);
        this.setItemMeta(meta);
        return this;
    }

    public CustomItem setSpecialEnchanted(boolean value){
        if(!this.hasItemMeta()) {
            sendMissingItemMetaWarning();
            return this;
        }

        final Enchantment enchant = this.getType().equals(Material.BOW) ?
                Enchantment.PROTECTION_ENVIRONMENTAL :
                Enchantment.ARROW_INFINITE;

        final ItemFlag flag = ItemFlag.HIDE_ENCHANTS;

        if(value){
            if(!this.getItemMeta().hasEnchant(enchant))
                this.addUnsafeEnchantment(enchant, 1);
            if(!this.getItemMeta().hasItemFlag(flag)){
                ItemMeta meta = this.getItemMeta();
                meta.addItemFlags(flag);
                this.setItemMeta(meta);
            }
        }
        else{
            if(this.getItemMeta().hasEnchant(enchant))
                this.removeEnchantment(enchant);
            if(this.getItemMeta().hasItemFlag(flag)){
                ItemMeta meta = this.getItemMeta();
                meta.removeItemFlags(flag);
                this.setItemMeta(meta);
            }
        }
        return this;
    }

    public CustomItem setLore(String... lore){
        if(!this.hasItemMeta()) {
            sendMissingItemMetaWarning();
            return this;
        }

        List<String> actualLore = new ArrayList<>();
        for(String line : lore){
            actualLore.add("§r§f" + line);
        }

        ItemMeta meta = this.getItemMeta();
        meta.setLore(actualLore);
        this.setItemMeta(meta);
        return this;
    }

    public CustomItem addLore(String... lore){
        if(!this.hasItemMeta()) {
            sendMissingItemMetaWarning();
            return this;
        }

        ItemMeta meta = this.getItemMeta();
        List<String> actualLore = meta.getLore();
        for(String line : lore){
            actualLore.add("§r§f" + line);
        }

        meta.setLore(actualLore);
        this.setItemMeta(meta);
        return this;
    }

    public List<String> getLore(){
        return this.getItemMeta().getLore();
    }
}
