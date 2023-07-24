package com.cdsoftware.hireme.service.impl;

import com.cdsoftware.hireme.auth.AuthenticationService;
import com.cdsoftware.hireme.dto.HireServiceWorkerDto;
import com.cdsoftware.hireme.dto.UserDto;
import com.cdsoftware.hireme.dto.WorkerDto;
import com.cdsoftware.hireme.entity.HireServiceWorker;
import com.cdsoftware.hireme.entity.User;
import com.cdsoftware.hireme.entity.Worker;

import com.cdsoftware.hireme.mapper.HireServiceMapper;
import com.cdsoftware.hireme.mapper.UserMapper;
import com.cdsoftware.hireme.repository.HireWorkerRepository;
import com.cdsoftware.hireme.repository.UserRepository;
import com.cdsoftware.hireme.service.HireService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HireServiceImpl implements HireService {

    private final HireWorkerRepository hireWorkerRepository;
    private final UserServiceImpl userService;


    @Override
    public Optional<HireServiceWorker> createHireService(List<Worker> hireWorker, LocalDateTime date) {

        UserDto authUser = userService.getAuthUser();


        HireServiceWorker savedScheduleJob = HireServiceWorker.builder()
                .user(UserMapper.USER_MAPPER.DtoToUser(authUser))
                .workers(hireWorker)
                .requestCreateAt(date)
                .beginScheduleDateAt(date)
                .hoursRequired(4)
                .build();

        hireWorkerRepository.save(savedScheduleJob);
        return Optional.of(savedScheduleJob);
    }

    /*@Override
    public Optional<List<HireServiceWorker>> getScheduleJobsByWorker(Worker worker) {

        Optional<List<HireServiceWorker>> listHireServices = hireWorkerRepository.getServicesByWorkers(worker);
        return listHireServices;
    }

    @Override
    public Optional<List<HireServiceWorker>> getScheduleJobsByBeginScheduleDateAtAndWorker(Worker worker, LocalDateTime date) {

        Optional<List<HireServiceWorker>> listHireServices = hireWorkerRepository.getServicesByWorkersAndDate(worker,date);
        return listHireServices;
    }

    @Override
    public Optional<List<HireServiceWorker>> getScheduleJobsByBeginScheduleDateAtAndUser(User user_contractor, LocalDateTime date) {
        return Optional.empty();
    }


    public Optional<List<HireServiceWorker>> getServicesByUserAndDate(User user_contractor, LocalDateTime date) {
        Optional<List<HireServiceWorker>> listHireServices = hireWorkerRepository.getServicesByUserAndDate(user_contractor,date);
        return listHireServices;
    }*/

    @Override
    public Optional<List<HireServiceWorkerDto>> getScheduleJobsByUser() {

        UserDto authUser = userService.getAuthUser();
        Optional<List<HireServiceWorker>> listHireServices = hireWorkerRepository.getServicesByUser(UserMapper.USER_MAPPER.DtoToUser(authUser));
        List<HireServiceWorkerDto>listServicesDTO = listHireServices
                .get()
                .stream()
                .map(worker -> HireServiceMapper.HIRE_MAPPER.ClassToDTO(worker))
                .collect(Collectors.toList());

        return Optional.of(listServicesDTO);
    }


}
