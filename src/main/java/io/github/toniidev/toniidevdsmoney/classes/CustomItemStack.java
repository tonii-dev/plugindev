package io.github.toniidev.toniidevdsmoney.classes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CustomItemStack extends ItemStack {

    public CustomItemStack(Material material) {
        super(material);
    }

    public CustomItemStack(Material material, int amount) {
        super(material, amount);
    }

    public CustomItemStack rename(String newName, boolean special) {
        String specialName = "";
        if(special){
            char first = newName.toCharArray()[0];
            specialName = "§r§f§l[ §k" + first + "§r§f§l ] §r§f" + newName;
        }

        ItemMeta meta = this.getItemMeta();
        meta.setDisplayName(special ? specialName : newName);
        this.setItemMeta(meta);
        return this;
    }

    public CustomItemStack setSpecialEnchanted(boolean value){
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

    public boolean isSpecialEnchanted(){
        final Enchantment enchant = this.getType().equals(Material.BOW) ?
                Enchantment.PROTECTION_ENVIRONMENTAL :
                Enchantment.ARROW_INFINITE;

        final ItemFlag flag = ItemFlag.HIDE_ENCHANTS;

        for(Map.Entry<Enchantment, Integer> enc : this.getItemMeta().getEnchants().entrySet()) {
            System.out.println(enc.getKey());
        }

        for(ItemFlag f : this.getItemMeta().getItemFlags()){
            System.out.println(f);
        }

        return this.getItemMeta().hasEnchant(enchant) &&
                this.getItemMeta().hasItemFlag(flag);
    }

    public CustomItemStack setLore(String... lore){
        List<String> actualLore = new ArrayList<>();
        for(String line : lore){
            actualLore.add("§r§f" + line);
        }

        ItemMeta meta = this.getItemMeta();
        meta.setLore(actualLore);
        this.setItemMeta(meta);
        return this;
    }

    public CustomItemStack setLore(List<String> lore){
        List<String> actualLore = new ArrayList<>();
        for(String line : lore){
            actualLore.add("§r§f" + line);
        }

        ItemMeta meta = this.getItemMeta();
        meta.setLore(actualLore);
        this.setItemMeta(meta);
        return this;
    }

    public CustomItemStack addLore(String... lore){
        ItemMeta meta = this.getItemMeta();
        List<String> actualLore = meta.getLore() == null ?
                new ArrayList<>() : meta.getLore();
        for(String line : lore){
            actualLore.add("§r§f" + line);
        }

        meta.setLore(actualLore);
        this.setItemMeta(meta);
        return this;
    }

    public List<String> replaceLoreLine(Integer lineIndex, String newLine){
        List<String> newLore = this.getLore();
        newLore.set(lineIndex, newLine);
        return newLore;
    }

    public List<String> getLore(){
        return this.getItemMeta().getLore();
    }

    public static CustomItemStack parse(ItemStack itemStack){
        CustomItemStack parsed = new CustomItemStack(itemStack.getType(), itemStack.getAmount());
        parsed.setItemMeta(itemStack.getItemMeta());

        return parsed;
    }
}

