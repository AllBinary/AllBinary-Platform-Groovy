/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image;

import javax.microedition.lcdui.Image;
import org.allbinary.image.ImageCache;

@groovy.transform.CompileStatic
public class ImageScaleUtil {
    private static final ImageScaleUtil instance = new ImageScaleUtil();

    public static ImageScaleUtil getInstance() {
        return ImageScaleUtil.instance;
    }

    //private int anchor = Anchor.TOP_LEFT;
    private ImageScaleUtil() {
    }

    public Image createImage2(final ImageCache imageCache, final Image originalImage, final float scaleNominatorX, final float scaleDenominatorX, final float scaleNominatorY, final float scaleDenominatorY, final boolean cached) throws Exception {
        return this.createImage3(imageCache, originalImage, scaleNominatorX, scaleDenominatorX, scaleNominatorY, scaleDenominatorY, cached, true);
    }

    //private int anchor = Anchor.TOP_LEFT;
    public Image createImage3(final ImageCache imageCache, final Image originalImage, final float scaleNominatorX, final float scaleDenominatorX, final float scaleNominatorY, final float scaleDenominatorY, final boolean cached, final boolean mutable) throws Exception {
        //return this.createImage(imageCache, originalImage, scaleX, scaleY, cached);
        return originalImage;
    }

}


