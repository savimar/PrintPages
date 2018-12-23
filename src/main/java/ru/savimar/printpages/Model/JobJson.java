package ru.savimar.printpages.Model;

import java.util.Objects;

public class JobJson {
    private int jobId;
    private String device;
    private String user;
    private String type;
    private int amount;
    private String time;

    public JobJson() {
    }

    public JobJson(int jobId, String device, String user, String type, int amount, String time) {
        this.jobId = jobId;
        this.device = device;
        this.user = user;
        this.type = type;
        this.amount = amount;
        this.time = time;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobJson jobJson = (JobJson) o;
        return jobId == jobJson.jobId &&
                amount == jobJson.amount &&
                Objects.equals(device, jobJson.device) &&
                Objects.equals(user, jobJson.user) &&
                Objects.equals(type, jobJson.type) &&
                Objects.equals(time, jobJson.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, device, user, type, amount, time);
    }

    @Override
    public String toString() {
        return "JobJson{" +
                "jobId=" + jobId +
                ", device='" + device + '\'' +
                ", user='" + user + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", time='" + time + '\'' +
                '}';
    }
}
