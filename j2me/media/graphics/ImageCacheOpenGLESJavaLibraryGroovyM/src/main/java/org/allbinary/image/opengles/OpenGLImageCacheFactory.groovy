/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles;

import org.allbinary.image.ImageCache;

//ImageCacheOpenGLESJavaLibrary
@groovy.transform.CompileStatic
public class OpenGLImageCacheFactory {
    private static final ImageCache IMAGE_CACHE = new OpenGLImageCache();

    /*     public static void init(GL10 gl)     {         ((OpenGLImageCache) OpenGLImageCacheFactory.IMAGE_CACHE).setGl(gl);     }     */
    public static ImageCache getInstance() {
        return OpenGLImageCacheFactory.IMAGE_CACHE;
    }

    //require special attention and special calls for Android
    public static void init() {
    }

}


