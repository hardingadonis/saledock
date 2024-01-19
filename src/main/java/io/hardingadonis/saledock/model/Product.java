package io.hardingadonis.saledock.model;

import jakarta.persistence.*;
import java.time.*;
import lombok.*;

@Entity(name = "Product")
@Table(name = "`product`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Product {

    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "`code`", unique = true, nullable = false)
    private String code;

    @Column(name = "`name`", nullable = false)
    private String name;

    @Column(name = "`description`", columnDefinition = "longtext")
    private String description;

    @Column(name = "`price`", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
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
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
    }
}
