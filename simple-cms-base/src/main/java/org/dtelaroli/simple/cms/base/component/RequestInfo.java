package org.dtelaroli.simple.cms.base.component;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

import br.com.caelum.vraptor.controller.BeanClass;
import br.com.caelum.vraptor.events.ControllerFound;

@Named("info")
@ApplicationScoped
public class RequestInfo {

	private BeanClass controller;
	private String action;

	public RequestInfo() {
	}
	
	public void includes(@Observes ControllerFound controllerFound) {
		controller = controllerFound.getController();
		action = controllerFound.getMethod().getMethod().getName();
	}
	
	public BeanClass getController() {
		return controller;
	}

	public void setController(BeanClass controller) {
		this.controller = controller;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}