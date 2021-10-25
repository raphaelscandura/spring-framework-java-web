package br.com.scandura.gerenciador.servlets;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private static List<Empresa> empresas = new ArrayList<>();

    static{
        Empresa empresaTeste1 = new Empresa("Google");
        Empresa empresaTeste2 = new Empresa("Twitter");
        empresas.add(empresaTeste1);
        empresas.add(empresaTeste2);
    }

    public void adicionaEmpresa(Empresa empresa)
    {
        empresas.add(empresa);
    }

    public List<Empresa> getListaDeEmpresas()
    {
        return BancoDeDados.empresas;
    }

}
