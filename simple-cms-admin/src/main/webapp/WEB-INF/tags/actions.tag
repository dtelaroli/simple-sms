<%@ taglib tagdir="/WEB-INF/tags" prefix="cms"%>
<%@ attribute name="editAction" required="true"%>
<%@ attribute name="removeAction" required="true" %>
<%@ attribute name="object" required="true" type="java.lang.Object"%>

<form action="${removeAction}" method="post" id="formDelete${object.id}">
	<input type="hidden" name="_method" value="delete"/>
	<div class="btn-group">
		<a href="${editAction}" type="button"
			class="btn btn-default btn-xs">
			<span class="glyphicon glyphicon-edit"></span>
		</a>
		<button class="btn btn-default btn-xs" name="_method" value="delete" data-toggle="modal"
			data-target="#confirm${object.id}" type="button">
			<span class="glyphicon glyphicon-remove"></span>
		</button>
	</div>
	<cms:confirm title="${t['action.delete']} ${t[object['class']['simpleName']]} #${object.id}" msg="${t['action.confirm.message']}" id="confirm${object.id}">
		<button type="button" class="btn btn-danger" onclick="$('#formDelete${object.id}').submit()">${t['action.delete']}</button>
	</cms:confirm>
</form>