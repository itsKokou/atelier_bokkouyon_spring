package ism.spring.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ConducteurController {
    @RequestMapping("/conducteurs")
    ResponseEntity<Map<Object, Object>> getAllConducteursList();
}
