package ism.spring.data.repositories;

import ism.spring.data.entities.Trajet;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;


public interface TrajetRepository extends JpaRepository<Trajet, Long> {

}
