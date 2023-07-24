package com.cdsoftware.hireme.mapper;

import com.cdsoftware.hireme.dto.UserDto;
import com.cdsoftware.hireme.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    User DtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
}
