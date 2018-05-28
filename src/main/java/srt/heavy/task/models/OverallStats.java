package srt.heavy.task.models;

import java.util.Date;
import java.util.List;

public class OverallStats {
    private long lastResponseTime;
    private long averageResponseTime;
    private List<Long> lastTenResponseTime;
    private int numberOfSuccess;
    private int numberOfFailure;
    private Date lastChecked;

    public long getLastResponseTime() {
        return lastResponseTime;
    }

    public void setLastResponseTime(long lastResponseTime) {
        this.lastResponseTime = lastResponseTime;
    }

    public long getAverageResponseTime() {
        return averageResponseTime;
    }

    public void setAverageResponseTime(long averageResponseTime) {
        this.averageResponseTime = averageResponseTime;
    }

    public int getNumberOfSuccess() {
        return numberOfSuccess;
    }

    public void setNumberOfSuccess(int numberOfSuccess) {
        this.numberOfSuccess = numberOfSuccess;
    }

    public int getNumberOfFailure() {
        return numberOfFailure;
    }

    public void setNumberOfFailure(int numberOfFailure) {
        this.numberOfFailure = numberOfFailure;
    }

    public OverallStats(long lastResponseTime, long averageResponseTime, int numberOfSuccess, int numberOfFailure,
                        Date lastChecked, List<Long> lastTenResponseTime) {
        this.lastResponseTime = lastResponseTime;
        this.averageResponseTime = averageResponseTime;
        this.numberOfSuccess = numberOfSuccess;
        this.numberOfFailure = numberOfFailure;
        this.lastChecked = lastChecked;
        this.lastTenResponseTime = lastTenResponseTime;
    }

    public Date getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(Date lastChecked) {
        this.lastChecked = lastChecked;
    }

    public List<Long> getLastTenResponseTime() {
        return lastTenResponseTime;
    }

    public void setLastTenResponseTime(List<Long> lastTenResponseTime) {
        this.lastTenResponseTime = lastTenResponseTime;
    }
}
