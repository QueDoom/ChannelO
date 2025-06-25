package net.quedoom.channelo.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.quedoom.channelo.ChannelO;

public class ModItemGroups {
    public static final ItemGroup CHANNEL_O = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ChannelO.MOD_ID, "channel_o_itemgroup"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.VOID_PEBBLE))
                    .displayName(Text.translatable("itemgroup.channelo.channel_o"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.VOID_PEBBLE);
                    }).build());

    public static void registerItemGroups() {
        ChannelO.LOGGER.info("Registering Item Groups for " + ChannelO.MOD_ID);
    }
}
