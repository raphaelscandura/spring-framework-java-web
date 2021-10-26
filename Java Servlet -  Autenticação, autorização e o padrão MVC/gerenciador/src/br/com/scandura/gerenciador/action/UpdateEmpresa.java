package br.com.scandura.gerenciador.action;

import br.com.scandura.gerenciador.model.BancoDeDados;
import br.com.scandura.gerenciador.model.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateEmpresa implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        if(!request.getParameter("nome").equals("")) {
            String paramId = request.getParameter("id");
            int id = Integer.parseInt(paramId);
            BancoDeDados banco = new BancoDeDados();
            Empresa empresa = banco.getEmpresa(id);
            empresa.setNome(request.getParameter("nome"));
            return "redirect:control?action=read-empresas";
        }else{
            throw new ServletException("É necessário fornecer o novo nome da empresa cadastrada!");
        }
    }
}
