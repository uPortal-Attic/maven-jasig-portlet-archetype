package ${package}.mvc;

import javax.portlet.PortletRequest;

public interface IViewSelector {

    public boolean isMobile(PortletRequest request);

}
