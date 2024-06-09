package la.ryla.blessings.mixin;

import la.ryla.blessings.enchantment.PaceBlessingEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.minecraft.text.MutableText;

@Mixin(Enchantment.class)
public class blessings$ChangeEnchantmentNameColorMixin {
    @Redirect(method = "getName(I)Lnet/minecraft/text/Text;", at = @At(value = "INVOKE", target = "Lnet/minecraft/text/MutableText;formatted(Lnet/minecraft/util/Formatting;)Lnet/minecraft/text/MutableText;"))
    private MutableText injected(MutableText instance, Formatting formatting) {
        // We're hooking the part of the code that sets the color of the enchantment name.
        // If it's going to set it to gray, we need to check if it's a blessing.
        // If it is, let's make it yellow instead.
        if ((formatting == Formatting.GRAY) && (((Object)this) instanceof PaceBlessingEnchantment)) {
            return instance.formatted(Formatting.YELLOW);
        }
        return instance.formatted(formatting);
    }
}