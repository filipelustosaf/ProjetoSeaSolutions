package seaSolutions.seaSolutions.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_cargos")
public class Cargo implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cargo")
	private Long id;
	
	@NotBlank(message = "Nome é um atributo obrigatório")
	@Size(max = 50)
	@Column(name = "nome")
	private String nome;
	
	@NotNull(message = "Salário é um atributo obrigatório")
	@Column(name = "salario")
	private double salario;
	
	@ManyToOne()
	@JoinColumn(name = "id_setor")
	private Setor setor;

	public Cargo(@NotBlank(message = "Nome é um atributo obrigatório") @Size(max = 50) String nome,
			@NotBlank(message = "Salario é um atributo obrigatório") double salario) {
		super();
		this.nome = nome;
		this.salario = salario;
	}
	
}
