package model;

import java.util.Map;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Usuario{
	public PessoaJuridica(){}
	public PessoaJuridica(Map<String,Object> userData) throws Exception{
		super(userData);
	}
	
	
}
