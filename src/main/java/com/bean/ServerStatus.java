package com.bean;

public class ServerStatus {
    private long time;
    private int totalThread;
    private int cpuRatio;
    private int maxMemory;
    private int totalMemory;
    private int freeMemory;
    private int totalMemorySize;
    private int freePhysicalMemorySize;
    private int usedMemory;
    private String osName;


    public ServerStatus(ServerStatus serverStatus) {}

    public ServerStatus(long time, int totalThread, int cpuRatio, int maxMemory, int totalMemory, int freeMemory, int totalMemorySize, int freePhysicalMemorySize, int usedMemory, String osName) {
        this.time = time;
        this.totalThread = totalThread;
        this.cpuRatio = cpuRatio;
        this.maxMemory = maxMemory;
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
        this.totalMemorySize = totalMemorySize;
        this.freePhysicalMemorySize = freePhysicalMemorySize;
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
