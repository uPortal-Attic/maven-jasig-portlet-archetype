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
 * EditController renders the editing interface and persists user selections
 * to the portlet's preferences.
 */
@Controller
@RequestMapping("EDIT")
public class EditController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @RenderMapping
    public ModelAndView showMainView(
            final RenderRequest request, final RenderResponse response) {

        final ModelAndView mav = new ModelAndView("edit");
        return mav;

    }

    @ActionMapping
    public void editPreferences() {
    }

}
