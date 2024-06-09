package ism.spring.data.repositories;


import ism.spring.data.entities.Passager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassagerRepository extends JpaRepository<Passager, Long> {

}
