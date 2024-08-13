package com.demo.domain;

import java.io.Serializable;

public class ClearLogDTO {
    private int uniqueid;
    private long timestamp;
    private String logContent;
    private String logType;

    // Getters and Setters
    public int getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(int uniqueid) {
        this.uniqueid = uniqueid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    // Optional: Override toString(), equals(), and hashCode() methods
    @Override
    public String toString() {
        return "ClearLogDTO{" +
                "uniqueid=" + uniqueid +
                ", timestamp=" + timestamp +
                ", logContent='" + logContent + '\'' +
                ", logType='" + logType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClearLogDTO that = (ClearLogDTO) o;

        if (uniqueid != that.uniqueid) return false;
        if (timestamp != that.timestamp) return false;
        if (logContent != null ? !logContent.equals(that.logContent) : that.logContent != null) return false;
        return logType != null ? logType.equals(that.logType) : that.logType == null;
    }

    @Override
    public int hashCode() {
        int result = uniqueid;
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (logContent != null ? logContent.hashCode() : 0);
        result = 31 * result + (logType != null ? logType.hashCode() : 0);
        return result;
    }
}

