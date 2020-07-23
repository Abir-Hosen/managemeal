<md-card>
	<md-card-title>
		<md-card-title-text>
			<span class="md-headline">${name}</span>
			<span class="md-subhead">${email}</span>
			<span class="md-subhead">${user.username}</span>
		</md-card-title-text>
		<md-card-title-media>
			<div class="md-media-sm card-media">
				<img style="height:auto; width: 100%;" src="${img}/favicon.png">
			</div>
		</md-card-title-media>
	</md-card-title>
<!-- 	<md-card-actions layout="row" layout-align="end center">
		<md-button ng-click="viewDetails()">View Details</md-button>
		<md-button ng-click="viewTimeline()">Timeline</md-button>
		<md-button ng-click="viewBlog()">Blog</md-button>
	</md-card-actions> -->
</md-card>

<md-card>
	<md-content>
		<md-list flex>
			<md-subheader class="md-no-sticky">Your Navigation</md-subheader>
			<md-list-item class="md-2-line" ng-click="null" ui-sref="meal">
				<md-icon>fact_check</md-icon>
				<div class="md-list-item-text" layout="column">
					<h3>Meal List</h3>
					<p>Create, edit, delete or View your meal!</p>
				</div>
			</md-list-item>
			<md-list-item class="md-2-line" ng-click="null" ui-sref="hostelMember">
				<md-icon>grading</md-icon>
				<div class="md-list-item-text" layout="column">
					<h3>Student List</h3>
					<p>Add, Modify or Remove Members!</p>
				</div>
			</md-list-item>
		</md-list>
	</md-content>
</md-card>

<br>


