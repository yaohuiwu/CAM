package org.cam.web;

import org.cam.core.impl.ThreadLocalUserContext;
import org.cam.core.domain.User;
import org.cam.core.domain.UserImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public abstract class WebUserContextProvider extends ThreadLocalUserContext implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(WebUserContextProvider.class);

        @Override
    public User getCurrentUser() {
        User user = getThreadUser();
        //如果当前线程没有绑定用户，则认为是匿名用户
        return user!= null ? user : UserImpl.ANONYMOUS_USER;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        ServletContext servletContext = req.getSession().getServletContext();
        User user = getUser(req);
        setThreadUser(user);

        chain.doFilter(request, response);

        removeThreadUser();
    }

    @Override
    public void destroy() {
    }

    /**
     * Wrapper method that will handle any runtime exception.
     *
     * @param request current request.
     * @return null if no user found for current request or any runtime exception occurs.
     */
    private User wrapGetUser(final HttpServletRequest request){
        User user = null;
        try{
            user = getUser(request);
        }catch (RuntimeException e){
            LOG.debug("No user found for current request : {}",request);
            return null ;
        }
        return user ;
    }



    protected abstract User getUser(final HttpServletRequest request) throws RuntimeException;
}
