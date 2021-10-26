package br.com.scandura.gerenciador.action;

import br.com.scandura.gerenciador.model.BancoDeDados;
import br.com.scandura.gerenciador.model.Empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ReadEmpresa implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        BancoDeDados banco = new BancoDeDados();
        List<Empresa> listaDeEmpresas = banco.getListaDeEmpresas();
        request.setAttribute("listaDeEmpresas", listaDeEmpresas);
        return "forward:/lista-empresas.jsp";
    }
}
