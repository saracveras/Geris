package br.unitins.projeto.geris.controller;

import java.io.Serializable;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.projeto.geris.model.Usuario;

@Named
@ViewScoped
public class HomeController implements Serializable{

	
	public Usuario getUsuarioLogado() {
		Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//Testando
		return (Usuario) session.get("usuarioLogado");
	}
	
	public void encerrarSessao() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return;
	}
}
