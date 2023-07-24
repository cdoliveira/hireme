package com.cdsoftware.hireme.dto;

import com.cdsoftware.hireme.entity.Address;
import com.cdsoftware.hireme.entity.PhoneNumber;
import com.cdsoftware.hireme.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long userID;

    private UserType userType;

    private String fullName;

    private String email;

    private Address address;

    private List<PhoneNumber> phoneNumbers;

}
