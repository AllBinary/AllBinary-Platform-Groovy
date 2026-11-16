/* Generated Code Do Not Modify */
package org.allbinary.thread;


@groovy.transform.CompileStatic
public class ThreadObjectUtil {
    private static final ThreadObjectUtil instance = new ThreadObjectUtil();

    public static ThreadObjectUtil getInstance() {
        return ThreadObjectUtil.instance;
    }

    public final PriorityRunnable NULL_PRIORITY_RUNNABLE = new NullPriorityRunnable();

    public void notifyObject(Object anyType) {
    }

    public void waitObject(Object anyType) throws Exception {
    }

    public void waitObjectFor(Object anyType, long delay) throws Exception {
    }

    public void processThread(final Runnable runnable) {
        runnable.run();
    }

}


