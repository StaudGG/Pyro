package me.staud.pyro.listener;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void playerHitPlayerEvent(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        if (damager instanceof Player) {
            Player player = (Player)damager;
            if (player.getItemInHand() == null) {
                return;
            }

            if (!player.getItemInHand().hasItemMeta()) {
                return;
            }

            if (!player.getItemInHand().getItemMeta().hasLore()) {
                return;
            }

            LivingEntity target;
            if (((String)player.getItemInHand().getItemMeta().getLore().get(0)).equals(ChatColor.DARK_RED + "I come from the Iron Hills")) {
                target = (LivingEntity)event.getEntity();
                target.getWorld().playEffect(target.getLocation(), Effect.ZOMBIE_DESTROY_DOOR, 1);
                target.getWorld().playSound(target.getLocation(), Sound.ANVIL_LAND, 1.0F, 0.001F);
                player.playSound(target.getLocation(), Sound.ANVIL_LAND, 2.0F, 0.001F);
                if (!event.isCancelled()) {
                    player.setHealth(player.getHealth() + this.getConfig().getDouble("DAMAGE.PYRO"));
                }
            }
            if (((String)player.getItemInHand().getItemMeta().getLore().get(0)).equals(ChatColor.GREEN + "I come from the Iron Hills")) {
                target = (LivingEntity)event.getEntity();
                target.getWorld().playEffect(target.getLocation(), Effect.ZOMBIE_DESTROY_DOOR, 1);
                target.getWorld().playSound(target.getLocation(), Sound.ANVIL_LAND, 1.0F, 0.001F);
                player.playSound(target.getLocation(), Sound.ANVIL_LAND, 2.0F, 0.001F);
                if (!event.isCancelled()) {
                    player.setHealth(player.getHealth() + this.getConfig().getDouble("DAMAGE.PYRO"));
                }
            }
            if (((String)player.getItemInHand().getItemMeta().getLore().get(0)).equals(ChatColor.DARK_RED + "Forged by ancient gods")) {
                target = (LivingEntity)event.getEntity();
                target.getWorld().playEffect(target.getLocation(), Effect.BLAZE_SHOOT, 1);
                target.getWorld().playSound(target.getLocation(), Sound.FIREWORK_BLAST, 1.0F, 0.001F);
                player.playSound(target.getLocation(), Sound.ANVIL_LAND, 1.0F, 0.001F);
                if (!event.isCancelled()) {
                    player.setHealth(player.getHealth() + this.getConfig().getDouble("DAMAGE.PYROSWORD"));
                }
            }

            if (ChatColor.stripColor((String)player.getItemInHand().getItemMeta().getLore().get(0)).equals("Deathbringer")) {
                if (player.getFireTicks() < 0) {
                    player.setHealth(player.getHealth() + this.getConfig().getDouble("DAMAGE.DEATHBRINGER"));
                }

                player.setHealth(player.getHealth() + 2.0D);
            }
        }

    }
    public static FileConfiguration getConfig() {
        return null;
    }
}