/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.score.remote;

import org.allbinary.logic.string.StringUtil;
import java.io.IOException;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.init.crypt.jcehelper.CryptInterface;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.communication.xmlrpc.XmlRpcAbeClient;
import org.allbinary.logic.java.exception.ExceptionUtil;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.system.security.licensing.AbeClientInformationInterface;
import org.allbinary.util.ABHashtable;
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

@groovy.transform.CompileStatic
public class XmlRpcRemoteHighScoresClient extends XmlRpcAbeClient {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private String page;

    public XmlRpcRemoteHighScoresClient(AbeClientInformationInterface clientInfo, String page, String remoteMethod) {
        super(clientInfo, remoteMethod);
        this.page = page;
        //Start with the first server
        this.setServer(0);
    }

    public Object get(final Object anyType, final CryptInterface cryptInterface) throws Exception {
        try {
            BasicArrayList param = new BasicArrayListD();
            String serverUrl = getClientInfo().getLicenseServer(this.getServer());
            int index = serverUrl.lastIndexOf(((int) ('/' as char)));
            serverUrl = serverUrl.substring(0, index + 1) + this.page;
            StringMaker stringBuffer = new StringMaker();
            stringBuffer.append(TRYING);
            stringBuffer.appendint(this.getServer());
            stringBuffer.append(SEP);
            stringBuffer.append(serverUrl);
            //System.out.println(stringBuffer.toString());
            this.logUtil.putF(stringBuffer.toString(), this, this.commonStrings.@GET);
            //System.out.println("Renamed Server: " + serverUrl);
            final XmlRpcClient xmlRpcClient = new XmlRpcClient(serverUrl);
            this.setClient(xmlRpcClient);
            xmlRpcClient.setBasicAuthentication(StringUtil.getInstance().@EMPTY_STRING, StringUtil.getInstance().@EMPTY_STRING);
            ABHashtable<Object, Object> hashtable = ((ABHashtable<Object, Object>) anyType);
            //System.out.println("Client Info: \n" + hashtable.toString());
            this.logUtil.putF(CLIENT_INFO + hashtable.toString(), this, this.commonStrings.@GET);
            /*              * if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().LICENSING)) {              * this.logUtil.putF("Xml-Rpc Client Liscense Request: \n" +              * client.toString(), this, this.commonStrings.GET); }              */
            param.add(hashtable);
            // KeySpecFactory.DES,
            Object result = xmlRpcClient.executeWithCrypt(this.getRemoteMethod(), param, cryptInterface);
            //System.out.println(CommonLabels.getInstance().RESULT_ + CommonSeps.getInstance().NEW_LINE + result.toString());
            this.logUtil.putF(RESULT + result.toString(), this, this.commonStrings.@GET);
            //Hashtable resultHashtable = (Hashtable) result;
            isOnline = true;
            return result;
        } catch (IOException e) {
            //System.out.println("IOException Trying Other Servers");
            this.logUtil.put(TRYING_OTHER_SERVERS + ExceptionUtil.getInstance().getStackTrace(e), this, this.commonStrings.@GET, e);
            // }
            if (!e.getMessage().startsWith(HOST_NOT_RESOLVED)) {
                return this.tryAnother(anyType);
            } else {
                throw new Exception(HOST_NOT_RESOLVED_MSG);
            }
        } catch (XmlRpcException e) {
            //System.out.println(message);
            this.logUtil.put(SERVER_REPORTED_ERROR, this, this.commonStrings.@GET, e);
            // }
            return this.tryAnother(anyType);
        } catch (Exception e) {
            //System.out.println(message);
            this.logUtil.put(UNKNOWN_ERROR, this, this.commonStrings.@GET, e);
            // }
            return this.tryAnother(anyType);
        }
    }

}


