/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.image;

import javax.microedition.lcdui.Image;
import org.allbinary.animation.Animation;
import org.allbinary.animation.AnimationBehaviorFactory;
import org.allbinary.graphics.opengles.OpenGLUtil;
import org.allbinary.logic.math.PrimitiveIntUtil;

/**  *  * @author User  */
@groovy.transform.CompileStatic
public class ImageAnimationFactory extends BaseImageAnimationFactory {
    public static ImageAnimationFactory createFactory(final Image image) throws Exception {
        return new ImageAnimationFactory(image, image.getWidth(), image.getHeight(), 0, 0, AnimationBehaviorFactory.getInstance());
    }

    //    }
    public ImageAnimationFactory(final Image image, final int width, final int height, final int dx, final int dy, final AnimationBehaviorFactory animationBehaviorFactory) throws Exception {
        super(image, PrimitiveIntUtil.getArrayInstance(), width, height, dx, dy, animationBehaviorFactory);
    }

    @Override
    public Animation getInstance(final int instanceId) throws Exception {
        //final ImageCopyUtil imageCopyUtil = ImageCopyUtil.getInstance();
        Image scaledImage = this.animationFactoryImageScaleUtil.createImage(this.getImage(), this.animationFactoryInitializationVisitor.@width, this.animationFactoryInitializationVisitor.@height, this.scaleProperties.@scaleWidth, this.scaleProperties.@scaleHeight);
        final OpenGLUtil openGLUtil = OpenGLUtil.getInstance();
        scaledImage = openGLUtil.addImage(scaledImage);
        //final Image copyOfScaledImage = ImageCopyUtil.getInstance().createImage(scaledImage);
        if (this.animationFactoryInitializationVisitor.@dx != 0 || this.animationFactoryInitializationVisitor.@dy != 0) {
            this.animationFactoryImageScaleUtil.processAdjust(this);
            return new AdjustedImageAnimation(scaledImage, this.animationFactoryInitializationVisitor.@dx, this.animationFactoryInitializationVisitor.@dy, this.animationBehaviorFactory.getOrCreateInstance());
        } else {
            return new ImageAnimation(scaledImage, this.animationBehaviorFactory.getOrCreateInstance());
        }
    }

}


