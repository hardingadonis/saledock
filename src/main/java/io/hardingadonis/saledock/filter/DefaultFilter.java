package io.hardingadonis.saledock.filter;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebFilter(filterName = "DefaultFilter", urlPatterns = {"/*"})
public class DefaultFilter implements Filter {

    public DefaultFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//
//        String url = req.getServletPath();
//
//        if (url.equals("/") || url.contains(".jsp")) {
//            HttpSession session = req.getSession();
//
//            if (session.getAttribute("employee") != null) {
//                res.sendRedirect(req.getContextPath() + "/dashboard");
//                
//                return;
//            }
//
//            res.sendRedirect(req.getContextPath() + "/login");
//        } else {
//            chain.doFilter(request, response);
//        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }
}
