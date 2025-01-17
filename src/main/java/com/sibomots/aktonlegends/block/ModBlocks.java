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
package com.sibomots.aktonlegends.block;

import com.sibomots.aktonlegends.AktonLegendsMod;
import com.sibomots.aktonlegends.block.custom.BloomeryBlock;

import com.sibomots.aktonlegends.block.entity.BloomeryBlockEntity;
import com.sibomots.aktonlegends.creat.ModCreatModeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

import static com.sibomots.aktonlegends.core.ModRegistry.*;

public class ModBlocks {
    public static void register(IEventBus eventBus) {
       BLOCKS.register(eventBus);
       BLOCK_ENTITY_TYPES.register(eventBus);
       // MENU_REGISTRAR.register(eventBus);
    }

    public static final DeferredBlock<Block> SILVERLIGHT_BLOCK = registerBlock(
            "silverlight_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(AktonLegendsMod.MODID,
                                    "silverlight_block")))
                    .strength(4f)
                    .explosionResistance(10.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
                    .lightLevel(state -> 7)
            ), ModCreatModeTab.AKTONLEGENDS_BLOCKS_TAB);

    public static final DeferredBlock<Block> SILVERLIGHT_ORE_BLOCK = registerBlock(
            "silverlight_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK,
                                    ResourceLocation.fromNamespaceAndPath(AktonLegendsMod.MODID,
                                            "silverlight_ore_block")))
                            .strength(1.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.AMETHYST)), ModCreatModeTab.AKTONLEGENDS_BLOCKS_TAB);

    public static final DeferredBlock<Block> VITREOUS_SILVERLIGHT_ORE_BLOCK = registerBlock(
            "vitreous_silverlight_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK,
                                    ResourceLocation.fromNamespaceAndPath(AktonLegendsMod.MODID,
                                            "vitreous_silverlight_ore_block")))
                            .strength(1.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.AMETHYST)), ModCreatModeTab.AKTONLEGENDS_BLOCKS_TAB);


    /* public static final DeferredBlock<Block>
            BLOOMERY_BLOCK  = registerBlock("bloomery_block",
            ()  -> new BloomeryBlock(
                    BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()),
                    ModCreatModeTab.AKTONLEGENDS_ITEMS_TAB);
*/

    /*
    public static final DeferredBlock<BloomeryBlock> BLOOMERY_BLOCKXX
          =  BLOCKS.register("bloomery_block",
                    ()  -> new BloomeryBlock(
            BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(AktonLegendsMod.MODID,
                                    "bloomery_block")))
                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion())
    );
     */

    public static final DeferredBlock<Block> BLOOMERY_BLOCK = registerBlock(
            "bloomery_block",
            () -> new BloomeryBlock(
                    BlockBehaviour.Properties.of()
                            .setId(ResourceKey.create(Registries.BLOCK,
                                    ResourceLocation.fromNamespaceAndPath(AktonLegendsMod.MODID,
                                            "vitreous_silverlight_ore_block")))
                            .strength(1.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.AMETHYST)),
            ModCreatModeTab.AKTONLEGENDS_BLOCKS_TAB);


    public static final Supplier<BlockEntityType<BloomeryBlockEntity>> BLOOMERY_BLOCK_ENTITY
            = BLOCK_ENTITY_TYPES.register(
            "bloomery_block_entity",
            // The block entity type.
            () -> new BlockEntityType<>(
                    // The supplier to use for constructing the block entity instances.
                    BloomeryBlockEntity::new,
                    // A vararg of blocks that can have this block entity.
                    // This assumes the existence of the referenced blocks as DeferredBlock<Block>s.
                    ModBlocks.BLOOMERY_BLOCK.get())
            );
}
