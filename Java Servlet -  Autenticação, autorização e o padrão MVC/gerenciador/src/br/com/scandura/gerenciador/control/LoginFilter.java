package br.com.scandura.gerenciador.control;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/control")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String paramAction = request.getParameter("action");
        HttpSession sessao = request.getSession();
        if(!paramAction.equals("form-login") &&  !paramAction.equals("login-usuario") && sessao.getAttribute("usuarioLogado") == null){
            request.setAttribute("action", "form-login");
        }else{
            request.setAttribute("action", paramAction);
        }
        filterChain.doFilter(request, response);
    }
}
