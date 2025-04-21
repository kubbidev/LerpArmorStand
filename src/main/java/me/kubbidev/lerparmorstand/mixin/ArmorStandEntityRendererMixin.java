package me.kubbidev.lerparmorstand.mixin;

import me.kubbidev.lerparmorstand.api.ArmorStandAccessor;
import net.minecraft.client.render.entity.ArmorStandEntityRenderer;
import net.minecraft.client.render.entity.state.ArmorStandEntityRenderState;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.util.math.EulerAngle;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorStandEntityRenderer.class)
public class ArmorStandEntityRendererMixin {

    @Inject(method = "updateRenderState", at = @At("TAIL"))
    public void updateRenderState(ArmorStandEntity armorStandEntity,
                                  ArmorStandEntityRenderState armorStandEntityRenderState, float f, CallbackInfo ci) {
        ArmorStandAccessor armorStandAccessor = (ArmorStandAccessor) armorStandEntity;
        armorStandEntityRenderState.headRotation = lerpEulerAngle(f, armorStandAccessor.getLastHeadRotation(),
            armorStandEntity.getHeadRotation());
        armorStandEntityRenderState.bodyRotation = lerpEulerAngle(f, armorStandAccessor.getLastBodyRotation(),
            armorStandEntity.getBodyRotation());
        armorStandEntityRenderState.leftArmRotation = lerpEulerAngle(f, armorStandAccessor.getLastLeftArmRotation(),
            armorStandEntity.getLeftArmRotation());
        armorStandEntityRenderState.rightArmRotation = lerpEulerAngle(f, armorStandAccessor.getLastRightArmRotation(),
            armorStandEntity.getRightArmRotation());
        armorStandEntityRenderState.leftLegRotation = lerpEulerAngle(f, armorStandAccessor.getLastLeftLegRotation(),
            armorStandEntity.getLeftLegRotation());
        armorStandEntityRenderState.rightLegRotation = lerpEulerAngle(f, armorStandAccessor.getLastRightLegRotation(),
            armorStandEntity.getRightLegRotation());
    }

    private static EulerAngle lerpEulerAngle(float delta, EulerAngle start, EulerAngle end) {
        boolean bl = delta == 1f;
        float p = bl ? end.getPitch() : MathHelper.lerp(delta, start.getPitch(), end.getPitch());
        float y = bl ? end.getYaw() : MathHelper.lerpAngleDegrees(delta, start.getYaw(), end.getYaw());
        float r = bl ? end.getRoll() : MathHelper.lerp(delta, start.getRoll(), end.getRoll());
        return new EulerAngle(p, y, r);
    }
}
