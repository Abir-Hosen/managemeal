<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/css" />
<spring:url var="js" value="/js" />
<spring:url var="img" value="/images" />
<spring:url var="tmp" value="/templates" />
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta http-equiv="refresh" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="An Film Production based project">
<meta name="author" content="Abir Hosen">

<title>${title }</title>

<!--##########@@############ Angular JS ####################################################################-->
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.12/angular-material.min.css">
<!-- Angular Material requires Angular.js Libraries -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular-animate.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular-aria.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular-messages.min.js"></script>
<!-- Angular Resource Library -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.6/angular-resource.js"></script>
<!-- Angular Material Library -->
<script src="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.12/angular-material.min.js"></script>
<!-- Angular UI Router Library -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/1.0.25/angular-ui-router.min.js"></script>
<!--##########@@############ Angular JS Finished ###########################################################-->

<!--##########@@############ CSS Icon Library ##############################################################-->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- <script src="https://kit.fontawesome.com/a076d05399.js"></script> -->
<!--##########@@############ CSS Icon Library Finished #####################################################-->

<!--##########@@############ Self CSS and JS Library #######################################################-->
<script type="text/javascript">
	window.id = '${id}';
</script>
<link href="${css}/myapp.css" rel="stylesheet">
<link href="${css}/multimedia.css" rel="stylesheet">
<script src="${js}/style.js"></script>
<script src="${js}/myapp.js"></script>
<script src="${js}/state.js"></script>
<!--##########@@############ Self CSS and JS Library Finished ##############################################-->

<link rel="icon" href="${img}/favicon.png" />
</head>

<body ng-app="myApp">

	<c:if test="${userClickAdmin==true }">
		<%@ include file="pages/admin.jsp"%>
	</c:if>

	<c:if test="${userClickManager==true }">
		<%@ include file="pages/manage.jsp"%>
	</c:if>

	<c:if test="${userClickMember==true }">
		<%@ include file="pages/member.jsp"%>
	</c:if>

	<c:if test="${userClickUser==true }">
		<%@ include file="pages/user.jsp"%>
	</c:if>

	<c:if test="${userClickAnonymous==true }">
		<%@ include file="pages/anonymous.jsp"%>
	</c:if>

	<c:if test="${userClickLogin==true }">
		<%@ include file="login.jsp"%>
	</c:if>

	<c:if test="${userClickSignUp==true }">
		<%@ include file="signup.jsp"%>
	</c:if>
	
</body>
</html>
