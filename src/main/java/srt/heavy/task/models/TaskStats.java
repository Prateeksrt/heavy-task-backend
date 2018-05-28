package srt.heavy.task.models;

import java.util.Date;

public class TaskStats {
    private long responseTime;
    private boolean isSuccessful;
    private Date timeStamp;

    public TaskStats(long responseTime, boolean isSuccessful, Date timeStamp) {
        this.responseTime = responseTime;
        this.isSuccessful = isSuccessful;
        this.timeStamp = timeStamp;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
