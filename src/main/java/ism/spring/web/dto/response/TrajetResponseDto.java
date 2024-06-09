package ism.spring.web.dto.response;

import ism.spring.data.entities.Trajet;
import lombok.*;


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
    private Integer nbrPassagers;
    private Integer nbrPlace;
    private Double prix;
    private String conducteur;

    public static TrajetResponseDto toDto(Trajet trajet){
        return TrajetResponseDto.builder()
                .id(trajet.getId())
                .pointDepart(trajet.getPointDepart())
                .pointArrivee(trajet.getPointArrivee())
                .nbrPassagers(trajet.getNbrPassagers())
                .date(trajet.getDate().toString())
                .nbrPlace(trajet.getNbrPlace())
                .prix(trajet.getPrix())
                .conducteur(trajet.getConducteur().getNomComplet())
                .build();
    }
}
