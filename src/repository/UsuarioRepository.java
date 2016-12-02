package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import model.Usuario;

public class UsuarioRepository {
	EntityManagerFactory emf;
	EntityManager em;
	
	public UsuarioRepository(){
		emf = Persistence.createEntityManagerFactory("fintech-PSW-MySQL");
		em = emf.createEntityManager();
	}
	
	public void cadastrarNovoUsuario(Usuario newUser) throws Exception{
		try{
			em.getTransaction().begin();
			em.merge(newUser);
			em.getTransaction().commit();
		}catch(Exception e){
			throw e;
		}
	}
	
	public Usuario recuperarUsuarioPorID(int idUsuario) throws Exception{
		try{
			em.getTransaction().begin();
			Usuario user = em.find(Usuario.class, idUsuario);
			em.getTransaction().commit();
			return user;		
		}catch(Exception e){
			throw e;
		}
	}
	
	public Usuario recuperarUsuarioPorNomeESenha(String nome, String senha) throws Exception{
		List<Usuario> usuarios;
		try{
			em.getTransaction().begin();
			usuarios = (List<Usuario>) em.createQuery("SELECT user FROM Usuario user WHERE user.nome_do_usuario LIKE :userName AND user.senha_para_acesso LIKE :userPass")
					.setParameter("userName", nome)
					.setParameter("userPass", senha)
					.getResultList();
			em.getTransaction().commit();
		}catch(Exception e){
			throw e;
		}

		if(usuarios != null && usuarios.size() == 1){
			return usuarios.get(0);		
		}else{
			return null;
		}
	}
	
	
}
