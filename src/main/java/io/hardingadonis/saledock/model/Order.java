package io.hardingadonis.saledock.model;

import jakarta.persistence.*;
import java.text.DecimalFormat;
import java.time.*;
import java.util.*;
import lombok.*;

@Entity(name = "Order")
@Table(name = "`order`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    public static enum Status {
        PENDING,
        SHIPPING,
        DONE,
        CANCELLED
    }

    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "`code`", unique = true, nullable = false, insertable = true, updatable = false)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "`employee_id`", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "`customer_id`", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "`status`", nullable = false)
    private Status status;

    @Column(name = "`total`", nullable = false)
    private Double total;

    @Column(name = "`note`", columnDefinition = "longtext")
    private String note;

    @Column(name = "`created_at`")
    private LocalDateTime createdAt;

    @Column(name = "`updated_at`")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderDetail> orderDetails = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        this.code = generateRandomOrderCode();
        this.status = Status.PENDING;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
    }

    public void addProduct(Product product, Integer quantity) {
        var detail = new OrderDetail(this, product);
        detail.setQuantity(quantity);

        this.orderDetails.add(detail);

        if (this.total == null) {
            this.total = Double.valueOf(0);
        }

        this.total += product.getPrice() * quantity;
    }

    private static String generateRandomOrderCode() {
        UUID uuid = UUID.randomUUID();

        return uuid.toString().toUpperCase().replace("-", "").substring(0, 15);
    }
    
     public String getTotalToString() {
         DecimalFormat decimalFormat = new DecimalFormat("#,###.#");
        return decimalFormat.format(this.total);
    }
}
