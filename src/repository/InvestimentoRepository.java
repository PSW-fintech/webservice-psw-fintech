package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Investimento;


public class InvestimentoRepository  {
	EntityManagerFactory emf;
	EntityManager em;
	
	public InvestimentoRepository(){
		emf = Persistence.createEntityManagerFactory("fintech-PSW-MySQL");
		em = emf.createEntityManager();
	}
	
	public void criarNovoInvestimento(Investimento investimento) throws Exception{
		try{

			if( !em.getTransaction().isActive() ){
				em.getTransaction().begin();
			}
			em.merge(investimento);

			if( em.getTransaction().isActive() ){
				em.getTransaction().commit();
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public Investimento recuperarInvestimentoPorID(int idInvestimento) throws Exception{
		try{

			if( !em.getTransaction().isActive() ){
				em.getTransaction().begin();
			}
			Investimento investimento = em.find(Investimento.class, idInvestimento);

			if( em.getTransaction().isActive() ){
				em.getTransaction().commit();
			}
			return investimento;		
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public List<Investimento> recuperarTodosOsInvestimentos() throws Exception{
		List<Investimento> investimentos;
		try{

			if( !em.getTransaction().isActive() ){
				em.getTransaction().begin();
			}
			investimentos = (List<Investimento>) em.createQuery("SELECT investimentos FROM Investimento investimentos")
					.getResultList();

			if( em.getTransaction().isActive() ){
				em.getTransaction().commit();
			}
		}catch(Exception e){
			throw e;
		}
		return investimentos;
	}
	
	
	
}
