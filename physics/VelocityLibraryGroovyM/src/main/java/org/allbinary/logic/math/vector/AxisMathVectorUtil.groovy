/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math.vector;

import org.allbinary.math.NoDecimalTrigTable;

@groovy.transform.CompileStatic
public class AxisMathVectorUtil {
    private static final AxisMathVectorUtil instance = new AxisMathVectorUtil();

    public static AxisMathVectorUtil getInstance() {
        return AxisMathVectorUtil.instance;
    }

    private final NoDecimalTrigTable noDecimalTrigTable = NoDecimalTrigTable.getInstance();

    public long calculateX(long magnitude, int angle) {
        return Math.divideExact(magnitude * this.noDecimalTrigTable.cos(angle), ((long) 10));
    }

    public long calculateY(long magnitude, int angle) {
        return Math.divideExact(magnitude * this.noDecimalTrigTable.sin(angle), ((long) 10));
    }

    //as such it is hard to say what the otherAngle is since I do not have normal orientation of the axi.
    public long calculateZ(long magnitude, int otherAngle) {
        return Math.divideExact(magnitude * this.noDecimalTrigTable.sin(otherAngle), ((long) 10));
    }

}


