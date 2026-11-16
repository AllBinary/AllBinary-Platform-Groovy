/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image;

import javax.microedition.lcdui.Image;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.GameFeatureFactory;
import org.allbinary.graphics.displayable.DisplayInfoSingleton;
import org.allbinary.graphics.opengles.OpenGLFeatureFactory;
import org.allbinary.graphics.opengles.OpenGLUtil;
import org.allbinary.image.opengles.OpenGLESDeviceImageTranslate;
import org.allbinary.image.opengles.OpenGLESImage;
import org.allbinary.image.opengles.OpenGLESImageExclusionUtil;
import org.allbinary.image.opengles.OpenGLESImageProperties;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.string.CommonStrings;
import org.eclipse.swt.graphics.ImageData;
import org.microemu.app.ui.swt.SwtDeviceComponent;
import org.microemu.device.swt.PostLoadSwtImmutableImageProcessor;
import org.microemu.device.swt.PostLoadSwtMutableImageProcessor;
import org.microemu.device.swt.SwtImmutableImage;
import org.microemu.device.swt.SwtMutableImage;

@groovy.transform.CompileStatic
public class ImageCopyUtil {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final ImageCopyUtil instance = new ImageCopyUtil();

    public static ImageCopyUtil getInstance() {
        return ImageCopyUtil.instance;
    }

    //private final BasicColorSetUtil basicColorUtil = BasicColorSetUtil.getInstance();
    private ImageCopyUtil() {
    }

    //private int anchor = Anchor.TOP_LEFT;
    private final CommonStrings commonStrings = CommonStrings.getInstance();

    //private final CommonSeps commonSeps = CommonSeps.getInstance();
    private final GameFeatureFactory gameFeatureFactory = GameFeatureFactory.getInstance();

    private final Features features = Features.getInstance();

    private final OpenGLFeatureFactory openGLFeatureFactory = OpenGLFeatureFactory.getInstance();

    private final OpenGLUtil openGLUtil = OpenGLUtil.getInstance();

    private final OpenGLESImageExclusionUtil openGLESImageExclusionUtil = OpenGLESImageExclusionUtil.getInstance();

    private final String NO_COPY = 'SWT should not copy images after initial loading as the alpha is not honored';

    //private final String NO_COPY2 = "JOGL support for SWT Image copy is not implemented";
    private final String UNABLE = 'Unable to scale image without dimensions';

    public Image createImageForRotation(final Image originalImage) throws Exception {
        if (this.features.isFeature(this.openGLFeatureFactory.@OPENGL)) {
            Image image = originalImage;
            image = this.openGLUtil.addImage(image);
            return image;
        } else {
            return this.createImage(originalImage);
        }
    }

    // String resource,
    public Image createImage(final Image originalImage) throws Exception {
        if (!this.features.isFeature(this.gameFeatureFactory.@POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.@CONSTRUCTOR);
            return originalImage;
        }
        Image originalImage2 = originalImage;
        if (this.features.isFeature(this.openGLFeatureFactory.@OPENGL)) {
            //this.logUtil.putF(new StringMaker().append(NO_COPY2).append(" from: ").append(originalImage.getWidth()).append(commonSeps.SPACE).append(originalImage.getHeight()).append(" to: ").append(width).append(commonSeps.SPACE).append(height).toString(), this, this.commonStrings.CONSTRUCTOR);
            if (originalImage.getType() >= OpenGLESImage.TYPE) {
                final OpenGLESImage openGLESImage = (((OpenGLESImage) originalImage));
                originalImage2 = openGLESImage.@openGLBitmap.getImage();
            }
        }
        //Image image = null;
        Image image = null;
        //final org.eclipse.swt.graphics.Image swtImage = mutableImage.img;
        if (originalImage2.isMutable()) {
            final SwtMutableImage originalMutableImage = ((SwtMutableImage) originalImage2);
            //            image = new SwtMutableImage(SwtDeviceComponent.createImage(imageData0));
            image = new SwtMutableImage(SwtDeviceComponent.createImage(originalMutableImage.@image.getImageData()));
        } else {
            final SwtImmutableImage originalImmutableImage = ((SwtImmutableImage) originalImage2);
            //              if(originalImmutableImage.getImage() != null) {
            image = new SwtMutableImage(SwtDeviceComponent.createImage(originalImmutableImage.@image.getImageData()));
        }
        //            
        image = this.openGLUtil.addImage(image);
        return image;
    }

