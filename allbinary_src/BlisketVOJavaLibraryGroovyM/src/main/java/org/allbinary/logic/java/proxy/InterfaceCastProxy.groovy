/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@groovy.transform.CompileStatic
public class InterfaceCastProxy implements java.lang.reflect.InvocationHandler {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private Object anyType;

    private InterfaceCastProxy(Object anyType) {
        this.anyType = anyType;
    }

    public static Object newInstance(Object anyType) {
        return Proxy.newProxyInstance(anyType.getClass().getClassLoader(), anyType.getClass().getInterfaces(), new InterfaceCastProxy(anyType));
    }

    //Invokes on the dynamic class and uses proxy class info for its invocation
    public Object invoke(Object proxyObject, Method proxyMethod, Object[] proxyArgs) throws java.lang.Throwable {
        String methodName = proxyMethod.getName();
        Method realMethod = this.anyType.getClass().getMethod(methodName, proxyMethod.getParameterTypes());
        //the proxy object methods should be not accessible always
        if (!realMethod.isAccessible()) {
            realMethod.setAccessible(true);
        }
        return proxyMethod.invoke(this.anyType, proxyArgs);
    }

}


