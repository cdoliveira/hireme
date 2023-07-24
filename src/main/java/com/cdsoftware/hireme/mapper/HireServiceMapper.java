package com.cdsoftware.hireme.mapper;

import com.cdsoftware.hireme.dto.HireServiceWorkerDto;
import com.cdsoftware.hireme.entity.HireServiceWorker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface HireServiceMapper {

    HireServiceMapper HIRE_MAPPER = Mappers.getMapper(HireServiceMapper.class);

    HireServiceWorkerDto ClassToDTO(HireServiceWorker hireWorker);
    HireServiceWorker DTOtoClass(HireServiceWorkerDto hireWorkerDTO);
}
