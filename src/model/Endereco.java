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
	
	
	public String jsonString(){
		return "{\"" + "nome" + "\":" + "\"" + this.nome.toString() + "\"" + "," +
				 "\"" + "descricao" + "\":" + "\"" + this.descricao.toString() + "\"" + "," +
				 "\"" + "setor_de_atuacao" + "\":" + "\"" + this.setor_de_atuacao.toString() + "\"" + "," +
				 "\"" + "id_projeto" + "\":" + "\"" + this.id_projeto + "\"" + "," +
				 "\"" + "url_video_apresentacao" + "\":" + "\"" + this.url_video_apresentacao.toString() + "\"" + "," +
				 "\"" + "aceita_socio" + "\":" + "\"" + this.aceita_socio.toString() + "\"" + "}";
	}
}
