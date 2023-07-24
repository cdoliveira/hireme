package com.cdsoftware.hireme.dto;

import com.cdsoftware.hireme.entity.Address;
import com.cdsoftware.hireme.entity.User;
import com.cdsoftware.hireme.entity.Worker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HireServiceWorkerDto {



    private UserDto user;
    private List<Worker> workers;
    private LocalDateTime beginScheduleDateAt;
    private LocalDateTime endScheduleDateAt;
    private LocalDateTime requestCreateAt;
    private Address addressToWork;
    private int hoursRequired;

}
