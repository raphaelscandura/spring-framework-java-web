package br.com.scandura.gerenciador.control;

import br.com.scandura.gerenciador.action.*;

import javax.servlet.RequestDispatcher;
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
        String nome = null;
        switch (paramAction) {
            case "create-empresa": {
                CreateEmpresa action = new CreateEmpresa();
                nome = action.execute(request, response);
                break;
            }
            case "read-empresas": {
                ReadEmpresa action = new ReadEmpresa();
                nome = action.execute(request, response);
                break;
            }
            case "update-empresa": {
                UpdateEmpresa action = new UpdateEmpresa();
                nome = action.execute(request, response);
                break;
            }
            case "delete-empresa": {
                DeleteEmpresa action = new DeleteEmpresa();
                nome = action.execute(request, response);
                break;
            }
            case "show-empresa": {
                ShowEmpresa action = new ShowEmpresa();
                nome = action.execute(request, response);
                break;
            }
            case "form-empresa": {
                FormEmpresa action = new FormEmpresa();
                nome = action.execute(request, response);
                break;
            }
            default: {
                response.sendRedirect("WEB-INF/view/home.html");
            }
        }
        assert nome != null;
        String[] typeAddress = nome.split(":");
        if(typeAddress[0].equals("forward")){
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + typeAddress[1]);
            rd.forward(request, response);
        }else if(typeAddress[0].equals("redirect")){
            response.sendRedirect(typeAddress[1]);
        }

    }
}
