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
@Table(schema = "shop", name = "order")
public class Order {

    @Id
    @GeneratedValue(generator = "sequence-generator3")
    @GenericGenerator(
            name = "sequence-generator3",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "shop.order_id_seq"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "clientid", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Order_Item> orderItems;

}
