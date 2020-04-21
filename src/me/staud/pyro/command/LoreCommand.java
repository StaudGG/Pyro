package me.staud.pyro.command;

import me.staud.pyro.PyroPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.security.SecureRandom;
import java.util.ArrayList;

public class LoreCommand implements CommandExecutor {

    static SecureRandom random = new SecureRandom();

    PyroPlugin plugin;

    String randomString(int len) {
        StringBuilder stringBuilder = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            stringBuilder.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    .charAt(random.nextInt("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".length())));
        }
        return stringBuilder.toString();
    }

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
        Player player = (Player)sender;
        if (args[0].equals("lore")) {
            if(args[1].equals("add")) {
                player.getInventory().getItemInHand().getItemMeta().hasLore();
                ItemStack add = player.getInventory().getItemInHand();
                ItemMeta meta = add.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                lore.addAll(meta.getLore());
                lore.add("&a" + randomString(10));
                meta.setLore(lore);
                add.setItemMeta(meta);
                sender.sendMessage(ChatColor.GREEN + "&aGreencode Successful!");

            } else if (!player.getInventory().getItemInHand().getItemMeta().hasLore()) {
                ItemStack add = player.getInventory().getItemInHand();
                ItemMeta meta = add.getItemMeta();
                ArrayList<String> lore = new ArrayList();
                lore.add("&a" + randomString(10));
                meta.setLore(lore);
                add.setItemMeta(meta);
                sender.sendMessage(ChatColor.GREEN + "&aGreencode Successful!");
                return true;
            }
        }
        return false;
    }
}
