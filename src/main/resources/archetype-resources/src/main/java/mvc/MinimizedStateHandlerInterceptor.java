package ${package}.mvc;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.springframework.web.portlet.handler.HandlerInterceptorAdapter;

public class MinimizedStateHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandleRender(RenderRequest request, RenderResponse response, Object handler) throws Exception {
        if (WindowState.MINIMIZED.equals(request.getWindowState())) {
            return false;
        }
        
        return true;
    }
}
