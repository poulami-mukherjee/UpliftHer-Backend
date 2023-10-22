package com.uplifther.upliftherservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
@Table(name="mood_tagging")
public class MoodTagging {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mood_id")
    int moodId;
    @Column(name="mood_entry")
    String moodEntry;
    @Column(name="mood_tag")
    String moodTag;
}
