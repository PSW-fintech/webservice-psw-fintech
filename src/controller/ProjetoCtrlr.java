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
			return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel instanciar a pessoa juridica, verifique a passagem de argumentos\"}";
		}
		
		if(proct != null){
			try{
				this.projectRep.criarNovoProjeto(proct);	
			}catch(Exception e){
				return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel armazenar o usuario no banco\"}";
			}
			return "{\"code\":200,\"Message\":\"Usuario cadastrado com sucesso\"}";
		}else{
			return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel criar o usuario para armazenar no banco\"}";
		}

	}
	

	@RequestMapping(value="/todosOsProjetos",method= RequestMethod.POST )
	public String todosOsProjetos(@RequestBody Map<String,Object> payload){
	
		try{
			List<Projeto> projetos = this.projectRep.recuperarTodosOsProjetos();
			String projetosJSON = "";
			for(Projeto proct : projetos){
				projetosJSON += proct.jsonProject();
			}
			return "{\"response\":{\"code\":200,\"Message\":\"Projetos buscados com sucesso com sucesso\"},\"projetos\":[" + projetosJSON + "]}";
		}catch(Exception e){
			return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel armazenar o usuario no banco\"}";
		}
		
	}
	
	
}
