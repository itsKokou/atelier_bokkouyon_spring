package ism.spring.web.dto.response;

import ism.spring.data.entities.Trajet;
import lombok.*;

import java.text.SimpleDateFormat;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrajetResponseDto {
    private Long id;
    private String pointDepart;
    private String pointArrivee;
    private String date;
    private String etat;
    private Integer nbrPassagers;
    private Integer nbrPlace;
    private Double prix;
    private String conducteur;

    public static TrajetResponseDto toDto(Trajet trajet){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return TrajetResponseDto.builder()
                .id(trajet.getId())
                .pointDepart(trajet.getPointDepart())
                .pointArrivee(trajet.getPointArrivee())
                .nbrPassagers(trajet.getNbrPassagers())
                .date(sdf.format(trajet.getDate()))
                .nbrPlace(trajet.getNbrPlace())
                .prix(trajet.getPrix())
                .etat(trajet.getEtat().toString())
                .conducteur(trajet.getConducteur().getNomComplet())
                .build();
    }
}
