package io.github.toniidev.toniidevdsmoney.listeners;

import io.github.toniidev.toniidevdsmoney.handlers.MessageHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class ChatListener implements Listener {
    private static List<Player> playersChoosingPWD;

    public static List<Player> getPlayersChoosingPWD() {
        return playersChoosingPWD;
    }

    public static void setPlayersChoosingPWD(List<Player> playersChoosingPWD) {
        ChatListener.playersChoosingPWD = playersChoosingPWD;
    }

    public static void startWatchingPlayer(Player p){
        ChatListener.playersChoosingPWD.add(p);
    }

    public static void stopWatchingPlayer(Player p){
        ChatListener.playersChoosingPWD.add(p);
    }

    private final MessageHandler messageHandler;

    public ChatListener(MessageHandler messageHandler){
        this.messageHandler = messageHandler;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        String message = e.getMessage();

        if(getPlayersChoosingPWD().contains(e.getPlayer())) {
            e.setCancelled(true);
            messageHandler.pinHandler(message, e.getPlayer());
        }
    }
}
