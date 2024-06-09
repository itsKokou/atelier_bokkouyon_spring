package ism.spring.security.controllers.impl;

import ism.spring.data.entities.AppUser;
import ism.spring.security.controllers.SecurityController;
import ism.spring.security.controllers.dtos.AuthenticationRequestDto;
import ism.spring.security.controllers.dtos.TokenReponseDto;
import ism.spring.security.services.SecurityService;
import ism.spring.security.services.impl.JwtService;
import ism.spring.web.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@Slf4j
public class SecurityControllerImpl implements SecurityController {
    private final SecurityService securityService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


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

}