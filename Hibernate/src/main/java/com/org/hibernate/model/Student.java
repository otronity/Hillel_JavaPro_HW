package com.org.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(schema = "school", name = "student")
public class Student {

    @Id
    @GeneratedValue(generator = "sequence-generator2")
    @GenericGenerator(
            name = "sequence-generator2",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "school.student_id_seq"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Integer id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Mark> marks;
}
