package br.com.scandura.gerenciador.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BancoDeDados {
    private static final List<Empresa> empresas = new ArrayList<>();
    private static int id = 0 ;

    static{
        Empresa empresaTeste1 = new Empresa("Google");
        empresaTeste1.setId(BancoDeDados.id++);
        Empresa empresaTeste2 = new Empresa("Twitter");
        empresaTeste2.setId(BancoDeDados.id++);
        empresas.add(empresaTeste1);
        empresas.add(empresaTeste2);
    }

    public void adicionaEmpresa(Empresa empresa){
        empresa.setId(BancoDeDados.id++);
        empresas.add(empresa);
    }

    public void removeEmpresa(int id){
        if(!empresas.isEmpty()){
            empresas.removeIf(empresa -> empresa.getId() == id);
        }
    }

    public List<Empresa> getListaDeEmpresas()
    {
        return BancoDeDados.empresas;
    }

    public Empresa getEmpresa(int id){
        return empresas.stream()
                .filter(empresa -> id == empresa.getId())
                .findAny()
                .orElse(null);
    }

}
