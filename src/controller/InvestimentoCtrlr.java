package controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Investimento;
import repository.InvestimentoRepository;

@RestController
@RequestMapping("/investment")
public class InvestimentoCtrlr {
	InvestimentoRepository investmentRep = new InvestimentoRepository();

	@RequestMapping(value="/criar", method = RequestMethod.POST)
	public String criarInvestimento(@RequestBody Map<String,Object> payload){
						
		Investimento proct = null;

		try{
			proct = new Investimento(payload);
		}catch(Exception e){
			return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel instanciar o investimento, verifique a passagem de argumentos\"}";
		}finally{
			if(proct != null){
				try{
					this.investmentRep.criarNovoInvestimento(proct);	
				}catch(Exception e){
					return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel armazenar o investimento no banco\"}";
				}
				return "{\"code\":200,\"Message\":\"Usuario cadastrado com sucesso\"}";
			}
		}
		return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel criar o investimento para armazenar no banco\"}";
	}
	

	@RequestMapping(value="/todosOsInvestimentos",method= RequestMethod.POST )
	public String todosOsInvestimentos(@RequestBody Map<String,Object> payload){
	
		try{
			List<Investimento> Investimentos = this.investmentRep.recuperarTodosOsInvestimentos();
			String InvestimentosJSON = "";
			Integer max = Investimentos.size();
			Integer i = 0;
			for(Investimento proct : Investimentos){
				i++;
				InvestimentosJSON += proct.jsonString() + (i<max ? ",":"");
			}
			return "{\"response\":{\"code\":200,\"Message\":\"Investimentos buscados com sucesso com sucesso\"},\"Investimentos\":[" + InvestimentosJSON + "]}";
		}catch(Exception e){
			return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"O banco recusou a consulta aos investimentos\"}";
		}
		
	}
	
	
}
