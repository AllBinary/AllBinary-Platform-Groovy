/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.java.vm.stats;


@groovy.transform.CompileStatic
public class JvmStatistics {
    private Runtime runtime;

    public JvmStatistics() {
        this.runtime = Runtime.getRuntime();
    }

    public long getFreeMemoryBytes() {
        return this.runtime.freeMemory();
    }

    public long getFreeMemoryKilobytes() {
        return Math.divideExact(this.getFreeMemoryBytes(), ((long) 1024));
    }

    public long getFreeMemoryMegabytes() {
        return Math.divideExact(this.getFreeMemoryKilobytes(), ((long) 1024));
    }

    public long getMaxMemoryBytes() {
        return this.runtime.maxMemory();
    }

    public long getMaxMemoryKilobytes() {
        return Math.divideExact(this.getMaxMemoryBytes(), ((long) 1024));
    }

    public long getMaxMemoryMegabytes() {
        return Math.divideExact(this.getMaxMemoryKilobytes(), ((long) 1024));
    }

    public long getTotalMemoryBytes() {
        return this.runtime.totalMemory();
    }

    public long getTotalMemoryKilobytes() {
        return Math.divideExact(this.getTotalMemoryBytes(), ((long) 1024));
    }

    public long getTotalMemoryMegabytes() {
        return Math.divideExact(this.getTotalMemoryKilobytes(), ((long) 1024));
    }

    public Long getFreeMemoryBytesLong() {
        return new Long(this.getFreeMemoryBytes());
    }

    public Long getFreeMemoryKilobytesLong() {
        return new Long(this.getFreeMemoryKilobytes());
    }

    public Long getFreeMemoryMegabytesLong() {
        return new Long(this.getFreeMemoryMegabytes());
    }

    public Long getMaxMemoryBytesLong() {
        return new Long(this.getMaxMemoryBytes());
    }

    public Long getMaxMemoryKilobytesLong() {
        return new Long(this.getMaxMemoryKilobytes());
    }

    public Long getMaxMemoryMegabytesLong() {
        return new Long(this.getMaxMemoryMegabytes());
    }

    public Long getTotalMemoryBytesLong() {
        return new Long(this.getTotalMemoryBytes());
    }

    public Long getTotalMemoryKilobytesLong() {
        return new Long(this.getTotalMemoryKilobytes());
    }

    public Long getTotalMemoryMegabytesLong() {
        return new Long(this.getTotalMemoryMegabytes());
    }

    public String getFreeMemoryBytesString() {
        return this.getFreeMemoryBytesLong().toString();
    }

    public String getFreeMemoryKilobytesString() {
        return this.getFreeMemoryKilobytesLong().toString();
    }

    public String getFreeMemoryMegabytesString() {
        return this.getFreeMemoryMegabytesLong().toString();
    }

    public String getMaxMemoryBytesString() {
        return this.getMaxMemoryBytesLong().toString();
    }

    public String getMaxMemoryKilobytesString() {
        return this.getMaxMemoryKilobytesLong().toString();
    }

    public String getMaxMemoryMegabytesString() {
        return this.getMaxMemoryMegabytesLong().toString();
    }

    public String getTotalMemoryBytesString() {
        return this.getTotalMemoryBytesLong().toString();
    }

    public String getTotalMemoryKilobytesString() {
        return this.getTotalMemoryKilobytesLong().toString();
    }

    public String getTotalMemoryMegabytesString() {
        return this.getTotalMemoryMegabytesLong().toString();
    }

    public long getNumberOfThreads() {
        return Thread.activeCount();
    }

    public Long getNumberOfThreadsLong() {
        return new Long(this.getNumberOfThreads());
    }

    public String getNumberOfThreadsString() {
        return this.getNumberOfThreadsLong().toString();
    }

    public void collectGarbage() {
        this.runtime.gc();
    }

}


