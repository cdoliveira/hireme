package com.cdsoftware.hireme.entity;

import com.cdsoftware.hireme.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class HireServiceWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToMany
    private List<Worker> workers;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime beginScheduleDateAt;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endScheduleDateAt;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime requestCreateAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address addressToWork;

    private int hoursRequired;

}
