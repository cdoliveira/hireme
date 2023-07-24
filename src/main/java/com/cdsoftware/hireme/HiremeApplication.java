package com.cdsoftware.hireme;

import com.cdsoftware.hireme.dto.UserDto;
import com.cdsoftware.hireme.entity.User;
import com.cdsoftware.hireme.mapper.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class HiremeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiremeApplication.class, args);
	}


}
