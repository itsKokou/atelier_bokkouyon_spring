package ism.spring.web.dto.request;

import ism.spring.data.entities.Passager;
import ism.spring.data.entities.Trajet;
import ism.spring.data.enums.EtatTrajet;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassagerCreateRequestDto {
    @NotBlank(message = "Le username est obligatoire")
    private String username;
    @NotBlank(message = "Le password est obligatoire")
    private String password;
    @NotBlank(message = "Le nom complet est obligatoire")
    private String nomComplet;
    @NotBlank(message = "Le telephone est obligatoire")
    private String telephone;


    public Passager toEntity(){

            Passager passager = new Passager();
            passager.setTelephone(telephone);
            passager.setNomComplet(nomComplet);
            passager.setLogin(username);
            return passager;



    }

}
