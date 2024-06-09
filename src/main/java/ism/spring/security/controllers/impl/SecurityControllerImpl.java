package ism.spring.security.controllers.impl;

import ism.spring.data.entities.*;
import ism.spring.data.fixtures.PassagerFixtures;
import ism.spring.exceptions.EntityNotFoundException;
import ism.spring.security.controllers.SecurityController;
import ism.spring.security.controllers.dtos.AuthenticationRequestDto;
import ism.spring.security.controllers.dtos.TokenReponseDto;
import ism.spring.security.services.SecurityService;
import ism.spring.security.services.impl.JwtService;
import ism.spring.services.PassagerService;
import ism.spring.web.dto.RestResponse;
import ism.spring.web.dto.request.PassagerCreateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@Slf4j
public class SecurityControllerImpl implements SecurityController {
    private final SecurityService securityService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final PassagerService passagerService;


    @Override
    public ResponseEntity<Map<Object, Object>> login(AuthenticationRequestDto authenticationRequestDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword()));
        Map<Object, Object> response;
        if(authenticate.isAuthenticated()){
            //Generer le token
             String token= jwtService.createToken(authenticationRequestDto.getUsername());
             AppUser user = securityService.getUserByUsername(authenticationRequestDto.getUsername());
            TokenReponseDto tokenDto = TokenReponseDto.builder()
                    .token(token)
                    .username(authenticationRequestDto.getUsername())
                    .userId(user.getId())
                    .nomComplet(user.getNomComplet())
                    .roles(authenticate.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                    .build();
            response= RestResponse.response(tokenDto, HttpStatus.OK);
        }else{
            response= RestResponse.response(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> savePassager(PassagerCreateRequestDto passagerCreate, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{

            try {
                Passager passager = passagerCreate.toEntity();
                passager.setPassword(passwordEncoder.encode(passagerCreate.getPassword()));
                AppRole role = securityService.getRoleByName("ROLE_PASSAGER");
                passager.setRoles(new ArrayList<>());
                passager.getRoles().add(role);
                passagerService.save(passager);
                response= RestResponse.response(passagerCreate,HttpStatus.OK);
            }catch (Exception e) {
                response= RestResponse.response(passagerCreate,HttpStatus.CONFLICT);
                System.out.println(e.getMessage());
            }

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
