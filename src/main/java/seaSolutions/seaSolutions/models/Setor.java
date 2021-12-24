package seaSolutions.seaSolutions.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import seaSolutions.seaSolutions.model.enums.setoresEnum;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_setores")
public class Setor implements Serializable{
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_setor")
	private Long id;
	
	@NotNull(message = "Nome é um atributo obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "nome", unique = true)
	private setoresEnum nome;

	public Setor(@NotNull(message = "Nome é um atributo obrigatório") setoresEnum nome) {
		super();
		this.nome = nome;
	}
	
}
