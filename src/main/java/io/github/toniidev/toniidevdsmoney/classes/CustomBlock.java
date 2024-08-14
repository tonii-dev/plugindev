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
        ArmorStand stand = block.getWorld()
                .spawn(block.getLocation(), ArmorStand.class);

        stand.setCustomName(blockName);
        stand.setCustomNameVisible(true);
        stand.setCollidable(false);
        stand.setGravity(false);
        stand.setInvisible(true);
        stand.setInvulnerable(true);

        // TODO: add database link
    }
}
