package io.hardingadonis.saledock.model;

import jakarta.persistence.*;
import java.time.*;
import lombok.*;

@Entity(name = "Category")
@Table(name = "`category`")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category {

    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "`name`", nullable = false)
    private String name;
    
    @Column(name = "`created_at`")
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
    }
}
