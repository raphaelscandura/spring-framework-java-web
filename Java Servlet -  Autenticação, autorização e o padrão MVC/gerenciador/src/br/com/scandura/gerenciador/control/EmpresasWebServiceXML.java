package br.com.scandura.gerenciador.control;

import br.com.scandura.gerenciador.model.BancoDeDados;
import br.com.scandura.gerenciador.model.Empresa;
import com.thoughtworks.xstream.XStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/empresas/XML")
public class EmpresasWebServiceXML extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Empresa> empresas = new BancoDeDados().getListaDeEmpresas();
        XStream xstream = new XStream();
        xstream.alias("empresa", Empresa.class);
        String xml = xstream.toXML(empresas);
        response.setContentType("application/xml");
        response.getWriter().print(xml);
    }
}
