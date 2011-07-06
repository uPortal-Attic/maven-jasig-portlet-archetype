package ${package}.mvc.portlet;

import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 * HelpController is a simple controller that displays the help interface
 */
@Controller
@RequestMapping("HELP")
public class HelpController {

    protected final Log logger = LogFactory.getLog(getClass());

    /**
     * Returns the help view.  The help view is a very simple JSP, so we don't
     * both returning a model.
     * 
     * @param request
     * @param response
     * @return
     */
    @RenderMapping
    public String showHelpView(final RenderRequest request, final RenderResponse response) {
        return "help";
    }

    @ActionMapping
    public void doAction() {
        // no-op action mapping to prevent accidental calls to this URL from
        // crashing the portlet
    }

}
