<form role="form" action="${linkTo[UserController].update(user.id)}" method="post">
	<input type="hidden" name="_method" value="put"/>
	<input type="hidden" name="user.id" value="${user.id}"/>
	<jsp:include page="./form.jsp"></jsp:include>
</form>