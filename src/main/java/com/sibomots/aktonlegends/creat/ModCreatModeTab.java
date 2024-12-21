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
package com.sibomots.aktonlegends.creat;

import static com.sibomots.aktonlegends.core.ModRegistry.CREATIVE_MODE_TABS;

import com.sibomots.aktonlegends.AktonLegendsMod;
import com.sibomots.aktonlegends.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import com.sibomots.aktonlegends.item.ModItems;

public class ModCreatModeTab {

    // Creates a creative tab with the id "aktonlegends:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AKTONLEGENDS_ITEMS_TAB
            = CREATIVE_MODE_TABS.register("silverlight_items_tab",
            () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.aktonlegends.silverlight_items_tab"))
//            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.SILVERLIGHT_ORE_BLOCK_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                // Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(ModItems.SILVERLIGHT_ITEM.get());
                output.accept(ModItems.SILVERLIGHT_ORE_BLOCK_ITEM.get());
                output.accept(ModItems.SILVERLIGHT_BLOCK_ITEM.get());
                output.accept(ModItems.RAW_SILVERLIGHT_ITEM.get());
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> AKTONLEGENDS_BLOCKS_TAB
            = CREATIVE_MODE_TABS.register("silverlight_blocks_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.aktonlegends.silverlight_blocks_tab"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AktonLegendsMod.MODID, "silverlight_items_tab"))
                    .icon(() -> ModItems.SILVERLIGHT_BLOCK_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        // Add the example item to the tab. For your own tabs, this method is preferred over the event
                        output.accept(ModBlocks.SILVERLIGHT_BLOCK.get());
                        output.accept(ModBlocks.SILVERLIGHT_ORE_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
