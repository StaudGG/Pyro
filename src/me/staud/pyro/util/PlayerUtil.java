package me.staud.pyro.util;

import me.staud.pyro.PyroPlugin;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlayerUtil {

    public static Collection<Player> getOnlinePlayers() {
        List<Player> players = new ArrayList<>();
        for(Player player : PyroPlugin.getInstance().getServer().getOnlinePlayers()) {
            players.add(player);
        }
        return players;
    }
}