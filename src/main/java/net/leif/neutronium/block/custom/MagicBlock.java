package net.leif.neutronium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        world.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 5f, World.ExplosionSourceType.TNT);

        return super.onBreak(world, pos, state, player);
    }
}
