package model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Investimento {
	@Id
	@GeneratedValue
	protected int id_investimento;

	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario_investidor;
	

	@ManyToOne
	@JoinColumn(name="id_projeto")
	private Projeto projeto_investido;
	
	@Column
	private Double valor_investimento;
	@Column
	private Boolean quero_ser_socio;
	@Column
	private Date data_investimento;
	public Usuario getUsuario_investidor() {
		return usuario_investidor;
	}
	public void setUsuario_investidor(Usuario usuario_investidor) throws Exception{
		if(usuario_investidor == null){
			throw new Exception();
		}
		this.usuario_investidor = usuario_investidor;
	}
	public Projeto getProjeto_investido() {
		return projeto_investido;
	}
	public void setProjeto_investido(Projeto projeto_investido) throws Exception{
		if(projeto_investido == null){
			throw new Exception();
		}
		this.projeto_investido = projeto_investido;
	}
	public Double getValor_investimento() {
		return valor_investimento;
	}
	public void setValor_investimento(Double valor_investimento) throws Exception{
		if(valor_investimento == null){
			throw new Exception();
		}
		this.valor_investimento = valor_investimento;
	}
	public Boolean getQuero_ser_socio() {
		return quero_ser_socio;
	}
	public void setQuero_ser_socio(Boolean quero_ser_socio) throws Exception{
		if(quero_ser_socio == null){
			throw new Exception();
		}
		this.quero_ser_socio = quero_ser_socio;
	}
	public Date getData_investimento() {
		return data_investimento;
	}
	public void setData_investimento(Date data_investimento) throws Exception{
		if(data_investimento == null){
			throw new Exception();
		}
		this.data_investimento = data_investimento;
	}
	public Investimento(Map<String,Object> investimentData) throws Exception{
		super();
		try{
			this.usuario_investidor = (Usuario) investimentData.get("usuario_investidor");
			this.setUsuario_investidor(usuario_investidor);
			this.projeto_investido = (Projeto) investimentData.get("projeto_investido");
			this.setProjeto_investido(projeto_investido);
			this.valor_investimento = (Double) investimentData.get("valor_investimento");
			this.setValor_investimento(valor_investimento);
			this.quero_ser_socio = (Boolean) investimentData.get("quero_ser_socio");
			this.setQuero_ser_socio(quero_ser_socio);
			this.data_investimento = (Date) investimentData.get("data_investimento");
			this.setData_investimento(data_investimento);
		}catch(Exception ex){
			throw new Exception();
		}
	}
	public Investimento() {
		super();
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
