
<div ng-include src="header.jsp"></div>
<%
	if (request.getRemoteUser() == null) {
%>
<!-- Not Logged In -->


<form class="form-horizontal" action="j_security_check" method=post>
	<fieldset>
		<legend>
			Login to your Account
			<div id="messages" ng-show="message">{{ message }}</div>
		</legend>
		<div class="control-group">
			<label class="control-label" for="j_username">User Name</label>
			<div class="controls">
				<input class="input-xlarge" type="text" name="j_username"
					ng-model="j_username" required ng-trim="false" />
				<p class="help-block"></p>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="j_password">Password</label>
			<div class="controls">
				<input class="input-xlarge" type="text" name="j_password"
					ng-model="j_password" required ng-trim="false" />
				<p class="help-block"></p>
			</div>
		</div>

		<div class="form-actions">
			<input type="submit" value="Submit">
			 <input type="reset"
				value="Reset">
		</div>
		<a href="#/registerUser">Register For An Account</a>
	</fieldset>

</form>

<%
	} else {
%>
<!--  Redirect to index.html-->
<%
	}
%>
<div ng-include src="footer.jsp"></div>

