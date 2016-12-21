package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pagamento {
	@Id
	@GeneratedValue
	protected int id_pagamento;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario_pagante;
	
	@Column
	private int id_beneficiario;
	
	@Column
	private Double valor_pagamento;
	
	@Column
	private String tipo_de_pagamento;
	
	@Column
	private String tipo_de_beneficiario;
	
	
	public String jsonString(){
		return "{\"" + "nome" + "\":" + "\"" + this.nome.toString() + "\"" + "," +
				 "\"" + "descricao" + "\":" + "\"" + this.descricao.toString() + "\"" + "," +
				 "\"" + "setor_de_atuacao" + "\":" + "\"" + this.setor_de_atuacao.toString() + "\"" + "," +
				 "\"" + "id_projeto" + "\":" + "\"" + this.id_projeto + "\"" + "," +
				 "\"" + "url_video_apresentacao" + "\":" + "\"" + this.url_video_apresentacao.toString() + "\"" + "," +
				 "\"" + "aceita_socio" + "\":" + "\"" + this.aceita_socio.toString() + "\"" + "}";
	}
}	
