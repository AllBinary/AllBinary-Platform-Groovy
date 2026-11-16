/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image;

import javax.microedition.lcdui.Image;
import org.microemu.device.playn.PlaynImmutableImage;
import org.microemu.device.playn.PlaynMutableImage;
import playn.core.CanvasImage;
import playn.core.CanvasSurface;

@groovy.transform.CompileStatic
public class ImageRotationUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private static final ImageRotationUtil instance = new ImageRotationUtil();

    public static ImageRotationUtil getInstance() {
        return ImageRotationUtil.instance;
    }

    private ImageRotationUtil() {
    }

    public Image rotateImage(final Image originalImage, final Image image, final int totalAngle) {
        if (image.isMutable()) {
            final PlaynMutableImage htmlImage = ((PlaynMutableImage) image);
            final CanvasImage canvasImage = ((CanvasImage) htmlImage.getImage());
            final CanvasSurface canvasSurface = htmlImage.getCanvasSurface(canvasImage);
            canvasSurface.translate(Math.divideExact(originalImage.getWidth(), 2), Math.divideExact(originalImage.getHeight(), 2));
            final Image image2 = this.rotateImageCanvasSurface(originalImage, image, canvasSurface, totalAngle);
            this.drawImage(originalImage, image, canvasSurface);
            return image2;
        } else {
            return null;
        }
    }

    public Image rotateImageCanvasSurfaceClear(final Image originalImage, final Image image, final CanvasSurface canvasSurface, final int totalAngle) {
        if (image.isMutable()) {
            canvasSurface.translate(Math.divideExact(-originalImage.getWidth(), 2), Math.divideExact(-originalImage.getHeight(), 2));
            canvasSurface.clear();
            canvasSurface.translate(Math.divideExact(originalImage.getWidth(), 2), Math.divideExact(originalImage.getHeight(), 2));
            return this.rotateImageCanvasSurface(originalImage, image, canvasSurface, totalAngle);
        } else {
            return null;
        }
    }

    public Image rotateImageCanvasSurface(final Image originalImage, final Image image, final CanvasSurface canvasSurface, final int totalAngle) {
        if (image.isMutable()) {
            canvasSurface.rotate(((float) Math.toRadians(totalAngle)));
            return image;
        } else {
            return null;
        }
    }

    public void drawImage(final Image originalImage, final Image image, final CanvasSurface canvasSurface) {
        playn.core.Image originalPlayNImage = null;
        if (originalImage.isMutable()) {
            //PreLogUtil.put("3a", this, "createRotatedImage");
            final PlaynMutableImage originalHTMLImage = ((PlaynMutableImage) originalImage);
            originalPlayNImage = ((playn.core.Image) originalHTMLImage.getImage());
        } else {
            //PreLogUtil.put("3b", this, "createRotatedImage");
            final PlaynImmutableImage originalHTMLImage = ((PlaynImmutableImage) originalImage);
            originalPlayNImage = ((playn.core.Image) originalHTMLImage.getImage());
        }
        canvasSurface.drawImage(originalPlayNImage, Math.divideExact(-originalImage.getWidth(), 2), Math.divideExact(-originalImage.getHeight(), 2));
    }

    public Image createRotatedImage(final Image originalImage, final int rotationInDegrees) throws Exception {
        //PreLogUtil.put("originalImage: " + originalImage + " rotationInDegrees: " + rotationInDegrees, this, "createRotatedImage");
        final Image image = ImageCreationUtil.getInstance().createImageWH(originalImage.getWidth(), originalImage.getHeight());
        final Image rotatedImage = this.rotateImage(originalImage, image, rotationInDegrees);
        if (rotatedImage == null) {
            throw new Exception('Not Mutable');
        }
        return rotatedImage;
    }

}


