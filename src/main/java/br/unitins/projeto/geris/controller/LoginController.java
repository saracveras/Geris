package br.unitins.projeto.geris.controller;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.unitins.projeto.geris.application.RepositoryException;
import br.unitins.projeto.geris.application.Util;
import br.unitins.projeto.geris.model.Usuario;
import br.unitins.projeto.geris.repository.UsuarioRepository;


@Named
@RequestScoped
public class LoginController {
private Usuario usuario;
	
	public String logar() {
		
		UsuarioRepository repo = new UsuarioRepository();
		
		Usuario usuarioLogado;
		try {
			usuarioLogado = repo.buscar(getUsuario().getEmail(), getUsuario().getSenha());
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
			return null;
		}
		
		Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("usuarioLogado", usuarioLogado);
		
		return "home.xhtml?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
