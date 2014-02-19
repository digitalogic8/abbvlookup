
<div ng-include src="'header.jsp'"></div>
<!-- Main component for a primary marketing message or call to action -->

	<form class="form-horizontal" name="registerUserForm"
		ng-controller="registerUserCtrl">

		<fieldset>
			<legend>
				Register for an Account
				<div id="messages" ng-show="message">{{ message }}</div>
			</legend>
			<div class="control-group">
				<label class="control-label" for="user.username">User Name</label>
				<div class="controls">
					<input class="input-xlarge" type="text" name="user.username"
						ng-model="user.username" required ng-trim="false" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="user.password">Password</label>
				<div class="controls">
					<input class="input-xlarge" type="text" name="user.password"
						ng-model="user.password" required ng-trim="false" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="user.cpassword">Confirm
					Password</label>
				<div class="controls">
					<input class="input-xlarge" type="text" name="user.cpassword"
						ng-model="user.cpassword" required ng-trim="false" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="user.email">E-Mail Address</label>
				<div class="controls">
					<input class="input-xlarge" type="text" name="user.email"
						ng-model="user.email" required ng-trim="false" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="user.firstname">First Name</label>
				<div class="controls">
					<input class="input-xlarge" type="text" name="user.firstname"
						ng-model="user.firstname" required ng-trim="false" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="user.lastname">Last Name</label>
				<div class="controls">
					<input class="input-xlarge" type="text" name="user.lastname"
						ng-model="user.lastname" required ng-trim="false" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="user.phonenumber">Phone
					Number</label>
				<div class="controls">
					<input class="input-xlarge" type="text" name="user.phonenumber"
						ng-model="user.phonenumber" required ng-trim="false" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="user.company">Company</label>
				<div class="controls">
					<input class="input-xlarge" type="text" name="user.company"
						ng-model="user.company" required ng-trim="false" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="form-actions">
				<button ng-click="reset()">Reset</button>
				<button ng-click="registerUser(user)">Register</button>
			</div>
		</fieldset>

	</form>

<div ng-include src="footer.jsp"></div>