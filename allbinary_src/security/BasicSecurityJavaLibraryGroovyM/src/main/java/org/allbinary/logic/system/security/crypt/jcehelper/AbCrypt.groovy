/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.crypt.jcehelper;

import java.security.Security;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import org.allbinary.TsUtil;
import org.allbinary.init.crypt.jcehelper.CryptInterface;
import org.allbinary.logic.NullUtil;
import org.allbinary.logic.communication.log.PreLogUtil;
import org.allbinary.string.CommonStrings;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

@groovy.transform.CompileStatic
public class AbCrypt implements CryptInterface {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private final TsUtil tsUtil = TsUtil.getInstance();

    private BaseSecretComposite secretComposite = BaseSecretComposite.NULL_SECRET_COMPOSITE;

    private String algorithm;

    public AbCrypt(final String algorithm) {
        this.algorithm = algorithm;
    }

    public void init(final String keyAsString) {
        final CommonStrings commonStrings = CommonStrings.getInstance();
        try {
            //Security.addProvider(sunJce);
            try {
                Security.addProvider(new BouncyCastleProvider());
            } catch (Exception e) {
                PreLogUtil.putOE(commonStrings.@EXCEPTION, this, commonStrings.@INIT, e);
            }
            final byte[] key = this.tsUtil.getByteArray(keyAsString);
            final KeySpec keySpec = KeySpecFactory.getInstance().getInstance(this.algorithm, key);
            final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(this.algorithm);
            final SecretKey secretKey = keyFactory.generateSecret(keySpec);
            final Cipher cipher = Cipher.getInstance(this.algorithm);
            this.secretComposite = new SecretComposite(secretKey, cipher, key);
        } catch (Exception e) {
            //{
            PreLogUtil.putOE('init Failed', this, commonStrings.@INIT, e);
        }
    }

    @Override
    public byte[] encrypt(final byte[] array) {
        try {
            return this.secretComposite.encrypt(array);
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
            return this.secretComposite.decrypt(array);
        } catch (Exception e) {
            //{
            PreLogUtil.putOE('decrypt Failed', this, 'decrypt', e);
            //}
            return NullUtil.getInstance().@NULL_BYTE_ARRAY;
        }
    }

}


