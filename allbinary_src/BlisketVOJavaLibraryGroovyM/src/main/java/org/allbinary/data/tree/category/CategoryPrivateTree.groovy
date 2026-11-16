/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.category;

import org.allbinary.business.category.CategoryComponent;
import org.allbinary.business.category.CategoryData;
import org.allbinary.business.category.CategoryFactoryInterface;
import org.allbinary.business.category.CategoryInterface;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.control.crypt.file.CryptFileWriter;
import org.allbinary.logic.io.file.AbFile;
import org.allbinary.string.CommonStrings;
import org.w3c.dom.Document;

@groovy.transform.CompileStatic
public class CategoryPrivateTree {
    protected final LogUtil logUtil = LogUtil.getInstance();

    protected CategoryFactoryInterface categoryFactoryInterface;

    public CategoryPrivateTree(CategoryFactoryInterface categoryFactoryInterface) {
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@CATEGORY)) {
            final CommonStrings commonStrings = CommonStrings.getInstance();
            this.logUtil.putF(commonStrings.@START, this, 'CategoryPrivateTree(CategoryFactoryInterface categoryFactoryInterface)');
        }
        this.categoryFactoryInterface = categoryFactoryInterface;
    }

    protected synchronized void save(CategoryInterface categoryInterface) throws Exception {
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLLOGGING)) {
            this.logUtil.putF('Saving Category File: ' + categoryInterface.getFilePath(), this, 'save()');
        }
        Document document = new CategoryComponent(categoryInterface).toXmlDoc();
        //overwrite old file with new
        CryptFileWriter cryptFileWriter = new CryptFileWriter(CategoryData.getInstance().@UNCRYPTED_EXTENSION, CategoryData.getInstance().@ENCRYPTED_EXTENSION);
        cryptFileWriter.write(categoryInterface.getFilePath(), document);
        if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLLOGGING)) {
            this.logUtil.putF('end', this, 'save()');
        }
    }

    protected synchronized void delete(CategoryInterface categoryInterface) throws Exception {
        if (categoryInterface.isLeaf()) {
            AbFile categoryFile = AbFile.createAbFileFromAbPath(categoryInterface.getFilePath());
            if (categoryFile.delete()) {
                if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLLOGGING)) {
                    this.logUtil.putF('Removed: ' + categoryInterface.getFilePath(), this, 'delete(CategoryInterface)');
                }
            }
        } else {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLLOGGING)) {
                this.logUtil.putF('Not a leaf unable to remove', this, 'delete(CategoryInterface)');
            }
        }
    }

}


