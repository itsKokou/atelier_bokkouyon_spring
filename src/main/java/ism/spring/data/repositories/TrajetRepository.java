package ism.spring.data.repositories;

import ism.spring.data.entities.Conducteur;
import ism.spring.data.entities.Trajet;
import ism.spring.data.enums.EtatTrajet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface TrajetRepository extends JpaRepository<Trajet, Long> {
    @Query("SELECT DISTINCT t FROM Trajet t " +
            "WHERE (:etat IS NULL OR t.etat = :etat) "+
            "AND (:conducteur IS NULL OR t.conducteur = :conducteur) "
    )
    Page<Trajet> findByEtatAndConducteur(@Param("conducteur") Conducteur conducteur,
                                         @Param("etat") EtatTrajet etat,
                                         Pageable pageable);
}
