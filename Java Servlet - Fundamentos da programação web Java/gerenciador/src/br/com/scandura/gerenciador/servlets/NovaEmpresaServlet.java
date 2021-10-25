package br.com.scandura.gerenciador.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class NovaEmpresaServlet
 */

@WebServlet(urlPatterns = "/nova-empresa")
public class NovaEmpresaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Empresa novaEmpresa = new Empresa(req.getParameter("nome"));
        BancoDeDados banco = new BancoDeDados();
        banco.adicionaEmpresa(novaEmpresa);
        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1>Empresa " + novaEmpresa.getNome() + " cadastrada com sucesso</h1></body></html>");
    }
}
