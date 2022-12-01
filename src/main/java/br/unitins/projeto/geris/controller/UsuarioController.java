package br.unitins.projeto.geris.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.projeto.geris.application.Util;
import br.unitins.projeto.geris.model.Departamento;
import br.unitins.projeto.geris.model.Perfil;
import br.unitins.projeto.geris.model.Usuario;
import br.unitins.projeto.geris.repository.DepartamentoRepository;
import br.unitins.projeto.geris.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController implements Serializable {
	private static final long serialVersionUID = -3302405539658316990L;

	private Usuario usuario = null;
	private List<Usuario> listaUsuario;
	private List<Departamento> listaDepartamento;
	
	public List<Departamento> getListaDepartamento() {
		if (listaDepartamento == null) { 
			DepartamentoRepository repo = new DepartamentoRepository();
			listaDepartamento = repo.buscarTodos();
		}
		return listaDepartamento;
	}
	
	public Perfil[] getListaPerfil() {
		return Perfil.values();
	}
	
	public void incluir() {
		UsuarioRepository repo = new UsuarioRepository();
		getUsuario().setSenha(Util.hash(getUsuario().getSenha()));
		try {
			repo.salvar(getUsuario());
		} catch (Exception e) {
			Util.addErrorMessage(e.getMessage());
			e.printStackTrace();
			return;
		}
		limpar();

		listaUsuario = null;
	}
	
	public void alterar() {
		UsuarioRepository repo = new UsuarioRepository();
		try {
			repo.salvar(getUsuario());
		} catch (Exception e) {
			Util.addErrorMessage(e.getMessage());
			e.printStackTrace();
			return;
		}
		limpar();
	
		listaUsuario = null;
	}
	

	public void excluir() {
		excluir(getUsuario());
		limpar();	
	}
	
	
	public void excluir(Usuario usu) {
		UsuarioRepository repo = new UsuarioRepository();
		repo.deletar(usu);
		listaUsuario = null;
	}
	
	public void limpar() {
		usuario = null;
	}
	
	public void editar(Usuario usu) {
		setUsuario(usu);
	}
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			UsuarioRepository repo = new UsuarioRepository();
			listaUsuario = repo.buscarTodos();
			if (listaUsuario == null)
				listaUsuario = new ArrayList<Usuario>();
		}
		return listaUsuario;
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
