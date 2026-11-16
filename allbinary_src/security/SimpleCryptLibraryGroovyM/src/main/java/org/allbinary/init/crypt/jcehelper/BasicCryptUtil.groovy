/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.init.crypt.jcehelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.allbinary.TsUtil;
import org.allbinary.logic.communication.log.LogUtil;

@groovy.transform.CompileStatic
public class BasicCryptUtil {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static final BasicCryptUtil instance = new BasicCryptUtil();

    /**      * @return the instance      */
    public static BasicCryptUtil getInstance() {
        return BasicCryptUtil.instance;
    }

    private final TsUtil tsUtil = TsUtil.getInstance();

    private final String XML_START = '<?xml';

    public InputStream getDecryptedInputStream(InputStream inputStream, CryptInterface cryptInterface) throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int ch;
        //while ((ch = inputStream.read()) != -1)
        while (true) {
            ch = inputStream.read();
            if (ch == -1) {
                break;
            }
            //buffer.write((byte) ch);
            buffer.write(ch);
        }
        //byte[] decrypted = cryptInterface.decrypt(tsUtil.getBytes(responseData));
        byte[] decrypted = cryptInterface.decrypt(buffer.toByteArray());
        //TWB - debug output
        String decryptedString = new String(decrypted);
        //PreLogUtil.put(decryptedString, this, "decRespXMLRPC");
        int index = decryptedString.indexOf(this.XML_START);
        if (index > 0) {
            ////System.out.println("Removing Pre Decrypted XML data");
            decryptedString = decryptedString.substring(index);
        }
        ////PreLogUtil.put(new String(decryptedString), this, "decRespXMLRPC");
        return new ByteArrayInputStream(this.tsUtil.getByteArray(decryptedString));
    }

}


