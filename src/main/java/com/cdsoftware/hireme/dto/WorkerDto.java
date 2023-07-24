package com.cdsoftware.hireme.dto;

import com.cdsoftware.hireme.entity.PhoneNumber;
import com.cdsoftware.hireme.enums.WorkerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDto {

    private String workerName;
    private WorkerType workerType;
    private List<PhoneNumber> phoneNumberList;
    private Double hourValue;
}
