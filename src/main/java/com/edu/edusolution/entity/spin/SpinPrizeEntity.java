package com.edu.edusolution.entity.spin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "spin_prizes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpinPrizeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "spin_prize_id")
    private UUID spinPrizeId;
    @Column(name = "spin_prize_name", unique = true, nullable = false)
    private String spinPrizeName;
    @Column(name = "spin_prize_weight", nullable = false)
    private Integer spinPrizeWeight;
    @CreationTimestamp
    @Column(name = "created_at", insertable = false)
    private OffsetDateTime createdAt;
}
