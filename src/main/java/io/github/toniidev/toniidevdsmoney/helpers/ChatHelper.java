package io.github.toniidev.toniidevdsmoney.helpers;

import org.bukkit.entity.Player;

public class ChatHelper {
    public static void sendMessage(String title, String mess, Player player){
        String message = "§l[" + title.toUpperCase() + "]§r " + mess;
        player.sendMessage(message);
    }
}
