package seaSolutions.seaSolutions.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum setorNomeEnum {
	DIRETORIA, ADMINISTRATIVO, JURIDICO, FINANCEIRO, OPERACIONAL, RH;
	
    private String setor;
    
    private void setSetor (String setor) {
        this.setor = setor;
    }
    
    public String getSetor() {
        return this.setor;
    }
    
    @JsonCreator
    public static setorNomeEnum getSetoresEnum(String value) {
        for (setorNomeEnum setor : setorNomeEnum.values()) {
            if (setor.getSetor().equals(value)) {
                return setor;
            }
        }
        return null;
    }

}
