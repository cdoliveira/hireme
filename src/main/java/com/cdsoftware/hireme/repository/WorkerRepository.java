package com.cdsoftware.hireme.repository;

import com.cdsoftware.hireme.entity.Worker;
import com.cdsoftware.hireme.enums.WorkerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker,Long> {


    Optional<List<Worker>> findAllByWorkerType(WorkerType workerType);
}
