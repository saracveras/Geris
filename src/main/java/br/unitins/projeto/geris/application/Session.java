package br.unitins.projeto.geris.application;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Session {
private static Session session;
	
	private Session() {
	}
	
	private static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	public static Session getInstance() {
		if (session == null)
			session = new Session();
		return session;
	}
	
	public void put(String key, Object value) {
		getExternalContext().getSessionMap().put(key, value);
	}
	
	public Object get(String key) {
		return getExternalContext().getSessionMap().get(key);
	}
}
