package com.example.Onboarding.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
public class Checklist {
    @Id
    private Long id;
    public String names;
    public String tel;
    public String emails;
    public String lawyer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date date;
    public String department;

    public Checklist() {
    }

    public Checklist(Long id, String names, String tel, String emails, String lawyer, Date date, String department) {
        this.id = id;
        this.names = names;
        this.tel = tel;
        this.emails = emails;
        this.date = date;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getLawyer() {
        return lawyer;
    }

    public void setLawyer(String lawyer) {
        this.lawyer = lawyer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getdepartment() {
        return department;
    }

    public void setdepartment(String department) {
        this.department = department;
    }
}
