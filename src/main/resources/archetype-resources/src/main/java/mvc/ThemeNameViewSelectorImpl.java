package ${package}.mvc;

import javax.portlet.PortletRequest;
import javax.portlet.WindowState;

public class ThemeNameViewSelectorImpl implements IViewSelector {
    
    protected static final String THEME_NAME_PROPERTY = "themeName";
    protected static final String MOBILE_THEMES_KEY = "mobileThemes";
    protected static final String[] MOBILE_THEMES_DEFAULT = new String[]{ "UniversalityMobile" };

    public boolean isMobile(PortletRequest request) {
        
        String[] mobileThemes = request.getPreferences().getValues(MOBILE_THEMES_KEY, MOBILE_THEMES_DEFAULT);
        String themeName = request.getProperty(THEME_NAME_PROPERTY);
        
        // if no theme name can be found, just assume the request is for a 
        // desktop client
        if (themeName == null) {
            return false;
        }

        // otherwise, determine if the theme name matches one of the known 
        // mobile themes
        for (String theme : mobileThemes) {
            if (themeName.equals(theme)) {
                return true;
            }
        }
        
        return false;
    }

}
