/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;

import org.allbinary.string.CommonStrings;
import org.allbinary.logic.communication.log.LogFormatUtil;

@groovy.transform.CompileStatic
public class Log {
    private final LogFormatUtil logFormatUtil = LogFormatUtil.getInstance();

    private final String specialMessage;

    private final Object anyType;

    private final String functionName;

    private final Object exception;

    public Log(final String specialMessage, final Object anyType, final String functionName, final Object exception) {
        this.specialMessage = specialMessage;
        this.anyType = anyType;
        this.functionName = functionName;
        this.exception = exception;
    }

    public String getSpecialMessage() {
        return this.specialMessage;
    }

    public Object getObject() {
        return this.anyType;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public Object getThrowable() {
        return this.exception;
    }

    public String toString() {
        String className = CommonStrings.getInstance().@EMPTY;
        Class clazz = this.anyType.getClass();
        if (clazz.getName() != null) {
            className = clazz.getName();
        }
        return this.logFormatUtil.get(className, this.functionName, this.specialMessage, this.exception);
    }

}


