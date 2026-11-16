/* Generated Code Do Not Modify */
package org.allbinary.thread;

import org.allbinary.TsUtil;

@groovy.transform.CompileStatic
public class ThreadObjectUtil {
    private static final ThreadObjectUtil instance = new ThreadObjectUtil();

    public static ThreadObjectUtil getInstance() {
        return ThreadObjectUtil.instance;
    }

    public final PriorityRunnable NULL_PRIORITY_RUNNABLE = new NullPriorityRunnable();

    public void notifyObject(Object anyType) {
        anyType.notify();
    }

    public void waitObject(Object anyType) throws Exception {
        anyType.wait();
    }

    public void waitObjectFor(Object anyType, long delay) throws Exception {
        TsUtil.getInstance().waitFor(anyType, delay);
    }

    public void processThread(final Runnable runnable) {
        final Thread thread = new Thread(runnable);
        thread.start();
    }

}


