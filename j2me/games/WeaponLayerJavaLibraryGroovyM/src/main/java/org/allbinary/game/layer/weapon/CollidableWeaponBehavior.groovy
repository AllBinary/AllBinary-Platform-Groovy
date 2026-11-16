/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.weapon;

import org.allbinary.game.collision.CollidableHelperFactory;
import org.allbinary.game.collision.CollidableInterfaceCompositeInterface;
import org.allbinary.game.collision.CollisionHelper;
import org.allbinary.game.collision.CollisionType;
import org.allbinary.game.collision.CollisionTypeFactory;
import org.allbinary.game.combat.damage.DamageableInterface;
import org.allbinary.game.layer.CollidableCompositeLayer;
import org.allbinary.game.layer.special.CollidableDestroyableDamageableBehavior;
import org.allbinary.layer.AllBinaryLayer;
import org.allbinary.logic.NullUtil;

@groovy.transform.CompileStatic
public class CollidableWeaponBehavior extends CollidableDestroyableDamageableBehavior {
    private static Object NULL_COLLIDABLE_WEAPON_BEHAVIOR = NullUtil.getInstance().@NULL_OBJECT;

    public static CollidableWeaponBehavior getNullInstance() {
        if (CollidableWeaponBehavior.NULL_COLLIDABLE_WEAPON_BEHAVIOR === NullUtil.getInstance().@NULL_OBJECT) {
            CollidableWeaponBehavior.NULL_COLLIDABLE_WEAPON_BEHAVIOR = new CollidableWeaponBehavior(false);
        }
        return ((CollidableWeaponBehavior) CollidableWeaponBehavior.NULL_COLLIDABLE_WEAPON_BEHAVIOR);
    }

    private boolean collided;

    protected CollisionHelper collisionHelper;

    public CollidableWeaponBehavior(final boolean collidable) {
        super(collidable);
        this.setCollided(false);
        this.setCollidable(true);
        this.collisionHelper = CollidableHelperFactory.getInstance();
    }

    public void init(final AllBinaryLayer sourceLayerInterface) {
        this.setCollided(false);
        this.collisionHelper.setOwnerLayerInterface(sourceLayerInterface);
    }

    // TODO TWB Special Super Efficient Collision Processing
    @Override
    public boolean isCollision(final CollidableCompositeLayer ownerLayer, final CollidableCompositeLayer collisionLayer) {
        if (this.collisionHelper.isCollidable(collisionLayer)) {
            if (ownerLayer.getGroupInterface()[0] !== collisionLayer.getGroupInterface()[0]) {
                // collisionLayer.getGroupInterface().getGroupName(), this, // damageUtil.IS_COLLISION);
                return super.isCollision(ownerLayer, collisionLayer);
            }
        }
        return false;
    }

    // TODO TWB Special Super Efficient Collision Processing
    @Override
    public void collide(final CollidableCompositeLayer ownerLayer, final CollidableCompositeLayer collisionLayer) throws Exception {
        //this.slow();
        super.collide(ownerLayer, collisionLayer);
        this.collided = true;
    }

    @Override
    public boolean isCollisionInterface(final CollidableCompositeLayer ownerLayer, final CollidableInterfaceCompositeInterface collidableInterfaceCompositeInterface) {
        if (this.collisionHelper.isCollidable(((CollidableCompositeLayer) collidableInterfaceCompositeInterface))) {
            final AllBinaryLayer layerInterface = ((AllBinaryLayer) collidableInterfaceCompositeInterface);
            // layerInterface.getGroupInterface().getGroupName(), // this, damageUtil.IS_COLLISION);
            if (ownerLayer.getGroupInterface()[0] !== layerInterface.getGroupInterface()[0]) {
                if (this.layerCollisionUtil.isCollision(ownerLayer, layerInterface)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void collideInterface(final CollidableCompositeLayer ownerLayer, final CollidableInterfaceCompositeInterface collidableInterfaceCompositeInterface) throws Exception {
        // DamageableInterface) {
        final DamageableInterface ownerDamageableInterface = ((DamageableInterface) ownerLayer);
        final DamageableInterface damageableInterface = ((DamageableInterface) collidableInterfaceCompositeInterface);
        this.damageUtil.process(ownerDamageableInterface, damageableInterface);
        this.collided = true;
    }

    /*     private void slow()     {         Movement movement = ((WeaponLayer) this.ownerLayer).getMovement();          BasicVelocityProperties velocityProperties =              ((VelocityInterfaceCompositeInterface) movement).getVelocityProperties();          BasicDecimal xBasicDecimal = velocityProperties.getVelocityXBasicDecimalP();         BasicDecimal yBasicDecimal = velocityProperties.getVelocityYBasicDecimalP();           if(xBasicDecimal.getUnscaled() > 1000 || yBasicDecimal.getUnscaled() > 1000)         {             xBasicDecimal.divide(2);             yBasicDecimal.divide(2);         }     }     */
    @Override
    public CollisionType getCollisionTypeWith(final AllBinaryLayer layerInterface) {
        return CollisionTypeFactory.getInstance().@COLLISION;
    }

    /**      * @return the collided      */
    public boolean isCollided() {
        return this.collided;
    }

    /**      * @param collided      *            the collided to set      */
    private void setCollided(final boolean collided) {
        this.collided = collided;
    }

}


