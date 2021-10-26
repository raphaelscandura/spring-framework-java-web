package br.com.scandura.gerenciador.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update-empresa")
public class AtualizaEmpresaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!request.getParameter("nome").equals("")){
            String paramId = request.getParameter("id");
            int id = Integer.parseInt(paramId);
            BancoDeDados banco = new BancoDeDados();
            Empresa empresa = banco.getEmpresa(id);
            empresa.setNome(request.getParameter("nome"));
            response.sendRedirect("read-empresas");
        }else{
            throw new ServletException("É necessário fornecer o nome da empresa que será cadastrada!");
        }
    }
}
