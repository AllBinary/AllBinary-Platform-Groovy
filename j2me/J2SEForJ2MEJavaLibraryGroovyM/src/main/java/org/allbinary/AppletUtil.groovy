/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary;


//import org.allbinary.logic.communication.log.PreLogUtil;
@groovy.transform.CompileStatic
public class AppletUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private AppletUtil() {
    }

    private static boolean applet = false;

    public static void setApplet() {
        AppletUtil.applet = true;
    }

    //private static final String APPLET = "sun.plugin.security.PluginClassLoader".toLowerCase();
    public static boolean isAppletLoader(Object anyType) {
        //}
        return AppletUtil.applet;
    }

}


