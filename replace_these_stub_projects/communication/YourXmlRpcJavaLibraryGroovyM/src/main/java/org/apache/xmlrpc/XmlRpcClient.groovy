/* Generated Code Do Not Modify */
package org.apache.xmlrpc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.init.crypt.jcehelper.CryptInterface;
import org.allbinary.logic.NullUtil;

@groovy.transform.CompileStatic
public class XmlRpcClient implements XmlRpcHandler {
    private final URL url;

    //    }
    public XmlRpcClient(String url) throws MalformedURLException {
        //this(new URL(url));
        this.url = new URL(url);
    }

    //    }
    public URL getURL() {
        return this.url;
    }

    public void setBasicAuthentication(String user, String password) {
    }

    @Override
    public Object execute(String method, BasicArrayList params) throws XmlRpcException, IOException {
        return NullUtil.getInstance().@NULL_OBJECT;
    }

    public Object executeWithCrypt(String method, BasicArrayList params, CryptInterface cryptInterface) throws XmlRpcException, IOException {
        return NullUtil.getInstance().@NULL_OBJECT;
    }

}


