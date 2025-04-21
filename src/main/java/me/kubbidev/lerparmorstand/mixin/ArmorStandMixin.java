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

    @Inject(method = "setHeadRotation", at = @At("HEAD"))
    private void onSetHeadRotationCaptureOld(EulerAngle angle, CallbackInfo ci) {
        this.lastHeadRotation = this.headRotation;
    }

    @Inject(method = "setBodyRotation", at = @At("HEAD"))
    private void onSetBodyRotationCaptureOld(EulerAngle angle, CallbackInfo ci) {
        this.lastBodyRotation = this.bodyRotation;
    }

    @Inject(method = "setLeftArmRotation", at = @At("HEAD"))
    private void onSetLeftArmRotationCaptureOld(EulerAngle angle, CallbackInfo ci) {
        this.lastLeftArmRotation = this.leftArmRotation;
    }

    @Inject(method = "setRightArmRotation", at = @At("HEAD"))
    private void onSetRightArmRotationCaptureOld(EulerAngle angle, CallbackInfo ci) {
        this.lastRightArmRotation = this.rightArmRotation;
    }

    @Inject(method = "setLeftLegRotation", at = @At("HEAD"))
    private void onSetLeftLegRotationCaptureOld(EulerAngle angle, CallbackInfo ci) {
        this.lastLeftLegRotation = this.leftLegRotation;
    }

    @Inject(method = "setRightLegRotation", at = @At("HEAD"))
    private void onSetRightLegRotationCaptureOld(EulerAngle angle, CallbackInfo ci) {
        this.lastRightLegRotation = this.rightLegRotation;
    }
}
