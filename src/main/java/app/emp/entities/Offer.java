package app.emp.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private Date endDate;
    private boolean status = true;
    @OneToMany(mappedBy = "offer", fetch = FetchType.LAZY)
    private List<JobApplication> jobApplications;

    public Offer(){

    }

    public Offer(String title, String description, Date endDate){
        this.title = title;
        this.description = description;
        this.endDate = endDate;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }
}
