/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;


//ActualPlatform
@groovy.transform.CompileStatic
public class LogUtil {
    private static final LogUtil instance = new LogUtil();

    //ActualPlatform
    public static final LogUtil getInstance() {
        return LogUtil.instance;
    }

    private final LogFormatUtil logFormatUtil = LogFormatUtil.getInstance();

    private final String LABEL = 'org.allbinary';

    private final String LOG_SUCCESS = 'org.allbinary: ';

    private LogUtil() {
    }

    //ActualPlatform
    public void putL(final Log log) {
        final String specialMessage = log.getSpecialMessage();
        final Object anyType = log.getObject();
        final String functionName = log.getFunctionName();
        final Object exception = log.getThrowable();
        if (log != null) {
            this.put(specialMessage, anyType, functionName, exception);
        }
    }

    //ActualPlatform
    public void putF(final String specialMessage, final Object anyType, final String functionName) {
    }

    //ActualPlatform
    public void putFS(final String specialMessage, final String className, final String functionName) {
    }

    //ActualPlatform
    public void put(final String specialMessage, final Object anyType, final String functionName, final Object exception) {
        String className = this.LABEL;
        /*       if(object != null && object.getClass().getName() != null)       {          className = new String(object.getClass().getName());       }          */
        className = anyType.getClass().getName();
        final String message = this.logFormatUtil.get(className, functionName, specialMessage, exception);
        android.util.Log.i(this.LABEL, this.LOG_SUCCESS + message);
    }

}


