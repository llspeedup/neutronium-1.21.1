package net.leif.neutronium.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class AtomicHammerItem extends Item {
    public AtomicHammerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();

        /*FireballEntity fireballEntity = EntityType.FIREBALL.create(world);
        if (fireballEntity != null){
            fireballEntity.refreshPositionAfterTeleport(context.getBlockPos().getX(), context.getBlockPos().getY(), context.getBlockPos().getZ());

            world.spawnEntity(fireballEntity);
        }*/

        Entity lightningEntity = ((EntityType<LightningEntity>) EntityType.get("minecraft:lightning_bolt").get()).create(world);
        lightningEntity.updatePosition(context.getBlockPos().getX(), context.getBlockPos().getY(), context.getBlockPos().getZ());
        world.spawnEntity(lightningEntity);

        world.createExplosion(context.getPlayer(), context.getBlockPos().getX(), context.getBlockPos().getY(),context.getBlockPos().getZ(), 30f, World.ExplosionSourceType.BLOCK);

        return super.useOnBlock(context);


    }
}
