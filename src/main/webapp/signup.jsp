<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div ng-controller="signupCtrl">
	<div layout="column" layout-align="center center" ng-cloak>
		<md-whiteframe style="min-width:480px;" class="md-whiteframe-13dp" flex="noshrink"
			layout-align="center center"> <md-content>
		<sf:form action="${contextRoot }/signup" method="POST"
			modelAttribute="user">
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
				<sf:input path="firstname" placeholder="First Name" type="text" />
				<br>
				<sf:errors path="firstname" cssClass="error" element="em" /> <br>
				</md-input-container>
				<md-input-container class="md-block" flex="100">
				<sf:input path="lastname" placeholder="Last Name" type="text" /> <br>
				<sf:errors path="lastname" cssClass="error" element="em" /> <br>
				</md-input-container>
			</div>
			<div layout="row">
				<md-input-container class="md-block" flex="100">
				<sf:input path="username" placeholder="Username" type="text" /> <br>
				<sf:errors path="username" cssClass="error" element="em" /> <br>
				</md-input-container><%-- 
				<md-input-container class="md-block" flex="100">
				<sf:input path="dateOfBirth" placeholder="Birth Date" type="date" />
				<br>
				<sf:errors path="dateOfBirth" cssClass="error" element="em" /> <br>
				</md-input-container> --%>
			</div>
			<div layout="row">
				<md-input-container class="md-block" flex="100">
				<sf:input path="email" placeholder="Email" type="text" /> <br>
				<sf:errors path="email" cssClass="error" element="em" /> <br>
				</md-input-container>
			</div>
			<div layout="row">
				<md-input-container class="md-block" flex="100">
				<sf:input path="password" placeholder="Password" type="password" />
				<br>
				<sf:errors path="password" cssClass="error" element="em" /> <br>
				</md-input-container>
				<md-input-container class="md-block" flex="100">
				<sf:input path="confirmPassword" placeholder="Confirm password"
					type="password" /> <br>
				<sf:errors path="confirmPassword" cssClass="error" element="em" />
				<br>
				</md-input-container>
			</div>

			<md-button style="width:99%" type="submit" flex-gt-xs
				class="md-raised md-primary">Submit</md-button> </md-card-content> </md-card>
			<md-card> <md-card-header> <md-card-avatar>
			<img src="${img}/question.png" /> </md-card-avatar> <md-card-header-text>
			<span class="md-title">Already Registered?</span> <span
				class="md-subhead">Click and <a href="${contextRoot }/login">sign
					in</a> here!
			</span> </md-card-header-text> </md-card-header> </md-card>
		</sf:form> </md-content> </md-whiteframe>
	</div>
</div>

