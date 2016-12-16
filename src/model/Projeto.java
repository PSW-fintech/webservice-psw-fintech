package model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Projeto {
	@Id
	@GeneratedValue
	protected int id_projeto;
	
	@Column
	private int id_usuario_dono_do_projeto;
	
	@Column
	private String nome;
	@Column
	private String descricao;
	@Column
	private String url_video_apresentacao;
	@Column
	private String setor_de_atuacao;
	@Column
	private Double valor_total_investimento;
	@Column
	private Date prazo_levantamento;
	@Column
	private Double faturamento_mensal_estimado;
	@Column
	private Double lucro_mensal_estimado;
	@Column
	private Date carencia_emprestimo;
	@Column
	private Date prazo_quitacao;
	@Column
	private Double taxa_juros;
	@Column
	private Double taxa_iof;
	@Column
	private Double taxa_remuneracao_investidor;
	@Column
	private Double taxa_intermediacao;
	@Column
	private Boolean aceita_socio;
	@Column
	private Double percentual_ingresso;
	@Column
	private Double percentual_socio;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception{
		if(nome == null || nome.length() < 5){
			throw new Exception();
		}
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) throws Exception{
		if(descricao == null || descricao.length() < 5){
			throw new Exception();
		}
		this.descricao = descricao;
	}
	public String getUrl_video_apresentacao() {
		return url_video_apresentacao;
	}
	public void setUrl_video_apresentacao(String url_video_apresentacao) throws Exception{
		if(url_video_apresentacao == null || url_video_apresentacao.length() < 5){
			throw new Exception();
		}
		this.url_video_apresentacao = url_video_apresentacao;
	}
	public String getSetor_de_atuacao() {
		return setor_de_atuacao;
	}
	public void setSetor_de_atuacao(String setor_de_atuacao) throws Exception{
		if(setor_de_atuacao == null || setor_de_atuacao.length() < 5){
			throw new Exception();
		}
		this.setor_de_atuacao = setor_de_atuacao;
	}
	public Double getValor_total_investimento() {
		return valor_total_investimento;
	}
	public void setValor_total_investimento(Double valor_total_investimento) throws Exception{
		if(valor_total_investimento == null){
			throw new Exception();
		}
		this.valor_total_investimento = valor_total_investimento;
	}
	public Date getPrazo_levantamento() {
		return prazo_levantamento;
	}
	public void setPrazo_levantamento(Date prazo_levantamento) throws Exception{
		if(prazo_levantamento == null ){
			throw new Exception();
		}
		this.prazo_levantamento = prazo_levantamento;
	}
	public Double getFaturamento_mensal_estimado() {
		return faturamento_mensal_estimado;
	}
	public void setFaturamento_mensal_estimado(Double faturamento_mensal_estimado) throws Exception{
		if(faturamento_mensal_estimado == null){
			throw new Exception();
		}
		this.faturamento_mensal_estimado = faturamento_mensal_estimado;
	}
	public Double getLucro_mensal_estimado() {
		return lucro_mensal_estimado;
	}
	public void setLucro_mensal_estimado(Double lucro_mensal_estimado) throws Exception{
		if(lucro_mensal_estimado == null){
			throw new Exception();
		}
		this.lucro_mensal_estimado = lucro_mensal_estimado;
	}
	public Date getCarencia_emprestimo() {
		return carencia_emprestimo;
	}
	public void setCarencia_emprestimo(Date carencia_emprestimo) throws Exception{
		if(carencia_emprestimo == null){
			throw new Exception();
		}
		this.carencia_emprestimo = carencia_emprestimo;
	}
	public Date getPrazo_quitacao() {
		return prazo_quitacao;
	}
	public void setPrazo_quitacao(Date prazo_quitacao) throws Exception{
		if(prazo_quitacao == null){
			throw new Exception();
		}
		this.prazo_quitacao = prazo_quitacao;
	}
	public Double getTaxa_juros() {
		return taxa_juros;
	}
	public void setTaxa_juros(Double taxa_juros) throws Exception{
		if(taxa_juros == null){
			throw new Exception();
		}
		this.taxa_juros = taxa_juros;
	}
	public Double getTaxa_iof() {
		return taxa_iof;
	}
	public void setTaxa_iof(Double taxa_iof) throws Exception{
		if(taxa_iof == null){
			throw new Exception();
		}
		this.taxa_iof = taxa_iof;
	}
	public Double getTaxa_remuneracao_investidor() {
		return taxa_remuneracao_investidor;
	}
	public void setTaxa_remuneracao_investidor(Double taxa_remuneracao_investidor) throws Exception{
		if(taxa_remuneracao_investidor == null){
			throw new Exception();
		}
		this.taxa_remuneracao_investidor = taxa_remuneracao_investidor;
	}
	public Double getTaxa_intermediacao() {
		return taxa_intermediacao;
	}
	public void setTaxa_intermediacao(Double taxa_intermediacao) throws Exception{
		if(taxa_intermediacao == null){
			throw new Exception();
		}
		this.taxa_intermediacao = taxa_intermediacao;
	}
	public Boolean getAceita_socio() {
		return aceita_socio;
	}
	public void setAceita_socio(Boolean aceita_socio) throws Exception{
		if(aceita_socio == null){
			throw new Exception();
		}
		this.aceita_socio = aceita_socio;
	}
	public Double getPercentual_ingresso() {
		return percentual_ingresso;
	}
	public void setPercentual_ingresso(Double percentual_ingresso) throws Exception{
		if(percentual_ingresso == null){
			throw new Exception();
		}
		this.percentual_ingresso = percentual_ingresso;
	}
	public Double getPercentual_socio() {
		return percentual_socio;
	}
	public void setPercentual_socio(Double percentual_socio) throws Exception{
		if(percentual_socio == null){
			throw new Exception();
		}
		this.percentual_socio = percentual_socio;
	}
	public int getId_usuario_dono_do_projeto() {
		return id_usuario_dono_do_projeto;
	}
	public void setId_usuario_dono_do_projeto(int id_usuario_dono_do_projeto) {
		this.id_usuario_dono_do_projeto = id_usuario_dono_do_projeto;
	}
	
	
	public Projeto(){}
	
	public Projeto(Map<String,Object> projectData) throws Exception{
		super();
		try{
			this.id_usuario_dono_do_projeto =(Integer) projectData.get("id_usuario_dono_do_projeto");
			this.setId_usuario_dono_do_projeto(id_usuario_dono_do_projeto);
			this.nome =(String) projectData.get("nome");
			this.setNome(nome);
			this.descricao =(String) projectData.get("descricao");
			this.setDescricao(descricao);
			this.url_video_apresentacao =(String) projectData.get("url_video_apresentacao");
			this.setUrl_video_apresentacao(url_video_apresentacao);
			this.setor_de_atuacao =(String) projectData.get("setor_de_atuacao");
			this.setSetor_de_atuacao(setor_de_atuacao);
			this.valor_total_investimento =(Double) projectData.get("valor_total_investimento");
			this.setValor_total_investimento(valor_total_investimento);
			this.prazo_levantamento =(Date) projectData.get("prazo_levantamento");
			this.setPrazo_levantamento(prazo_levantamento);
			this.faturamento_mensal_estimado =(Double) projectData.get("faturamento_mensal_estimado");
			this.setFaturamento_mensal_estimado(faturamento_mensal_estimado);
			this.lucro_mensal_estimado =(Double) projectData.get("lucro_mensal_estimado");
			this.setLucro_mensal_estimado(lucro_mensal_estimado);
			this.carencia_emprestimo =(Date) projectData.get("carencia_emprestimo");
			this.setCarencia_emprestimo(carencia_emprestimo);
			this.prazo_quitacao =(Date) projectData.get("prazo_quitacao");
			this.setPrazo_quitacao(prazo_quitacao);
			this.taxa_juros =(Double) projectData.get("taxa_juros");
			this.setTaxa_juros(taxa_juros);
			this.taxa_iof =(Double) projectData.get("taxa_iof");
			this.setTaxa_iof(taxa_iof);
			this.taxa_remuneracao_investidor =(Double) projectData.get("taxa_remuneracao_investidor");
			this.setTaxa_remuneracao_investidor(taxa_remuneracao_investidor);
			this.taxa_intermediacao =(Double) projectData.get("taxa_intermediacao");
			this.setTaxa_intermediacao(taxa_intermediacao);
			this.aceita_socio =(Boolean) projectData.get("aceita_socio");
			this.setAceita_socio(aceita_socio);
			this.percentual_ingresso =(Double) projectData.get("percentual_ingresso");
			this.setPercentual_ingresso(percentual_ingresso);
			this.percentual_socio =(Double) projectData.get("percentual_socio");
			this.setPercentual_socio(percentual_socio);
		}catch(Exception ex){
			throw ex;
		}
	}
	
	
}