    public Image createImageWH(final Image originalImage, final int width, final int height, final boolean mutable) throws Exception {
        Image originalImage2 = originalImage;
        if (!this.features.isFeature(this.gameFeatureFactory.@POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.@CONSTRUCTOR);
            return originalImage;
        }
        //if(originalImage instanceof OpenGLESImage) {
        if (this.features.isFeature(this.openGLFeatureFactory.@OPENGL)) {
            if (this.openGLESImageExclusionUtil.isCustomScaling(originalImage)) {
                return this.createImage2(originalImage, width, height, mutable);
            }
            //this.logUtil.putF(new StringMaker().append(NO_COPY2).append(" from: ").append(originalImage.getWidth()).append(commonSeps.SPACE).append(originalImage.getHeight()).append(" to: ").append(width).append(commonSeps.SPACE).append(height).toString(), this, this.commonStrings.CONSTRUCTOR);
            if (originalImage.getType() >= OpenGLESImage.TYPE) {
                final OpenGLESImage openGLESImage = (((OpenGLESImage) originalImage));
                originalImage2 = openGLESImage.@openGLBitmap.getImage();
            }
        }
        Image image = null;
        if (originalImage2.isMutable() && mutable) {
            final SwtMutableImage originalMutableImage = ((SwtMutableImage) originalImage2);
            if (originalMutableImage.getImage() != null) {
                final ImageData imageData2 = originalMutableImage.@image.getImageData();
                //                if(imageData2.data.length != 120000) {
                final ImageData imageData = imageData2.scaledTo(width, height);
                image = new SwtMutableImage(SwtDeviceComponent.createImage(imageData));
            } else {
                image = new SwtMutableImage(originalMutableImage.getName(), new PostLoadSwtMutableImageProcessor(originalMutableImage));
            }
        } else {
            final SwtImmutableImage originalImmutableImage = ((SwtImmutableImage) originalImage2);
            if (originalImmutableImage.getImage() != null) {
                final ImageData imageData2 = originalImmutableImage.@image.getImageData();
                //                if(imageData2.data.length != 120000) {
                if (width > 0 && height > 0) {
                    final ImageData imageData = imageData2.scaledTo(width, height);
                    image = new SwtImmutableImage(originalImage.getName(), SwtDeviceComponent.createImage(imageData));
                } else {
                    this.logUtil.putF(UNABLE, this, this.commonStrings.@CONSTRUCTOR);
                    image = new SwtImmutableImage(originalImmutableImage.getName(), new PostLoadSwtImmutableImageProcessor(originalImmutableImage));
                }
            } else {
                image = new SwtImmutableImage(originalImmutableImage.getName(), new PostLoadSwtImmutableImageProcessor(originalImmutableImage));
            }
        }
        image = this.openGLUtil.addImage(image);
        return image;
    }

    private final String INFORMATION = 'about_';

    private final String LEADERBOARD = 'leaderboard';

