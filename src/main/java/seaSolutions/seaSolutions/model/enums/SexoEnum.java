package seaSolutions.seaSolutions.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexoEnum {
	
	MASCULINO("m"), 
	FEMININO("f");
	
    private String sexo;
    
    @JsonCreator
    public static SexoEnum getSexoEnum(String value) {
        for (SexoEnum sexo : SexoEnum.values()) {
            if (sexo.getSexo().equals(value)) {
                return sexo;
            }
        }
        return null;
    }
}
