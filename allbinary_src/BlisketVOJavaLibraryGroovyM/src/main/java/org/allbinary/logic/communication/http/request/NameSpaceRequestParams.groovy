/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.request;

import java.util.HashMap;
import java.util.Set;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import org.allbinary.data.tree.dom.DomData;
import org.allbinary.data.tree.dom.DomNodeHelper;
import org.allbinary.data.tree.dom.DomSearchHelper;
import org.allbinary.data.tree.dom.ModDomHelper;
import org.allbinary.data.tree.dom.document.DomDocumentHelper;
import org.allbinary.data.tree.dom.document.XmlDocumentHelper;
import org.allbinary.logic.StdUtil;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.logic.string.StringUtil;
import org.allbinary.string.CommonSeps;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

//containing string values and other hashmaps of the like
@groovy.transform.CompileStatic
public class NameSpaceRequestParams extends RequestParams {
    protected final LogUtil logUtil = LogUtil.getInstance();

    public NameSpaceRequestParams() {
        super();
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
            this.logUtil.putF('Constructing empty', this, this.commonStrings.@CONSTRUCTOR);
        }
    }

    public NameSpaceRequestParams(HttpServletRequest httpServletRequest) {
        super(httpServletRequest);
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
            this.logUtil.putF('Constructing from HttpServletRequest', this, this.commonStrings.@CONSTRUCTOR);
        }
    }

    public NameSpaceRequestParams(PageContext pageContext) {
        super(pageContext);
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
            this.logUtil.putF('Constructing from PageContext', this, this.commonStrings.@CONSTRUCTOR);
        }
    }

    //make new node
    private Node createPackageNode(Document document, String packageName, HashMap packagePropertiesHashMap) throws Exception {
        final Node node = document.createElement(packageName);
        //add root node properties
        final Set propertyKeySet = packagePropertiesHashMap.keySet();
        final Object[] propertyKeySetArray = propertyKeySet.toArray();
        final int size = propertyKeySetArray.length;
        for (int index = 0; index < size; index++) {
            String propertyName = ((String) propertyKeySetArray[index]);
            String propertyValue = ((String) packagePropertiesHashMap.get(propertyName));
            Node propertyNode = ModDomHelper.createTextNode(document, propertyName, propertyValue);
            node.appendChild(propertyNode);
        }
        return node;
    }

    private Node createPackageMultiNode(Document document, NameSpaceRequestParam nameSpaceRequestParam, String packageName, HashMap packagePropertiesHashMap) throws Exception {
        int beginIndex = packageName.indexOf(((int) ('[' as char)));
        String indexValue = packageName.substring(beginIndex + 1, packageName.length() - 1);
        String multiElementPackage = packageName.substring(0, beginIndex);
        String selectedValue = nameSpaceRequestParam.getValue();
        String propertyValue = ((String) packagePropertiesHashMap.get(DomData.VALUE));
        if (propertyValue.compareTo(NameSpaceRequestParamData.VALUE) != 0) {
            selectedValue = propertyValue;
        }
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
            this.logUtil.putF('\nAppending Multinode Element: ' + multiElementPackage + '[' + indexValue + '] ' + selectedValue, this, 'createPackageMultiNode');
        }
        Node nextNode = ModDomHelper.createNameValueNodes(document, multiElementPackage, selectedValue);
        //Add Index Data
        Node indexNode = ModDomHelper.createTextNode(document, DomData.INDEX, indexValue);
        nextNode.appendChild(indexNode);
        return nextNode;
    }

    private Node getRootNode(String rootElementPackage, HashMap packagePropertiesHashMap, Document document) throws Exception {
        Node rootNode = DomSearchHelper.getNodeNoThrow(rootElementPackage, document.getChildNodes());
        if (rootNode == null) {
            //getName()
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                this.logUtil.putF('\nAppending Document Root: ' + '\nElementName: ' + rootElementPackage + '\nProperties: ' + packagePropertiesHashMap.toString(), this, 'getRootNode');
            }
            //make new root node
            Node node = this.createPackageNode(document, rootElementPackage, packagePropertiesHashMap);
            document.appendChild(node);
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                this.logUtil.putF('\nAppended Document Created: ' + XmlDocumentHelper.toString(document), this, 'getRootNode');
            }
            return node;
        } else {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                this.logUtil.putF('\nUsing Existing Root Node', this, 'getRootNode');
            }
            return rootNode;
        }
    }

    private Node addNewProperties(Document document, Node node, HashMap nextPackagePropertiesHashMap) throws Exception {
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
            this.logUtil.putF(new StringMaker().append('\nAdding Any New Properties: ').append(nextPackagePropertiesHashMap.toString()).append('\nto node: ').append(node.getNodeName()).toString(), this, 'addNewProperties');
        }
        final Set propertyNameSet = nextPackagePropertiesHashMap.keySet();
        final Object[] propertyNameSetArray = propertyNameSet.toArray();
        final int size = propertyNameSetArray.length;
        for (int index = 0; index < size; index++) {
            String nextPropertyName = ((String) propertyNameSetArray[index]);
            String propertyValue = StringUtil.getInstance().getNonNull(((String) nextPackagePropertiesHashMap.get(nextPropertyName)));
            //Obtain DomData.VALUE and compare to new value
            Node valueNode = DomSearchHelper.getNodeNoThrow(nextPropertyName, node.getChildNodes());
            if (valueNode != null) {
                String existingElementNodeTextNodeValue = DomNodeHelper.getTextNodeValue(valueNode);
                if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                    this.logUtil.putF('\nIf property: \"' + nextPropertyName + ' is the same as:\n' + 'Node: ' + node.getNodeName() + ' then: ' + propertyValue + '==' + existingElementNodeTextNodeValue, this, 'addNewProperties');
                }
                //Node does not have the same properties
                if (propertyValue.compareTo(existingElementNodeTextNodeValue) != 0) {
                    if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                        this.logUtil.putF('At least one Property from NameSpaceRequest Package was different from Node', this, 'addNewProperties');
                    }
                    //found a property that does not match
                    throw new Exception('Property Modifications Should Not Occur');
                }
            } else {
                //found a new property and now add it
                if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                    this.logUtil.putF('Adding a new Property: ' + nextPropertyName + '=' + propertyValue, this, 'addNewProperties');
                }
                Node newPropertyNode = ModDomHelper.createTextNode(document, nextPropertyName, propertyValue);
                node.appendChild(newPropertyNode);
            }
        }
        return node;
    }

    private boolean isElementValueTextNodeEqual(HashMap nextPackagePropertiesHashMap, Node node) throws Exception {
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
            this.logUtil.putF('\nComparing the value property in: ' + nextPackagePropertiesHashMap.toString() + '\nto node child leaves of node: ' + node.getNodeName(), this, 'isElementValueTextNodeEqual');
        }
        String propertyValue = ((String) nextPackagePropertiesHashMap.get(DomData.VALUE));
        //Obtain DomData.VALUE and compare to new value
        Node valueNode = DomSearchHelper.getNodeNoThrow(DomData.VALUE, node.getChildNodes());
        if (valueNode != null) {
            String existingElementNodeTextNodeValue = DomNodeHelper.getTextNodeValue(valueNode);
            //found a property that does not match
            if (propertyValue.compareTo(existingElementNodeTextNodeValue) == 0) {
                if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                    this.logUtil.putF('Value Node is the same', this, 'isElementValueTextNodeEqual');
                }
                return true;
            }
        } else {
            return true;
        }
        return false;
    }

    private int isElementValueTextNodeUnique(HashMap nextPackagePropertiesHashMap, BasicArrayList elementNodeVector) throws Exception {
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
            this.logUtil.putF('\nComparing Properties of: ' + elementNodeVector.size() + ' Nodes', this, 'isElementValueTextNodeUnique');
        }
        //see if a value node contains unique values
        final int size = elementNodeVector.size();
        for (int index = 0; index < size; index++) {
            Node existingElementNode = ((Node) elementNodeVector.get(index));
            if (this.isElementValueTextNodeEqual(nextPackagePropertiesHashMap, existingElementNode)) {
                return index;
            }
        }
        return -1;
    }

    private Document addChildren(Document document, Node rootNode, NameSpaceRequestParam nameSpaceRequestParam) throws Exception {
        Node node = rootNode;
        //vector contains hashmaps with one dom element
        final BasicArrayList packageVector = nameSpaceRequestParam.getPackages();
        //Add Children
        final int size = packageVector.size();
        for (int index = 1; index < size; index++) {
            String nextPackageName = ((String) packageVector.get(index));
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                this.logUtil.putF(new StringMaker().append('\nTrying to Add Child to Node: ').append(node.getNodeName()).append('\nwith new PackageName: ').append(nextPackageName).toString(), this, 'addChildren');
            }
            HashMap nextPackagePropertiesHashMap = nameSpaceRequestParam.getPackageProperties(index);
            BasicArrayList elementNodeVector = DomSearchHelper.getAllNodesNoThrow(nextPackageName, node.getChildNodes());
            //Document already has atleast 1 node with the same package name
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                this.logUtil.putF('\nDocument Contains ' + elementNodeVector.size() + ' Node(s) With Same Name', this, 'addChildren');
            }
            //Special for value property
            int isElementValueTextNodeUniqueIndex = this.isElementValueTextNodeUnique(nextPackagePropertiesHashMap, elementNodeVector);
            //Create new node if node with the same name does not exist unless an array multinode
            if ((elementNodeVector.size() == 0 || isElementValueTextNodeUniqueIndex == -1) && !nextPackageName.endsWith(CommonSeps.getInstance().@BRACKET_CLOSE)) {
                Node nextNode = this.createPackageNode(document, nextPackageName, nextPackagePropertiesHashMap);
                node.appendChild(nextNode);
                //Crazy data carry through
                node = nextNode;
                if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                    this.logUtil.putF('\nAppended Package: ' + node.getNodeName(), this, 'addChildren');
                    this.logUtil.putF('\nAppended Document Created: ' + XmlDocumentHelper.toString(document), this, 'addChildren');
                }
            } else if (nextPackageName.endsWith(CommonSeps.getInstance().@BRACKET_CLOSE)) {
                if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                    this.logUtil.putF('Package is MultiNode: just append', this, 'addChildren');
                }
                Node nextNode = this.createPackageMultiNode(document, nameSpaceRequestParam, nextPackageName, nextPackagePropertiesHashMap);
                node.appendChild(nextNode);
                node = nextNode;
                if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                    this.logUtil.putF('\nAppended Multinode Element: ' + XmlDocumentHelper.toString(document), this, 'addChildren');
                }
            } else {
                if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                    this.logUtil.putF('Value Node already exists: Now compare (properties to leaf nodes)', this, 'addChildren');
                }
                Node nodeNameDuplicateNode = ((Node) elementNodeVector.get(isElementValueTextNodeUniqueIndex));
                node = this.addNewProperties(document, nodeNameDuplicateNode, nextPackagePropertiesHashMap);
                //Not Unique so move on to duplicate
                if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                    this.logUtil.putF('\nDuplicate Node Found: Moving to next child ^', this, 'addChildre');
                }
            }
        }
        return document;
    }

    private Document addNameSpace(String key, String value, Document document) throws Exception {
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
            this.logUtil.putF(new StringMaker().append('NameSpace key: ').append(key).append(' Value: ').append(value).toString(), this, 'addNameSpace');
        }
        final NameSpaceRequestParam nameSpaceRequestParam = new NameSpaceRequestParam(key, value);
        //vector contains hashmaps with one dom element
        final BasicArrayList packageVector = nameSpaceRequestParam.getPackages();
        final int size = packageVector.size();
        for (int index = 0; index < size; index++) {
            String packageName = ((String) packageVector.get(index));
            HashMap packagePropertiesHashMap = nameSpaceRequestParam.getPackageProperties(packageVector.indexOf(packageName));
            Node rootNode = this.getRootNode(packageName, packagePropertiesHashMap, document);
            //document
            if (index < size - 1) {
                return this.addChildren(document, ((Node) rootNode), nameSpaceRequestParam);
            }
        }
        return document;
    }

    public HashMap toHashMap() throws Exception {
        Document document = DomDocumentHelper.create();
        final HashMap hashMap = StdUtil.getInstance().createHashMap();
        final Set keys = this.getMap().keySet();
        final Object[] keyArray = keys.toArray();
        final int keySize = keyArray.length;
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
            this.logUtil.putF('NameSpace Request Size: ' + keys.size(), this, 'toHashMap');
        }
        for (int i = 0; i < keySize; i++) {
            String key = ((String) keyArray[i]);
            Object anyType = this.getMap().get(key);
            String className = ((String) anyType.getClass().getName());
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                this.logUtil.putF('Request Param Class: ' + className, this, 'toHashMap');
            }
            if (this.getMap().get(key) instanceof String) {
                String value = ((String) this.getMap().get(key));
                if (key.indexOf(NameSpaceRequestParamData.NAME) < 0) {
                    if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                        this.logUtil.putF('Not NameSpace key: ' + key + ' Value: ' + value, this, 'toHashMap()');
                    }
                    hashMap.put(new String(key), new String(value));
                } else {
                    document = this.addNameSpace(new String(key), new String(value), document);
                }
            } else if (this.getMap().get(key) instanceof String[]) {
                String[] values = ((String[]) this.getMap().get(key));
                if (key.indexOf(NameSpaceRequestParamData.NAME) < 0) {
                    if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
                        this.logUtil.putF('Not NameSpace key: ' + key + ' Value: ' + values[0], this, 'toHashMap()');
                    }
                    hashMap.put(new String(key), new String(values[0]));
                } else {
                    document = this.addNameSpace(new String(key), new String(values[0]), document);
                }
            }
        }
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@HTTPREQUEST)) {
            this.logUtil.putF('NameSpaceRequestParams: ' + this.getMap().toString() + '\ntoHashMap(): ' + hashMap.toString() + '\nDocument Created: ' + XmlDocumentHelper.toString(document), this, 'toHashMap()');
        }
        hashMap.put(NameSpaceRequestParamData.DOCUMENT, document);
        return hashMap;
    }

}


