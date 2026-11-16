/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.log;

import org.allbinary.logic.string.StringUtil;
import java.io.IOException;
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.logic.communication.xmlrpc.XmlRpcAbeClient;
import org.allbinary.logic.system.security.crypt.jcehelper.NoCrypt;
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface;
import org.allbinary.string.CommonLabels;
import org.allbinary.string.CommonSeps;
import org.allbinary.util.ABHashtable;

@groovy.transform.CompileStatic
public class XmlRpcRemoteLogClient extends XmlRpcAbeClient {
    //private final LogFormatUtil logFormatUtil = LogFormatUtil.getInstance();
    private final NoCrypt noCrypt = new NoCrypt();

    public XmlRpcRemoteLogClient(final AbeClientInformationInterface clientInfo) {
        super(clientInfo, 'SSLLogServ.logUtil');
    }

    public Object get(final Object anyType) throws Exception {
        try {
            // }
            BasicArrayList param = new BasicArrayListD();
            String serverUrl = getClientInfo().getLicenseServer(this.getServer());
            int index = serverUrl.lastIndexOf('/');
            serverUrl = serverUrl.substring(0, index + 1) + 'logservssl.php';
            //System.out.println("Renamed Server: " + serverUrl);
            final XmlRpcClient xmlRpcClient = new XmlRpcClient(serverUrl);
            this.setClient(xmlRpcClient);
            xmlRpcClient.setBasicAuthentication(StringUtil.getInstance().@EMPTY_STRING, StringUtil.getInstance().@EMPTY_STRING);
            ABHashtable<Object, Object> hashtable = ((ABHashtable<Object, Object>) anyType);
            /*              * if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LICENSING)) {              this.logUtil.putF("Xml-Rpc Client Liscense Request: \n" +              * client.toString(), this, this.commonStrings.GET); }              */
            param.add(hashtable);
            // KeySpecFactory.DES,
            Object result = xmlRpcClient.executeWithCrypt(this.getRemoteMethod(), param, this.noCrypt);
            // {
            System.out.println(CommonLabels.getInstance().@RESULT_ + CommonSeps.getInstance().@NEW_LINE + result.toString());
            // }
            return result;
        } catch (IOException e) {
            // {
            System.out.println('IOException Trying Other Servers');
            // }
            if (!e.getMessage().startsWith(HOST_NOT_RESOLVED)) {
                return this.tryAnother(anyType);
            } else {
                throw new Exception(HOST_NOT_RESOLVED_MSG);
            }
        } catch (XmlRpcException e) {
            // }
            return this.tryAnother(anyType);
        } catch (Exception e) {
            // }
            return this.tryAnother(anyType);
        }
    }

}


