package br.com.scandura.gerenciador.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormEmpresa implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
            return "forward:/nova-empresa-form.jsp";
    }
}
