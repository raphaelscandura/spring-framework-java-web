package br.com.scandura.gerenciador.action;

import br.com.scandura.gerenciador.model.BancoDeDados;
import br.com.scandura.gerenciador.model.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateEmpresa {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!request.getParameter("nome").equals("")){
            Empresa novaEmpresa = new Empresa(request.getParameter("nome"));
            BancoDeDados banco = new BancoDeDados();
            banco.adicionaEmpresa(novaEmpresa);
            response.sendRedirect("control?action=read-empresas");
        }else{
            throw new ServletException("É necessário fornecer o nome da empresa que será cadastrada!");
        }
    }
}
