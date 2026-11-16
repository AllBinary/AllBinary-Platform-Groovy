/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.io.path;

import org.allbinary.logic.io.file.FilePathData;
import org.allbinary.logic.string.StringUtil;
import org.allbinary.string.CommonSeps;

@groovy.transform.CompileStatic
public class AbPathData {
    private static final AbPathData instance = new AbPathData();

    public static AbPathData getInstance() {
        return AbPathData.instance;
    }

    public final String EXTENSION_SEP = CommonSeps.getInstance().@PERIOD;

    public final char SEPARATORCHAR = ('/' as char);

    public final String SEPARATOR = CommonSeps.getInstance().@FORWARD_SLASH;

    private AbPathData() {
    }

}


