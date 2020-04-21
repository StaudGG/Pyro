package me.staud.pyro.armor;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public class ArmorEquipEvent extends PlayerEvent
{
    private static HandlerList handlers;
    private ArmorType type;
    private ItemStack oldArmorPiece;
    private ItemStack ArmorPiece;

    public ArmorEquipEvent(final Player player, final ArmorType type, final ItemStack oldArmorPiece, final ItemStack ArmorPiece) {
        super(player);
        this.type = type;
        this.oldArmorPiece = oldArmorPiece;
        this.ArmorPiece = ArmorPiece;
    }

    public HandlerList getHandlers() {
        return ArmorEquipEvent.handlers;
    }

    public static HandlerList getHandlerList() {
        return ArmorEquipEvent.handlers;
    }

    public ItemStack getArmorPiece() {
        return this.ArmorPiece;
    }

    static {
        ArmorEquipEvent.handlers = new HandlerList();
    }
}
