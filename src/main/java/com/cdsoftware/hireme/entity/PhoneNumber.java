package com.cdsoftware.hireme.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phone_id;

    @Column(name = "phone_number")
    private String phoneNumber;
}
