package com.bean;

public class ServerStatus {
    private int cpuRatio;
    private int totalMemory;
    private int freePhysicalMemorySize;
    private long time;
    private int totalThread;
    private int maxMemory;
    private int freeMemory;
    private int totalMemorySize;
    private int usedMemory;
    private String osName;


    public ServerStatus(ServerStatus serverStatus) {}

    public ServerStatus(int cpuRatio, int totalMemory, int freePhysicalMemorySize, long time, int totalThread, int maxMemory, int freeMemory, int totalMemorySize, int usedMemory, String osName) {
        this.cpuRatio = cpuRatio;
        this.totalMemory = totalMemory;
        this.freePhysicalMemorySize = freePhysicalMemorySize;
        this.time = time;
        this.totalThread = totalThread;
        this.maxMemory = maxMemory;
        this.freeMemory = freeMemory;
        this.totalMemorySize = totalMemorySize;
        this.usedMemory = usedMemory;
        this.osName = osName;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getTotalThread() {
        return totalThread;
    }

    public void setTotalThread(int totalThread) {
        this.totalThread = totalThread;
    }

    public int getCpuRatio() {
        return cpuRatio;
    }

    public void setCpuRatio(int cpuRatio) {
        this.cpuRatio = cpuRatio;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public int getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(int totalMemory) {
        this.totalMemory = totalMemory;
    }

    public int getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }

    public int getTotalMemorySize() {
        return totalMemorySize;
    }

    public void setTotalMemorySize(int totalMemorySize) {
        this.totalMemorySize = totalMemorySize;
    }

    public int getFreePhysicalMemorySize() {
        return freePhysicalMemorySize;
    }

    public void setFreePhysicalMemorySize(int freePhysicalMemorySize) {
        this.freePhysicalMemorySize = freePhysicalMemorySize;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(int usedMemory) {
        this.usedMemory = usedMemory;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }
}
