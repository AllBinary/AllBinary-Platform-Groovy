/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache;

import jsinterop.annotations.JsType;
import org.allbinary.logic.NullUtil;
import org.allbinary.util.CircularIndexUtil;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;

@JsType
@groovy.transform.CompileStatic
public class BaseCircularPool {
    @JsProperty
    protected CircularIndexUtil circularIndexUtil = CircularIndexUtil.NULL_CIRCULAR_INDEX_UTIL;

    @JsProperty
    protected Object[] OBJECT_ARRAY = NullUtil.getInstance().@NULL_OBJECT_ARRAY;

    @JsMethod
    public synchronized Object getNextInstance() throws Exception {
        Object anyType = this.OBJECT_ARRAY[this.circularIndexUtil.getIndex()];
        this.circularIndexUtil.next();
        return anyType;
    }

    @JsMethod
    public void init(AllBinaryObjectFactoryInterface allBinaryObjectFactoryInterface) {
        this.circularIndexUtil.setIndex(0);
        int size = this.circularIndexUtil.getSize();
        for (int index = 0; index < size; index++) {
            this.OBJECT_ARRAY[index] = allBinaryObjectFactoryInterface.getInstance();
        }
    }

    @JsMethod
    public Object getInstance(int index) throws Exception {
        return this.OBJECT_ARRAY[index];
    }

}


