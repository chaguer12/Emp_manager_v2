package app.emp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;
@Entity
@Table(name = "admins")
public class Admin extends User{
    public Admin(String name, String lastname, String tel, String email, String poste, String password, double nss, Date date_insertion, String department) {
        super(name, lastname, tel, email, poste, password, nss, date_insertion, department);
    }

    public Admin() {
    }
}
