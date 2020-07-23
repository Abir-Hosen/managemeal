
		<a ui-sref="home">Home</a>
		<a href="${contextRoot }/signup">Manager Registration</a>
		<a href="${contextRoot }/login">User Login</a>
		<security:authorize access="isAuthenticated()">
			<a href="${contextRoot }/logout">Logout</a>
		</security:authorize>

