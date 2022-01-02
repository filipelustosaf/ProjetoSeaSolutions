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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import lombok.Data;
import lombok.NoArgsConstructor;
import seaSolutions.seaSolutions.model.enums.SexoEnum;
import seaSolutions.seaSolutions.model.enums.StatusTrabalhadorEnum;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_trabalhadores")
public class Trabalhador implements Serializable {
	
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_trabalhador")
	private Long id;
	
	@NotBlank(message = "Nome é um atributo obrigatório.")
	@Size(max = 50)
	@Column(name = "nome")
	private String nome;
	
	@NotBlank(message = "CPF é um atributo obrigatório.")
	@CPF
	@Size(max = 15)
	@Column(name = "cpf", unique = true)
	private String cpf;
	
	@NotNull(message = "Sexo é um atributo obrigatório.")
	@Enumerated(EnumType.STRING)
	@Column(name = "sexo")
	private SexoEnum sexo;
	
	@Column(name = "data_nascimento")
	private String dataNascimento;
	
	@Email
	@Size(max = 50)
	@Column(name = "email", unique = true)
	private String email;
	
	@Size(max = 20)
	@Column(name = "telefone", unique = true)
	private String telefone;
	
	@Size(max = 20)
	@Column(name = "endereco")
	private String endereco;
	
	@NotNull(message = "Cargo é um atributo obrigatório.")
	@ManyToOne()
	@JoinColumn(name = "id_cargo")
	private Cargo cargo;

	@NotNull(message = "Status é um atributo obrigatório.")
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusTrabalhadorEnum status;

	public Trabalhador(@NotBlank(message = "Nome é um atributo obrigatório.") @Size(max = 50) String nome,
			@NotBlank(message = "CPF é um atributo obrigatório.") @CPF @Size(max = 15) String cpf,
			@NotNull(message = "Sexo é um atributo obrigatório.") SexoEnum sexo,
			@NotNull(message = "Cargo é um atributo obrigatório.") Cargo cargo,
			@NotNull(message = "Status é um atributo obrigatório.") StatusTrabalhadorEnum status) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.cargo = cargo;
		this.status = status;
	}




	
}
