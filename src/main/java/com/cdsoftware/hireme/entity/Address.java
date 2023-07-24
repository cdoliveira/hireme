package com.cdsoftware.hireme.entity;

import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Data;

@Entity
@Data
@Table(name = "tbl_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;

    @Column(name = "street_name",nullable = false)
    private String streetName;

    @Column(name = "eir_code",nullable = true)
    private String eirCode;

    @Column(name = "desc_number",nullable = false)
    private String descriptionNumber;

    @Column(name = "description_details",nullable = true)
    private String description;



}
