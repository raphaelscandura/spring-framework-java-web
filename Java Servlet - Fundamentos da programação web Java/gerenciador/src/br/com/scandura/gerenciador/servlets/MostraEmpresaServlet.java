package br.com.scandura.gerenciador.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/show-empresa")
public class MostraEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramId = request.getParameter("id");
        int id = Integer.parseInt(paramId);
        BancoDeDados banco = new BancoDeDados();
        request.setAttribute("empresa", banco.getEmpresa(id));
        RequestDispatcher rd = request.getRequestDispatcher("/edita-empresa-form.jsp");
        rd.forward(request, response);
    }
}
