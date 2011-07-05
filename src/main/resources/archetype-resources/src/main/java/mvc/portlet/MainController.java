package ${packageName}.mvc.portlet;

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
 * Main portlet view.
 */
@Controller
@RequestMapping("VIEW")
public class MainController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @RenderMapping
    public ModelAndView showMainView(
            final RenderRequest request, final RenderResponse response) {

        if(logger.isDebugEnabled()) {
            logger.debug("Gathering user info for main view");
        }

        //Get the USER_INFO from portlet.xml,
        //which gets it from personDirectoryContext.xml
        final Map<String,String> userInfo = (Map<String,String>) request.
                getAttribute(PortletRequest.USER_INFO);
        
        final String username = request.getRemoteUser();
        final String displayName = userInfo.get("displayName");

        if(logger.isDebugEnabled()) {
            logger.debug("Rendering main view for user '" + displayName + " (" + username + ")'");
        }

        final ModelAndView mav = new ModelAndView("main");
        mav.addObject("displayName", displayName);
        mav.addObject("username", username);
        return mav;

    }

    @ActionMapping
    public void doAction() {
        // no-op action mapping to prevent accidental calls to this URL from
        // crashing the portlet
    }

}
