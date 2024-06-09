package ism.spring.web.dto.request;

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
public class TrajetCreateRequestDto {
    private Long id;
    @NotNull
    @Min(value = 1, message = "Le conducteur est obligatoire")
    private Long conducteur;
    @NotBlank(message = "La date est obligatoire")
    private String date;
    @NotBlank(message = "Le point de départ est obligatoire")
    private String pointDepart;
    @NotBlank(message = "Le point d'arrivée est obligatoire")
    private String pointArrivee;
    @Min(value = 0, message = "Le nombre de passager est obligatoire")
    private Integer nbrPassagers;
    @Min(value = 1, message = "Le nbre de place libre est obligatoire")
    private Integer nbrPlace;
    @Min(value = 50, message = "Le prix est obligatoire")
    private Double prix;



    public Trajet toEntity(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(this.date);
            Trajet trajet = Trajet.builder()
                    .etat(EtatTrajet.Restant)
                    .pointDepart(pointDepart)
                    .pointArrivee(pointArrivee)
                    .nbrPassagers(nbrPassagers)
                    .nbrPlace(nbrPlace)
                    .prix(prix)
                    .date(date)
                    .build();
            return trajet;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }

}
