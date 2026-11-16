/*  * AllBinary Open License Version 1  * Copyright (c) 2002 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.generator;

import java.util.HashMap;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;
import org.allbinary.business.init.db.UserDbInitInfo;
import org.allbinary.logic.StdUtil;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.communication.sql.AbSqlBean;
import org.allbinary.logic.string.StringMaker;

@groovy.transform.CompileStatic
public class IdGeneratorEntity extends AbSqlBean implements IdGeneratorEntityInterface {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private final String tableName = 'idgenerator';

    private final String tableData;

    @groovy.transform.PackageScope final String NAME = 'NAME';

    @groovy.transform.PackageScope final String VALUE = 'VALUE';

    public IdGeneratorEntity() {
        super(new UserDbInitInfo());
        this.tableData = new StringMaker().append(this.sqlStrings.@CREATE_TABLE).append(tableName).append(this.sqlStrings.@START).append(NAME).append(this.sqlTypeStrings.@MAX_CHAR_COLUMN_NOT_NULL).append(VALUE).append(this.sqlTypeStrings.@MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.@PRIMARY_KEY).append(NAME).append(this.sqlStrings.@END).toString();
        super.setTableName(this.tableName);
    }

    public Long get(String name) throws Exception {
        HashMap keysAndValues = StdUtil.getInstance().createHashMap();
        keysAndValues.put(this.NAME, name);
        HashMap hashMap = super.getRow(keysAndValues);
        if ((((String) hashMap.get(this.NAME))).compareTo(name) != 0) {
            throw new Exception('results do not match');
        }
        String value = ((String) hashMap.get(this.VALUE));
        return Long.parseLong(value);
    }

    public void insert(BasicArrayList values) {
        try {
            //values.add(time);
            super.insert(values);
            this.logUtil.putF(this.commonStrings.@SUCCESS, this, INSERT);
        } catch (Exception e) {
            this.logUtil.put(this.commonStrings.@FAILURE, this, INSERT, e);
        }
    }

    public void delete(String value) {
        try {
            super.deleteWhere(this.NAME, value);
            this.logUtil.putF(this.commonStrings.@SUCCESS, this, this.commonStrings.@delete);
        } catch (Exception e) {
            this.logUtil.put(this.commonStrings.@FAILURE, this, this.commonStrings.@delete, e);
        }
    }

    public void update(String name, Long value) {
        final HashMap map = StdUtil.getInstance().createHashMap();
        map.put(this.NAME, name);
        map.put(this.VALUE, value.toString());
        this.update(map);
    }

    public void update(HashMap hashMap) {
        //hashMap.put(EntryData.getInstance().LASTMODIFIED, time);
        super.updateWhere(this.NAME, ((String) hashMap.get(this.NAME)), hashMap);
    }

    public String createTable() {
        String returnStr = super.createTable(tableData);
        return returnStr;
    }

    public String dropTable() {
        return super.dropTable();
    }

    //Needed for polyglot do not remove
    @Override
    public void deleteWhere(final String key, final String value) {
        super.deleteWhere(key, value);
    }

}


