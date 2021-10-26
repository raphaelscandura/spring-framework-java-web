package br.com.scandura.gerenciador.action;

import br.com.scandura.gerenciador.model.BancoDeDados;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmpresa {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paramId = request.getParameter("id");
        int id = Integer.parseInt(paramId);
        BancoDeDados banco = new BancoDeDados();
        banco.removeEmpresa(id);
        response.sendRedirect("control?action=read-empresas");
    }
}
