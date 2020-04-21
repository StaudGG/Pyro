package me.staud.pyro.command;

import me.staud.pyro.PyroPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class InvseeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PyroPlugin.instance.getConfig().getString("EXECUTOR")));
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PyroPlugin.instance.getConfig().getString("PLAYER.OFFLINE")));
            return true;
        }
        Player player = (Player) sender;
        Inventory inventory = Bukkit.createInventory((InventoryHolder) null, 45, ChatColor.translateAlternateColorCodes('&', "&7Inventory ") + target.getName());
        if (target.getInventory().getHelmet() != null) ;
        inventory.setItem(33, target.getInventory().getHelmet());

        if(target.getInventory().getChestplate() != null) {
            inventory.setItem(34, target.getInventory().getChestplate());
        }
        if(target.getInventory().getLeggings() != null) {
            inventory.setItem(35, target.getInventory().getLeggings());
        }
        if(target.getInventory().getBoots() != null) {
            inventory.setItem(36, target.getInventory().getBoots());
        }
        for(int i = 9; i < target.getInventory().getSize() + 9; i++) {
            inventory.setItem(i, target.getInventory().getItem(i - 9));
        }
        player.openInventory(inventory);
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PyroPlugin.instance.getConfig().getString("INVSEE")).replace("%target%", target.getName()));
        return true;
    }
}
