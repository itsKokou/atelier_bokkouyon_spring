package ism.spring.security.controllers;

import ism.spring.security.controllers.dtos.AuthenticationRequestDto;
import ism.spring.web.dto.request.PassagerCreateRequestDto;
import ism.spring.web.dto.request.TrajetCreateRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface SecurityController {
    @PostMapping("/login")
      public ResponseEntity<Map<Object, Object>> login(@RequestBody AuthenticationRequestDto authenticationRequestDto);

    @PostMapping("/register-passager")
    ResponseEntity<Map<Object, Object>> savePassager(@Valid @RequestBody PassagerCreateRequestDto passagerCreate, BindingResult bindingResult);


}
