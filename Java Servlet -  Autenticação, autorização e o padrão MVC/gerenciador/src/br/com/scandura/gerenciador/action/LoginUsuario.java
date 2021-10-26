package br.com.scandura.gerenciador.action;

import br.com.scandura.gerenciador.model.BancoDeDados;
import br.com.scandura.gerenciador.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginUsuario implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        BancoDeDados banco = new BancoDeDados();
        Usuario usuario = banco.verificaUsuario(login, senha);
        if(usuario != null){
            return "redirect:control?action=read-empresas";
        }
            return "redirect:control?action=form-login";
    }
}
