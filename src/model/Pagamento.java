package model;

import java.util.Map;

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
	private Integer id_beneficiario;
	
	@Column
	private Double valor_pagamento;
	
	@Column
	private String tipo_de_pagamento;
	
	@Column
	private String tipo_de_beneficiario;
	
	
	
	
	public Pagamento(Map<String,Object> paymentData) throws Exception{
		super();
		try{
			this.usuario_pagante =  (Usuario) paymentData.get("usuario_pagante");
			this.id_beneficiario =  (Integer) paymentData.get("id_beneficiario");
			this.valor_pagamento =  (Double) paymentData.get("valor_pagamento");
			this.tipo_de_pagamento =  (String) paymentData.get("tipo_de_pagamento");
			this.tipo_de_beneficiario =  (String) paymentData.get("tipo_de_beneficiario");

			this.setUsuario_pagante(usuario_pagante);
			this.setId_beneficiario(id_beneficiario);
			this.setValor_pagamento(valor_pagamento);
			this.setTipo_de_pagamento(tipo_de_pagamento);
			this.setTipo_de_beneficiario(tipo_de_beneficiario);
		
		}catch(Exception ex){
			throw new Exception();
		}
		
	}




	public Usuario getUsuario_pagante() {
		return usuario_pagante;
	}

	public Pagamento() {
		super();
	}




	public void setUsuario_pagante(Usuario usuario_pagante) throws Exception{
		if(usuario_pagante == null){
			throw new Exception();
		}
		this.usuario_pagante = usuario_pagante;
	}

	public int getId_beneficiario() {
		return id_beneficiario;
	}

	public void setId_beneficiario(Integer id_beneficiario) throws Exception{
		if(id_beneficiario == null){
			throw new Exception();
		}
		this.id_beneficiario = id_beneficiario;
	}

	public Double getValor_pagamento() {
		return valor_pagamento;
	}

	public void setValor_pagamento(Double valor_pagamento) throws Exception{
		if(valor_pagamento == null){
			throw new Exception();
		}
		this.valor_pagamento = valor_pagamento;
	}

	public String getTipo_de_pagamento() {
		return tipo_de_pagamento;
	}

	public void setTipo_de_pagamento(String tipo_de_pagamento) throws Exception{
		if(tipo_de_pagamento == null){
			throw new Exception();
		}
		this.tipo_de_pagamento = tipo_de_pagamento;
	}

	public String getTipo_de_beneficiario() {
		return tipo_de_beneficiario;
	}

	public void setTipo_de_beneficiario(String tipo_de_beneficiario) throws Exception{
		if(tipo_de_beneficiario == null){
			throw new Exception();
		}
		this.tipo_de_beneficiario = tipo_de_beneficiario;
	}



	public String jsonString(){
		return "{\"" + "id_pagamento" + "\":" + "\"" + this.id_pagamento + "\"" + "," +
				 "\"" + "id_beneficiario" + "\":" + "\"" + this.id_beneficiario + "\"" + "," +
				 "\"" + "usuario_pagante.id_usuario" + "\":" + "\"" + this.usuario_pagante.id_usuario + "\"" + "," +
				 "\"" + "tipo_de_beneficiario" + "\":" + "\"" + this.tipo_de_beneficiario.toString() + "\"" + "," +
				 "\"" + "tipo_de_pagamento" + "\":" + "\"" + this.tipo_de_pagamento + "\"" + "," +
				 "\"" + "valor_pagamento" + "\":" + "\"" + this.valor_pagamento.toString() + "\"" +  "}";
	}
}	
