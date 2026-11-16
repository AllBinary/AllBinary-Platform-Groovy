/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;

import org.allbinary.log.FileLog;
import org.allbinary.string.CommonSeps;
import org.allbinary.string.CommonStrings;
import org.allbinary.logic.string.StringMaker;

//ActualPlatform
@groovy.transform.CompileStatic
public class LogUtil {
    private static final LogUtil instance = new LogUtil();

    //ActualPlatform
    public static final LogUtil getInstance() {
        return LogUtil.instance;
    }

    //private final String LOG_SUCCESS = "org.allbinary: ";
    private LogUtil() {
    }

    //ActualPlatform
    public void putL(Log log) {
        String specialMessage = log.getSpecialMessage();
        Object anyType = log.getObject();
        String functionName = log.getFunctionName();
        Object exception = log.getThrowable();
        this.put(specialMessage, anyType, functionName, exception);
    }

    //ActualPlatform
    public void putF(String specialMessage, Object anyType, String functionName) {
        //        }
        FileLog.put(specialMessage, anyType, functionName);
    }

    //ActualPlatform
    public void putFS(String specialMessage, final String className, String functionName) {
        //        }
        FileLog.put(specialMessage, className, functionName);
    }

    //ActualPlatform
    public void put(String specialMessage, Object anyType, String functionName, Object exception) {
        //        }
        FileLog.put(specialMessage, anyType, functionName, ((Throwable) exception));
    }

}


