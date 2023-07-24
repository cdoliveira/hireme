package com.cdsoftware.hireme.entity;

import com.cdsoftware.hireme.enums.WorkerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long worker_id;
    @Column(nullable = false)
    private String workerName;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private WorkerType workerType;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumberList;

    @Column(nullable = true)
    private Double hourValue;

}
