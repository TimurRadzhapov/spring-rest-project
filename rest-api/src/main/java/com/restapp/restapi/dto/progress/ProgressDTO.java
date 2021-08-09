package com.restapp.restapi.dto.progress;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class ProgressDTO {
    private Long id;
    @NotBlank
    private String text;

    public ProgressDTO(Long id, @NotBlank String text) {
        this.id = id;
        this.text = text;
    }

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
        ProgressDTO that = (ProgressDTO) o;
        return id.equals(that.id) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }
}
