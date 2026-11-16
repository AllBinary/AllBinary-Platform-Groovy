/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache;


@groovy.transform.CompileStatic
public class BasicArrayListResetablePool extends AbstractArrayListPool {
    public BasicArrayListResetablePool(CacheableInterfaceFactoryInterface cacheableInterfaceFactoryInterface) {
        super(cacheableInterfaceFactoryInterface);
    }

    @Override
    public void clear() {
    }

    @Override
    public CacheableInterface remove(Object key) throws Exception {
        int size = this.buffers.size();
        if (size > 0) {
            return ((CacheableInterface) this.buffers.removeAt(size - 1));
        } else {
            return this.cacheableInterfaceFactoryInterface.getInstance(key);
        }
    }

}


