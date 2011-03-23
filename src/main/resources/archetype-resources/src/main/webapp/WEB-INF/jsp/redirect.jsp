<%@ include file="/WEB-INF/jsp/include.jsp" %>

<h1>Enter a URL for Redirection</h1>

<form method="post" action="<portlet:actionURL/>">
	<table border="0" cellpadding="4">
		<tr>
			<th>URL</th>
			<td><html:input path="redirect.url" size="30" maxlength="80"/></td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="submit">Go</button>
			</th>
		</tr>
	</table>
</form>

<spring:hasBindErrors name="redirect">
	<p style="color:#A00000">Please fix all errors!</p>
</spring:hasBindErrors>

<p style="text-align:center;"><a href="<portlet:renderURL portletMode="view"/>">- <spring:message code="button.home"/> -</a></p>
