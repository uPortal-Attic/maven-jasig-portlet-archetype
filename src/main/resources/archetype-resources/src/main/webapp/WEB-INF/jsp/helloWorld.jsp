<%@ include file="/WEB-INF/jsp/include.jsp" %>

<h1>Hello World</h1>

<p>This portlet is a Hello World Spring JSR 168 Starter Shell</p>

<table border="0" cellpadding="4">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <tr>
        <td><c:out value="${firstname}" /></td>
        <td><c:out value="${lastname}" /></td>
    </tr>
</table>