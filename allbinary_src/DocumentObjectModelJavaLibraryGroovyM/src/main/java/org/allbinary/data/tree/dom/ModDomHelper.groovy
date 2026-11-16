/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.dom;

import java.util.HashMap;
import java.util.Set;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.logic.java.anyType.clazz.ClassUtil;
import org.allbinary.logic.string.StringUtil;
import org.allbinary.string.CommonSeps;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

@groovy.transform.CompileStatic
public class ModDomHelper {
    private ModDomHelper() {
    }

    public static Node createTextNode(Document document, String name, String text) throws Exception {
        Node newValueNode = document.createElement(name);
        Node newValueTextNode = document.createTextNode(text);
        newValueNode.appendChild(newValueTextNode);
        return newValueNode;
    }

    public static Node createValueNode(Document document, String text) throws Exception {
        return ModDomHelper.createTextNode(document, DomData.VALUE, text);
    }

    public static Node createNameNode(Document document, String text) throws Exception {
        return ModDomHelper.createTextNode(document, DomData.NAME, text);
    }

    public static Node createIndexNode(Document document, int index) throws Exception {
        return ModDomHelper.createTextNode(document, DomData.INDEX, new Integer(index).toString());
    }

    public static Node createNameValueNodes(Document document, String elementName, String nameText, String valueText) throws Exception {
        Node newNode = document.createElement(elementName);
        newNode.appendChild(ModDomHelper.createNameNode(document, nameText));
        newNode.appendChild(ModDomHelper.createValueNode(document, valueText));
        return newNode;
    }

    public static Node createNameValueNodes(Document document, String elementNameAndNameText, String valueText) throws Exception {
        Node newNode = ModDomHelper.createNameValueNodes(document, elementNameAndNameText, elementNameAndNameText, valueText);
        return newNode;
    }

    public static Node createNameValueIndexNodes(Document document, String elementNameAndNameText, int index, String valueText) throws Exception {
        Node newNode = ModDomHelper.createNameValueNodes(document, elementNameAndNameText, valueText);
        newNode.appendChild(ModDomHelper.createIndexNode(document, index));
        return newNode;
    }

    public static Node createNameValueNodes(Document document, String rootNode, HashMap hashMap) throws Exception {
        Node node = document.createElement(rootNode);
        return ModDomHelper.createNameValueNodes(document, node, hashMap);
    }

    //Don't use - use withvaluenodes - it excludes name nodes and makes value nodes a text node
    public static Node createNameValueNodes(Document document, Node node, HashMap hashMap) throws Exception {
        StringUtil stringUtil = StringUtil.getInstance();
        Set keySet = hashMap.keySet();
        Object[] keyArray = keySet.toArray();
        int size = keyArray.length;
        for (int i = 0; i < size; i++) {
            Object objectKey = keyArray[i];
            String name = ((String) objectKey);
            Object anyType = ((Object) hashMap.get(objectKey));
            //this.logUtil.putF("Adding: " + name + "=" + value ,this,"toXmlNode(document)");
            if (anyType == null) {
                String value = stringUtil.@EMPTY_STRING;
                node.appendChild(ModDomHelper.createNameValueNodes(document, name, value));
            } else if (anyType instanceof String) {
                String value = stringUtil.getNonNull(((String) anyType));
                node.appendChild(ModDomHelper.createNameValueNodes(document, name, value));
            } else if (anyType instanceof HashMap) {
                node.appendChild(ModDomHelper.createNameValueNodes(document, name, hashMap));
            } else {
                throw new Exception('HashMap value is the wrong instance and is: ' + ClassUtil.viewAll(anyType, CommonSeps.getInstance().@NEW_LINE));
            }
        }
        return node;
    }

    public static Node createNameValueNodes(Document document, String rootNodeName, String duplicateNodeName, BasicArrayList valueVector) throws Exception {
        StringUtil stringUtil = StringUtil.getInstance();
        Node node = document.createElement(rootNodeName);
        int size = valueVector.size();
        for (int i = 0; i < size; i++) {
            String value = stringUtil.getNonNull(((String) valueVector.get(i)));
            //this.logUtil.putF("Adding: " + name + "=" + value , this, stringUtil.EMPTY_STRING);
            node.appendChild(ModDomHelper.createNameValueNodes(document, duplicateNodeName, value));
        }
        return node;
    }

    public static Node createNameValueIndexNodes(Document document, String rootNodeName, String duplicateNodeName, BasicArrayList valueVector) throws Exception {
        StringUtil stringUtil = StringUtil.getInstance();
        Node node = document.createElement(rootNodeName);
        int size = valueVector.size();
        for (int index = 0; index < size; index++) {
            String value = stringUtil.getNonNull(((String) valueVector.get(index)));
            //this.logUtil.putF("Adding: " + name + "=" + value , this, stringUtil.EMPTY_STRING);
            node.appendChild(ModDomHelper.createNameValueIndexNodes(document, duplicateNodeName, index, value));
        }
        return node;
    }

    public static Node createNodeWithValueNodes(Document document, String rootNode, HashMap hashMap) throws Exception {
        Node node = document.createElement(rootNode);
        return ModDomHelper.createNodeWithValueNodes(document, node, hashMap);
    }

    public static Node createNodeWithValueNodes(Document document, Node node, HashMap hashMap) throws Exception {
        StringUtil stringUtil = StringUtil.getInstance();
        Set keySet = hashMap.keySet();
        Object[] keyArray = keySet.toArray();
        int size = keyArray.length;
        for (int i = 0; i < size; i++) {
            String name = ((String) keyArray[i]);
            Object anyType = ((Object) hashMap.get(name));
            //this.logUtil.putF("Adding: " + name + "=" + value ,this,"toXmlNode(document)");
            String value = stringUtil.getNonNull(((String) anyType));
            node.appendChild(ModDomHelper.createTextNode(document, name, value));
        }
        return node;
    }

}


