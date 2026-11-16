/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.weapon;

import org.allbinary.animation.Animation;
import org.allbinary.game.multiplayer.layer.RemoteInfo;
import org.allbinary.graphics.Rectangle;
import org.allbinary.physics.movement.Movement;
import org.allbinary.view.ViewPositionBase;

@groovy.transform.CompileStatic
public class DamageWeaponLayer extends WeaponLayer {
    //    }
    public DamageWeaponLayer(final String name, final RemoteInfo remoteInfo, final Movement movement, final Animation animationInterface, final Animation destroyedAnimationInterface, final Rectangle rectangle, final ViewPositionBase viewPosition, final String username, final int actorSessionId, final int id, final int multiPlayerType) throws Exception {
        super(name, remoteInfo, multiPlayerType, movement, animationInterface, destroyedAnimationInterface, rectangle, viewPosition);
        this.setCollidableInferface(new CollidableDamageWeaponBehavior(true));
    }

}


