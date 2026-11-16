/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import org.allbinary.DisposalUtil;
import org.allbinary.animation.AnimationBehavior;
import org.allbinary.animation.IndexedAnimation;
import org.allbinary.graphics.Anchor;
import org.allbinary.logic.math.PrimitiveIntUtil;

@groovy.transform.CompileStatic
public class ImageAnimation extends IndexedAnimation {
    private final Image image;

    public ImageAnimation(final Image image, final AnimationBehavior animationBehavior) throws Exception {
        super(animationBehavior);
        this.image = image;
    }

    @Override
    public int getAnimationSize() throws Exception {
        return this.getSize();
    }

    @Override
    public void nextFrame() {
    }

    @Override
    public void previousFrame() {
    }

    @Override
    public void setFrame(int index) {
    }

    @Override
    public int getFrame() {
        return 0;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public void setSequence(int[] sequence) {
    }

    @Override
    public int[] getSequence() {
        return PrimitiveIntUtil.getArrayInstance();
    }

    private int anchor = Anchor.TOP_LEFT;

    @Override
    public void paintXY(Graphics graphics, int x, int y) {
        graphics.drawImage(this.image, x, y, this.anchor);
    }

    /**      * @return the image      */
    protected Image getImage() {
        return this.image;
    }

    //java.lang.ref.PhantomReference
    public void close() throws Exception {
        DisposalUtil.getInstance().disposeImage(this.image);
    }

    @Override
    protected void finalize() throws Throwable {
        DisposalUtil.getInstance().disposeImage(this.image);
    }

}


