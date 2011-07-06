<jsp:directive.include file="/WEB-INF/jsp/include.jsp"/>

<h1>Help</h1>

<p>Instructions go here</p>

<portlet:renderURL var="viewUrl" portletMode="view"/>
<p><a href="${ viewUrl }">Back</a></p>
