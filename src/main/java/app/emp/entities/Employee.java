package app.emp.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee extends User {
    private double salary;
    private double children;



    public Employee(String name, String lastname, String tel, String email, String poste, String password, double nss, Date date_insertion, String department,double salary,double children) {
       super(name,lastname,tel,email,poste,password,nss,date_insertion,department);
       this.salary = salary;
       this.children= children;
    }

    public Employee(){

    }



}
