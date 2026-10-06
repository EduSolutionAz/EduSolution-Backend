package com.edu.edusolution.entity.spin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "spin_results")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpinResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "spin_result_id")
    private UUID spinResultId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "spin_prize_id", nullable = false)
    private SpinPrizeEntity prize;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "participant_id", nullable = false)
    private SpinParticipantEntity participant;

    private String email;

    @Column(name = "reward_id")
    private UUID rewardId;

    @CreationTimestamp
    @Column(insertable = false, nullable = false, name = "created_at")
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false, name = "updated_at")
    private OffsetDateTime updatedAt;
}
