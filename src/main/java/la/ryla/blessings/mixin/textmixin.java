package la.ryla.blessings.mixin;

import la.ryla.blessings.enchantment.PaceBlessingEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.minecraft.text.MutableText;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// so i want to target Enchantment.java in minecraft
// line 110 and line 135 both have stuff relating to curses
// my goal is to essentially copy that and change the color to make blessings

@Mixin(Enchantment.class) //the class is minecraft's enchantment stuff!!!!
public class textmixin {
    @Inject(method = "", at = @At("HEAD")) // ooh scary!
    private void injected(int level, CallbackInfoReturnable<Text> cir) {

    }

    //@Inject(method = "getName(I)Lnet/minecraft/text/Text;", at = @At("HEAD")) // ooh scary!
    @Redirect(method = "getName(I)Lnet/minecraft/text/Text;", at = @At(value = "INVOKE", target = "Lnet/minecraft/text/MutableText;formatted(Lnet/minecraft/util/Formatting;)Lnet/minecraft/text/MutableText;"))
    private MutableText injected(MutableText instance, Formatting formatting) {
        if (formatting == Formatting.GRAY ){
            if (((Object)this) instanceof PaceBlessingEnchantment) {
                return instance.formatted(Formatting.YELLOW);
            } else {
                return instance.formatted(Formatting.GRAY);
            }
        }
        //System.out.println("This line is printed by an example mod mixin!");
        return instance.formatted(formatting);

    }
}