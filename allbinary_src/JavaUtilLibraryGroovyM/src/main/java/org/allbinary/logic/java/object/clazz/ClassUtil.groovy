/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.anyType.clazz;

import org.allbinary.logic.java.anyType.ConstructorUtil;
import org.allbinary.logic.java.anyType.InterfaceUtil;
import org.allbinary.logic.java.anyType.MethodUtil;
import org.allbinary.logic.string.StringMaker;

@groovy.transform.CompileStatic
public class ClassUtil {
    private ClassUtil() {
    }

    // Usage = allbinary.util.objectinfo.ObjectInfo.viewAll(object);
    public static String viewAll(Object anyType, String lineBreak) {
        if (anyType != null) {
            return ClassUtil.viewAll(anyType.getClass(), lineBreak);
        } else {
            return 'Object Null';
        }
    }

    // Usage = allbinary.util.objectinfo..viewAll(object);
    public static String viewAll(Class myClass, String lineBreak) {
        if (myClass != null) {
            StringMaker stringBuffer = new StringMaker();
            Class[] classes = myClass.getClasses();
            stringBuffer.append(lineBreak);
            stringBuffer.append('Class: ');
            stringBuffer.append(myClass.getName());
            stringBuffer.append(' uses ');
            stringBuffer.appendint(classes.length);
            stringBuffer.append(' other classes');
            stringBuffer.append(lineBreak);
            stringBuffer.append(lineBreak);
            stringBuffer.append('Classes: ');
            stringBuffer.append(lineBreak);
            for (int index = 0; index < classes.length; index++) {
                stringBuffer.append('Class: ');
                stringBuffer.append(classes[index].getName());
                stringBuffer.append(lineBreak);
            }
            stringBuffer.append(InterfaceUtil.viewAll(myClass, lineBreak));
            stringBuffer.append(lineBreak);
            stringBuffer.append(ConstructorUtil.viewAll(myClass, lineBreak));
            stringBuffer.append(lineBreak);
            stringBuffer.append(MethodUtil.viewAll(myClass, lineBreak));
            return stringBuffer.toString();
        } else {
            return 'Class Null';
        }
    }

}


