/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary;


//None - Do not use
@groovy.transform.CompileStatic
public class TsUtil {
    private static final TsUtil instance = new TsUtil();

    /**      * @return the instance      */
    public static TsUtil getInstance() {
        return TsUtil.instance;
    }

    public int hashCode(Object anyType) {
        return anyType.hashCode();
    }

    public void waitFor(Object any, final long timeoutMillis) throws InterruptedException {
        final Object anyType = ((Object) any);
        anyType.wait(timeoutMillis);
    }

    public byte[] getRecord(final Object anyType, final int recordId) {
        return new byte[0];
    }

    public int compareTo(final String a, final String b) {
        return a.compareTo(b);
    }

    public boolean equalIgnoreCase(final String a, final String b) {
        return a.equalsIgnoreCase(b);
    }

    public boolean equalsNotstring(final Object anyType, final Object object2) {
        return anyType.equals(object2);
    }

    //    }
    public int toNumberFromChar(final char value) {
        return ((int) value);
    }

    public int toNumber(final int value) {
        return value;
    }

    public byte[] getByteArray(final String string) {
        return string.getBytes();
    }

    public boolean isItemListener(Object owner) {
        return false;
    }

    public void printAvailableMethods(Object anyType) {
    }

    public void gc() {
        System.gc();
    }

}


