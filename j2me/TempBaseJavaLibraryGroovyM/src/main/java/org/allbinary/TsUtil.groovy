/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary;


//TempBase
@groovy.transform.CompileStatic
public class TsUtil {
    private static final TsUtil instance = new TsUtil();

    /**      * @return the instance      */
    public static TsUtil getInstance() {
        return TsUtil.instance;
    }

    public double longBitsToDouble(final long bits) {
        return java.lang.Double.longBitsToDouble(bits);
    }

    public float intBitsToFloat(final int bits) {
        return java.lang.Float.intBitsToFloat(bits);
    }

    public int hashCode(Object anyType) {
        return anyType.hashCode();
    }

    public void waitFor(Object any, final long timeoutMillis) throws InterruptedException {
        final Object anyType = ((Object) any);
        anyType.wait(timeoutMillis);
    }

    public int compareTo(final String a, final String b) {
        return a.compareTo(b);
    }

}


