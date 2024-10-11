package app.emp.entities;

import java.sql.Date;

public class Recruiter extends User{
    public Recruiter(String name, String lastname, String tel, String email, String poste, String password, double nss, Date date_insertion, String department) {
        super(name, lastname, tel, email, poste, password, nss, date_insertion, department);
    }

    public Recruiter() {
    }
}
