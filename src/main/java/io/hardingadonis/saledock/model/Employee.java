package io.hardingadonis.saledock.model;

import jakarta.persistence.*;
import java.time.*;
import lombok.*;

@Entity(name = "Employee")
@Table(name = "`employee`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employee {

    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "`code`", unique = true)
    private String code;
    
    @Column(name = "`password`", nullable = false)
    private String hashedPassword;
    
    @Column(name = "`email`", nullable = false)
    private String email;
    
    @Column(name = "`name`", nullable = false)
    private String fullName;
    
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
