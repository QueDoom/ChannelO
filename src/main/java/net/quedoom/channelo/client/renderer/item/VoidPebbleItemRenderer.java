package net.quedoom.channelo.client.renderer.item;

import net.minecraft.util.Identifier;
import net.quedoom.channelo.ChannelO;
import net.quedoom.channelo.item.custom.VoidPebbleItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class  VoidPebbleItemRenderer extends GeoItemRenderer<VoidPebbleItem> {
    public VoidPebbleItemRenderer() {
        super(new DefaultedItemGeoModel<>(Identifier.of(ChannelO.MOD_ID, "void_pebble")));
    }
}
