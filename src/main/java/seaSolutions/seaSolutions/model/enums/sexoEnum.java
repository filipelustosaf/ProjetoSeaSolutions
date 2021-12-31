package seaSolutions.seaSolutions.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum sexoEnum {
	
	MASCULINO("m"), 
	FEMININO("f");
	
    private String sexo;
    
    @JsonCreator
    public static sexoEnum getSexoEnum(String value) {
        for (sexoEnum sexo : sexoEnum.values()) {
            if (sexo.getSexo().equals(value)) {
                return sexo;
            }
        }
        return null;
    }
}
