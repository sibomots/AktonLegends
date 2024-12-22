/********************************************************************************
 * BSD 3-Clause License
 * Akton Legends Mod
 * Copyright (c) 2024 sibomots, rocsorc
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holder nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************/
package com.sibomots.aktonlegends.block.custom;

import com.mojang.serialization.MapCodec;
import com.sibomots.aktonlegends.block.entity.BloomeryBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.level.block.state.StateDefinition;

import static com.sibomots.aktonlegends.block.ModBlocks.BLOOMERY_BLOCK_ENTITY;

/*
// The important part is implementing the EntityBlock interface and
// overriding the #newBlockEntity method.
public class MyEntityBlock extends Block implements EntityBlock {
    // Constructor deferring to super.
    public MyEntityBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    // Return a new instance of our block entity here.
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MyBlockEntity(pos, state);
    }
}
 */
//public class BloomeryBlock extends HorizontalDirectionalBlock
public class BloomeryBlock extends Block implements EntityBlock
{
    // public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    private static final VoxelShape SHAPE =
        Block.box(0, 0, 0, 16, 10, 16);

    @SuppressWarnings("unchecked") // Due to generics, an unchecked cast is necessary here.
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T>
    getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        // You can return different tickers here, depending on whatever factors you want. A common use case would be
        // to return different tickers on the client or server, only tick one side to begin with,
        // or only return a ticker for some blockstates (e.g. when using a "my machine is working" blockstate property).
        return type == BLOOMERY_BLOCK_ENTITY.get()
                ? (BlockEntityTicker<T>) BloomeryBlockEntity::tick : null;
    }

    /*
    int value;

    // ...

    @Override
    protected MapCodec<BloomeryBlock>  codec()
    {
        return COMPLEX_CODEC.get();
    }

    public int getValue() {
        return this.value;
    }
    */

    // as per 1.21.4 kit
    public BloomeryBlock(Properties properties /* p_54120_ */)
    {
        // as per
        //  https://docs.neoforged.net/docs/blocks/states/#blockstate-properties
        super(properties);
        registerDefaultState(stateDefinition.any()
                .setValue(FACING, Direction.NORTH));
    }

    // jdw TODO
    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec()
    {
        return null;
    }

    // jdw TODO
    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context)
    {
        // return super.getStateForPlacement(context);
        return this.defaultBlockState().setValue(FACING,
                context.getHorizontalDirection().getOpposite());
    }

    // jdw TODO
    @Override
    protected BlockState rotate(BlockState state, Rotation rot)
    {
        //return super.rotate(state, rot);
        return state.setValue(FACING,
                rot.rotate(state.getValue(FACING)));
    }

    // jdw TODO
    @Override
    protected BlockState mirror(BlockState state, Mirror mirror)
    {
        // return super.mirror(state, mirror);
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    // jdw TODO
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        //return super.getShape(state, level, pos, context);
        return SHAPE;
    }

    // jdw TODO
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        return new BloomeryBlockEntity(blockPos, blockState);
    }
}