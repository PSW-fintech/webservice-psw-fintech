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
		return "{\"" + "id_pagamento" + "\":" + "\"" + this.id_pagamento + "\"" + "," +
				 "\"" + "id_beneficiario" + "\":" + "\"" + this.id_beneficiario + "\"" + "," +
				 "\"" + "usuario_pagante.id_usuario" + "\":" + "\"" + this.usuario_pagante.id_usuario + "\"" + "," +
				 "\"" + "tipo_de_beneficiario" + "\":" + "\"" + this.tipo_de_beneficiario.toString() + "\"" + "," +
				 "\"" + "tipo_de_pagamento" + "\":" + "\"" + this.tipo_de_pagamento + "\"" + "," +
				 "\"" + "valor_pagamento" + "\":" + "\"" + this.valor_pagamento.toString() + "\"" +  "}";
	}
}	
