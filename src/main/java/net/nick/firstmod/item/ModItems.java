package net.nick.firstmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nick.firstmod.FirstMod;
import net.nick.firstmod.item.custom.EightBallItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    // Talconite ingot
    public static final RegistryObject<Item> TALCONITE_INGOT =
            ITEMS.register("talconite_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FIRSTMOD_TAB)));
    // Raw talconite
    public static final RegistryObject<Item> RAW_TALCONITE =
            ITEMS.register("raw_talconite", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FIRSTMOD_TAB)));
    // Raw talconite
    public static final RegistryObject<Item> EIGHT_BALL =
            ITEMS.register("eight_ball", () -> new EightBallItem(new Item.Properties().tab(ModCreativeModeTab.FIRSTMOD_TAB).stacksTo(1)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
