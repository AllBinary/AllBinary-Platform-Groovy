/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.crypt.jcehelper;

import java.security.spec.KeySpec;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import org.allbinary.TsUtil;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class KeySpecFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private static final KeySpecFactory instance = new KeySpecFactory();

    public static KeySpecFactory getInstance() {
        return KeySpecFactory.instance;
    }

    //tested
    public final String DES = 'DES';

    //requires 24byte key mininum
    public final String DESEDE = 'DESede';

    //untested
    public final String BLOWFISH = 'Blowfish';

    //public final String DH = "Diffie-Hellman";
    private KeySpecFactory() {
    }

    public KeySpec getInstance(String algorithm, byte[] keyData) {
        try {
            final TsUtil tsUtil = TsUtil.getInstance();
            if (tsUtil.compareTo(algorithm, this.DES) == 0) {
                return new DESKeySpec(keyData);
            } else if (tsUtil.compareTo(algorithm, this.DESEDE) == 0) {
                return new DESedeKeySpec(keyData);
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            //{
            final CommonStrings commonStrings = CommonStrings.getInstance();
            PreLogUtil.putOE(commonStrings.@EXCEPTION, this, commonStrings.@GET_INSTANCE, e);
            //return null;
            throw new RuntimeException();
        }
    }

}


