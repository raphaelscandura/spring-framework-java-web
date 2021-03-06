package br.com.scandura.gerenciador.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class NovaEmpresaServlet
 */

@WebServlet(urlPatterns = "/create-empresa")
public class NovaEmpresaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!request.getParameter("nome").equals("")){
            Empresa novaEmpresa = new Empresa(request.getParameter("nome"));
            BancoDeDados banco = new BancoDeDados();
            banco.adicionaEmpresa(novaEmpresa);
            response.sendRedirect("read-empresas");
        }else{
            throw new ServletException("É necessário fornecer o nome da empresa que será cadastrada!");
        }
    }
}
