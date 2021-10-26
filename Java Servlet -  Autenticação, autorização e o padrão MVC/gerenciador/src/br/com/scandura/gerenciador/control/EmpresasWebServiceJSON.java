package br.com.scandura.gerenciador.control;

import br.com.scandura.gerenciador.model.BancoDeDados;
import br.com.scandura.gerenciador.model.Empresa;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/empresas/JSON")
public class EmpresasWebServiceJSON extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Empresa> empresas = new BancoDeDados().getListaDeEmpresas();
        Gson gson = new Gson();
        String json = gson.toJson(empresas);
        response.setContentType("application/json");
        response.getWriter().print(json);
    }
}
