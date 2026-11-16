/* * AllBinary Open License Version 1 * Copyright (c) 2023 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image;

import javax.microedition.lcdui.Image;

/**  *  * @author user  */
@groovy.transform.CompileStatic
public class ImageJ2MEScaleUtil {
    private static final ImageJ2MEScaleUtil instance = new ImageJ2MEScaleUtil();

    /**      * @return the instance      */
    public static ImageJ2MEScaleUtil getInstance() {
        return ImageJ2MEScaleUtil.instance;
    }

    private ImageJ2MEScaleUtil() {
    }

    public Image[] scaleArray(Image[] images, int width, int height) throws Exception {
        Image[] scaledImages = new Image[images.length];
        for (int index = images.length; --index >= 0; ) {
            scaledImages[index] = this.scale(images[index], width, height);
        }
        return scaledImages;
    }

    public Image scale(Image image, int width, int height) throws Exception {
        /*         Image scaledImage = GameFeatureImageCacheFactory.getInstance().get(this, width, height);         Graphics graphics = scaledImage.getGraphics();          for(int index = sourceWidth; --index >= 0;)         {             for(int index2 = sourceHeight; --index2 >= 0;)             {                 graphics.setClip(index, index2, 1, 1);                  dx = index * sourceWidth / width;                 dy = index2 * sourceHeight / height;                  graphics.drawImage(image, index - dx, index2 - dy, 0);             }         }         */
        return image;
    }

}


