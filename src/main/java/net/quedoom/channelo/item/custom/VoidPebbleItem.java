package net.quedoom.channelo.item.custom;

import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.quedoom.channelo.client.renderer.item.VoidPebbleItemRenderer;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class VoidPebbleItem extends Item implements GeoItem {
    private static final RawAnimation BLINK_ANIM = RawAnimation.begin().thenPlay("blink");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);


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
        controllerRegistrar.add(new AnimationController<>(this, "Blink", 0, animationState -> PlayState.STOP)
                .triggerableAnim("blink", BLINK_ANIM));
    }

   /* @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        int mathMin = 1;
        int mathMax = 5000;
        int mathRange = mathMax - mathMin + 1;
        int mathResult = (int)(Math.random() * mathRange) + mathMin;

        if (mathResult == 1) {
            triggerAnim(entity, "Blink", "blink");
        }


        super.inventoryTick(stack, world, entity, slot, selected);
    } */

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
