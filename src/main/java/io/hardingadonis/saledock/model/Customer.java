package io.hardingadonis.saledock.model;

import jakarta.persistence.*;
import java.time.*;
import java.util.*;

import lombok.*;

@Entity(name = "Customer")
@Table(name = "`customer`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "`code`", unique = true, nullable = false, insertable = true, updatable = false)
    private String code;

    @Column(name = "`name`", nullable = false)
    private String name;

    @Column(name = "`email`", unique = true, nullable = false)
    private String email;

    @Column(name = "`address`", nullable = false)
    private String address;

    @Column(name = "`created_at`")
    private LocalDateTime createdAt;

    @Column(name = "`updated_at`")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.code = generateRandomCustomerCode();
        this.createdAt = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
    }

    private static String generateRandomCustomerCode() {
        UUID uuid = UUID.randomUUID();

        return uuid.toString().toUpperCase().replace("-", "").substring(0, 7);
    }
}
