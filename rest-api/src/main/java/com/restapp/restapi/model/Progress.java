package com.restapp.restapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "progress")
public class Progress {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "text")
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Progress progress = (Progress) o;
        return id.equals(progress.id) &&
                Objects.equals(text, progress.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }
}
