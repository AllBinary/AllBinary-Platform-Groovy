/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;


//ActualPlatform
@groovy.transform.CompileStatic
public class LogFactory {
    //ActualPlatform
    public static final Log getInstance(String specialMessage, Object anyType, String functionName, Object exception) {
        return new Log(specialMessage, anyType, functionName, exception);
    }

    //ActualPlatform
    public static final Log getInstanceF(String specialMessage, Object anyType, String functionName) {
        return null;
    }

    //ActualPlatform
    public static final Log getInstanceSE(String specialMessage, String className, String functionName, Object exception) {
        return LogFactory.getInstance(specialMessage, className, functionName, exception);
    }

}


