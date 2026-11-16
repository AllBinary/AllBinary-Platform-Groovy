/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary;

import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;
import org.allbinary.logic.NullUtil;

//SWT
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

    public byte[] getRecord(final Object anyType, final int recordId) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        final RecordStore recordStore = ((RecordStore) anyType);
        byte[] data;
        synchronized (this) {
            data = new byte[recordStore.getRecordSize(recordId)];
            recordStore.getRecord(recordId, data, 0);
        }
        return data.length < 1 ? NullUtil.getInstance().@NULL_BYTE_ARRAY : data;
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

    public ClassLoader getClassClassLoader(final Object anyType) {
        return anyType.getClass().getClassLoader();
    }

    public int toNumberFromChar(final char value) {
        return ((int) value);
    }

    public int toNumber(final int value) {
        return value;
    }

    public byte[] getByteArray(final String string) {
        return string.getBytes();
    }

    public boolean isItemListener(Displayable owner) {
        if (owner instanceof Form) {
            return true;
        } else {
            return false;
        }
    }

    public void gc() {
        System.gc();
    }

}


