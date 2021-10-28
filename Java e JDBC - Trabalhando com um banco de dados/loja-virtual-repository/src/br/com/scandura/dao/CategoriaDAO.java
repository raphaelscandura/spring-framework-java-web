package br.com.scandura.dao;

import br.com.scandura.model.Categoria;
import br.com.scandura.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private final Connection con;

    public CategoriaDAO(Connection connection) throws SQLException {
        this.con = connection;
    }

    public List<Categoria> retrieveAll(){
        try(PreparedStatement stm = this.con.prepareStatement("SELECT id, nome FROM CATEGORIA", Statement.RETURN_GENERATED_KEYS)){
            stm.execute();
            ResultSet rst = stm.getResultSet();

            List<Categoria> categorias = new ArrayList<>();

            while(rst.next()){
                Integer id = rst.getInt("id");
                String nome = rst.getString("nome");
                Categoria temp = new Categoria(id, nome);
                temp.setId(id);
                categorias.add(temp);
            }
            return categorias;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public List<Categoria> retrieveProdutoByCategoria() throws SQLException {
        try (PreparedStatement stm = this.con.prepareStatement("SELECT c.id, c.nome, p.id, p.nome, p.descricao FROM CATEGORIA c INNER JOIN " + "PRODUTO p on C.ID = P.CATEGORIA_ID", Statement.RETURN_GENERATED_KEYS)) {
            stm.execute();
            List<Categoria> categorias = new ArrayList<>();
            Categoria ultima = null;
            try (ResultSet rst = stm.getResultSet()) {
                while (rst.next()) {
                    if(ultima == null || !ultima.getNome().equals((rst.getString(2)))){
                        Categoria ct = new Categoria(rst.getInt(1), rst.getString(2));
                        ultima = ct;
                        categorias.add(ct);
                    }
                    Produto pd = new Produto(rst.getString(4), rst.getString(5), rst.getInt(1));
                    pd.setId(rst.getInt(3));
                    ultima.adicionaProduto(pd);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return categorias;
        }
    }
}
