<ul class="nav nav-pills" role="tablist">
	<li role="presentation"${info.controller eq UserController ? ' class="active"' : ''}>
		<a href="${linkTo[UserController].index()}">User</a>
	</li>
	<li role="presentation"${info.controller eq ContentController ? ' class="active"' : ''}>
		<a href="${linkTo[ContentController].index()}">Content</a>
	</li>
	<li role="presentation"><a href="#">Groups</a></li>
</ul>