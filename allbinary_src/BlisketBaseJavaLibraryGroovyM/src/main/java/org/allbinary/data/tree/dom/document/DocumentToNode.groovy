/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom.document;

import org.allbinary.logic.string.StringUtil;
import org.allbinary.logic.string.regex.replace.Replace;

@groovy.transform.CompileStatic
public class DocumentToNode {
    //null;
    private static final String XMLROOT = '<?xml version=\"1.0\" encoding=\"UTF-8\"?>';

    private static final String XMLROOTSTART = '<?xml';

    private static final String XMLROOTEND = '?>';

    private static final String XMLJSPROOTSTART = '<jsp:root';

    private static final String XMLEND = '>';

    private static final String XMLJSPROOTENDSTART = '</jsp:root';

    private DocumentToNode() {
    }

    /*     public static final Node createTempNode(Document document)     {     return document.createElement(TEMPNODE);     }      public static String getKey()     {     return tempNodeStr;     }      */
    public static String convertDocumentToNodeString(String documentString) throws Exception {
        //TWB - Remove jsp:root from inserted component
        documentString = DocumentToNode.remove(documentString, DocumentToNode.XMLJSPROOTSTART, DocumentToNode.XMLEND);
        //"1: " + documentString);
        documentString = DocumentToNode.remove(documentString, DocumentToNode.XMLJSPROOTENDSTART, DocumentToNode.XMLEND);
        //this replaces the xml info and could cause a problem with different transformations
        Replace replaceXmlRoot = new Replace(XMLROOT, StringUtil.getInstance().@EMPTY_STRING);
        return replaceXmlRoot.all(documentString);
    }

    public static String removeXmlDefinitionFromDocumentString(String documentString) {
        return DocumentToNode.remove(documentString, XMLROOTSTART, XMLROOTEND);
    }

    public static String remove(String documentString, String start, String end) {
        //this replaces the xml info and could cause a problem with different transformations
        int startIndex;
        while ((startIndex = documentString.indexOf(start)) != -1) {
            if (startIndex >= 0) {
                int endIndex = documentString.indexOf(end, startIndex);
                if (endIndex >= 0) {
                    String startString = documentString.substring(0, startIndex);
                    String resultString = documentString.substring(endIndex + 1);
                    return startString + resultString;
                }
            }
        }
        return documentString;
    }

}


