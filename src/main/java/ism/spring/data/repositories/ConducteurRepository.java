package ism.spring.data.repositories;


import ism.spring.data.entities.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {

}
