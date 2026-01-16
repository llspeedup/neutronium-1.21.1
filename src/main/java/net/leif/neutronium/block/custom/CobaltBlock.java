package net.leif.neutronium.block.custom;

import net.leif.neutronium.block.ModBlocks;
import net.leif.neutronium.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CobaltBlock extends Block {

    public static BooleanProperty CHROMIUM = BooleanProperty.of("chromium");
    //has the block been reinforced with chromium (right click)
    public static final BooleanProperty GOLD = BooleanProperty.of("gold");
    //has the block been reinforced with gold (right click)

    public CobaltBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState()
                .with(CHROMIUM, false)
                .with(GOLD, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CHROMIUM);
        builder.add(GOLD);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
       if(world.isClient){return super.onUseWithItem(stack, state, world, pos, player, hand, hit);}

        if(stack.getItem() == ModItems.CHROMIUM_INGOT){
            world.setBlockState(pos, state.with(CHROMIUM, true), Block.NOTIFY_ALL);
            stack.decrement(1);
            return ItemActionResult.SUCCESS;
        } else if (stack.getItem() == Items.GOLD_INGOT) {
            world.setBlockState(pos, state.with(GOLD, true), Block.NOTIFY_ALL);
            stack.decrement(1);
            return ItemActionResult.SUCCESS;
        } else if (stack.getItem() == ModItems.MOTOR && state.get(CHROMIUM) && state.get(GOLD) ) {
            stack.decrement(1);
            world.setBlockState(pos
                    , ModBlocks.CENTRIFUGE.getDefaultState()
                            .with(HorizontalFacingBlock.FACING, player.getHorizontalFacing().getOpposite())
                    , Block.NOTIFY_ALL);
        }

        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        return super.onUse(state, world, pos, player, hit);
    }
}
