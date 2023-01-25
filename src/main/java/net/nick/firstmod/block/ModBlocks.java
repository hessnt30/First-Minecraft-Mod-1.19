package net.nick.firstmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nick.firstmod.FirstMod;
import net.nick.firstmod.block.custom.JumpyBlock;
import net.nick.firstmod.item.ModCreativeModeTab;
import net.nick.firstmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);

    // Talconite Block
    public static final RegistryObject<Block> TALCONITE_BLOCK = registerBlock("talconite_block",
            () -> new Block((BlockBehaviour.Properties.of(Material.STONE).strength(6f).sound(SoundType.METAL).requiresCorrectToolForDrops())),
            ModCreativeModeTab.FIRSTMOD_TAB);
    // Talconite Ore Block
    public static final RegistryObject<Block> TALCONITE_ORE_BLOCK = registerBlock("talconite_ore_block",
            () -> new DropExperienceBlock((BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), UniformInt.of(3,7)),
            ModCreativeModeTab.FIRSTMOD_TAB);
    // Deepslate Talconite Ore Block
    public static final RegistryObject<Block> DEEPSLATE_TALCONITE_ORE_BLOCK = registerBlock("deepslate_talconite_ore_block",
            () -> new DropExperienceBlock((BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), UniformInt.of(3,7)),
            ModCreativeModeTab.FIRSTMOD_TAB);
    // Jumpy Block
    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock((BlockBehaviour.Properties.of(Material.AMETHYST).strength(6f).requiresCorrectToolForDrops())),
            ModCreativeModeTab.FIRSTMOD_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
