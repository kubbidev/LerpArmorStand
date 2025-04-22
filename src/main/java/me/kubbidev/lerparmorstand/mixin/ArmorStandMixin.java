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

    private @Unique EulerAngle lastHeadRotation     = null;
    private @Unique EulerAngle lastBodyRotation     = null;
    private @Unique EulerAngle lastLeftArmRotation  = null;
    private @Unique EulerAngle lastRightArmRotation = null;
    private @Unique EulerAngle lastLeftLegRotation  = null;
    private @Unique EulerAngle lastRightLegRotation = null;

    @Override
    public EulerAngle getLastHeadRotation() {
        return this.lastHeadRotation != null ? this.lastHeadRotation : this.headRotation;
    }

    @Override
    public EulerAngle getLastBodyRotation() {
        return this.lastBodyRotation != null ? this.lastBodyRotation : this.bodyRotation;
    }

    @Override
    public EulerAngle getLastLeftArmRotation() {
        return this.lastLeftArmRotation != null ? this.lastLeftArmRotation : this.leftArmRotation;
    }

    @Override
    public EulerAngle getLastRightArmRotation() {
        return this.lastRightArmRotation != null ? this.lastRightArmRotation : this.rightArmRotation;
    }

    @Override
    public EulerAngle getLastLeftLegRotation() {
        return this.lastLeftLegRotation != null ? this.lastLeftLegRotation : this.leftLegRotation;
    }

    @Override
    public EulerAngle getLastRightLegRotation() {
        return this.lastRightLegRotation != null ? this.lastRightLegRotation : this.rightLegRotation;
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
