package br.com.scandura.gerenciador.action;

import br.com.scandura.gerenciador.model.BancoDeDados;
import br.com.scandura.gerenciador.model.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateEmpresa {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(!request.getParameter("nome").equals("")) {
            String paramId = request.getParameter("id");
            int id = Integer.parseInt(paramId);
            BancoDeDados banco = new BancoDeDados();
            Empresa empresa = banco.getEmpresa(id);
            empresa.setNome(request.getParameter("nome"));
            response.sendRedirect("control?action=read-empresas");
        }else{
            throw new ServletException("É necessário fornecer o novo nome da empresa cadastrada!");
        }
    }
}
