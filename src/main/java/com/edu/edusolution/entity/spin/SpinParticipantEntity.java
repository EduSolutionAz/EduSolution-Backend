package com.edu.edusolution.entity.spin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "spin_participants")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SpinParticipantEntity {

    @Id
    @Column(name = "participant_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID participantId;

    @Column(name = "browser_id", nullable = false)
    private UUID browserId;

    @Column(nullable = false)
    private String ip;

    @CreationTimestamp
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
}
