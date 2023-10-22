package com.uplifther.upliftherservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
@Builder
@Table(name="mood_selection")
public class MoodSelection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="entry_id")
    int entryId;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    int userId;
    @Column(name="timestamp")
    Timestamp entryTimeStamp;
    @ManyToOne
    @JoinColumn(name="mood_entry", referencedColumnName = "mood_entry")
    String moodEntry;
    @Column(name="notes")
    String notes;
}
