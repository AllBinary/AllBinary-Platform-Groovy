/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;

import java.util.logging.Level;
import org.allbinary.logic.string.StringMaker;
import java.util.logging.Logger;
import org.allbinary.string.CommonStrings;

//ActualPlatform
@groovy.transform.CompileStatic
public class LogUtil {
    private static final LogUtil instance = new LogUtil();

    //ActualPlatform
    public static final LogUtil getInstance() {
        return LogUtil.instance;
    }

    private final Logger logger = Logger.getLogger(LogUtil.class.getName());

    private final LogFormatUtil logFormatUtil = LogFormatUtil.getInstance();

    /*     private final static String DEFAULT_PATH;      static     {     StringMaker stringBuffer = new StringMaker();      stringBuffer.append(AbPathData.getInstance().EXTENSION_SEP);     stringBuffer.append(AbPathData.getInstance().SEPARATOR);     stringBuffer.append(LogData.ALLBINARY);     stringBuffer.append(LogData.extension);      LogUtil.DEFAULT_PATH = stringBuffer.toString();      LogUtil.init();     }      */
    private LogUtil() {
    }

    //ActualPlatform
    public void init() {
        //PreLogUtil.put(message, "LogUtil", "init()");
        PreLogUtil.put('Loggin Initialized', this, 'init()');
    }

    //ActualPlatform
    public void putL(final Log log) {
        Object exception = log.getThrowable();
        try {
            if (exception != null) {
                String specialMessage = log.getSpecialMessage();
                Object anyType = log.getObject();
                String functionName = log.getFunctionName();
                String className = CommonStrings.getInstance().@EMPTY;
                Class clazz = anyType.getClass();
                if (clazz.getName() != null) {
                    className = clazz.getName();
                }
                String message = this.logFormatUtil.get(className, functionName, specialMessage, exception);
                //logger.severe(message);
                this.logger.log(Level.INFO, message);
            }
        } catch (Exception e) {
        }
    }

    //ActualPlatform
    public void put(final String specialMessage, final Object anyType, final String functionName, final Object exception) {
        try {
            String className = CommonStrings.getInstance().@EMPTY;
            Class clazz = anyType.getClass();
            if (clazz.getName() != null) {
                className = clazz.getName();
            }
            String message = this.logFormatUtil.getS(className, functionName, specialMessage);
            //className, functionName, specialMessage, exception);
            if (exception != null) {
                //logger.severe(message);
                this.logger.log(Level.SEVERE, message, exception);
            } else {
                //Change this back to warning when I get a stable version of gaefv without massive warnings
                this.logger.log(Level.INFO, message);
            }
        } catch (Exception e) {
        }
    }

}


