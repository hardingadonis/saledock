package io.hardingadonis.saledock.model;

import jakarta.persistence.*;
import java.io.*;
import lombok.*;

@Entity(name = "OrderDetail")
@Table(name = "order_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"order"})
public class OrderDetail {

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class ID implements Serializable {

        @Column(name = "`order_id`")
        private Integer orderID;

        @Column(name = "`product_id`")
        private Integer productID;
    }

    @EmbeddedId
    private ID ID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderID")
    private Order order;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productID")
    private Product product;

    @Column(name = "`quantity`", nullable = false)
    private int quantity;
    
    public OrderDetail(Order order, Product product) {
        this.order = order;
        this.product = product;
        this.ID = new ID(order.getID(), product.getID());
    }
}
