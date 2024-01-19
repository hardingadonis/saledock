package io.hardingadonis.saledock.model;

import jakarta.persistence.*;
import java.time.*;
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
    private Long ID;
    
    @Column(name = "`code`", unique = true, nullable = false)
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
        this.createdAt = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
    }
}