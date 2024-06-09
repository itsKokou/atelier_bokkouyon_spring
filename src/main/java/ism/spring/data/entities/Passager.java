package ism.spring.data.entities;


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
@Table(name = "passagers")
public class Passager extends AppUser{
    @OneToMany(mappedBy = "passager")
    private List<Course> courses;
}
