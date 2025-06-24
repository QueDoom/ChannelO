package net.quedoom.channelo.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.quedoom.channelo.ChannelO;

public class ModItems {

    public static Item VOID_PEBBLE = registerItem("void_pebble", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ChannelO.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ChannelO.LOGGER.info("Registering Mod Items for " + ChannelO.MOD_ID);
    }
}
