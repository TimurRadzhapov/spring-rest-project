package com.restapp.restapi.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "progress_id")
    private Long progress_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getProgress_id() {
        return progress_id;
    }

    public void setProgress_id(Long progress_id) {
        this.progress_id = progress_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) &&
                full_name.equals(student.full_name) &&
                dateOfBirth.equals(student.dateOfBirth) &&
                Objects.equals(progress_id, student.progress_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, full_name, dateOfBirth, progress_id);
    }
}
