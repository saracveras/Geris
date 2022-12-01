package br.unitins.projeto.geris.model;

public enum Perfil {
	FUNCIONARIO (1, "Funcionario"),
	ADMINISTRADOR (2, "Administrador"),
	GESTOR (3, "Gestor");
	
	private int id;
	private String label;
	
	private Perfil(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public static Perfil valueOf(Integer id) {
		if (id == null)
			return null;
		
		for(Perfil perfil : Perfil.values())
			if (perfil.getId() == id)
				return perfil;
		return null;
	}
}
