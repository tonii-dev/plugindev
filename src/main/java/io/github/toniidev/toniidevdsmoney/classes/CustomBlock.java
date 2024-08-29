package io.github.toniidev.toniidevdsmoney.classes;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;

public class CustomBlock implements Cloneable {
    private Block block;
    private String blockName;

    public CustomBlock(Block b, String bn){
        block = b;
        blockName = bn;
    }

    public Block getBlock() {
        return block;
    }

    public String getBlockName() {
        return blockName;
    }

    public void initialize(){
        Location loc = block.getLocation()
                .add(0.5, 1.5, 0.5);

        ArmorStand stand = block.getWorld()
                .spawn(loc, ArmorStand.class);

        stand.setCustomName(blockName);
        stand.setCustomNameVisible(true);
        stand.setCollidable(false);
        stand.setGravity(false);
        stand.setInvisible(true);
        stand.setInvulnerable(true);

        // TODO: add database link
    }
}
