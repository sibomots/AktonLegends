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
package com.sibomots.aktonlegends.item;

import com.mojang.logging.LogUtils;
import com.sibomots.aktonlegends.AktonLegendsMod;
import com.sibomots.aktonlegends.core.ModRegistry;

import static com.sibomots.aktonlegends.core.ModRegistry.BLOCKS;
import static com.sibomots.aktonlegends.core.ModRegistry.ITEMS;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static final DeferredItem<Item> RAW_SILVERLIGHT_ITEM =
            ModRegistry.registerModItem("raw_silverlight");

    public static final DeferredItem<Item> SILVERLIGHT_ITEM =
            ModRegistry.registerModFoodItem("silverlight");

    public static final DeferredItem<Item> VITREOUS_SILVERLIGHT_ITEM =
            ModRegistry.registerModFoodItem("vitreous_silverlight");

    public static final DeferredItem<Item> SILVERLIGHT_ITEMBLOCK =
            ModRegistry.registerModFoodItem("silverlight_itemblock");

    public static final DeferredItem<Item> SILVERLIGHT_ORE_ITEMBLOCK =
            ModRegistry.registerModItem("silverlight_ore_itemblock");

    public static final DeferredItem<Item> SILVERLIGHT_VITREOUS_ORE_ITEMBLOCK =
            ModRegistry.registerModItem("vitreous_silverlight_ore_itemblock");

    public static final DeferredItem<Item> SILVERLIGHT_VITREOUS_ITEMBLOCK =
            ModRegistry.registerModItem("vitreous_silverlight_itemblock");


}
