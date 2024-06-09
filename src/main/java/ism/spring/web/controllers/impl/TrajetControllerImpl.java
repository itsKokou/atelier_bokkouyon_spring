package ism.spring.web.controllers.impl;

import ism.spring.data.entities.Trajet;
import ism.spring.services.TrajetService;
import ism.spring.web.controllers.TrajetController;
import ism.spring.web.dto.RestResponse;
import ism.spring.web.dto.response.TrajetResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class TrajetControllerImpl implements TrajetController {

    private final TrajetService trajetService;

    @Override
    public ResponseEntity<Map<Object, Object>> ListerTrajets(int page, int size) {
        Page<Trajet> trajets = trajetService.getAllTrajet(PageRequest.of(page,size));
        Page<TrajetResponseDto> dataDtos = trajets.map(TrajetResponseDto::toDto);
        Map<Object, Object> model = RestResponse.paginateResponse(
                dataDtos.getContent(), new int[dataDtos.getTotalPages()], dataDtos.getNumber(),dataDtos.hasPrevious(),
                dataDtos.hasNext(), dataDtos.getTotalElements(), dataDtos.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
}
