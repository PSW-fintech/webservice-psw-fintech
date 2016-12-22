package controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Projeto;
import repository.ProjetoRepository;

@RestController
@RequestMapping("/project")
public class ProjetoCtrlr {
	ProjetoRepository projectRep = new ProjetoRepository();

	@RequestMapping(value="/criar", method = RequestMethod.POST)
	public String criarProjeto(@RequestBody Map<String,Object> payload){
						
		Projeto proct = null;

		try{
			proct = new Projeto(payload);
		}catch(Exception e){
			return "{\"code\":500,\"type\":\"Erro na passagem de parametros\",\"Message\":\"Nao foi possivel instanciar o Projeto, verifique a passagem de argumentos\"}";
		}finally{
			if(proct != null){
				try{
					this.projectRep.criarNovoProjeto(proct);	
				}catch(Exception e){
					return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel armazenar o Projeto no banco\"}";
				}
				return "{\"code\":200,\"Message\":\"Projeto cadastrado com sucesso\"}";
			}
		}
		return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel criar o Projeto para armazenar no banco\"}";
	}
	

	@RequestMapping(value="/todosOsProjetos",method= RequestMethod.POST )
	public String todosOsProjetos(@RequestBody Map<String,Object> payload){
	
		try{
			List<Projeto> projetos = this.projectRep.recuperarTodosOsProjetos();
			String projetosJSON = "";
			for(Projeto proct : projetos){
				projetosJSON += proct.jsonString();
			}
			return "{\"response\":{\"code\":200,\"Message\":\"Projetos buscados com sucesso com sucesso\"},\"projetos\":[" + projetosJSON + "]}";
		}catch(Exception e){
			return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"O banco recusou a consulta aos Projetos\"}";
		}
		
	}
	
	
}
