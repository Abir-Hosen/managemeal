<div ng-controller="adminCtrl">

	<div class="header">
		<%@ include file="view/header.jsp"%>
	</div>
	
	<div class="navbar">
		<%@ include file="view/nav.jsp"%>
	</div>
	
	<div class="row">
		<div class="column" style="position: -webkit-sticky; position: sticky; z-index: 1; top: 50px;" flex="100">
			<md-progress-linear md-mode="indeterminate" ng-show="showProgressBar"></md-progress-linear>
		</div>
		<div class="side">
			<%@ include file="view/sidenav.jsp"%>
		</div>
		<div class="main">
			<div ui-view = "main"></div>
			<div class="footer">
				<%@ include file="view/footer.jsp"%>
				<h2>Footer</h2>
			</div>
		</div>
	</div>
	
</div>