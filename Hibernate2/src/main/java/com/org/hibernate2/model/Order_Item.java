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
@Table(schema = "shop", name = "order_item")
public class Order_Item {

    @Id
    @GeneratedValue(generator = "sequence-generator4")
    @GenericGenerator(
            name = "sequence-generator4",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "public.order_item_id_seq"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "orderid", nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "productid", nullable = false)
    private Product product;
    private Integer count;

}
