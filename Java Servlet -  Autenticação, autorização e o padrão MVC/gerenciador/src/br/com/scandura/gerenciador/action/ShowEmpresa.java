package br.com.scandura.gerenciador.action;

import br.com.scandura.gerenciador.model.BancoDeDados;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowEmpresa extends HttpServlet {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramId = request.getParameter("id");
        int id = Integer.parseInt(paramId);
        BancoDeDados banco = new BancoDeDados();
        request.setAttribute("empresa", banco.getEmpresa(id));
        RequestDispatcher rd = request.getRequestDispatcher("/edita-empresa-form.jsp");
        rd.forward(request, response);
    }
}
