package me.staud.pyro.command;

import me.staud.pyro.PyroPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PyroPlugin.instance.getConfig().getString("EXECUTOR")));
            return true;
        }
        if(!sender.hasPermission("pyro.admin")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PyroPlugin.instance.getConfig().getString("NO.PERMISSION")));
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PyroPlugin.instance.getConfig().getString("USAGE.RENAME")));
            return true;
        }
        Player player = (Player)sender;
        if (player.getItemInHand() != null && !player.getItemInHand().getType().equals(Material.AIR)) {
            ItemMeta meta = player.getItemInHand().getItemMeta();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < args.length; i ++) {
                stringBuilder.append(args[i]).append(" ");
            }
            meta.setDisplayName(stringBuilder.toString());
            player.getItemInHand().setItemMeta(meta);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PyroPlugin.instance.getConfig().getString("ITEM.RENAMED")));
            return true;
        }
        return false;
    }
}
