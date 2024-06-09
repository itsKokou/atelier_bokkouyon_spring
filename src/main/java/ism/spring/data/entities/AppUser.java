package ism.spring.data.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue(value = "AppUser")
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    private String nomComplet;
    @Column(nullable = false, unique = true)
    private String telephone;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles = new ArrayList<>();

    public AppUser(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
