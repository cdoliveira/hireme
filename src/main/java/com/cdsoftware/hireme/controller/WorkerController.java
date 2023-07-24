package com.cdsoftware.hireme.controller;

import com.cdsoftware.hireme.entity.Worker;
import com.cdsoftware.hireme.enums.WorkerType;
import com.cdsoftware.hireme.service.impl.WorkerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/worker")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerServiceImpl workerService;

    @PostMapping("list")
    public ResponseEntity<List<Worker>> getAllWorkers(){

        Optional<List<Worker>> listWorker = workerService.getAllWorkers();

        return ResponseEntity.ok(listWorker.orElseThrow());

    }

    @PostMapping("list/filtered")
    public ResponseEntity<List<Worker>> getFilteredWorkers(@RequestBody WorkerType workerType){

        Optional<List<Worker>> listWorker = workerService.getWorkerByType(workerType);

        return ResponseEntity.ok(listWorker.orElseThrow());

    }
}
