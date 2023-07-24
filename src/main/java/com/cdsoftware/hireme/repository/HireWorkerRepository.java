package com.cdsoftware.hireme.repository;

import com.cdsoftware.hireme.entity.HireServiceWorker;
import com.cdsoftware.hireme.entity.User;
import com.cdsoftware.hireme.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HireWorkerRepository extends JpaRepository<HireServiceWorker,Long> {

    Optional<List<HireServiceWorker>> getServicesByUser(User solicitor);
    Optional<List<HireServiceWorker>> getServicesByBeginScheduleDateAtAndUser(LocalDateTime date,User user);
/*
    default Optional<List<HireServiceWorker>> getServicesByUserAndDate(User user_contractor, LocalDateTime date){
        return getServicesByBeginScheduleDateAtAndUser(date,user_contractor);
    }

    default Optional<List<HireServiceWorker>> getServicesByWorkersAndDate(Worker worker, LocalDateTime date){
        return getServicesByBeginScheduleDateAtAndWorkers(date,worker);
    }

    Optional<List<HireServiceWorker>> getServicesByWorkers(Worker hiredWorker);
    Optional<List<HireServiceWorker>> getServicesByBeginScheduleDateAtAndWorkers(LocalDateTime date,Worker hiredWorker);*/

}
