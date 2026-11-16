/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.thread;

import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.string.CommonStrings;
import org.allbinary.util.BasicArrayList;
import org.allbinary.util.BasicArrayListD;

@groovy.transform.CompileStatic
public class ThreadPool {
    //5 = Thread.NORM_PRIORITY
    public static final int NORMAL_PRIORITY = 5;

    protected final LogUtil logUtil = LogUtil.getInstance();

    protected final CommonStrings commonStrings = CommonStrings.getInstance();

    protected final NullRunnable NULL_RUNNABLE = NullRunnable.getInstance();

    protected final ThreadPoolStrings threadPoolStrings = ThreadPoolStrings.getInstance();

    protected final ThreadObjectUtil threadObjectUtil = ThreadObjectUtil.getInstance();

    //private final int priority;
    private boolean isAlive;

    private BasicArrayList taskQueue = new BasicArrayListD();

    //private int threadID;
    private int numThreads;

    //private static int threadPoolID;
    private boolean runningTask;

    public ThreadPool(final String poolName, final int numThreads, final int priority) {
    }

    //TWB - PlayN Single Thread Fix
    private PriorityRunnable currentPriorityRunnable = this.threadObjectUtil.@NULL_PRIORITY_RUNNABLE;

    public void runAPriorityTask() throws Exception {
        if (!this.currentPriorityRunnable.isDone()) {
            //this.logUtil.putF(currentPriorityRunnable.toString(), this, "runAPriorityTask:Again");
            this.currentPriorityRunnable.run();
        } else {
            final Runnable runnable = this.getTask();
            if (runnable === this.NULL_RUNNABLE) {
                return;
            }
            this.currentPriorityRunnable = ((PriorityRunnable) runnable);
            if (!(this.currentPriorityRunnable === this.threadObjectUtil.@NULL_PRIORITY_RUNNABLE)) {
                //this.logUtil.putF(currentPriorityRunnable.toString(), this, "runAPriorityTask:New");
                this.currentPriorityRunnable.reset();
                this.currentPriorityRunnable.run();
            }
        }
    }

    public void runATask() throws Exception {
        Runnable runnable = this.getTask();
        if (runnable != null) {
            runnable.run();
        }
    }

    public void init() {
        if (!this.isAlive) {
            this.isAlive = true;
            this.taskQueue = new BasicArrayListD();
        }
    }

    public synchronized void runTaskWithPriority(final PriorityRunnable task) {
        if (!this.isAlive) {
            this.init();
        }
        if (task != null) {
            //PreLogUtil.put("Add: ").append(task, this, this.threadPoolStrings.ADD_TASK);
            final int size = this.taskQueue.size();
            PriorityRunnable runnable;
            PriorityRunnable lowerPriorityRunnable = this.threadObjectUtil.@NULL_PRIORITY_RUNNABLE;
            for (int index = 0; index < size; index++) {
                runnable = ((PriorityRunnable) this.taskQueue.get(index));
                //this.logUtil.putF(new StringMaker().append(COMPARE_PRIORITY).append(task.getPriority()).toString(), this, this.threadPoolStrings.ADD_TASK);
                if (runnable.getPriority() > task.getPriority()) {
                    lowerPriorityRunnable = runnable;
                    break;
                }
            }
            if (lowerPriorityRunnable === this.threadObjectUtil.@NULL_PRIORITY_RUNNABLE) {
                this.taskQueue.add(task);
            } else {
                //this.logUtil.putF(new StringMaker().append(ADD_PRIORITY).append(task.getPriority()).toString(), this, this.threadPoolStrings.ADD_TASK);
                final int index = this.taskQueue.indexOf(lowerPriorityRunnable);
                //this.logUtil.putF(new StringMaker().append(ADD_PRIORITY).append(index).append(CommonSeps.getInstance().SPACE).append(this.taskQueue.size()).toString(), this, this.threadPoolStrings.ADD_TASK);
                this.taskQueue.addAt(index, task);
            }
        }
    }

    public synchronized void runTask(final Runnable task) {
        if (!this.isAlive) {
            this.init();
        }
        if (task != null) {
            //PreLogUtil.put("Add: ").append(task, this, "runTask");
            this.taskQueue.add(task);
        }
    }

    protected synchronized Runnable getTask() throws InterruptedException {
        if (this.taskQueue.isEmpty()) {
            return this.NULL_RUNNABLE;
        }
        /*         while (this.taskQueue.size() == 0)         {             if (!this.isAlive)             {                 return NULL_RUNNABLE;             }             //TWB - Playn Testing             //this.wait();         }         */
        return ((Runnable) this.taskQueue.removeAt(0));
    }

    public synchronized void clear() {
        this.taskQueue.clear();
    }

    public synchronized void close() {
        if (this.isAlive) {
            this.isAlive = false;
            this.taskQueue.clear();
            this.currentPriorityRunnable = this.threadObjectUtil.@NULL_PRIORITY_RUNNABLE;
        }
    }

    public void join() {
        this.isAlive = false;
        this.taskQueue.clear();
        this.currentPriorityRunnable = this.threadObjectUtil.@NULL_PRIORITY_RUNNABLE;
    }

    public boolean isBusy() {
        if (!this.isAlive) {
            return false;
        }
        if (this.taskQueue.size() > 0) {
            return true;
        }
        if (this.runningTask) {
            return true;
        }
        return false;
    }

    protected void threadStarted() {
    }

    protected void threadStopped() {
        if (this.numThreads == 1) {
            this.isAlive = false;
            this.taskQueue.clear();
            this.currentPriorityRunnable = this.threadObjectUtil.@NULL_PRIORITY_RUNNABLE;
        }
    }

    protected void startTask(final Runnable task) {
    }

    protected void completedTask(final Runnable task) {
    }

}


