package la.ryla.blessings.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class PaceBlessingEnchantment extends Enchantment {
    public PaceBlessingEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[] {EquipmentSlot.LEGS, EquipmentSlot.FEET});
        // TODO: Make it only apply to boots and leggings
        // You can probably mixin to the enchantment table and anvil for that
    }

    @Override
    public boolean isTreasure() {
        return true;
    }
    //need to make it not show as a book or be found in trades (easy just lazy)

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    // Rarity
    @Override
    public int getMinPower(int level) { return 25; }
    @Override
    public int getMaxPower(int level) { return 50; }

}