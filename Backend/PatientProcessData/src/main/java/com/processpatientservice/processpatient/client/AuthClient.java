package com.processpatientservice.processpatient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.processpatientservice.processpatient.DTO.ValidatingDTO;

@FeignClient(name="auth-client",url="${Authorization.URL}")
public interface AuthClient {
	@GetMapping(value = "/validate")
	public ValidatingDTO getValidity(@RequestHeader(name = "Authorization",required = true) String token);
	
}
