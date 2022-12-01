package br.unitins.projeto.geris.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.unitins.projeto.geris.application.RepositoryException;
import br.unitins.projeto.geris.model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {

	public List<Usuario> buscarTodos() {
		Query query = getEntityManager().createQuery("SELECT u FROM Usuario u");
		return query.getResultList();
	}

	public Usuario buscar(String email, String senha) throws RepositoryException {

		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT ");
		jpql.append("  u ");
		jpql.append("FROM ");
		jpql.append("  Usuario u ");
		jpql.append("WHERE ");
		jpql.append("  u.email = :pEmail AND ");
		jpql.append("  u.senha = :pSenha ");

		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("pEmail", email);
		query.setParameter("pSenha", senha);

		try {
			return (Usuario) query.getSingleResult();
		} catch (NoResultException e) {
			throw new RepositoryException("Email ou senha Inv�lido");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
