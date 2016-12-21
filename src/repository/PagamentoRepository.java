package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pagamento;


public class PagamentoRepository  {
	EntityManagerFactory emf;
	EntityManager em;
	
	public PagamentoRepository(){
		emf = Persistence.createEntityManagerFactory("fintech-PSW-MySQL");
		em = emf.createEntityManager();
	}
	
	public void criarNovoPagamento(Pagamento pagamento) throws Exception{
		try{
			em.getTransaction().begin();
			em.merge(pagamento);
			em.getTransaction().commit();
		}catch(Exception e){
			throw e;
		}
	}
	
	public Pagamento recuperarProjetoPorID(int idPagamento) throws Exception{
		try{
			em.getTransaction().begin();
			Pagamento pagamento = em.find(Pagamento.class, idPagamento);
			em.getTransaction().commit();
			return pagamento;		
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public List<Pagamento> recuperarTodosOsPagamentos() throws Exception{
		List<Pagamento> Pagamentos;
		try{
			em.getTransaction().begin();
			Pagamentos = (List<Pagamento>) em.createQuery("SELECT pagamentos FROM Pagamento pagamentos")
					.getResultList();
			em.getTransaction().commit();
		}catch(Exception e){
			throw e;
		}
		return Pagamentos;
	}
	
	
	
}
