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
package com.sibomots.aktonlegends.core;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sibomots.aktonlegends.AktonLegendsMod;
import com.sibomots.aktonlegends.block.ModBlocks;
import com.sibomots.aktonlegends.block.custom.BloomeryBlock;
import com.sibomots.aktonlegends.block.entity.BloomeryBlockEntity;
import io.netty.resolver.DefaultHostsFileEntriesResolver;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModRegistry {
    public static final DeferredRegister.Items ITEMS
            = DeferredRegister.createItems(AktonLegendsMod.MODID);

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(AktonLegendsMod.MODID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS
            = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AktonLegendsMod.MODID);

    /*
    public static final DeferredRegister<MenuType<?>> MENU_REGISTRAR =
            DeferredRegister.create(Registries.MENU, AktonLegendsMod.MODID);
*/
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, AktonLegendsMod.MODID);

    /*
    public static final Supplier<MenuType<BloomeryMenu>> BLOOMERY_MENU
            = MENU_REGISTRAR.register("my_menu",
            () -> new MenuType<>(BloomeryMenu::new, FeatureFlags.DEFAULT_FLAGS));
*/

    public static DeferredItem<Item> registerModItem(String name)
    {
        return ITEMS.register(name, () ->
                new Item(
                        new Item.Properties()
                                .useItemDescriptionPrefix()
                                .setId(ResourceKey.create(Registries.ITEM,
                                        ResourceLocation.fromNamespaceAndPath(AktonLegendsMod.MODID, name)
                                ))
                ));
    }

    /*
    public static DeferredItem<Item> registerModFoodItem(String name)
    {
        return ITEMS.register(name, () ->
                new Item(
                        new Item.Properties()
                                .food(new FoodProperties.Builder()
                                        .alwaysEdible()
                                        .nutrition(1)
                                        .saturationModifier(2.0f)
                                        .build())
                                .useItemDescriptionPrefix()
                                .setId(ResourceKey.create(Registries.ITEM,
                                        ResourceLocation.fromNamespaceAndPath(AktonLegendsMod.MODID, name)
                                ))
                ));
    }
    */

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, DeferredHolder<CreativeModeTab, CreativeModeTab> aktonlegendsBlocksTab)
    {
         DeferredBlock<T> toReturn = BLOCKS.register(name, block);
         registerBlockItem(name, toReturn);
         return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
         ITEMS.register(name, () ->
                 new BlockItem(block.get(),
                         new Item.Properties()
                                 .useItemDescriptionPrefix()
                                 .setId(ResourceKey.create(Registries.ITEM,
                                         ResourceLocation.fromNamespaceAndPath(AktonLegendsMod.MODID,
                                                 name)
                                 ))
                 ));
    }

    /*
    // In some registration class
    public static final DeferredRegister<MapCodec<? extends Block>>
            REGISTRAR = DeferredRegister.create(BuiltInRegistries.BLOCK_TYPE,
            AktonLegendsMod.MODID);

    public static final Supplier<MapCodec<BloomeryBlock>>
            COMPLEX_CODEC = REGISTRAR.register(
            "simple",
            () -> RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            Codec.INT.fieldOf("value")
                                    .forGetter(BloomeryBlock::getValue),
                            BlockBehaviour.propertiesCodec() // represents the BlockBehavior.Properties parameter
                    ).apply(instance, BloomeryBlock::new)
            ));
     */
}
