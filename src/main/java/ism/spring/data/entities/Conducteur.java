package ism.spring.data.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "conducteurs")
@DiscriminatorValue(value = "Conducteur")
public class Conducteur extends AppUser{
    @OneToMany(mappedBy = "conducteur")
    private List<Trajet> trajets;
}
