/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.time;

import com.google.gwt.i18n.client.DateTimeFormat;
import java.util.Date;

//ActualPlatform
@groovy.transform.CompileStatic
public class TimeStampUtil {
    private static final TimeStampUtil instance = new TimeStampUtil();

    //ActualPlatform
    public static TimeStampUtil getInstance() {
        return TimeStampUtil.instance;
    }

    private TimeStampUtil() {
    }

    //ActualPlatform    
    public String getAsString() {
        // GWT's replacement for SimpleDateFormat
        final DateTimeFormat simpleDataFormat = DateTimeFormat.getFormat('yyyy-MM-dd HH:mm:ss.SSS');
        // replacing the need for Calendar.getInstance().getTime()
        final Date date = new Date();
        return simpleDataFormat.format(date);
    }

}


