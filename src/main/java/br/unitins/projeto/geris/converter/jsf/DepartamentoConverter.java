package br.unitins.projeto.geris.converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.unitins.projeto.geris.model.Departamento;
import br.unitins.projeto.geris.repository.DepartamentoRepository;

@Named
@FacesConverter(forClass = Departamento.class)
public class DepartamentoConverter implements Converter<Departamento>{

	@Override
	public Departamento getAsObject(FacesContext context, UIComponent component, String id) {
		if (id == null || id.isBlank())
			return null;
		DepartamentoRepository departamento = new DepartamentoRepository();
		return departamento.buscarPeloId(Integer.valueOf(id));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Departamento departamento) {
		if(departamento == null || departamento.getId() == null)
			return null;
		return departamento.getId().toString();
	}

}
