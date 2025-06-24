package net.quedoom.channelo.item.custom;

import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.item.Item;
import net.quedoom.channelo.client.renderer.item.VoidPebbleItemRenderer;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;

import java.util.function.Consumer;

public class VoidPebbleItem extends Item implements GeoItem {
    public VoidPebbleItem(Settings settings) {
        super(settings);

        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private VoidPebbleItemRenderer renderer;
            @Override
            public @Nullable BuiltinModelItemRenderer getGeoItemRenderer() {
                if(this.renderer == null) {
                    this.renderer = new VoidPebbleItemRenderer();
                }

                return GeoRenderProvider.super.getGeoItemRenderer();
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
    }
}
