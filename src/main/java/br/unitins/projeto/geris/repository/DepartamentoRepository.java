package br.unitins.projeto.geris.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.projeto.geris.model.Departamento;

public class DepartamentoRepository extends Repository<Departamento>{
	public Departamento buscarPeloId(Integer id) {
		return getEntityManager().find(Departamento.class, id);
	}
	public List<Departamento> buscarTodos() {
		Query query = getEntityManager().createQuery("SELECT d FROM Departamento d");
		return query.getResultList();
	}
}
