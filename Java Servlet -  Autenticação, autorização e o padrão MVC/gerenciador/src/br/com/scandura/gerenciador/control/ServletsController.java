package br.com.scandura.gerenciador.control;

import br.com.scandura.gerenciador.action.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/control")
public class ServletsController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramAction = request.getParameter("action");
        switch (paramAction) {
            case "create-empresa": {
                CreateEmpresa action = new CreateEmpresa();
                action.execute(request, response);
                break;
            }
            case "read-empresas": {
                ReadEmpresa action = new ReadEmpresa();
                action.execute(request, response);
                break;
            }
            case "update-empresa": {
                UpdateEmpresa action = new UpdateEmpresa();
                action.execute(request, response);
                break;
            }
            case "delete-empresa": {
                DeleteEmpresa action = new DeleteEmpresa();
                action.execute(request, response);
                break;
            }
            case "show-empresa": {
                ShowEmpresa action = new ShowEmpresa();
                action.execute(request, response);
                break;
            }
        }
    }
}
