package br.com.scandura.gerenciador.action;

import br.com.scandura.gerenciador.model.BancoDeDados;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowEmpresa implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String paramId = request.getParameter("id");
        int id = Integer.parseInt(paramId);
        BancoDeDados banco = new BancoDeDados();
        request.setAttribute("empresa", banco.getEmpresa(id));
        return "forward:/edita-empresa-form.jsp";
    }
}
