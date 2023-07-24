package com.cdsoftware.hireme.service;

import com.cdsoftware.hireme.entity.Worker;
import com.cdsoftware.hireme.enums.WorkerType;

import java.util.List;
import java.util.Optional;

public interface WorkerService {

    Optional<List<Worker>> getAllWorkers();
    Optional<List<Worker>> getWorkerByType(WorkerType workerType);


}
