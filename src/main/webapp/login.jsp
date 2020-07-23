<%-- <form class="form-signin" method="post"	action="${contextRoot}/login">
<br>
<input type="text" id="email" name="email" placeholder="Email"	required autofocus>
<input type="password" id="password" name="password" placeholder="Password" required>
<button type="submit">Sign In</button>
</form>
<br>
<span class="md-subhead">Click and <a href="${contextRoot }/signup">sign up</a> here!</span> --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div ng-controller="loginCtrl">
	<div  layout="column" layout-align="center center" ng-cloak>
		<md-whiteframe style="min-width:480px;" id="tm" class="md-whiteframe-13dp" flex="noshrink"
			layout-align="center center"> <md-content>
		<form class="form-signin" method="post"	action="${contextRoot}/login">
			<md-card> <md-card-header> <md-card-avatar>
			<a href="${contextRoot}/"><img src="${img}/favicon.png" /></a> </md-card-avatar>
			<md-card-header-text> <span class="md-title">Sign
				Up for Meal Manager</span> <c:if test="${empty message}">
				<span class="md-subhead">Author: Jay Ho</span>
			</c:if> <c:if test="${not empty message}">
				<span style="color: #113d70" class="md-subhead"><b>Note:</b>&nbsp;<span
					style="color: #e3710e">${message}</span></span>
			</c:if> </md-card-header-text> </md-card-header> </md-card>
			<md-card> <md-card-content>
			<div layout="row">
				<md-input-container class="md-block" flex="100">
				<input type="text" id="email" name="email" placeholder="Email"	required autofocus>
				</md-input-container>
			</div>
			<div layout="row">
				<md-input-container class="md-block" flex="100">
				<input type="password" id="password" name="password" placeholder="Password" required>
				</md-input-container>
			</div>

			<md-button style="width:99%" type="submit" flex-gt-xs
				class="md-raised md-primary">Submit</md-button> </md-card-content> </md-card>
			<md-card> <md-card-header> <md-card-avatar>
			<img src="${img}/question.png" /> </md-card-avatar> <md-card-header-text>
			<span class="md-title">Not Registered?</span> <span
				class="md-subhead">Click and <a href="${contextRoot }/signup">sign
					up</a> here!
			</span> </md-card-header-text> </md-card-header> </md-card>
		<form> </md-content> </md-whiteframe>
	</div>
</div>

