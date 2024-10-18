package app.emp.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;
@Entity(name = "jobApplications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Date created_at;
    private String email;
    private String tel;
    private String description;
    private String path;
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public JobApplication(){

    }
    public JobApplication(Date created_at, String email, String tel, Offer offer){
        this.created_at = created_at;
        this.email = email;
        this.tel = tel;
        this.offer = offer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
