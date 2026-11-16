/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.android;


@groovy.transform.CompileStatic
public class AndroidInfoFactory {
    private static final AndroidInfoFactory instance = new AndroidInfoFactory();

    public static AndroidInfoFactory getInstance() {
        return AndroidInfoFactory.instance;
    }

    private final int version = 8;

    //https://source.android.com/source/build-numbers
    public int getVersion() {
        return this.version;
    }

}


