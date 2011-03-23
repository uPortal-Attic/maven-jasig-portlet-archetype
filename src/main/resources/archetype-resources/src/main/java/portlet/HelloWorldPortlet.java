package ${packageName}.portlet;

import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

/**
 * A simple uPortal specific portlet shell
 *
 */
public class HelloWorldPortlet extends AbstractController {

    /**
     * private Commons Logger.
     */
    private final Log logger = LogFactory.getLog(getClass());

    @SuppressWarnings("unchecked")
    @Override
    public final ModelAndView handleRenderRequestInternal(
            final RenderRequest request, final RenderResponse response)
        throws Exception {

        if(logger.isDebugEnabled()) {
            logger.debug("Inside of HelloWorldPortlet controller.");
        }
        String firstname = "";
        String lastname  = "";
        try {
            //Get the USER_INFO from portlet.xml,
            //which gets it from personDirectoryContext.xml
            Map<String,String> userInfo = (Map<String,String>) request.
                    getAttribute(PortletRequest.USER_INFO);

            firstname = (String)userInfo.get("user.name.given");
            lastname  = (String)userInfo.get("user.name.family");
            if(logger.isDebugEnabled()) {
                logger.debug("Hello '" + firstname + " " + lastname + "'");
            }
        } catch (Exception e) {
            logger.error("error occured: " + e.getMessage());
            e.printStackTrace();
        }

        ModelAndView mav = new ModelAndView("helloWorld");
        mav.addObject("firstname", firstname);
        mav.addObject("lastname", lastname);
        return mav;

    }

}
