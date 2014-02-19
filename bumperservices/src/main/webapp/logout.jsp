<%@ page session="true"%>

User '<%=request.getRemoteUser()%>' has been logged out.

<% session.invalidate(); %>

<html>
<head>
<script language="javascript" type="text/javascript">
window.location.href="index.jsp";
</script>

</head>
</html>