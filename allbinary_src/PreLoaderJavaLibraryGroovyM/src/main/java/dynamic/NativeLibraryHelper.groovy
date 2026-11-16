/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package dynamic;


@groovy.transform.CompileStatic
public class NativeLibraryHelper {
    private String library;

    public NativeLibraryHelper(String library) {
        this.library = library;
    }

    //Runtime.getRuntime().load("c:\\winnt\\system32\\DirectXWindowsInputRobot.dll");
    public void load() {
        System.loadLibrary(this.library);
    }

}


