/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import org.allbinary.animation.AnimationBehavior;
import org.allbinary.math.AngleInfo;

@groovy.transform.CompileStatic
public class AdjustedImageBaseRotationAnimation extends ImageBaseRotationAnimation {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private int dx;

    private int dy;

    public AdjustedImageBaseRotationAnimation(final Image image, final AngleInfo angleInfo, final short totalAngle, final int dx, final int dy, final AnimationBehavior animationBehavior) throws Exception {
        super(image, angleInfo, totalAngle, animationBehavior);
        // this.logUtil.putF(, this, );
        this.init(dx, dy);
    }

    public void init(final int dx, final int dy) throws Exception {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void paintXY(final Graphics graphics, final int x, final int y) {
        super.paintXY(graphics, x + this.dx, y + this.dy);
    }

}


