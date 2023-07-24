package com.cdsoftware.hireme.service.impl;

import com.cdsoftware.hireme.entity.Worker;
import com.cdsoftware.hireme.enums.WorkerType;
import com.cdsoftware.hireme.repository.WorkerRepository;
import com.cdsoftware.hireme.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;


    @Override
    public Optional<List<Worker>> getAllWorkers() {

        Optional<List<Worker>> listWorker = Optional.of(workerRepository.findAll());
        return listWorker;
    }

    @Override
    public Optional<List<Worker>> getWorkerByType(WorkerType workerType) {

        Optional<List<Worker>> filteredList = workerRepository.findAllByWorkerType(workerType);
        return filteredList;
    }
}
