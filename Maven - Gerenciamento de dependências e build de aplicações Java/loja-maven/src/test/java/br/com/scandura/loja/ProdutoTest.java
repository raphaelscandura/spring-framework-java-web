package br.com.scandura.loja;

import br.com.scandura.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ProdutoTest {

    @Test
    public void test(){
        Produto produtoTeste = new Produto("arroz");
        String nome = produtoTeste.getNome();
        Assert.assertEquals("arroz", nome);
    }
}
