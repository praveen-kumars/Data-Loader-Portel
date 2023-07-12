package com.patientupdateservice.patientupdate.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.patientupdateservice.patientupdate.DTO.ValidatingDTO;

@FeignClient(name="auth-client",url="${Authorization.URL}")
public interface AuthClient {
	
	@GetMapping(value = "/validate")
	public ValidatingDTO getValidity(@RequestHeader(name = "Authorization",required = true) String token);

}
