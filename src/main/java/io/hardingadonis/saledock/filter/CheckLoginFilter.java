package io.hardingadonis.saledock.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;

public class CheckLoginFilter implements Filter {

  public CheckLoginFilter() {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest)request;
    HttpServletResponse res = (HttpServletResponse)response;

    //        var session = req.getSession();
    //
    //        if (session.getAttribute("employee") == null) {
    //            res.sendRedirect(req.getContextPath() + "/login");
    //        } else {
    chain.doFilter(request, response);
    //        }
  }

  @Override
  public void destroy() {}

  @Override
  public void init(FilterConfig filterConfig) {}
}
