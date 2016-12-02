package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue
	int id_endereco;
	
	@Column
	String numero;
	@Column
	String cep;
	@Column
	String rua;
	@Column
	String bairro;
	@Column
	String cidade;
}
