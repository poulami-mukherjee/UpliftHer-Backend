package com.uplifther.upliftherservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Builder
@Table(name="registered_user")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="user_id")
        int userId;
        @NonNull
        @Column(name="user_name")
        String userName;
        @NonNull
        @Column(name="first_name")
        String firstName;
        @Column(name="last_name")
        String lastName;
        @Column(name="dob")
        LocalDate dob;
        @Column(name="gender")
        String gender;
        @Column(name="create_time")
        Timestamp createTime;
}
