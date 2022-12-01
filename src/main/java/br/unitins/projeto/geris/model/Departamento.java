package br.unitins.projeto.geris.model;

import javax.persistence.Entity;


@Entity
public class Departamento extends GerisEntity{
	
	private String nome;
	private String descricao;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
