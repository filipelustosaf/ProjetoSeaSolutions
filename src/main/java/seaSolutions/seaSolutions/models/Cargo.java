package seaSolutions.seaSolutions.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import seaSolutions.seaSolutions.model.enums.nivelCargoEnum;

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
	
	@NotNull(message = "Nome do cargo é um atributo obrigatório")
	@Size(max = 45)
	@Column(name = "nome")
	private String nome;
	
	@NotNull(message = "Nivel do cargo é um atributo obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "nivel")
	private nivelCargoEnum nivel;
	
	@NotNull(message = "Salário é um atributo obrigatório")
	@Column(name = "salario")
	private double salario;
	
	@NotNull(message = "Setor é um atributo obrigatório")
	@ManyToOne()
	@JoinColumn(name = "id_setor")
	private Setor setor;

	public Cargo(@NotNull(message = "Nome do cargo é um atributo obrigatório") String nome,
			@NotNull(message = "Nivel do cargo é um atributo obrigatório") nivelCargoEnum nivel,
			@NotNull(message = "Salário é um atributo obrigatório") double salario, Setor setor) {
		super();
		this.nome = nome;
		this.nivel = nivel;
		this.salario = salario;
		this.setor = setor;
	}


	
}
