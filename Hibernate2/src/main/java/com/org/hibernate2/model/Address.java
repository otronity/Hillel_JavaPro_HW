package com.org.hibernate2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(schema = "shop", name = "address")
public class Address {

    @Id
    @GeneratedValue(generator = "sequence-generator2")
    @GenericGenerator(
            name = "sequence-generator2",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "shop.address_id_seq"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Integer id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    private String country;
    private String  city;
    private String street;
    private String house;
}
