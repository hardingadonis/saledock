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
@EqualsAndHashCode
@ToString
public class Customer {
    
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    
    @Column(name = "`code`", unique = true)
    private String code;
    
    @Column(name = "`name`")
    private String name;
    
    @Column(name = "`email`", unique = true)
    private String email;
    
    @Column(name = "`address`")
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