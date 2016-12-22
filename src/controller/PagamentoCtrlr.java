package controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Pagamento;
import repository.PagamentoRepository;

@RestController
@RequestMapping("/payment")
public class PagamentoCtrlr {
	PagamentoRepository paymentRep = new PagamentoRepository();

	@RequestMapping(value="/criar", method = RequestMethod.POST)
	public String criarPagamento(@RequestBody Map<String,Object> payload){
						
		Pagamento paymnt = null;

		try{
			paymnt = new Pagamento(payload);
		}catch(Exception e){
			return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel instanciar a pessoa juridica, verifique a passagem de argumentos\"}";
		}finally{
			if(paymnt != null){
				try{
					this.paymentRep.criarNovoPagamento(paymnt);	
				}catch(Exception e){
					return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel armazenar o pagamento no banco\"}";
				}
				return "{\"code\":200,\"Message\":\"Pagamento cadastrado com sucesso\"}";
			}	
		}
		return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"Nao foi possivel instanciar a pessoa juridica, verifique a passagem de argumentos\"}";
	}
	

	@RequestMapping(value="/todosOsPagamentos",method= RequestMethod.POST )
	public String todosOsPagamentos(@RequestBody Map<String,Object> payload){
	
		try{
			List<Pagamento> Pagamentos = this.paymentRep.recuperarTodosOsPagamentos();
			String PagamentosJSON = "";
			for(Pagamento paymnt : Pagamentos){
				PagamentosJSON += paymnt.jsonString();
			}
			return "{\"response\":{\"code\":200,\"Message\":\"Pagamentos buscados com sucesso com sucesso\"},\"Pagamentos\":[" + PagamentosJSON + "]}";
		}catch(Exception e){
			return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\",\"Message\":\"O banco recusou a consulta aos pagamentos\"}";
		}
		
	}
	
	
}
