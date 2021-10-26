package br.com.scandura.gerenciador.action;

import br.com.scandura.gerenciador.model.BancoDeDados;
import br.com.scandura.gerenciador.model.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReadEmpresa {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BancoDeDados banco = new BancoDeDados();
        List<Empresa> listaDeEmpresas = banco.getListaDeEmpresas();
        request.setAttribute("listaDeEmpresas", listaDeEmpresas);
        RequestDispatcher rd = request.getRequestDispatcher("/lista-empresas.jsp");
        rd.forward(request, response);
    }
}
