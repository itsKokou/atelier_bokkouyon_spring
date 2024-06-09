package ism.spring.web.controllers;

import ism.spring.data.enums.EtatTrajet;
import ism.spring.web.dto.request.TrajetCreateRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface TrajetController {
    @RequestMapping("/trajets")
    ResponseEntity<Map<Object, Object>> ListerTrajets(
            @RequestParam(defaultValue = "0" ) int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) EtatTrajet etat,
            @RequestParam(required = false) Long conducteurId
    );

    @PostMapping("/trajets")
    ResponseEntity<Map<Object, Object>> saveTrajet(@Valid @RequestBody TrajetCreateRequestDto trajetCreate, BindingResult bindingResult);

}
