package br.com.scandura.gerenciador.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete-empresa")
public class RemoveEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paramId = request.getParameter("id");
        int id = Integer.parseInt(paramId);
        BancoDeDados banco = new BancoDeDados();
        banco.removeEmpresa(id);
        response.sendRedirect("read-empresas");
    }
}
