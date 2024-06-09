package ism.spring.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EtatTrajet {
    Plein(0),
    Restant(1);

    private final Integer indexEnumEtat;
}

