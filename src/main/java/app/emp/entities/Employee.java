package app.emp.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee extends User {


    public Employee(String name, String lastname, String tel, String email, String poste, String password, double nss, Date date_insertion, String department) {
       super(name,lastname,tel,email,poste,password,nss,date_insertion,department);
    }

    public Employee(){

    }



}
