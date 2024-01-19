package io.hardingadonis.saledock.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "OrderDetail")
@Table(name = "order_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"order"})
public class OrderDetail {

    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`order_id`", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`product_id`", nullable = false)
    private Product product;

    @Column(name = "`quantity`", nullable = false)
    private int quantity;
}
