package ism.spring.web.controllers.impl;

import ism.spring.data.entities.Conducteur;
import ism.spring.data.entities.Trajet;
import ism.spring.services.ConducteurService;
import ism.spring.web.controllers.ConducteurController;
import ism.spring.web.dto.RestResponse;
import ism.spring.web.dto.response.ConductorResponseDto;
import ism.spring.web.dto.response.TrajetResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ConducteurControllerImpl implements ConducteurController {
    private final ConducteurService conducteurService;

    @Override
    public ResponseEntity<Map<Object, Object>> getAllConducteursList() {
        List<Conducteur> conducteurs = conducteurService.getAllList();
        List<ConductorResponseDto> dataDtos = conducteurs.stream().map(ConductorResponseDto::toDto).toList();
        Map<Object, Object> model = RestResponse.response(dataDtos, HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
