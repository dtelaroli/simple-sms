package org.dtelaroli.cms.backend.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.dtelaroli.cms.domain.model.User;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.actions.api.db.pagination.Page;
import br.com.caelum.vraptor.actions.api.test.MockAct;
import br.com.caelum.vraptor.util.test.MockResult;

public class UserControllerTest {

	private UserController controller;
	private MockAct act;
	private User user;
	private Result result;
	private Class<?> c = UserController.class;
	
	@Before
	public void setUp() throws Exception {
		user = new User(1L, "Foo");
		result = spy(new MockResult());
		act = new MockAct(result).returning(user);
		controller = new UserController(act);
	}

	@Test
	public void shouldReturnPage() {
		Page<User> paginate = controller.index();
		
		List<User> list = paginate.getList();
		User user = list.get(0);

		assertThat(paginate, instanceOf(Page.class));
		assertThat(paginate.getPageSize(), equalTo(1));
		assertThat(user.getId(), equalTo(1L));
		assertThat(user.getName(), equalTo("Foo"));
	}

	@Test
	public void shouldReturnUserOnEdit() {
		User user = controller.edit(1L);
		
		assertThat(user, notNullValue());
		assertThat(user.getId(), equalTo(1L));
	}
	
	@Test
	public void shouldRedirectOnUpdate() {
		controller.update(user);
		
		verify(result).redirectTo(c);
	}
	
	@Test
	public void shouldRedirectOnInsert() {
		controller.insert(user);
		
		verify(result).redirectTo(c);
	}
	
	@Test
	public void shouldRedirectOnRemove() {
		controller.remove(1L);
		
		verify(result).redirectTo(c);
	}
}
