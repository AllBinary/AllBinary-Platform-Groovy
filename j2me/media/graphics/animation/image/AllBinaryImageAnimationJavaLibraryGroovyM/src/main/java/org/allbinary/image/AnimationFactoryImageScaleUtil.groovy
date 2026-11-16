/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image;

import javax.microedition.lcdui.Image;
import org.allbinary.animation.image.AnimationFactoryInitializationVisitor;
import org.allbinary.animation.image.BaseImageAnimationFactory;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.media.ScaleProperties;
import org.allbinary.media.image.ImageJ2MEScaleUtil;
import org.allbinary.string.CommonLabels;
import org.allbinary.string.CommonStrings;

/**  *  * @author User  */
@groovy.transform.CompileStatic
public class AnimationFactoryImageScaleUtil {
    private static final AnimationFactoryImageScaleUtil instance = new AnimationFactoryImageScaleUtil();

    /**      * @return the instance      */
    public static AnimationFactoryImageScaleUtil getInstance() {
        return AnimationFactoryImageScaleUtil.instance;
    }

    //private final ImageScaleUtil imageScaleUtil = ImageScaleUtil.getInstance();
    private final ImageJ2MEScaleUtil imageScaleUtil = ImageJ2MEScaleUtil.getInstance();

    //private final ImageCopyUtil imageCopyUtil = ImageCopyUtil.getInstance();
    public Image createImage(final Image image, final int width, final int height, final int scaleWidth, final int scaleHeight) throws Exception {
        Image scaledImage;
        //        this.logUtil.putF(stringMaker.append("before scale").append(commonLabels.WIDTH_LABEL).appendint(width).append(commonLabels.HEIGHT_LABEL).appendint(height).toString(), this, commonStrings.PROCESS);
        if (scaleWidth != 0 && scaleHeight != 0) {
            final float scaleX = ((float) ((((float) scaleWidth)) / (((float) width))));
            final float scaleY = ((float) ((((float) scaleHeight)) / (((float) height))));
            //            this.logUtil.putF(stringMaker.append("0scaleX: ").appendfloat(scaleX).append(" scaleY: ").appendfloat(scaleY).toString(), this, commonStrings.PROCESS);
            if ((scaleX == 1.0f && scaleY == 1.0f) || (scaleX == 0.0f || scaleY == 0.0f)) {
                //scaledImage = this.imageCopyUtil.createImage(image);
                scaledImage = image;
            } else {
                //scaledImage = this.imageScaleUtil.createImage(this.imageCache, image, scaleX, 1, scaleY, 1, true);
                final int scaledWidth = ((int) (((float) (scaleX * width))));
                final int scaledHeight = ((int) (((float) (scaleY * height))));
                //                this.logUtil.putF(stringMaker.append("scaledWidth: ").appendfloat(scaledWidth).append(" scaledHeight: ").appendfloat(scaledHeight).toString(), this, commonStrings.PROCESS);
                scaledImage = this.imageScaleUtil.scale(image, scaledWidth, scaledHeight);
            }
        } else {
            //scaledImage = this.imageCopyUtil.createImage(image);
            scaledImage = image;
        }
        return scaledImage;
    }

    public void processAdjust(final BaseImageAnimationFactory baseImageAnimationFactory) throws Exception {
        final ScaleProperties scaleProperties = baseImageAnimationFactory.getScalePropertiesP();
        if (scaleProperties.@scaleWidth != 0 && scaleProperties.@scaleHeight != 0) {
            final AnimationFactoryInitializationVisitor animationFactoryInitializationVisitor = baseImageAnimationFactory.getAnimationFactoryInitializationVisitorP();
            final float scaleX = ((float) ((((float) scaleProperties.@scaleWidth)) / (((float) animationFactoryInitializationVisitor.@width))));
            final float scaleY = ((float) ((((float) scaleProperties.@scaleHeight)) / (((float) animationFactoryInitializationVisitor.@height))));
            if ((scaleX == 1.0f && scaleY == 1.0f) || (scaleX == 0.0f || scaleY == 0.0f)) {
            } else {
                animationFactoryInitializationVisitor.@dx = ((int) (((float) (animationFactoryInitializationVisitor.@originalDx * scaleX))));
                animationFactoryInitializationVisitor.@dy = ((int) (((float) (animationFactoryInitializationVisitor.@originalDy * scaleY))));
            }
        } else {
        }
    }

}


