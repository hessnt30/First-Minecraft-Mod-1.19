package net.nick.firstmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallItem extends Item {
    public EightBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            outputRandomNumber(player, 10);
            player.setForcedPose(Pose.USING_TONGUE);
            player.getCooldowns().addCooldown(this, 20);
        }
        else if(!level.isClientSide() && hand == InteractionHand.OFF_HAND && player.isCrouching()){
            outputRandomNumber(player, 100);
            player.setForcedPose(Pose.FALL_FLYING);
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()){
            components.add(Component.literal("Right click to get a random number!").withStyle(ChatFormatting.LIGHT_PURPLE));

        }else{
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.AQUA));

        }
        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }

    private void outputRandomNumber(Player player, int max){
        player.sendSystemMessage(Component.literal("Your Number is " + getRandomNumber(max)));
    }

    private int getRandomNumber(int max){
        return RandomSource.createNewThreadLocalInstance().nextInt(max);
    }
}
