/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer;

import org.allbinary.game.layer.pickup.PickedUpLayerInterface;
import org.allbinary.logic.communication.log.ForcedLogUtil;
import org.allbinary.game.collision.CollidableInterfaceCompositeInterface;
import org.allbinary.game.collision.CollisionType;
import org.allbinary.game.collision.CollisionTypeFactory;
import org.allbinary.game.layer.special.CollidableDestroyableDamageableBehavior;
import org.allbinary.game.layer.special.CollidableDestroyableDamageableLayer;

@groovy.transform.CompileStatic
public class CollidableVehicleBehavior extends CollidableDestroyableDamageableBehavior {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    protected long totalImpactVelocity = 0;

    public CollidableVehicleBehavior(final boolean collidable) {
        super(collidable);
    }

    @Override
    public void collide(final CollidableCompositeLayer ownerLayer, final CollidableCompositeLayer collidableInterfaceCompositeInterface) throws Exception {
        //if (this.getHealthInterface().isAlive())
        final CollisionTypeFactory collisionTypeFactory = CollisionTypeFactory.getInstance();
        final CollisionType collisionType = collidableInterfaceCompositeInterface.getCollidableInferface().getCollisionTypeWith(ownerLayer);
        if (collisionType === collisionTypeFactory.@PICKUP) {
            final CollidableDestroyableDamageableLayer collidableDestroyableDamageableLayer = (((CollidableDestroyableDamageableLayer) ownerLayer));
            collidableDestroyableDamageableLayer.getPickupBehavior().doPickupLayer(((PickedUpLayerInterface) collidableInterfaceCompositeInterface));
        } else if (collisionType === collisionTypeFactory.@COLLISION) {
            super.collide(ownerLayer, collidableInterfaceCompositeInterface);
        } else {
            this.collideVehicle(ownerLayer, ((VehiclePropertiesCompositeInterface) collidableInterfaceCompositeInterface));
        }
    }

    @Override
    public void collideInterface(final CollidableCompositeLayer ownerLayer, final CollidableInterfaceCompositeInterface collidableInterfaceCompositeInterface) {
        ForcedLogUtil.log('Don\'t Use Interface Version It Is Slower', this);
    }

    private long halfImpactVelocityX;

    private long halfImpactVelocityY;

    protected void collideVehicle(final CollidableCompositeLayer ownerLayer, final VehiclePropertiesCompositeInterface vehiclePropertiesCompositeInterface) {
        final VehiclePropertiesCompositeInterface ownerVehicleLayerInterface = (((VehiclePropertiesCompositeInterface) ownerLayer));
        final VehicleProperties ownerVehicleProperties = ownerVehicleLayerInterface.getVehicleProperties();
        final VehicleProperties vehicleProperties = vehiclePropertiesCompositeInterface.getVehicleProperties();
        // Reverse Velocity of both vehicles on the side of the hit
        final long impactVelocityX = ownerVehicleProperties.getVelocityProperties().getVelocityXBasicDecimalP().getUnscaled() - vehicleProperties.getVelocityProperties().getVelocityXBasicDecimalP().getUnscaled();
        final long impactVelocityY = ownerVehicleProperties.getVelocityProperties().getVelocityYBasicDecimalP().getUnscaled() - vehicleProperties.getVelocityProperties().getVelocityYBasicDecimalP().getUnscaled();
        // Basic bounce off
        if (impactVelocityX != 0L) {
            // impactVelocityX, this, damageUtil.COLLIDE);
            this.halfImpactVelocityX = (impactVelocityX >> 1);
            ownerVehicleProperties.getVelocityProperties().getVelocityXBasicDecimalP().addlong(this.halfImpactVelocityX);
            vehicleProperties.getVelocityProperties().getVelocityXBasicDecimalP().addlong(this.halfImpactVelocityX);
        } else {
        }
        // Basic bounce off
        if (impactVelocityY != 0L) {
            // impactVelocityY, this, damageUtil.COLLIDE);
            this.halfImpactVelocityY = (impactVelocityY >> 1);
            ownerVehicleProperties.getVelocityProperties().getVelocityYBasicDecimalP().addlong(this.halfImpactVelocityY);
            vehicleProperties.getVelocityProperties().getVelocityXBasicDecimalP().addlong(this.halfImpactVelocityY);
        } else {
        }
        // Slow Down
        this.collideFriction(ownerVehicleLayerInterface);
        this.collideFriction(vehiclePropertiesCompositeInterface);
        this.totalImpactVelocity = impactVelocityX + impactVelocityY;
    }

    private void collideFriction(final VehiclePropertiesCompositeInterface vehiclePropertiesCompositeInterface) {
        final VehicleFrictionProperties vehicleFrictionProperties = vehiclePropertiesCompositeInterface.getVehicleProperties().getVehicleFrictionProperties();
        vehiclePropertiesCompositeInterface.getVehicleProperties().getVehicleFrictionProperties().friction(vehiclePropertiesCompositeInterface.getVehicleProperties().getVelocityProperties(), vehicleFrictionProperties.getCrashFrictionNominator());
    }

}


