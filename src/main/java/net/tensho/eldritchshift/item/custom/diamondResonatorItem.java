package net.tensho.eldritchshift.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
//import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import net.minecraft.world.level.storage.WorldData;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.tensho.eldritchshift.entities.CustomDragon;

public class diamondResonatorItem extends Item {
    public diamondResonatorItem() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        CustomDragon dragon;

        if (!level.isClientSide) {
            Vec3 lookVec = player.getLookAngle();
            Vec3 playerPos = player.position();
            Vec3 targetVec = playerPos.add(lookVec.scale(10.0D));


            HitResult hitResult = level.clip(new ClipContext(playerPos, targetVec, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

            if (hitResult.getType() == HitResult.Type.ENTITY) {
                EntityHitResult entityHitResult = (EntityHitResult) hitResult;
                player.sendSystemMessage(Component.literal("Apuntando a: " + entityHitResult.getEntity().getName()));
            } else {
                for (Entity entity : level.getEntitiesOfClass(Entity.class, player.getBoundingBox().expandTowards(lookVec.scale(10.0D)))) {
                    if (entity.getBoundingBox().intersects(player.getBoundingBox().expandTowards(lookVec.scale(10.0D))) && entity != player) {
                        player.sendSystemMessage(Component.literal("Apuntando a: " + entity.getName().getString()));
                        if (entity.getName().getString() == "Piglin"){
                            dragon = entity instanceof CustomDragon ? (CustomDragon) entity : null;
                            boolean newState = !dragon.isHumanoid();
                            dragon.setHumanoid(newState);
                            player.sendSystemMessage(Component.literal("El dragon se ha transformado a: " + (newState ? "humanoide" : "dragon")));
                            return super.use(level,player,hand);

                        }
                        return InteractionResultHolder.fail(itemStack);
                    }
                }

            }
        }
        return super.use(level, player, hand);
    }


    public void modeShift(){

    }
}

