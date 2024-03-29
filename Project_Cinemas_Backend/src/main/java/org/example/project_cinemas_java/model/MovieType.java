package org.example.project_cinemas_java.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movieType")
@Builder
public class MovieType extends BaseEntity {
    private String movieTypeName;

    private boolean isActive = true;

    @OneToMany(mappedBy = "movietype", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Movie> movies;

}
