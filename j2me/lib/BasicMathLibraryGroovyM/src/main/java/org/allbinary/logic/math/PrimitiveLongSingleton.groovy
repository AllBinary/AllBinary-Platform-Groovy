/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.math;

import org.allbinary.logic.string.StringMaker;

@groovy.transform.CompileStatic
public class PrimitiveLongSingleton {
    private static final PrimitiveLongSingleton instance = new PrimitiveLongSingleton();

    public static PrimitiveLongSingleton getInstance() {
        return PrimitiveLongSingleton.instance;
    }

    public final char[] UNK = new char[] {('U' as char), ('n' as char), ('k' as char)};

    //public final String[] NUMBER_STRING_ARRAY = {CommonPhoneStrings.getInstance().ZERO, CommonPhoneStrings.getInstance().ONE, CommonPhoneStrings.getInstance().TWO, CommonPhoneStrings.getInstance().THREE, CommonPhoneStrings.getInstance().FOUR, CommonPhoneStrings.getInstance().FIVE, CommonPhoneStrings.getInstance().SIX, CommonPhoneStrings.getInstance().SEVEN, CommonPhoneStrings.getInstance().EIGHT, CommonPhoneStrings.getInstance().NINE};
    public final byte[] NUMBER_ARRAY = new byte[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public final char[] NUMBER_CHAR_ARRAY = new char[] {('0' as char), ('1' as char), ('2' as char), ('3' as char), ('4' as char), ('5' as char), ('6' as char), ('7' as char), ('8' as char), ('9' as char)};

    public final char[][] NUMBER_CHAR_ARRAYS = new char[][] {{('0' as char)}, {('1' as char)}, {('2' as char)}, {('3' as char)}, {('4' as char)}, {('5' as char)}, {('6' as char)}, {('7' as char)}, {('8' as char)}, {('9' as char)}};

    public final char[] ZERO = new char[] {this.NUMBER_CHAR_ARRAY[0]};

    public byte getNumberFromChar(char numberAsChar) throws Exception {
        final int size = this.NUMBER_CHAR_ARRAY.length;
        for (int index = 0; index < size; index++) {
            if (this.NUMBER_CHAR_ARRAY[index] == numberAsChar) {
                return this.NUMBER_ARRAY[index];
            }
        }
        throw new Exception(new StringMaker().append('numberAsChar was not in array: ').appendchar(numberAsChar).toString());
    }

}


