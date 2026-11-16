/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.os;


//ActualPlatform
@groovy.transform.CompileStatic
public class SystemProperties {
    private static final SystemProperties instance = new SystemProperties();

    //ActualPlatform
    public static SystemProperties getInstance() {
        return SystemProperties.instance;
    }

    private final String OS_NAME = 'os.name';

    private final String OS_ARCH = 'os.arch';

    private final String OS_VERSION = 'os.version';

    private SystemProperties() {
    }

    //ActualPlatform
    public String getName() {
        return this.OS_NAME;
    }

    //ActualPlatform
    public String getArch() {
        return this.OS_ARCH;
    }

    //ActualPlatform
    public String getVersion() {
        return this.OS_VERSION;
    }

    public String getUserHomePath() {
        throw new RuntimeException();
    }

}


