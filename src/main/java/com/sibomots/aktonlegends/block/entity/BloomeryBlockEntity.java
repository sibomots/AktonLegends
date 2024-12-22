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
package com.sibomots.aktonlegends.block.entity;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.property.Properties;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.function.Supplier;

import static com.sibomots.aktonlegends.block.ModBlocks.BLOOMERY_BLOCK_ENTITY;
// import static com.sibomots.aktonlegends.core.ModRegistry.MENU_REGISTRAR;

public class BloomeryBlockEntity extends BlockEntity
{
    private int value;
    private static final Logger LOGGER = LogUtils.getLogger();


    public BloomeryBlockEntity(BlockPos pos, BlockState state) {
        super(BLOOMERY_BLOCK_ENTITY.get(), pos, state);
    }

    // Read values from the passed CompoundTag here.
    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        // Will default to 0 if absent. See the NBT article for more information.
        this.value = tag.getInt("value");
    }

    // Save values into the passed CompoundTag here.
    @Override
    public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("value", this.value);
    }

    public static <T extends BlockEntity> void tick(Level level,
                                                    BlockPos blockPos,
                                                    BlockState blockState, T t)
    {
        if (Counter.Increment() % 20 == 0)
        {
            LOGGER.info("Tick reached 20. "
                   + "State = " + blockState.toString()
                   + "Level = " + level
                   + "Position = " + blockPos.toShortString());
        }
    }

/*
    @Override
    public Component getDisplayName()
    {
        return null;
    }
*/
    /*
    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inventory, Player player)
    {
        return new BloomeryMenu(id, inventory); // TODO , this, this.data);
    }
    */

   /*
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        return null;
    }
    */
}
