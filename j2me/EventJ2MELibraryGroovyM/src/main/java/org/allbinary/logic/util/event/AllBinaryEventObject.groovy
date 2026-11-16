/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.event;

import jsinterop.annotations.JsType;
import org.allbinary.logic.NullUtil;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsProperty;

@JsType
@groovy.transform.CompileStatic
public class AllBinaryEventObject {
    @JsProperty
    public static final AllBinaryEventObject NULL_EVENT = new AllBinaryEventObject(NullUtil.getInstance().@NULL_OBJECT);

    private Object source;

    @JsConstructor
    public AllBinaryEventObject(Object anyType) {
        this.source = anyType;
    }

    @JsMethod
    public Object getSource() {
        return this.source;
    }

    @JsMethod
    protected void setSource(Object source) {
        this.source = source;
    }

}


