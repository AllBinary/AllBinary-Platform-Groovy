/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info.objectConfig;

import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.data.tree.dom.document.mapping.DomDocumentMappingInterface;
import org.allbinary.logic.visual.transform.info.TransformInfoInterface;

@groovy.transform.CompileStatic
public interface TransformInfoObjectConfigInterface extends DomDocumentMappingInterface {
    //Usually used for updating a sites templates
    boolean containsView(TransformInfoInterface transformInfoInterface);

    String getName() throws Exception;

    BasicArrayList getTransformsGroup(String group) throws Exception;

    //InputStream createInputStream() throws Exception;
    BasicArrayList getTransforms() throws Exception;

    BasicArrayList getParentTransforms() throws Exception;

    BasicArrayList getGroupTransforms() throws Exception;

    String getOutputTypeName() throws Exception;

    void setOutputTypeName(String value);

    String getInputOutputTypeName() throws Exception;

    String getInputOutputTypeFile() throws Exception;

    String getImportUriPath() throws Exception;

    //void setImportUriPath(String importUriPath);
    String toString();

}


