package me.staud.pyro.armor;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EquipEvent implements Listener
{
    @EventHandler
    public void onEquip(ArmorEquipEvent event) {
        Player player = event.getPlayer();
        if (event.getArmorPiece().getItemMeta().getLore().contains("&2Infused with Strength")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000, 1));
        }
        if (event.getArmorPiece().getItemMeta().getLore().contains("&4Infused with Speed")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 1));
        }
        if (event.getArmorPiece().getItemMeta().getLore().contains("&2Infused with Invisibility")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 1));
        }
        if (event.getArmorPiece().getItemMeta().getLore().contains("&4Glowing")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 500));
        }
        String lore = ChatColor.stripColor((String)event.getArmorPiece().getItemMeta().getLore().get(7));
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

