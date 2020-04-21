package me.staud.pyro.armor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.potion.PotionEffectType;

public class ArmorListener implements Listener
{
        @EventHandler(priority = EventPriority.HIGHEST)
        public void onInteract(PlayerInteractEvent event) {
            Player player = event.getPlayer();
            ArmorType newArmorType = ArmorType.selectType(event.getItem());
            if ((newArmorType.equals(ArmorType.HELMET) && player.getInventory().getHelmet() == null) || (newArmorType.equals(ArmorType.CHESTPLATE) && player.getInventory().getChestplate() == null) || (newArmorType.equals(ArmorType.LEGGINGS) && player.getInventory().getLeggings() == null) || (newArmorType.equals(ArmorType.BOOTS) && player.getInventory().getBoots() == null)) {
                ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(player, ArmorType.selectType(event.getItem()), null, event.getItem());
                Bukkit.getServer().getPluginManager().callEvent((Event)armorEquipEvent);
            }
        }

        @EventHandler(priority = EventPriority.HIGHEST)
        public void onClick(InventoryClickEvent event) {
            boolean shift = false;
            boolean numberkey = false;
            int slot = event.getSlot();
            Player player = (Player)event.getWhoClicked();
            if (event.isCancelled()) {
                return;
            }
            if (event.getClick().equals((Object)ClickType.SHIFT_LEFT) || event.getClick().equals((Object)ClickType.SHIFT_RIGHT)) {
                shift = true;
            }
            ArmorType newArmorType = ArmorType.selectType(shift ? event.getCurrentItem() : event.getCursor());
            if (shift) {
                newArmorType = ArmorType.selectType(event.getCurrentItem());
                if (newArmorType != null) {
                    boolean equipping = true;
                    Label_0362: {
                        Label_0308: {
                            if (newArmorType.equals(ArmorType.HELMET)) {
                                if (equipping) {
                                    if (event.getWhoClicked().getInventory().getHelmet() == null) {
                                        break Label_0308;
                                    }
                                }
                                else if (event.getWhoClicked().getInventory().getHelmet() != null) {
                                    break Label_0308;
                                }
                            }
                            if (newArmorType.equals(ArmorType.CHESTPLATE)) {
                                if (equipping) {
                                    if (event.getWhoClicked().getInventory().getChestplate() == null) {
                                        break Label_0308;
                                    }
                                }
                                else if (event.getWhoClicked().getInventory().getChestplate() != null) {
                                    break Label_0308;
                                }
                            }
                            if (newArmorType.equals(ArmorType.LEGGINGS)) {
                                if (equipping) {
                                    if (event.getWhoClicked().getInventory().getLeggings() == null) {
                                        break Label_0308;
                                    }
                                }
                                else if (event.getWhoClicked().getInventory().getLeggings() != null) {
                                    break Label_0308;
                                }
                            }
                            if (!newArmorType.equals(ArmorType.BOOTS)) {
                                break Label_0362;
                            }
                            if (equipping) {
                                if (event.getWhoClicked().getInventory().getBoots() != null) {
                                    break Label_0362;
                                }
                            }
                            else if (event.getWhoClicked().getInventory().getBoots() == null) {
                                break Label_0362;
                            }
                        }
                        ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(player, newArmorType, equipping ? null : event.getCurrentItem(), equipping ? event.getCurrentItem() : null);
                        Bukkit.getServer().getPluginManager().callEvent((Event)armorEquipEvent);
                    }
                    if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta().hasLore()) {
                        String lore = ChatColor.stripColor((String)event.getCurrentItem().getItemMeta().getLore().get(0));
                        if ((player.getGameMode() != GameMode.CREATIVE && slot == 39) || slot == 38 || slot == 37 || slot == 36 || (player.getGameMode() == GameMode.CREATIVE && slot == 5) || slot == 6 || slot == 7 || slot == 8) {
                            if (lore.equals("Infused with Strength")) {
                                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                            }
                            if (lore.equals("Infused with Speed")) {
                                player.removePotionEffect(PotionEffectType.SPEED);
                            }
                            if (lore.equals("Infused with Invisibility")) {
                                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                            }
                            if (lore.equals("Glowing")) {
                                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                            }
                        }
                    }
                }
            }
        }
    @EventHandler
    public void itemBreak(PlayerItemBreakEvent event) {
        Player player = event.getPlayer();
        String lore = ChatColor.stripColor((String)event.getBrokenItem().getItemMeta().getLore().get(7));
        if (lore.equals("Infused with Strength")) {
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        }
        if (lore.equals("Infused with Speed")) {
            player.removePotionEffect(PotionEffectType.SPEED);
        }
        if (lore.equals("Infused with Invisibility")) {
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
        if (lore.equals("Glowing")) {
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
        }
    }
}
