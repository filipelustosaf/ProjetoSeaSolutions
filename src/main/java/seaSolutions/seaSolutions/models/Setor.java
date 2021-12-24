package seaSolutions.seaSolutions.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	@NotBlank(message = "Nome é um atributo obrigatório")
	@Size(max = 50)
	@Column(name = "nome")
	private String nome;
	
	@OneToMany()
	@JoinColumn(name = "id_cargo")
	private List<Cargo> cargos;

	public Setor(@NotBlank(message = "Nome é um atributo obrigatório") @Size(max = 50) String nome) {
		super();
		this.nome = nome;
	}
	
	
}
