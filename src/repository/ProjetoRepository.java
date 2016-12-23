package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Projeto;
import model.Usuario;


public class ProjetoRepository {
	EntityManagerFactory emf;
	EntityManager em;
	
	public ProjetoRepository(){
		emf = Persistence.createEntityManagerFactory("fintech-PSW-MySQL");
		em = emf.createEntityManager();
	}
	
	public void criarNovoProjeto(Projeto project) throws Exception{
		try{

			if( !em.getTransaction().isActive() ){
				em.getTransaction().begin();
			}
			em.merge(project);

			if( em.getTransaction().isActive() ){
				em.getTransaction().commit();
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public Projeto recuperarProjetoPorID(int idProjeto) throws Exception{
		try{

			if( !em.getTransaction().isActive() ){
				em.getTransaction().begin();
			}
			Projeto project = em.find(Projeto.class, idProjeto);

			if( em.getTransaction().isActive() ){
				em.getTransaction().commit();
			}
			return project;		
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public List<Projeto> recuperarTodosOsProjetos() throws Exception{
		List<Projeto> projetos;
		try{

			if( !em.getTransaction().isActive() ){
				em.getTransaction().begin();
			}
			projetos = (List<Projeto>) em.createQuery("SELECT project FROM Projeto project")
					.getResultList();

			if( em.getTransaction().isActive() ){
				em.getTransaction().commit();
			}
		}catch(Exception e){
			throw e;
		}
		return projetos;
	}
	
	
	
}
