package net.nick.firstmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SPAGHETTI = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.3F).build();
    public static final FoodProperties SPAGHETTI_WITH_MEATBALLS = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.6F).build();
    public static final FoodProperties MEATBALLS = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).build();



}
