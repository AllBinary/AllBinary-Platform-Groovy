/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.resource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.io.StreamUtil;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.string.StringUtil;

//J2SE - PC
@groovy.transform.CompileStatic
public class ResourceUtil {
    private static final ResourceUtil instance = new ResourceUtil();

    public static ResourceUtil getInstance() {
        return ResourceUtil.instance;
    }

    protected final LogUtil logUtil = LogUtil.getInstance();

    private String path = StringUtil.getInstance().@EMPTY_STRING;

    private String ext = StringUtil.getInstance().@EMPTY_STRING;

    private ResourceUtil() {
    }

    public void setLoadingPaths(String path, String ext) {
        this.path = path;
        this.ext = ext;
    }

    //    }
    public void setClassLoader(final ClassLoader classLoader) {
    }

    public InputStream getResourceAsStream(final String resource) throws Exception {
        InputStream inputStream = this.getResourceAsStreamAtStart(resource, 2);
        if (inputStream == null) {
            inputStream = this.getResourceAsStreamAtStart(resource, 1);
            if (inputStream == null) {
                throw new Exception(new StringMaker().append('Unable to obtain: ').append(resource).toString());
            }
        }
        return inputStream;
    }

    //private final String METHOD_NAME = "getResourceAsStream";
    private InputStream getResourceAsStreamAtStart(final String resource, final int startIndex) throws Exception {
        //Try getting resource with normal resource access
        InputStream inputStream = new FileInputStream(new StringMaker().append(this.path).append(resource).append(this.ext).toString());
        if (inputStream != null) {
            //            this.logUtil.putF(stringMaker.append(RESOURCE_FOUND).append(resource).toString(), this, METHOD_NAME);
            final byte[] byteArray = new byte[inputStream.available()];
            StreamUtil.getInstance().getByteArray(inputStream, new ByteArrayOutputStream(), byteArray);
            return new ByteArrayInputStream(byteArray);
        }
        return inputStream;
    }

    public void addResource(final String resource, final Integer value) {
    }

}


