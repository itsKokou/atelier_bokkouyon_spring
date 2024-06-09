package ism.spring.web.controllers.impl;

import ism.spring.data.entities.Conducteur;
import ism.spring.data.entities.Trajet;
import ism.spring.data.enums.EtatTrajet;
import ism.spring.exceptions.EntityNotFoundException;
import ism.spring.services.ConducteurService;
import ism.spring.services.TrajetService;
import ism.spring.web.controllers.TrajetController;
import ism.spring.web.dto.RestResponse;
import ism.spring.web.dto.request.TrajetCreateRequestDto;
import ism.spring.web.dto.response.TrajetResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class TrajetControllerImpl implements TrajetController {

    private final TrajetService trajetService;
    private final ConducteurService conducteurService;

    @Override
    public ResponseEntity<Map<Object, Object>> ListerTrajets(int page, int size, EtatTrajet etat, Long conducteurId) {
        Conducteur conducteur = null;
        if (conducteurId != null) {
            conducteur = conducteurService.show(conducteurId).orElse(null);
        }
        Page<Trajet> trajets = trajetService.getAllByEtatAndConducteur(conducteur, etat, PageRequest.of(page,size));
        Page<TrajetResponseDto> dataDtos = trajets.map(TrajetResponseDto::toDto);
        Map<Object, Object> model = RestResponse.paginateResponse(
                dataDtos.getContent(), new int[dataDtos.getTotalPages()], dataDtos.getNumber(),dataDtos.hasPrevious(),
                dataDtos.hasNext(), dataDtos.getTotalElements(), dataDtos.getTotalPages(), HttpStatus.OK);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<Object, Object>> saveTrajet(TrajetCreateRequestDto trajetCreate, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponse.response(errors, HttpStatus.NOT_FOUND);
        }else{

            try {

                Conducteur conducteur = conducteurService.show(trajetCreate.getConducteur())
                                .orElseThrow(() -> new EntityNotFoundException("Conducteur non trouvé"));
                Trajet trajet = trajetCreate.toEntity();
                trajet.setConducteur(conducteur);
                trajet = trajetService.save(trajet);

                response= RestResponse.response(trajetCreate,HttpStatus.CREATED);
            }catch (Exception e) {
                response= RestResponse.response(trajetCreate,HttpStatus.CONFLICT);
                System.out.println(e.getMessage());
            }

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
