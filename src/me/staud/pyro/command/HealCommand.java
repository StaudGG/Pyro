package me.staud.pyro.command;

import me.staud.pyro.PyroPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PyroPlugin.instance.getConfig().getString("EXECUTOR")));
            return true;
        }
        Player player = (Player)sender;
        player.setHealthScale(20);
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PyroPlugin.instance.getConfig().getString("HEAL")));
        return true;
    }
}
