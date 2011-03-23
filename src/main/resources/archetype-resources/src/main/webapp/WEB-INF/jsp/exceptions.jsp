<%@ include file="/WEB-INF/jsp/include.jsp" %>
<portlet:defineObjects/>
	
<h1><spring:message code="portlet.exceptions.title"/></h1>

<p>Locale: [${renderRequest.locale}]</p>

<p><spring:message code="portlet.exceptions.message"/></p>
<ul>
	<c:forEach items="${model.exceptions}" var="exName">
		<li><a href="<portlet:renderURL>
				<portlet:param name="throw" value="${exName}"/>
			</portlet:renderURL>">${exName}</a></li>
	</c:forEach>
</ul>

<p>You can also cause an exception in this portlet by switching to edit or help mode
because no handler has been mapped for those modes, even though they are declared as
valid in the portlet.xml file.<p>

<p>Here is an <a href="<portlet:actionURL/>">ActionURL</a> for an
AbstractController that does not implement the action phase.  This will both 
test the default implementation of handleActionRequestInternal (which should
throw an exception) and the DispatcherPortlet facility for forwarding an 
exception during the action phase to the render phase.</p>
