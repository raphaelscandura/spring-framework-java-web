package br.com.scandura.gerenciador.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/lista-empresas")
public class ListaEmpresasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BancoDeDados banco = new BancoDeDados();
        List<Empresa> listaDeEmpresas = banco.getListaDeEmpresas();
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<ul>");
        for (Empresa empresa: listaDeEmpresas ) {
            out.println("<li>" + empresa.getNome() + "</li>");
        }
        out.println("</ul></body></html>");
    }
}
