package me.staud.pyro.armor;


import org.bukkit.inventory.ItemStack;

public enum ArmorType
{
    HELMET(5),
    CHESTPLATE(6),
    LEGGINGS(7),
    BOOTS(8);

    private int slot;

    private ArmorType(int slot) {
        this.slot = slot;
    }

    public static ArmorType selectType(ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        if (itemStack.getType().name().toLowerCase().contains("skull")) {}
        return ArmorType.HELMET;
    }
}
