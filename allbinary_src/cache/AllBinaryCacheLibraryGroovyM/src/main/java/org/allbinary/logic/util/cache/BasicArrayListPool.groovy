/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.util.cache;

import org.allbinary.util.BasicArrayList;

@groovy.transform.CompileStatic
public class BasicArrayListPool extends AbstractArrayListPool {
    public BasicArrayListPool(CacheableInterfaceFactoryInterface cacheableInterfaceFactoryInterface) {
        super(cacheableInterfaceFactoryInterface);
    }

    @Override
    public void clear() {
        this.buffers.clear();
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

    public void addAll(BasicArrayList usedList) throws Exception {
        for (int index = usedList.size(); --index >= 0; ) {
            CacheableInterface anyType = ((CacheableInterface) usedList.@objectArray[index]);
            this.add(anyType);
        }
        usedList.clear();
    }

    public void releaseUsedBackToPool(BasicArrayList usedList) throws Exception {
        for (int index = usedList.size(); --index >= 0; ) {
            BasicArrayListCacheable list = ((BasicArrayListCacheable) usedList.@objectArray[index]);
            if (list.size() == 0) {
                usedList.removeAt(index);
                this.add(list);
            }
        }
    }

}


