package app.emp.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String lastname;
    private String tel;
    private String email;
    private String poste;
    private String password;
    private double nss;
    private Date date_insertion;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(String name, String lastname, String tel, String email, String poste, String password, double nss, Date date_insertion, Department department) {
        this.name = name;
        this.lastname = lastname;
        this.tel = tel;
        this.email = email;
        this.poste = poste;
        this.password = password;
        this.nss = nss;
        this.date_insertion = date_insertion;
        this.department = department;
    }

    public Employee(){

    }

    public double getNss() {
        return nss;
    }

    public void setNss(double nss) {
        this.nss = nss;
    }

    public Date getDate_insertion() {
        return date_insertion;
    }

    public void setDate_insertion(Date date_insertion) {
        this.date_insertion = date_insertion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
