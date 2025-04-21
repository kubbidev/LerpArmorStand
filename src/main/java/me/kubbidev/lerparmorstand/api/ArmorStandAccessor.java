package me.kubbidev.lerparmorstand.api;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.EulerAngle;

@Environment(EnvType.CLIENT)
public interface ArmorStandAccessor {

    EulerAngle getLastHeadRotation();

    EulerAngle getLastBodyRotation();

    EulerAngle getLastLeftArmRotation();

    EulerAngle getLastRightArmRotation();

    EulerAngle getLastLeftLegRotation();

    EulerAngle getLastRightLegRotation();
}
