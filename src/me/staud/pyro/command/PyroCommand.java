package me.staud.pyro.command;

import me.staud.pyro.PyroPlugin;
import me.staud.pyro.util.ItemBuilderUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class PyroCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PyroPlugin.instance.getConfig().getString("EXECUTOR")));
            return true;
        }
        if (!sender.hasPermission("pyro.admin")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PyroPlugin.instance.getConfig().getString("NO.PERMISSION")));
            return true;
        }
        Player player = (Player)sender;
        Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 9, ChatColor.translateAlternateColorCodes('&', "&6Pyro Menu"));
        player.openInventory(inventory);
        ItemStack items = new ItemBuilderUtil(Material.BOOK).setName(ChatColor.translateAlternateColorCodes('&', "&6Items")).create();
        inventory.setItem(4, items);
        return true;
    }
}
