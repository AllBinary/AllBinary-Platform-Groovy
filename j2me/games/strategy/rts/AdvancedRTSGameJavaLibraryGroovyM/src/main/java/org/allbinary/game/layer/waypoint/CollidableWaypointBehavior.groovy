/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.waypoint;

import org.allbinary.game.layer.CollidableCompositeLayer;
import org.allbinary.game.layer.CollidableRTSBehavior;
import org.allbinary.game.collision.CollidableInterfaceCompositeInterface;

@groovy.transform.CompileStatic
public class CollidableWaypointBehavior extends CollidableRTSBehavior {
    public CollidableWaypointBehavior(boolean collidable) {
        super(collidable);
    }

    //public void collide(CollidableInterfaceCompositeInterface collidableInterfaceCompositeInterface)
    @Override
    public boolean isCollision(final CollidableCompositeLayer ownerLayer, CollidableCompositeLayer collisionLayer) {
        return false;
    }

    @Override
    public void collide(final CollidableCompositeLayer ownerLayer, CollidableCompositeLayer collisionLayer) throws Exception {
    }

    @Override
    public boolean isCollisionInterface(final CollidableCompositeLayer ownerLayer, CollidableInterfaceCompositeInterface collidableInterface) {
        return false;
    }

    @Override
    public void collideInterface(final CollidableCompositeLayer ownerLayer, CollidableInterfaceCompositeInterface collidableInterface) throws Exception {
    }

}


