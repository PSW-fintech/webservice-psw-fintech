package model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public abstract class Usuario {
	@Id
	@GeneratedValue
	protected int id_usuario;
	
	@OneToOne
	@JoinColumn(name="id_endereco")
	protected Endereco endereco;
	@Column
	protected String nome_completo;
	@Column
	protected String codigo_pessoa;
	@Column
	protected String telefone;
	@Column
	protected String telefone_opcional;
	@Column
	protected String email;
	@Column(unique=true)
	protected String nome_do_usuario;
	@Column
	protected String senha_para_acesso;
	@Column
	protected String foto_perfil;
	
	public Usuario(){
		
	}
	
	public Usuario(Map<String,Object> userData) throws Exception{
		try{
			this.endereco =(Endereco) userData.get("endereco") ;
			this.setEndereco(this.endereco);
			this.nome_completo =(String) userData.get("nome_completo") ;
			this.setNome_completo(this.nome_completo);
			this.codigo_pessoa =(String) userData.get("codigo_pessoa") ;
			this.setCodigo_pessoa(this.codigo_pessoa);
			this.telefone =(String) userData.get("telefone") ;
			this.setTelefone(this.telefone);
			this.telefone_opcional =(String) userData.get("telefone_opcional") ;
			this.setTelefone_opcional(this.telefone_opcional);
			this.email =(String) userData.get("email") ;
			this.setEmail(this.email);
			this.nome_do_usuario =(String) userData.get("nome_do_usuario") ;
			this.setNome_do_usuario(this.nome_do_usuario);
			this.senha_para_acesso =(String) userData.get("senha_para_acesso") ;
			this.setSenha_para_acesso(this.senha_para_acesso);
			this.foto_perfil =(String) userData.get("foto_perfil") ;
			this.setFoto_perfil(this.foto_perfil);
		}catch(Exception e){
			throw e;
		}
	}
	
	public int getId_usuario(){
		return id_usuario;
	}
	public String getNome_completo() {
		return nome_completo;
	}
	public void setNome_completo(String nome_completo)  throws Exception{
		if(nome_completo == null || nome_completo.length() < 5){
			throw new Exception();
		}
		this.nome_completo = nome_completo;
	}
	public String getCodigo_pessoa() {
		return codigo_pessoa;
	}
	public void setCodigo_pessoa(String codigo_pessoa)  throws Exception{
		if(codigo_pessoa == null || codigo_pessoa.length() < 5){
			throw new Exception();
		}
		this.codigo_pessoa = codigo_pessoa;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone)  throws Exception{
		if(telefone == null || telefone.length() < 5){
			throw new Exception();
		}
		this.telefone = telefone;
	}
	public String getTelefone_opcional() {
		return telefone_opcional;
	}
	public void setTelefone_opcional(String telefone_opcional)  throws Exception{
		if(telefone_opcional == null || telefone_opcional.length() < 5){
			throw new Exception();
		}
		this.telefone_opcional = telefone_opcional;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email)  throws Exception{
		if(email == null || email.length() < 5){
			throw new Exception();
		}
		this.email = email;
	}
	public String getNome_do_usuario() {
		return nome_do_usuario;
	}
	public void setNome_do_usuario(String nome_do_usuario)  throws Exception{
		if(nome_do_usuario == null || nome_do_usuario.length() < 5){
			throw new Exception();
		}
		this.nome_do_usuario = nome_do_usuario;
	}
	public String getSenha_para_acesso() {
		return senha_para_acesso;
	}
	public void setSenha_para_acesso(String senha_para_acesso)  throws Exception{
		if(senha_para_acesso == null || senha_para_acesso.length() < 5){
			throw new Exception();
		}
		this.senha_para_acesso = senha_para_acesso;
	}
	public String getFoto_perfil() {
		return foto_perfil;
	}
	public void setFoto_perfil(String foto_perfil)  throws Exception{
		if(foto_perfil == null || foto_perfil.length() < 5){
			throw new Exception();
		}
		this.foto_perfil = foto_perfil;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco)  throws Exception{
		if(endereco == null){
			throw new Exception();
		}
		this.endereco = endereco;
	}
	
	public String jsonString(){
		return "{\"" + "nome" + "\":" + "\"" + this.nome.toString() + "\"" + "," +
				 "\"" + "descricao" + "\":" + "\"" + this.descricao.toString() + "\"" + "," +
				 "\"" + "setor_de_atuacao" + "\":" + "\"" + this.setor_de_atuacao.toString() + "\"" + "," +
				 "\"" + "id_projeto" + "\":" + "\"" + this.id_projeto + "\"" + "," +
				 "\"" + "url_video_apresentacao" + "\":" + "\"" + this.url_video_apresentacao.toString() + "\"" + "," +
				 "\"" + "aceita_socio" + "\":" + "\"" + this.aceita_socio.toString() + "\"" + "}";
	}
	
}