    //private final String GREEN_BUTTON = "green_button";
    public Image createImage2(final Image originalImage, final int width, final int height, final boolean mutable) throws Exception {
        Image originalImage2 = originalImage;
        if (!this.features.isFeature(this.gameFeatureFactory.@POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.@CONSTRUCTOR);
            return originalImage;
        }
        Image image = null;
        //if(originalImage instanceof OpenGLESImage) {
        if (this.features.isFeature(this.openGLFeatureFactory.@OPENGL)) {
            //this.logUtil.putF(new StringMaker().append(NO_COPY2).append(" from: ").append(width2).append(commonSeps.SPACE).append(height2).append(" to: ").append(width).append(commonSeps.SPACE).append(height).toString(), this, this.commonStrings.CONSTRUCTOR);
            final DisplayInfoSingleton displayInfoSingleton = DisplayInfoSingleton.getInstance();
            if (originalImage.getType() >= OpenGLESImage.TYPE) {
                //this.logUtil.putF("TWB0: " + originalImage.getWidth() + " h: " + originalImage.getHeight(), this, this.commonStrings.CONSTRUCTOR);
                final OpenGLESImage openGLESImage = (((OpenGLESImage) originalImage));
                final OpenGLESImageProperties openGLESImageProperties = openGLESImage.@openGLESImageProperties;
                //this.logUtil.putF(new StringMaker().append("0sx: ").append(openGLESImageProperties.scaleX2).append(" sy: ").append(openGLESImageProperties.scaleY2).toString(), this, this.commonStrings.CONSTRUCTOR);
                final int openGLWidth = openGLESImage.@openGLBitmap.getWidth();
                final int openGLHeight = openGLESImage.@openGLBitmap.getHeight();
                openGLESImageProperties.@scaleX = openGLESImageProperties.@scaleX2 = (((float) ((((float) width)) / openGLWidth)));
                openGLESImageProperties.@scaleY = openGLESImageProperties.@scaleY2 = (((float) ((((float) height)) / openGLHeight)));
                openGLESImageProperties.@scaleX = ((float) (openGLESImageProperties.@scaleX * 0.75f));
                openGLESImageProperties.@scaleY = ((float) (openGLESImageProperties.@scaleY * 0.75f));
                if (originalImage.getHeight() % 2 != 0) {
                    //this.logUtil.putF(new StringMaker().append("sx: ").append(openGLESImageProperties.scaleX2).append(" sy: ").append(openGLESImageProperties.scaleY2).toString(), this, this.commonStrings.CONSTRUCTOR);
                    openGLESImageProperties.@scaleX2 = ((float) (openGLESImageProperties.@scaleX2 + ((float) (1.0f / openGLWidth))));
                    openGLESImageProperties.@scaleY2 = ((float) (openGLESImageProperties.@scaleY2 + ((float) (1.0f / openGLHeight))));
                }
                //openGLESImageProperties.translateY = -displayInfoSingleton.getLastHeight() / 40 / openGLESImage.scaleY;
                image = openGLESImage;
            } else {
                //this.logUtil.putF("type: " + originalImage.getType(), this, this.commonStrings.CONSTRUCTOR);
                image = originalImage;
                final OpenGLESImage openGLESImage = ((OpenGLESImage) this.openGLUtil.addImage(image));
                final OpenGLESImageProperties openGLESImageProperties = openGLESImage.@openGLESImageProperties;
                openGLESImageProperties.@scaleX = openGLESImageProperties.@scaleX2 = ((float) (((float) ((((float) width)) / openGLESImage.getWidth()))));
                openGLESImageProperties.@scaleY = openGLESImageProperties.@scaleY2 = ((float) (((float) ((((float) height)) / openGLESImage.getHeight()))));
                if (image.getName().startsWith(this.INFORMATION)) {
                    openGLESImage.@openGLESImageTranslate = new OpenGLESDeviceImageTranslate();
                    final OpenGLESDeviceImageTranslate openGLESDeviceImageTranslate = ((OpenGLESDeviceImageTranslate) openGLESImage.@openGLESImageTranslate);
                    openGLESDeviceImageTranslate.@translateX = ((float) (((float) (displayInfoSingleton.getLastWidth() / 1.4f)) / openGLESImageProperties.@scaleX));
                    openGLESDeviceImageTranslate.@translateY = ((float) (Math.divideExact(displayInfoSingleton.getLastHeight(), 4) / openGLESImageProperties.@scaleY));
                    openGLESImageProperties.@scaleX = ((float) (openGLESImageProperties.@scaleX * 0.25f));
                    openGLESImageProperties.@scaleY = ((float) (openGLESImageProperties.@scaleY * 0.25f));
                } else {
                    //                    } else {
                    openGLESImageProperties.@scaleX = ((float) (openGLESImageProperties.@scaleX * 0.75f));
                    openGLESImageProperties.@scaleY = ((float) (openGLESImageProperties.@scaleY * 0.75f));
                    //                    }
                    if (image.getName().startsWith(this.LEADERBOARD)) {
                        openGLESImage.@openGLESImageTranslate = new OpenGLESDeviceImageTranslate();
                        final OpenGLESDeviceImageTranslate openGLESDeviceImageTranslate = ((OpenGLESDeviceImageTranslate) openGLESImage.@openGLESImageTranslate);
                        openGLESDeviceImageTranslate.@translateX = ((float) (Math.divideExact(-displayInfoSingleton.getLastWidth(), 40) / openGLESImageProperties.@scaleX));
                    }
                    if (image.getName().startsWith(this.LEADERBOARD)) {
                    } else {
                        openGLESImageProperties.@scaleX = 1.0f;
                        openGLESImageProperties.@scaleY = 1.0f;
                    }
                }
                //this.logUtil.putF(new StringMaker().append("sx: ").append(openGLESImageProperties.scaleX).append(" sy: ").append(openGLESImage.scaleY).append(" tx: ").append(openGLESImageProperties.translateX).append(" ty: ").append(openGLESImageProperties.translateY).toString(), this, this.commonStrings.CONSTRUCTOR);
                image = openGLESImage;
            }
        } else {
            if (originalImage2.isMutable() && mutable) {
                final SwtMutableImage originalMutableImage = ((SwtMutableImage) originalImage2);
                if (originalMutableImage.getImage() != null) {
                    final ImageData imageData2 = originalMutableImage.@image.getImageData();
                    //                    if (imageData2.data.length != 120000) {
                    final ImageData imageData = imageData2.scaledTo(width, height);
                    image = new SwtMutableImage(SwtDeviceComponent.createImage(imageData));
                } else {
                    image = new SwtMutableImage(originalMutableImage.getName(), new PostLoadSwtMutableImageProcessor(originalMutableImage));
                }
            } else {
                final SwtImmutableImage originalImmutableImage = ((SwtImmutableImage) originalImage2);
                if (originalImmutableImage.getImage() != null) {
                    final ImageData imageData2 = originalImmutableImage.@image.getImageData();
                    //                    if (imageData2.data.length != 120000) {
                    final ImageData imageData = imageData2.scaledTo(width, height);
                    image = new SwtImmutableImage(originalImage.getName(), SwtDeviceComponent.createImage(imageData));
                } else {
                    image = new SwtImmutableImage(originalImmutableImage.getName(), new PostLoadSwtImmutableImageProcessor(originalImmutableImage));
                }
            }
            image = this.openGLUtil.addImage(image);
        }
        return image;
    }

