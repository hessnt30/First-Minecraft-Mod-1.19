package net.nick.firstmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FIRSTMOD_TAB = new CreativeModeTab("firstmodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RAW_TALCONITE.get());
        }
    };
}
