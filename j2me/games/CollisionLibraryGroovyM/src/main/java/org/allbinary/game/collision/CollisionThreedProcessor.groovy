/* Generated Code Do Not Modify */
package org.allbinary.game.collision;

import org.allbinary.layer.AllBinaryLayer;

@groovy.transform.CompileStatic
public class CollisionThreedProcessor extends CollisionProcessor {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    @Override
    public boolean isCollision(final AllBinaryLayer myLayer, final AllBinaryLayer myLayer2) {
        //        }
        if (myLayer2.getXP() >= myLayer.getX2() || myLayer2.getYP() >= myLayer.getY2() || myLayer2.getX2() <= myLayer.getXP() || myLayer2.getY2() <= myLayer.getYP() || myLayer2.getZP() < myLayer.getZ2() || myLayer2.getZ2() > myLayer.getZP()) {
            return false;
        } else {
            //PreLogUtil.put(myLayer2.getZ() + " > " + myLayer.getZ2() + " || " + myLayer2.getZ2() + " < " + myLayer.getZP(), this, damageUtil.IS_COLLISION);
            return true;
        }
    }

}


