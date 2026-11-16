/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.string;

import org.allbinary.TsUtil;

@groovy.transform.CompileStatic
public class StringValidationUtil {
    private static final StringValidationUtil instance = new StringValidationUtil();

    public static StringValidationUtil getInstance() {
        return StringValidationUtil.instance;
    }

    private final StringUtil stringUtil = StringUtil.getInstance();

    private final TsUtil tsUtil = TsUtil.getInstance();

    private StringValidationUtil() {
    }

    public boolean containsSpaces(String value) {
        if (value.indexOf(((int) (' ' as char))) >= 0) {
            return true;
        }
        return false;
    }

    public boolean isNumber(String value) {
        int numberOfDecimalPoints = 0;
        for (int index = 0; index < value.length(); index++) {
            char digit = value.charAt(index);
            if (!this.isNumberFromChar(digit) && digit != ('.' as char)) {
                return false;
            }
            if (digit == ('.' as char)) {
                numberOfDecimalPoints++;
                if (numberOfDecimalPoints > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isNumberFromChar(char digit) {
        if (digit != ('0' as char) && digit != ('1' as char) && digit != ('2' as char) && digit != ('3' as char) && digit != ('4' as char) && digit != ('5' as char) && digit != ('6' as char) && digit != ('7' as char) && digit != ('8' as char) && digit != ('9' as char)) {
            return false;
        }
        return true;
    }

    public boolean isValidRequired(String value, int min, int max) {
        //value.compareTo(stringUtil.EMPTY_STRING)==0 ||
        if (value.length() < min || value.length() > max) {
            return false;
        }
        return true;
    }

    public boolean isValidRequiredNumber(String value, int min, int max) {
        if (this.isEmpty(value) || value.length() < min || value.length() > max) {
            return false;
        }
        if (!this.isNumber(value)) {
            return false;
        }
        return true;
    }

    public boolean isValidNotRequired(String value, int min, int max) {
        //value.compareTo(stringUtil.EMPTY_STRING)==0 ||
        if (value.length() > 0) {
            if (value.length() < min || value.length() > max) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidNotRequiredNumber(String value, int min, int max) {
        if (value.length() > 0) {
            if (this.tsUtil.compareTo(value, this.stringUtil.@NULL_STRING) == 0 || value.length() < min || value.length() > max) {
                return false;
            }
            if (!this.isNumber(value)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty(String string) {
        if (this.tsUtil.compareTo(string, this.stringUtil.@NULL_STRING) != 0 && this.tsUtil.compareTo(string, this.stringUtil.@EMPTY_STRING) != 0) {
            return false;
        } else {
            return true;
        }
    }

}


