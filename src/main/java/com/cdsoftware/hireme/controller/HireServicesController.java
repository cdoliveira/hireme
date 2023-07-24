package com.cdsoftware.hireme.controller;

import com.cdsoftware.hireme.dto.HireServiceWorkerDto;
import com.cdsoftware.hireme.entity.HireServiceWorker;
import com.cdsoftware.hireme.entity.Worker;

import com.cdsoftware.hireme.service.impl.HireServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/hire")
public class HireServicesController {

    private final HireServiceImpl hireService;

    @PostMapping("/create")
    public ResponseEntity<String> createHireOrder(@RequestBody List<Worker> hireServiceWorkerDto){

        hireService.createHireService(hireServiceWorkerDto, LocalDateTime.now());
        return ResponseEntity.ok("Created");
    }

    @PostMapping("/requested-jobs")
    public ResponseEntity<List<HireServiceWorkerDto>> getRequestedJobs(){

        return ResponseEntity.ok(hireService.getScheduleJobsByUser().get());
    }
}
