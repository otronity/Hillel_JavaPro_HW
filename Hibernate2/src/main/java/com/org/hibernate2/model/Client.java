package com.org.hibernate2.model;

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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(schema = "shop", name = "client")
public class Client {

    @Id
    @GeneratedValue(generator = "sequence-generator1")
    @GenericGenerator(
            name = "sequence-generator1",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "shop.client_id_seq"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Integer id;
    private String name;
    private String email;
    private String phone;

    @OneToOne(mappedBy = "client", fetch = FetchType.EAGER)
    @JsonIgnore
    Address address;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Order> ordersHistory;
}
