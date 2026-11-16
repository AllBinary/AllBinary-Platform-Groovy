/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.system;

import org.allbinary.logic.string.StringMaker;

//ActualPlatform
@groovy.transform.CompileStatic
public class Memory {
    //ActualPlatform
    public static String getInfo() {
        //VMRuntime vm = VMRuntime.getRuntime();
        StringMaker stringBuffer = new StringMaker();
        //stringBuffer.append(Runtime.getRuntime().freeMemory());
        long maxUtilizedMemoryAvailable = Runtime.getRuntime().maxMemory();
        long memoryUsed = Runtime.getRuntime().totalMemory();
        stringBuffer.append('APK Memory: Available: ');
        stringBuffer.appendlong(maxUtilizedMemoryAvailable);
        stringBuffer.append('/');
        stringBuffer.appendlong(Runtime.getRuntime().maxMemory());
        stringBuffer.append(' Used: ');
        stringBuffer.appendlong(memoryUsed);
        stringBuffer.append(' Free: ');
        stringBuffer.appendlong(maxUtilizedMemoryAvailable - memoryUsed);
        stringBuffer.append('/');
        stringBuffer.appendlong(Runtime.getRuntime().maxMemory() - memoryUsed);
        return stringBuffer.toString();
    }

}


