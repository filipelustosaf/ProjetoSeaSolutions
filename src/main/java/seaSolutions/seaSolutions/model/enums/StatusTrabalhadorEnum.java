package seaSolutions.seaSolutions.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusTrabalhadorEnum {
	
	ATIVO("ativo"), 
	INATIVO("inativo");
	
    private String status;
    
    @JsonCreator
    public static StatusTrabalhadorEnum getSexoEnum(String value) {
        for (StatusTrabalhadorEnum status : StatusTrabalhadorEnum.values()) {
            if (status.getStatus().equals(value)) {
                return status;
            }
        }
        return null;
    }
}
