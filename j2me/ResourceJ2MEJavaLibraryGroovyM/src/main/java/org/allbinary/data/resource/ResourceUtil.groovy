/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.resource;

import java.io.InputStream;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.string.CommonSeps;
import org.allbinary.string.CommonStrings;

//J2ME
@groovy.transform.CompileStatic
public class ResourceUtil {
    private static ResourceUtil instance = new ResourceUtil();

    public static ResourceUtil getInstance() {
        return ResourceUtil.instance;
    }

    protected final LogUtil logUtil = LogUtil.getInstance();

    private ResourceUtil() {
    }

    public void setLoadingPaths(String path, String ext) {
        this.logUtil.putF(CommonStrings.getInstance().@NOT_IMPLEMENTED, this, 'setLoadingPaths');
    }

    //private final String GET_RESOURCE = "Getting Resource: ";
    public InputStream getResourceAsStream(String resource) throws Exception {
        InputStream inputStream = resource.getClass().getResourceAsStream(resource);
        if (inputStream == null) {
            inputStream = this.getResourceAsStreamAtStart(resource, 2);
            if (inputStream == null) {
                inputStream = this.getResourceAsStreamAtStart(resource, 1);
                if (inputStream == null) {
                    final StringMaker stringMaker = new StringMaker();
                    final int index = resource.lastIndexOf(((int) ('/' as char)));
                    String resourcePath = resource.substring(index + 1);
                    //                    this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                    inputStream = resource.getClass().getResourceAsStream(resourcePath);
                    if (inputStream == null) {
                        resourcePath = resource.substring(index);
                        //                        this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                        inputStream = resource.getClass().getResourceAsStream(resourcePath);
                        if (inputStream == null) {
                            final String RES = 'res';
                            resourcePath = stringMaker.append(RES).append(resource.substring(index)).toString();
                            //                            this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                            inputStream = resource.getClass().getResourceAsStream(resourcePath);
                            if (inputStream == null) {
                                stringMaker.delete(0, stringMaker.length());
                                resourcePath = stringMaker.append('/').append(RES).append(resource.substring(index)).toString();
                                //                                this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                                inputStream = resource.getClass().getResourceAsStream(resourcePath);
                                final String COLON = CommonSeps.getInstance().@COLON;
                                if (inputStream == null) {
                                    stringMaker.delete(0, stringMaker.length());
                                    resourcePath = stringMaker.append(RES).append(COLON).append(resource.substring(index)).toString();
                                    //                                    this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                                    inputStream = resource.getClass().getResourceAsStream(resourcePath);
                                    if (inputStream == null) {
                                        stringMaker.delete(0, stringMaker.length());
                                        resourcePath = stringMaker.append(RES).append(COLON).append(resource.substring(index + 1)).toString();
                                        //                                        this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                                        inputStream = resource.getClass().getResourceAsStream(resourcePath);
                                        if (inputStream == null) {
                                            final String RESOURCE_STRING = 'resource';
                                            stringMaker.delete(0, stringMaker.length());
                                            resourcePath = stringMaker.append(RESOURCE_STRING).append(COLON).append(resource.substring(index)).toString();
                                            //                                            this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                                            inputStream = resource.getClass().getResourceAsStream(resourcePath);
                                            if (inputStream == null) {
                                                stringMaker.delete(0, stringMaker.length());
                                                resourcePath = stringMaker.append(RESOURCE_STRING).append(COLON).append(resource.substring(index + 1)).toString();
                                                //                                                this.logUtil.putF(stringMaker.append(GET_RESOURCE).append(resourcePath).toString(), this, METHOD_NAME);
                                                inputStream = resource.getClass().getResourceAsStream(resourcePath);
                                                //String resourcePath = resource;
                                                if (inputStream == null) {
                                                    stringMaker.delete(0, stringMaker.length());
                                                    throw new Exception(stringMaker.append('Unable to obtain: ').append(resource).toString());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return inputStream;
    }

    private InputStream getResourceAsStreamAtStart(String resource, int startIndex) throws Exception {
        final StringMaker stringMaker = new StringMaker();
        int index = resource.indexOf(CommonSeps.getInstance().@COLON);
        final String resourcePath = resource.substring(index + startIndex);
        //Try getting resource with normal resource access
        final InputStream inputStream = resource.getClass().getResourceAsStream(resourcePath);
        if (inputStream != null) {
            //            this.logUtil.putF("Resource Found", this, METHOD_NAME);
            return inputStream;
        }
        return inputStream;
    }

    public void addResource(final String resource, final Integer value) {
    }

}