    public Image createImageScale(final Image originalImage, final float canvasScale, final boolean resize) throws Exception {
        if (!this.features.isFeature(this.gameFeatureFactory.@POST_IMAGE_LOADING_MODIFICATION)) {
            this.logUtil.putF(this.NO_COPY, this, this.commonStrings.@CONSTRUCTOR);
            return originalImage;
        }
        //        this.logUtil.putF(new StringMaker().append(spacialStrings.WIDTH_LABEL).append(originalImage.getWidth()).append(spacialStrings.HEIGHT_LABEL).append(originalImage.getHeight()).toString(), this, this.commonStrings.CONSTRUCTOR);
        int newWidth = ((int) (originalImage.getWidth() * canvasScale));
        int newHeight = ((int) (originalImage.getHeight() * canvasScale));
        if (resize) {
            if (newWidth < newHeight) {
                newWidth = newHeight;
            }
            if (newHeight < newWidth) {
                newHeight = newWidth;
            }
        }
        //final Image image = imageCreationUtil.getInstance(newWidth, newHeight);
        final Image image = this.createImageWH(originalImage, newWidth, newHeight, true);
        if (image.isMutable()) {
            ImageData originalImageData = (((org.eclipse.swt.graphics.Image) originalImage.getImage())).getImageData();
            final SwtMutableImage mutableImage2 = ((SwtMutableImage) image);
            final int halfWidthDelta = Math.divideExact((newWidth - originalImage.getWidth()), 2);
            final int halfHeightDelta = Math.divideExact((newHeight - originalImage.getHeight()), 2);
            final int[] originalPixelArray = new int[originalImage.getWidth() * originalImage.getHeight()];
            final int[] newPixelArray = new int[image.getWidth() * image.getHeight()];
            final int width = originalImage.getWidth();
            final int height = originalImage.getHeight();
            for (int i = 0; i < height; i++) {
                originalImageData.getPixels(0, i, width, originalPixelArray, (i * width));
            }
            for (int index = halfWidthDelta; index < width; index++) {
                for (int index2 = halfHeightDelta; index2 < height; index2++) {
                    newPixelArray[index + (index2 * width)] = originalPixelArray[(index - halfWidthDelta) + ((index2 - halfHeightDelta) * width)];
                }
            }
            (((org.eclipse.swt.graphics.Image) mutableImage2.getImage())).getImageData().setPixels(0, 0, image.getWidth(), newPixelArray, 0);
            //graphics.drawRect(0, 0, newWidth, newHeight);
            return image;
        } else {
            final SwtImmutableImage originalImmutableImage = ((SwtImmutableImage) image);
            ImageData originalImageData = (((org.eclipse.swt.graphics.Image) originalImage.getImage())).getImageData();
            final int halfWidthDelta = Math.divideExact((newWidth - originalImage.getWidth()), 2);
            final int halfHeightDelta = Math.divideExact((newHeight - originalImage.getHeight()), 2);
            final int[] originalPixelArray = new int[originalImage.getWidth() * originalImage.getHeight()];
            final int[] newPixelArray = new int[image.getWidth() * image.getHeight()];
            final int width = originalImage.getWidth();
            final int height = originalImage.getHeight();
            for (int i = 0; i < height; i++) {
                originalImageData.getPixels(0, i, width, originalPixelArray, (i * width));
            }
            for (int index = halfWidthDelta; index < width; index++) {
                for (int index2 = halfHeightDelta; index2 < height; index2++) {
                    newPixelArray[index + (index2 * width)] = originalPixelArray[(index - halfWidthDelta) + ((index2 - halfHeightDelta) * width)];
                }
            }
            (((org.eclipse.swt.graphics.Image) originalImmutableImage.getImage())).getImageData().setPixels(0, 0, image.getWidth(), newPixelArray, 0);
            return image;
        }
    }

}


