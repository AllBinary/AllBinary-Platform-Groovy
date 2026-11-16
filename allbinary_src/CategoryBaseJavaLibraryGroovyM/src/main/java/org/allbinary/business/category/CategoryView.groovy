/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category;

import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.business.category.properties.CategoryPropertiesInterface;
import org.allbinary.business.category.properties.CategoryPropertiesView;
import org.allbinary.data.tree.dom.DomNodeInterface;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.java.anyType.InterfaceUtil;
import org.allbinary.string.CommonSeps;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

@groovy.transform.CompileStatic
public class CategoryView implements DomNodeInterface {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private CategoryInterface categoryInterface;

    public CategoryView(CategoryInterface categoryInterface) {
        this.categoryInterface = categoryInterface;
    }

    public CategoryInterface getCategoryInterface() {
        return this.categoryInterface;
    }

    public Node toXmlNode(Document document) throws Exception {
        Node node = document.createElement(CategoryData.getInstance().@NAME);
        /*       NamedNodeMap nodeAttributes = node.getAttributes();       Attr nameAttr = document.createAttribute(DomData.ID);       nameAttr.setValue(this.getCategoryInterface().getPath());       CategoryData.ROOTCATEGORY       nodeAttributes.setNamedItem(nameAttr);        */
        BasicArrayList childCategoryVector = this.categoryInterface.getChildNodes();
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@CATEGORY)) {
            this.logUtil.putF('Number Of Children: ' + childCategoryVector.size(), this, 'toXmlNode');
        }
        int size = childCategoryVector.size();
        for (int i = 0; i < size; i++) {
            Object anyType = childCategoryVector.get(i);
            CategoryPropertiesInterface categoryPropertiesInterface = null;
            if (InterfaceUtil.isImplemented('CategoryPropertiesInterface', anyType)) {
                categoryPropertiesInterface = ((CategoryPropertiesInterface) anyType);
            } else if (InterfaceUtil.isImplemented('CategoryInterface', anyType)) {
                CategoryInterface categoryInterface = ((CategoryInterface) anyType);
                categoryPropertiesInterface = categoryInterface.getProperties();
            } else {
                String isImpl = InterfaceUtil.viewAll(anyType.getClass(), CommonSeps.getInstance().@NEW_LINE);
                //"CategoryView found unknown object:\n" + 
                throw new Exception('CategoryView found unknown object.\n' + 'Show Testing:' + isImpl);
            }
            Node childCategoryNode = new CategoryPropertiesView(categoryPropertiesInterface).toXmlNode(document);
            node.appendChild(childCategoryNode);
        }
        return node;
    }

}


