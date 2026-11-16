/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import org.allbinary.animation.AnimationBehavior;
import org.allbinary.math.AngleInfo;
import org.allbinary.graphics.color.BasicColor;
import org.allbinary.media.image.ImageCopyUtil;
import org.allbinary.media.image.ImageModifierUtil;
import org.allbinary.media.image.ImageRotationUtil;
import org.microemu.device.playn.PlaynMutableImage;
import playn.core.CanvasImage;
import playn.core.CanvasSurface;

@groovy.transform.CompileStatic
public class AllBinaryHTMLImageRotationAnimation extends ImageBaseRotationAnimation {
    //private final ImageCreationUtil imageCreationUtil = ImageCreationUtil.getInstance();
    private final ImageRotationUtil imageRotationUtil = ImageRotationUtil.getInstance();

    private final ImageModifierUtil imageModifierUtil = ImageModifierUtil.getInstanceOrCreate();

    //private final float increment;
    private final Image originalImage;

    private final Image[] twoImages = new Image[2];

    private final CanvasSurface[] canvasSurfaceArray = new CanvasSurface[2];

    private Image imageToShow;

    private int bufferedImageIndex;

    private AlphaBaseProcessor alphaProcessor = AlphaBaseProcessor.getInstance();

    protected AllBinaryHTMLImageRotationAnimation(final Image originalImage, final Image image, final AngleInfo angleInfo, final short totalAngle, final AnimationBehavior animationBehavior) throws Exception {
        super(image, angleInfo, totalAngle, animationBehavior);
        this.originalImage = originalImage;
        //this.increment = (short)(this.angleInfo.getAngleIncrementInfo().getAngleIncrement() * 2.44);
        this.imageToShow = image;
        this.twoImages[0] = image;
        this.twoImages[1] = ImageCopyUtil.getInstance().createImage(image);
        //this.twoImages[1] = this.imageCreationUtil.getInstance(image.getWidth(), image.getHeight());
        this.canvasSurfaceArray[0] = this.getCanvasSurface(this.twoImages[0]);
        this.canvasSurfaceArray[1] = this.getCanvasSurface(this.twoImages[1]);
    }

    public CanvasSurface getCanvasSurface(final Image image) {
        final PlaynMutableImage htmlImage = ((PlaynMutableImage) image);
        final CanvasImage canvasImage = ((CanvasImage) htmlImage.getImage());
        final CanvasSurface canvasSurface = htmlImage.getCanvasSurface(canvasImage);
        canvasSurface.translate(Math.divideExact(this.originalImage.getWidth(), 2), Math.divideExact(this.originalImage.getHeight(), 2));
        return canvasSurface;
    }

    public void setBasicColorP(final BasicColor basicColor) {
        boolean changed = false;
        if (this.getBasicColorP() == null || this.getBasicColorP().intValue() != basicColor.intValue()) {
            changed = true;
        }
        super.setBasicColorP(basicColor);
        if (changed) {
            this.updateImage();
        }
    }

    public void setAlpha(final int alpha) {
        boolean changed = false;
        if (this.alphaP != alpha) {
            changed = true;
        }
        super.setAlpha(alpha);
        if (changed) {
            this.alphaProcessor = AlphaProcessor.getInstance();
            this.updateImage();
        }
    }

    public void nextRotation() {
        super.nextRotation();
        this.updateImage();
    }

    public void previousRotation() {
        super.previousRotation();
        this.updateImage();
    }

    private void updateImage() {
        final CanvasSurface canvasSurface = this.canvasSurfaceArray[this.bufferedImageIndex];
        canvasSurface.save();
        this.imageRotationUtil.rotateImageCanvasSurfaceClear(this.originalImage, this.twoImages[this.bufferedImageIndex], canvasSurface, this.angleInfo.getAngle() + 90);
        this.alphaProcessor.setAlpha(this.imageModifierUtil, this.originalImage, this.twoImages[this.bufferedImageIndex], this.alphaP);
        this.imageRotationUtil.drawImage(this.originalImage, imageToShow, canvasSurface);
        canvasSurface.restore();
        this.swap();
    }

    public void setFrame(final int index) {
        //this.logUtil.putF("currentFrame: " + currentFrame, this, "setRotation");
        super.setFrame(index);
        this.updateImage();
    }

    public void swap() {
        this.imageToShow = this.twoImages[this.bufferedImageIndex];
        if (this.bufferedImageIndex == 0) {
            this.bufferedImageIndex = 1;
        } else {
            this.bufferedImageIndex = 0;
        }
    }

    public void paintXY(Graphics graphics, int x, int y) {
        graphics.drawImage(this.imageToShow, x, y, this.anchor);
    }

}


