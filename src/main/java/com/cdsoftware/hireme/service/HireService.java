package com.cdsoftware.hireme.service;

import com.cdsoftware.hireme.dto.HireServiceWorkerDto;
import com.cdsoftware.hireme.entity.HireServiceWorker;
import com.cdsoftware.hireme.entity.User;
import com.cdsoftware.hireme.entity.Worker;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HireService {

    Optional<HireServiceWorker> createHireService(List<Worker> worker,LocalDateTime date);
   /* Optional<List<HireServiceWorker>> getScheduleJobsByWorker(Worker worker);
    Optional<List<HireServiceWorker>> getScheduleJobsByBeginScheduleDateAtAndWorker(Worker worker,LocalDateTime date);


    Optional<List<HireServiceWorker>> getScheduleJobsByBeginScheduleDateAtAndUser(User user_contractor, LocalDateTime date);
    */
    Optional<List<HireServiceWorkerDto>> getScheduleJobsByUser();

}
