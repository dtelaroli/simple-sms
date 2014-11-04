package org.dtelaroli.cms.backend.controller;

import static br.com.caelum.vraptor.actions.api.Acts.persist;
import static br.com.caelum.vraptor.view.Results.json;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.dtelaroli.cms.domain.model.Category;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.actions.api.Act;

@Controller
public class CategoryController {

	private final Act act;

	/**
	 * @deprecated CDI eyes-only
	 */
	protected CategoryController() {
		this(null);
	}
	
	@Inject
	public CategoryController(Act act) {
		this.act = act;
	}

	@Post @Consumes("application/json")
	public void save(@NotNull @Valid Category category) {
		act.validator().onErrorSendBadRequest();
		Category saved = act.as(persist()).save(category).andReturn();
		act.result().use(json()).withoutRoot().from(saved).serialize();
	}

}
