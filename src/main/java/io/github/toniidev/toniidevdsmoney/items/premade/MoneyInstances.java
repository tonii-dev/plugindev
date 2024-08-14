package io.github.toniidev.toniidevdsmoney.items.premade;

import io.github.toniidev.toniidevdsmoney.classes.CustomItem;
import io.github.toniidev.toniidevdsmoney.items.Money;
import org.bukkit.Material;

public class MoneyInstances {

    public static Money FIFTY_CENTS = new Money(0.50,
            new CustomItem(Material.IRON_NUGGET, 1)
            .rename("0.50€", true)
            .setSpecialEnchanted(true));

    public static Money ONE_EURO = new Money(1,
            new CustomItem(Material.GOLD_NUGGET, 1)
            .rename("1€", true)
            .setSpecialEnchanted(true));

    public static Money TWO_EUROS = new Money(2,
            new CustomItem(Material.COPPER_INGOT, 1)
            .rename("2€", true)
            .setSpecialEnchanted(true));

    public static Money FIVE_EUROS = new Money(5,
            new CustomItem(Material.COAL, 1)
            .rename("5€", true)
            .setSpecialEnchanted(true));

    public static Money TEN_EUROS = new Money(10,
            new CustomItem(Material.IRON_INGOT, 1)
            .rename("10€", true)
            .setSpecialEnchanted(true));

    public static Money TWENTY_EUROS = new Money(20,
            new CustomItem(Material.GOLD_INGOT, 1)
            .rename("20€", true)
            .setSpecialEnchanted(true));

    public static Money FIFTY_EUROS = new Money(50,
            new CustomItem(Material.LAPIS_LAZULI, 1)
            .rename("50€", true)
            .setSpecialEnchanted(true));

    public static Money ONE_HUNDRED_EUROS = new Money(100,
            new CustomItem(Material.EMERALD, 1)
            .rename("100€", true)
            .setSpecialEnchanted(true));

    public static Money FIVE_HUNDRED_EUROS = new Money(500,
            new CustomItem(Material.DIAMOND, 1)
            .rename("500€", true)
            .setSpecialEnchanted(true));
}
