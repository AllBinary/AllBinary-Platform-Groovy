/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image;

import javax.microedition.lcdui.Image;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.graphics.opengles.OpenGLFeatureFactory;
import org.allbinary.image.opengles.OpenGLESImage;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.eclipse.swt.graphics.GC;
import org.microemu.device.swt.SwtImmutableImage;
import org.microemu.device.swt.SwtMutableImage;

@groovy.transform.CompileStatic
public class ImageRotationUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private static final ImageRotationUtil instance = new ImageRotationUtil();

    public static ImageRotationUtil getInstance() {
        return ImageRotationUtil.instance;
    }

    private final ImageSwtRotationUtil imageSwtRotationUtil = ImageSwtRotationUtil.getInstance();

    private ImageRotationUtil() {
    }

    private final Features features = Features.getInstance();

    public void rotateImage(final Image originalImage, final Image image, final int totalAngle) {
        Image originalImage2 = originalImage;
        if (this.features.isFeature(OpenGLFeatureFactory.getInstance().@OPENGL)) {
            if (image.getType() >= OpenGLESImage.TYPE) {
                final OpenGLESImage openGLESImage = (((OpenGLESImage) image));
                //originalImage2 = openGLESImage.openGLBitmap.getImage();
                openGLESImage.@openGLESImageProperties.@angle = totalAngle;
                //                }
                return;
            } else {
                PreLogUtil.put('OpenGL but image is: ' + image + ' type: ' + image.getType(), this, 'rotateImage');
            }
        }
        final org.eclipse.swt.graphics.Image originalSwtImage = (((org.eclipse.swt.graphics.Image) originalImage2.getImage()));
        GC gc = null;
        org.eclipse.swt.graphics.Image copySwtImage = null;
        if (image.isMutable()) {
            //PreLogUtil.put("3a", this, "createRotatedImage");
            final SwtMutableImage swtImage = ((SwtMutableImage) image);
            copySwtImage = ((org.eclipse.swt.graphics.Image) swtImage.getImage());
            gc = swtImage.getGc();
            //PreLogUtil.put(CommonPhoneStrings.getInstance().FOUR, this, "createRotatedImage");
            this.imageSwtRotationUtil.rotateImage(originalSwtImage, copySwtImage, gc, totalAngle);
        } else {
            //final SwtImmutableImage swtImage = (SwtImmutableImage) image;
            PreLogUtil.put('No rotation for: ' + image.toString(), this, 'rotateImage');
        }
    }

    public Image createRotatedImage(Image originalImage, int rotationInDegrees) throws Exception {
        //        }
        return originalImage;
    }

}


