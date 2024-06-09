package ism.spring.web.dto.response;

import ism.spring.data.entities.Conducteur;
import ism.spring.data.entities.Trajet;
import lombok.*;

import java.text.SimpleDateFormat;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConductorResponseDto {
    private Long id;
    private String nomComplet;

    public static ConductorResponseDto toDto(Conducteur conducteur){
        return ConductorResponseDto.builder()
                .id(conducteur.getId())
                .nomComplet(conducteur.getNomComplet())
                .build();
    }
}
