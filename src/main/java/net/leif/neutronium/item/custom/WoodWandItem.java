package net.leif.neutronium.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class WoodWandItem extends Item {

    private static final Map<Block, Block> WOODWAND_MAP =
            Map.of(
                    Blocks.OAK_LOG, Blocks.SPRUCE_LOG,
                    Blocks.SPRUCE_LOG, Blocks.BIRCH_LOG,
                    Blocks.BIRCH_LOG, Blocks.ACACIA_LOG,
                    Blocks.ACACIA_LOG, Blocks.JUNGLE_LOG,
                    Blocks.JUNGLE_LOG, Blocks.DARK_OAK_LOG,
                    Blocks.DARK_OAK_LOG, Blocks.OAK_LOG
            );

    public WoodWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(WOODWAND_MAP.containsKey(clickedBlock)){
            if(!world.isClient()){
                world.setBlockState(context.getBlockPos(), WOODWAND_MAP.get(clickedBlock).getDefaultState());

                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS);

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                    Entity lightningEntity = ((EntityType<LightningEntity>) EntityType.get("minecraft:lightning_bolt").get()).create(world);
                    lightningEntity.updatePosition(context.getBlockPos().getX(), context.getBlockPos().getY(), context.getBlockPos().getZ());
                    world.spawnEntity(lightningEntity);
            }
        }

        return ActionResult.SUCCESS;
    }
}
