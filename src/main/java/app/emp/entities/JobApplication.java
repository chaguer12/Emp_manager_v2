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
}
