/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.allbinary.logic.io.file.AbFile;
import org.allbinary.logic.io.file.AbFileNativeUtil;

@groovy.transform.CompileStatic
public class AbFileOutputStream extends FileOutputStream {
    public static AbFileOutputStream createFromAbFile(final AbFile file) throws FileNotFoundException {
        return new AbFileOutputStream(file.getPath(), false);
    }

    public static AbFileOutputStream createFromAbFileAppend(final AbFile file, final boolean append) throws FileNotFoundException {
        return new AbFileOutputStream(file.getPath(), append);
    }

    public static AbFileOutputStream createFromFilePath(final String name) throws FileNotFoundException {
        return new AbFileOutputStream(name, false);
    }

    public static AbFileOutputStream createFromFilePathAppend(final String name, final boolean append) throws FileNotFoundException {
        return new AbFileOutputStream(name, append);
    }

    //    }
    public AbFileOutputStream(final String name, final boolean append) throws FileNotFoundException {
        super(name, append);
    }

}


