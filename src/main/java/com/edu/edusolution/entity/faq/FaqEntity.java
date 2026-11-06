package com.edu.edusolution.entity.faq;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "faqs"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FaqEntity {

    @Column(name = "faq_id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID faqId;

    @Column(name = "faq_question", nullable = false, columnDefinition = "TEXT")
    private String faqQuestion;

    @Column(name = "faq_answer", nullable = false, columnDefinition = "TEXT")
    private String faqAnswer;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

}
