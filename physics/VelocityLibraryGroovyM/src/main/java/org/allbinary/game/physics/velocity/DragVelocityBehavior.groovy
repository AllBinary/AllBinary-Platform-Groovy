/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.physics.velocity;

import org.allbinary.logic.math.BasicDecimal;

/**  *  * @author user  */
@groovy.transform.CompileStatic
public class DragVelocityBehavior extends VelocityBehaviorBase {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    public static final DragVelocityBehavior instance = new DragVelocityBehavior();

    @Override
    public void reduce(final BasicVelocityProperties velocityProperties, final int nominator, final int denominator) {
        //this.logUtil.putF("VelocityY: " + this.getVelocityYBasicDecimalP().getUnscaled(), this, "friction");
        if (velocityProperties.getVelocityXBasicDecimalP().getUnscaled() != 0L) {
            final BasicDecimal basicDecimal = velocityProperties.getVelocityXBasicDecimalP();
            basicDecimal.multiplyint(nominator);
            basicDecimal.divideint(denominator);
        }
        if (velocityProperties.getVelocityYBasicDecimalP().getUnscaled() != 0L) {
            final BasicDecimal basicDecimal = velocityProperties.getVelocityYBasicDecimalP();
            basicDecimal.multiplyint(nominator);
            basicDecimal.divideint(denominator);
        }
    }

    @Override
    public void reduceX(final BasicVelocityProperties velocityProperties, final int nominator, final int denominator) {
        final BasicDecimal basicDecimal = velocityProperties.getVelocityXBasicDecimalP();
        if (basicDecimal.getUnscaled() != 0L) {
            basicDecimal.multiplyint(nominator);
            basicDecimal.divideint(denominator);
        }
    }

    @Override
    public void reduceY(final BasicVelocityProperties velocityProperties, final int nominator, final int denominator) {
        if (velocityProperties.getVelocityYBasicDecimalP().getUnscaled() != 0L) {
            final BasicDecimal basicDecimal = velocityProperties.getVelocityYBasicDecimalP();
            basicDecimal.multiplyint(nominator);
            basicDecimal.divideint(denominator);
        }
    }

}


