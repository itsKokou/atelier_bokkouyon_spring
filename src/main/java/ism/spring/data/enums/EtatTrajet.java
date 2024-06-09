package ism.spring.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EtatTrajet {
    Prevu(0),
    Termine(1);

    private final Integer indexEnumEtat;
}

