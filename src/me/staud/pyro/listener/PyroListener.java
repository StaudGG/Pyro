package me.staud.pyro.listener;


import me.staud.pyro.util.ItemBuilderUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class PyroListener implements Listener
{
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory().getName().toLowerCase().contains("menu")) {
            event.setCancelled(true);
        }
        if (event.getInventory().getName().toLowerCase().contains("items")) {
            event.setCancelled(true);
        }
        if (event.getInventory().getName().toLowerCase().contains("menu") && event.getSlot() == 4) {
            Player player = (Player)event.getWhoClicked();
            Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 27, ChatColor.translateAlternateColorCodes('&', "&6Items"));
            player.openInventory(inventory);
            ItemStack pyro = new ItemBuilderUtil(Material.DIAMOND_AXE).setName(ChatColor.translateAlternateColorCodes('&', "&4Pyro Axe")).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).setLore(ChatColor.translateAlternateColorCodes('&', "&4I come from the Iron Hills"), "", ChatColor.translateAlternateColorCodes('&', "&aClick here to receive the &4Pyro Axe")).create();
            inventory.setItem(1, pyro);
            ItemStack apollo = new ItemBuilderUtil(Material.DIAMOND_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&bApollos Crest")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.PROTECTION_FIRE, 4).addEnchant(Enchantment.THORNS, 3).addEnchant(Enchantment.DURABILITY, 3).setLore(ChatColor.translateAlternateColorCodes('&', "&4Glowing"), "", ChatColor.translateAlternateColorCodes('&', "&aClick here to receive an &bApollos Crest")).create();
            inventory.setItem(2, apollo);
            ItemStack aegis = new ItemBuilderUtil(Material.DIAMOND_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&4*&8&lAegis&4*")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.PROTECTION_FIRE, 4).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.THORNS, 3).setLore(ChatColor.translateAlternateColorCodes('&', "&2Infused with Strength"), "", ChatColor.translateAlternateColorCodes('&', "&aClick here to receive the &4Aegis")).create();
            inventory.setItem(3, aegis);
            ItemStack etherals = new ItemBuilderUtil(Material.DIAMOND_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&8Etherals")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.PROTECTION_FIRE, 4).addEnchant(Enchantment.THORNS, 3).addEnchant(Enchantment.DURABILITY, 3).setLore(ChatColor.translateAlternateColorCodes('&', "&2Infused with Invisibility"), "", ChatColor.translateAlternateColorCodes('&', "&aClick here to receive a pair of &7Etherals")).create();
            inventory.setItem(4, etherals);
            ItemStack hermes = new ItemBuilderUtil(Material.DIAMOND_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&6Hermes Boots")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.PROTECTION_FIRE, 4).addEnchant(Enchantment.PROTECTION_FALL, 4).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.THORNS, 3).setLore(ChatColor.translateAlternateColorCodes('&', "&4Infused with Speed"), "", ChatColor.translateAlternateColorCodes('&', "&aClick here to receive the &6Hermes Boots")).create();
            inventory.setItem(5, hermes);
            ItemStack deathbringer = new ItemBuilderUtil(Material.DIAMOND_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&4&lD&8&le&4&la&8&lt&4&lh&8&lb&4&lr&8&li&4&ln&8&lg&4&le&8&lr")).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).setLore("&4&oLifesteal").setLore(ChatColor.translateAlternateColorCodes('&', "&aClick here to receive the &4&lD&8&le§4§la§8§lt§4§lh§8§lb§4§lr§8§li§4§ln§8§lg§4§le§8§lr")).create();
            inventory.setItem(6, deathbringer);
            ItemStack pyrosword = new ItemBuilderUtil(Material.DIAMOND_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&4Pyro Sword")).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).setLore(ChatColor.translateAlternateColorCodes('&', "&4Forged by ancient gods")).create();
            inventory.setItem(7, pyrosword);
        }
        if (event.getInventory().getName().toLowerCase().contains("items") && event.getSlot() == 1) {
            Player player = (Player)event.getWhoClicked();
            ItemStack pyro2 = new ItemBuilderUtil(Material.DIAMOND_AXE).setName(ChatColor.translateAlternateColorCodes('&', "&4Pyro Axe")).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).setLore(ChatColor.translateAlternateColorCodes('&', "&4I come from the Iron Hills")).create();
            player.getInventory().addItem(new ItemStack[] { pyro2 });
        }
        if (event.getInventory().getName().toLowerCase().contains("items") && event.getSlot() == 2) {
            Player player = (Player)event.getWhoClicked();
            ItemStack apollo2 = new ItemBuilderUtil(Material.DIAMOND_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&bApollos Crest")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.PROTECTION_FIRE, 4).addEnchant(Enchantment.THORNS, 3).addEnchant(Enchantment.DURABILITY, 3).setLore(ChatColor.translateAlternateColorCodes('&', "&4Glowing")).create();
            player.getInventory().addItem(new ItemStack[] { apollo2});
        }
        if (event.getInventory().getName().toLowerCase().contains("items") && event.getSlot() == 3) {
            Player player = (Player)event.getWhoClicked();
            ItemStack aegis2 = new ItemBuilderUtil(Material.DIAMOND_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&4*&8&lAegis&4*")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.PROTECTION_FIRE, 4).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.THORNS, 3).setLore(ChatColor.translateAlternateColorCodes('&', "&2Infused with Strength")).create();
            player.getInventory().addItem(new ItemStack[] { aegis2 });
        }
        if (event.getInventory().getName().toLowerCase().contains("items") && event.getSlot() == 4) {
            Player player = (Player)event.getWhoClicked();
            ItemStack etherals2 = new ItemBuilderUtil(Material.DIAMOND_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&8Etherals")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.PROTECTION_FIRE, 4).addEnchant(Enchantment.THORNS, 3).addEnchant(Enchantment.DURABILITY, 3).setLore(ChatColor.translateAlternateColorCodes('&', "&2Infused with Invisibility")).create();
            player.getInventory().addItem(new ItemStack[] { etherals2});
        }
        if (event.getInventory().getName().toLowerCase().contains("items") && event.getSlot() == 5) {
            Player player = (Player)event.getWhoClicked();
            ItemStack hermes2 = new ItemBuilderUtil(Material.DIAMOND_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&6Hermes Boots")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.PROTECTION_FIRE, 4).addEnchant(Enchantment.PROTECTION_FALL, 4).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.THORNS, 3).setLore(ChatColor.translateAlternateColorCodes('&', "&4Infused with Speed")).create();
            player.getInventory().addItem(new ItemStack[] { hermes2 });
        }
        if (event.getInventory().getName().toLowerCase().contains("items") && event.getSlot() == 6) {
            Player player = (Player)event.getWhoClicked();
            ItemStack deathbringer2 = new ItemBuilderUtil(Material.DIAMOND_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&4&lD&8&le§4§la§8§lt§4§lh§8§lb§4§lr§8§li§4§ln§8§lg§4§le§8§lr")).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).setLore(ChatColor.translateAlternateColorCodes('&', "&4&oLifesteal")).create();
            player.getInventory().addItem(new ItemStack[] { deathbringer2});
        }
        if (event.getInventory().getName().toLowerCase().contains("items") && event.getSlot() == 7) {
            Player player = (Player)event.getWhoClicked();
            ItemStack pyrosword2 = new ItemBuilderUtil(Material.DIAMOND_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&4Pyro Sword")).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).setLore(ChatColor.translateAlternateColorCodes('&', "&4Forged by ancient gods")).create();
            player.getInventory().addItem(new ItemStack[] { pyrosword2});
        }
    }
}
