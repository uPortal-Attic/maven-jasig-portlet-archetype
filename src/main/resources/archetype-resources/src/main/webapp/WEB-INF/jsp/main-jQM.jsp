<jsp:directive.include file="/WEB-INF/jsp/include.jsp"/>

<h1>Hello ${ fn:escapeXml(displayName) }!</h1>

<p>Your email address is ${ fn:escapeXml(emailAddress) }</p>

