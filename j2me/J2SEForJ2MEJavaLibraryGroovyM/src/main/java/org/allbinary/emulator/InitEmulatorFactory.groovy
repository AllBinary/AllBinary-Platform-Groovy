/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.emulator;


@groovy.transform.CompileStatic
public class InitEmulatorFactory {
    private static final InitEmulatorFactory instance = new InitEmulatorFactory();

    public static InitEmulatorFactory getInstance() {
        return InitEmulatorFactory.instance;
    }

    public void setInitEmulator(boolean initEmulator) {
        this.initEmulator = initEmulator;
    }

    public boolean isInitEmulator() {
        return this.initEmulator;
    }

    private boolean initEmulator = false;

}


