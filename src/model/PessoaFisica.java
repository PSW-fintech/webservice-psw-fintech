package model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Usuario{
	@Column
	private String nome_da_mae;
	@Column
	private String data_de_nascimento;
	
	public String getNome_da_mae() {
		return nome_da_mae;
	}
	public void setNome_da_mae(String nome_da_mae) {
		this.nome_da_mae = nome_da_mae;
	}
	public String getData_de_nascimento() {
		return data_de_nascimento;
	}
	public void setData_de_nascimento(String data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}
	
	public PessoaFisica(){
		
	}
	
	public PessoaFisica(Map<String,Object> userData) throws Exception{
		super(userData);
		try{ 
			this.nome_da_mae = (String) userData.get("nome_da_mae");
			this.data_de_nascimento = (String) userData.get("data_de_nascimento");
		}catch(Exception e){
			throw e;
		}
	}
}
