/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.media.image;

import javax.microedition.lcdui.Image;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.GameFeatureFactory;
import org.allbinary.image.ImageCache;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class ImageScaleUtil {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final ImageScaleUtil instance = new ImageScaleUtil();

    public static ImageScaleUtil getInstance() {
        return ImageScaleUtil.instance;
    }

    private final CommonStrings commonStrings = CommonStrings.getInstance();

    //private final ImageCreationUtil imageCreationUtil = ImageCreationUtil.getInstance();
    private final ImageCopyUtil imageCopyUtil = ImageCopyUtil.getInstance();

    private final GameFeatureFactory gameFeatureFactory = GameFeatureFactory.getInstance();

    private final Features features = Features.getInstance();

    private final String NO_COPY = 'SWT should not copy images after initial loading as the alpha is not honored';

    private ImageScaleUtil() {
    }

    public Image createImage2(final ImageCache imageCache, final Image originalImage, final float scaleNominatorX, final float scaleDenominatorX, final float scaleNominatorY, final float scaleDenominatorY, final boolean cached) throws Exception {
        return this.createImage3(imageCache, originalImage, scaleNominatorX, scaleDenominatorX, scaleNominatorY, scaleDenominatorY, cached, true);
    }

    //private int anchor = Anchor.TOP_LEFT;
    public Image createImage3(final ImageCache imageCache, final Image originalImage, final float scaleNominatorX, final float scaleDenominatorX, final float scaleNominatorY, final float scaleDenominatorY, final boolean cached, final boolean mutable) throws Exception {
        if (!this.features.isFeature(this.gameFeatureFactory.@POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.@CONSTRUCTOR);
            return originalImage;
        }
        final int width = originalImage.getWidth();
        final int height = originalImage.getHeight();
        final float scaleX = ((float) (scaleNominatorX / scaleDenominatorX));
        final float scaleY = ((float) (scaleNominatorY / scaleDenominatorY));
        //        this.scale(originalImage, image, scaleX, scaleY);
        final Image scaledImage = this.imageCopyUtil.createImageWH(originalImage, ((int) (((float) (scaleX * width)))), ((int) (((float) (scaleY * height)))), mutable);
        return scaledImage;
    }

    public void scale2(final Image originalImage, final Image[] originalImageArray, final Image[] ximageToShowArray, final int unused, final float scaleX, final float scaleY, final float maxScaleX, final float maxScaleY) throws Exception {
        this.scale(originalImage, originalImageArray, ximageToShowArray, unused, scaleX, scaleY, maxScaleX, maxScaleY, true);
    }

    public void scale(final Image originalImage, final Image[] originalImageArray, final Image[] ximageToShowArray, final int unused, final float scaleX, final float scaleY, final float maxScaleX, final float maxScaleY, final boolean mutable) throws Exception {
        final int width = originalImage.getWidth();
        final int height = originalImage.getHeight();
        final Image scaledImage = this.imageCopyUtil.createImageWH(originalImage, ((int) (((float) (scaleX * width)))), ((int) (((float) (scaleY * height)))), mutable);
        originalImageArray[0] = scaledImage;
    }

}


