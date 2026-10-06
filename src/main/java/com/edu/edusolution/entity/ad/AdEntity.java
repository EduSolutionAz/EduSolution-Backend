package com.edu.edusolution.entity.ad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "ads")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ad_id")
    private UUID adId;

    @Column(name = "title", nullable = false, unique = true, length = 75)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "ad_url", nullable = false, length = 512)
    private String adUrl;

    @Column(name = "title_not_changed", nullable = false, columnDefinition = "TEXT")
    private String titleNotChanged;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;
}
