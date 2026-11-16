/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.crypt.jcehelper;

import org.allbinary.TsUtil;
import org.allbinary.init.crypt.jcehelper.CryptInterface;
import org.allbinary.logic.NullUtil;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.logic.java.byteutil.ByteUtil;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class BasicCrypt implements CryptInterface {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private final ByteUtil byteUtil = ByteUtil.getInstance();

    private final byte[] key;

    public BasicCrypt(String keyAsString) {
        byte[] key = NullUtil.getInstance().@NULL_BYTE_ARRAY;
        try {
            key = TsUtil.getInstance().getByteArray(keyAsString);
        } catch (Exception e) {
            //{
            final CommonStrings commonStrings = CommonStrings.getInstance();
            PreLogUtil.putOE(commonStrings.@EXCEPTION, this, 'AbCrypt(alg,key)', e);
        }
        this.key = key;
    }

    @Override
    public byte[] encrypt(final byte[] array) {
        try {
            return this.mutilate(array);
        } catch (Exception e) {
            //{
            PreLogUtil.putOE('Encrypt Failed', this, 'encrypt', e);
            //}
            return NullUtil.getInstance().@NULL_BYTE_ARRAY;
        }
    }

    @Override
    public byte[] decrypt(final byte[] array) {
        try {
            return this.mutilate(array);
        } catch (Exception e) {
            //{
            PreLogUtil.putOE('decrypt Failed', this, 'decrypt', e);
            //}
            return NullUtil.getInstance().@NULL_BYTE_ARRAY;
        }
    }

    /*     public byte[] mutilate(byte [] array)     {     ByteUtil byteUtil = new ByteUtil();     array = byteUtil.not(array);     return array;     }      */
    public byte[] mutilate(byte[] array) {
        byte value;
        for (int index = 0; index < this.key.length; index++) {
            value = this.key[index];
            //{
            array = this.byteUtil.xor(array, value);
        }
        return array;
    }

}


