package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWTSigner;

import repository.ProjetoRepository;
import model.Projeto;

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
				this.userRep.cadastrarNovoUsuario(proct);	
			}catch(Exception e){
				return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel armazenar o usuario no banco\"}";
			}
			return "{\"code\":200,\"Message\":\"Usuario cadastrado com sucesso\"}";
		}	
		return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel criar o usuario para armazenar no banco\"}";

	}
	

	@RequestMapping(value="/todosOsProjetos",method= RequestMethod.POST )
	public String todosOsProjetos(@RequestBody Map<String,Object> payload){
		String user_type = (String) payload.get("user_type");
		Usuario user = null;
		if(user_type == null){
			return "{\"Missing Parameter\":\"user_type\"}";
		}else if(user_type.equals("pessoa_fisica")){
			try{
				user = new PessoaFisica(payload);
			}catch(Exception e){
				return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel instanciar a pessoa juridica, verifique a passagem de argumentos\"}";
			}
		}else if(user_type.equals("pessoa_juridica")){
			try{
				user = new PessoaJuridica(payload);
			}catch(Exception e){
				return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel instanciar a pessoa juridica, verifique a passagem de argumentos\"}";
			}
		}else if(user_type.equals("pessoa_fisica") && !user_type.equals("pessoa_juridica")){
			return "{\"Wrong argument\":\"O PARAMETRO user_type DEVE SER 'pessoa_fisica' OU 'pessoa_juridica', E NAO '" + user_type +"'\"}";
		}
		
		if(user != null){
			try{
				this.userRep.cadastrarNovoUsuario(user);	
			}catch(Exception e){
				return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel armazenar o usuario no banco\"}";
			}
			return "{\"code\":200,\"Message\":\"Usuario cadastrado com sucesso\"}";
		}	
		return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel criar o usuario para armazenar no banco\"}";
	}
	
	@RequestMapping(value="/projetosDoUsuario",method= RequestMethod.POST )
	public String projetosDoUsuario(@RequestBody Map<String,Object> payload){
		String user_type = (String) payload.get("user_type");
		Usuario user = null;
		if(user_type == null){
			return "{\"Missing Parameter\":\"user_type\"}";
		}else if(user_type.equals("pessoa_fisica")){
			try{
				user = new PessoaFisica(payload);
			}catch(Exception e){
				return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel instanciar a pessoa juridica, verifique a passagem de argumentos\"}";
			}
		}else if(user_type.equals("pessoa_juridica")){
			try{
				user = new PessoaJuridica(payload);
			}catch(Exception e){
				return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel instanciar a pessoa juridica, verifique a passagem de argumentos\"}";
			}
		}else if(user_type.equals("pessoa_fisica") && !user_type.equals("pessoa_juridica")){
			return "{\"Wrong argument\":\"O PARAMETRO user_type DEVE SER 'pessoa_fisica' OU 'pessoa_juridica', E NAO '" + user_type +"'\"}";
		}
		
		if(user != null){
			try{
				this.userRep.cadastrarNovoUsuario(user);	
			}catch(Exception e){
				return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel armazenar o usuario no banco\"}";
			}
			return "{\"code\":200,\"Message\":\"Usuario cadastrado com sucesso\"}";
		}	
		return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel criar o usuario para armazenar no banco\"}";
	}
	
}
