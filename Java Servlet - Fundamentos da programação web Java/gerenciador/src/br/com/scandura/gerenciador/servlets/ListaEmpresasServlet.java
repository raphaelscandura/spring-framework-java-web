package br.com.scandura.gerenciador.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/lista-empresas")
public class ListaEmpresasServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BancoDeDados banco = new BancoDeDados();
        List<Empresa> listaDeEmpresas = banco.getListaDeEmpresas();
        request.setAttribute("listaDeEmpresas", listaDeEmpresas);
        RequestDispatcher rd = request.getRequestDispatcher("/lista-empresas.jsp");
        rd.forward(request, response);
    }
}
