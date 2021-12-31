package seaSolutions.seaSolutions.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum statusTrabalhadorEnum {
	
	ATIVO("ativo"), 
	INATIVO("inativo");
	
    private String status;
    
    @JsonCreator
    public static statusTrabalhadorEnum getSexoEnum(String value) {
        for (statusTrabalhadorEnum status : statusTrabalhadorEnum.values()) {
            if (status.getStatus().equals(value)) {
                return status;
            }
        }
        return null;
    }
}
