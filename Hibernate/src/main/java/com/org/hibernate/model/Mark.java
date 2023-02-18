package com.org.hibernate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(schema = "school", name = "mark")
@IdClass(Mark.class)
public class Mark implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Student student;
    @Id
    private String discipline;
    private Integer value;
}
