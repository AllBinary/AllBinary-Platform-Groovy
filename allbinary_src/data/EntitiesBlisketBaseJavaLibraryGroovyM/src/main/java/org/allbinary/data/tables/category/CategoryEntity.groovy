/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.category;

import java.util.HashMap;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.business.category.Category;
import org.allbinary.business.category.CategoryData;
import org.allbinary.business.category.CategoryFactoryInterface;
import org.allbinary.business.init.db.InventoryDbInitInfo;
import org.allbinary.logic.StdUtil;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.communication.sql.AbSqlBean;
import org.allbinary.logic.string.StringMaker;

@groovy.transform.CompileStatic
public class CategoryEntity extends AbSqlBean implements CategoryEntityInterface {
    protected final LogUtil logUtil = LogUtil.getInstance();

    protected final String tableName = 'categories';

    //private CategoryFactoryInterface categoryFactoryInterface;
    public CategoryEntity(CategoryFactoryInterface categoryFactoryInterface) {
        super(new InventoryDbInitInfo());
        //this.categoryFactoryInterface = categoryFactoryInterface;
        this.setTableName(this.tableName);
    }

    public CategoryEntity() {
        super(new InventoryDbInitInfo());
        this.setTableName(this.tableName);
    }

    //ignore child categories
    public void insert(Category category) {
        try {
            BasicArrayList categoryVector = category.toVector();
            BasicArrayList values = new BasicArrayListD();
            values.add(categoryVector.get(0));
            values.add(categoryVector.get(1));
            super.insert(values);
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLLOGGING)) {
                this.logUtil.putF(this.commonStrings.@SUCCESS, this, INSERT);
            }
        } catch (Exception e) {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLLOGGING)) {
                this.logUtil.put(this.commonStrings.@FAILURE, this, INSERT, e);
            }
        }
    }

    public void delete(String value) {
        try {
            super.deleteWhere(CategoryData.getInstance().@NAME, value);
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLLOGGING)) {
                this.logUtil.putF(this.commonStrings.@SUCCESS, this, this.commonStrings.@delete);
            }
        } catch (Exception e) {
            if (org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().@SQLLOGGING)) {
                this.logUtil.put(this.commonStrings.@FAILURE, this, this.commonStrings.@delete, e);
            }
        }
    }

    public final String createTableStatement() {
        StringMaker stringBuffer = new StringMaker();
        stringBuffer.append(this.sqlStrings.@CREATE_TABLE);
        stringBuffer.append(this.tableName);
        stringBuffer.append(this.sqlStrings.@START);
        stringBuffer.append(CategoryData.getInstance().@NAME);
        stringBuffer.append(this.sqlTypeStrings.@MAX_CHAR_COLUMN_NOT_NULL);
        stringBuffer.append(CategoryData.getInstance().@LEVEL);
        stringBuffer.append(this.sqlTypeStrings.@MAX_BIG_INT_UNSIGNED_NOT_NULL);
        stringBuffer.append(this.sqlStrings.@PRIMARY_KEY);
        stringBuffer.append(CategoryData.getInstance().@NAME);
        stringBuffer.append(this.sqlStrings.@END);
        return stringBuffer.toString();
    }

    public String createTable() {
        return super.createTable(this.createTableStatement());
    }

    public void update(HashMap updatedValues) {
        super.updateWhere(CategoryData.getInstance().@NAME, ((String) updatedValues.get(CategoryData.getInstance().@NAME)), updatedValues);
    }

    public String dropTable() {
        return super.dropTable();
    }

    //Needed for polyglot do not remove
    @Override
    public void insert(final BasicArrayList values) {
        super.insert(values);
    }

}


