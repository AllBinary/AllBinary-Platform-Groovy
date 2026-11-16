/*  * AllBinary Open License Version 1  * Copyright (c) 2026 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic;

import java.util.Vector;

/**  *  * @author User  */
@groovy.transform.CompileStatic
public class VectorUtil {
    private static final VectorUtil instance = new VectorUtil();

    /**      * @return the instance      */
    public static VectorUtil getInstance() {
        return VectorUtil.instance;
    }

    public int getSize(final Object anyType) {
        final Vector<Object> vector = ((Vector<Object>) anyType);
        return vector.size();
    }

    public Object elementAt(final Object anyType, final int index) {
        final Vector<Object> vector = ((Vector<Object>) anyType);
        return vector.elementAt(index);
    }

}


