/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.anyType.clazz.loader;


@groovy.transform.CompileStatic
public class ClassLoaderUtil {
    private ClassLoaderUtil() {
    }

    public static String getName(Object anyType) throws Exception {
        ClassLoader classLoader = anyType.getClass().getClassLoader();
        if (classLoader != null) {
            return 'ClassLoader: ' + classLoader.getClass().getName();
        }
        throw new Exception('Unable to get ClassLoader');
    }

}


