package io.hardingadonis.saledock.model;

import io.hardingadonis.saledock.utils.Singleton;
import jakarta.persistence.*;
import java.time.*;
import java.util.*;
import lombok.*;

@Entity(name = "Product")
@Table(name = "`product`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "`code`", unique = true, nullable = false, insertable = true, updatable = false)
    private String code;

    @Column(name = "`name`", nullable = false)
    private String name;

    @Column(name = "`description`", columnDefinition = "longtext")
    private String description;

    @Column(name = "`price`", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "`category_id`", nullable = false)
    private Category category;

    @Column(name = "`image_url`", columnDefinition = "longtext")
    private String imageURL;

    @Column(name = "`created_at`")
    private LocalDateTime createdAt;

    @Column(name = "`updated_at`")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        this.code = generateUniqueOrderCode();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
    }

    private static String generateUniqueOrderCode() {
        Random random = new Random();
        String orderCode;

        do {
            char letter = (char) ('A' + random.nextInt(26)); 
            int number = 100 + random.nextInt(999); 
            orderCode = String.format("%c%d", letter, number);
        } while (Singleton.productDAO.getByCode(orderCode).isPresent());

        return orderCode;
    }
}
