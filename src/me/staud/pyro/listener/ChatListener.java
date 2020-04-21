package me.staud.pyro.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String prefix = PermissionsEx.getUser(event.getPlayer()).getGroups()[0].getPrefix().replace("_", " ").replace("&", "§") + event.getPlayer().getName();
        String message = event.getMessage().replace("%", "%%");
        event.setFormat(prefix + " §f" + message);
    }
}
