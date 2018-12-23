package ru.savimar.printpages.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Objects;

@Entity
@Table(name = "job")
@XmlRootElement(name = "job")
@XmlAccessorType(XmlAccessType.FIELD)

public class Job implements java.io.Serializable, Comparable<Job> {

    @XmlAttribute
    @Id
    private int id;

    @XmlTransient
    private String job;

    private String type;
    @XmlElement(name = "user")
    private String userJob;

    private String device;

    private int amount;

    @XmlTransient
    private Timestamp time;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Job() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String user) {
        this.userJob = user;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Job o) {
        int compare = 0;
        if (this.time.before(o.time)) {
            compare = -1;
        } else if (this.time.after(o.time)) {
            compare = 1;
        }
        return compare;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", job='" + job + '\'' +
                ", type='" + type + '\'' +
                ", userJob='" + userJob + '\'' +
                ", device='" + device + '\'' +
                ", amount=" + amount +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job1 = (Job) o;
        return id == job1.id &&
                amount == job1.amount &&
                Objects.equals(job, job1.job) &&
                type.equals(job1.type) &&
                userJob.equals(job1.userJob) &&
                device.equals(job1.device) &&
                Objects.equals(time, job1.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, job, type, userJob, device, amount, time);
    }

    public static Comparator<Job> UserComparator = new Comparator<Job>() {

        @Override
        public int compare(Job j1, Job j2) {
            return (j1.getUserJob().compareTo(j2.getUserJob()));
        }
    };

}
