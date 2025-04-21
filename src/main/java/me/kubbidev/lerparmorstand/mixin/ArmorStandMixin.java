package me.kubbidev.lerparmorstand.mixin;

import me.kubbidev.lerparmorstand.api.ArmorStandAccessor;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.util.math.EulerAngle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorStandEntity.class)
public class ArmorStandMixin implements ArmorStandAccessor {

    private @Shadow EulerAngle headRotation;
    private @Shadow EulerAngle bodyRotation;
    private @Shadow EulerAngle leftArmRotation;
    private @Shadow EulerAngle rightArmRotation;
    private @Shadow EulerAngle leftLegRotation;
    private @Shadow EulerAngle rightLegRotation;

    private @Unique EulerAngle lastHeadRotation     = ArmorStandEntity.DEFAULT_HEAD_ROTATION;
    private @Unique EulerAngle lastBodyRotation     = ArmorStandEntity.DEFAULT_BODY_ROTATION;
    private @Unique EulerAngle lastLeftArmRotation  = ArmorStandEntity.DEFAULT_LEFT_ARM_ROTATION;
    private @Unique EulerAngle lastRightArmRotation = ArmorStandEntity.DEFAULT_RIGHT_ARM_ROTATION;
    private @Unique EulerAngle lastLeftLegRotation  = ArmorStandEntity.DEFAULT_LEFT_LEG_ROTATION;
    private @Unique EulerAngle lastRightLegRotation = ArmorStandEntity.DEFAULT_RIGHT_LEG_ROTATION;

    @Override
    public EulerAngle getLastHeadRotation() {
        return this.lastHeadRotation;
    }

    @Override
    public EulerAngle getLastBodyRotation() {
        return this.lastBodyRotation;
    }

    @Override
    public EulerAngle getLastLeftArmRotation() {
        return this.lastLeftArmRotation;
    }

    @Override
    public EulerAngle getLastRightArmRotation() {
        return this.lastRightArmRotation;
    }

    @Override
    public EulerAngle getLastLeftLegRotation() {
        return this.lastLeftLegRotation;
    }

    @Override
    public EulerAngle getLastRightLegRotation() {
        return this.lastRightLegRotation;
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        this.lastHeadRotation = this.headRotation;
        this.lastBodyRotation = this.bodyRotation;
        this.lastLeftArmRotation = this.leftArmRotation;
        this.lastRightArmRotation = this.rightArmRotation;
        this.lastLeftLegRotation = this.leftLegRotation;
        this.lastRightLegRotation = this.rightLegRotation;
    }
}
