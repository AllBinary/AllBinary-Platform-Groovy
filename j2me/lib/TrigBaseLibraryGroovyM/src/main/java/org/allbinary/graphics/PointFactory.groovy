/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics;

import jsinterop.annotations.JsType;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;

@JsType
@groovy.transform.CompileStatic
public class PointFactory {
    private static final PointFactory instance = new PointFactory();

    @JsMethod
    public static PointFactory getInstance() {
        return PointFactory.instance;
    }

    @JsProperty
    public GPoint ZERO_ZERO = this.createXYZ(0, 0, 0);

    //private static final Hashtable hashtable = StdUtil.getInstance().createHashtable();
    @JsMethod
    public void init() {
    }

    @JsConstructor
    private PointFactory() {
    }

    //TWB - to be depricated
    @JsMethod
    public GPoint createXY(int x, int y) {
        return new GPoint(x, y, 0);
    }

    //The rest are mainly static or part of each game level as well
    @JsMethod
    public GPoint createXYZ(int x, int y, int z) {
        return new GPoint(x, y, z);
    }

}


