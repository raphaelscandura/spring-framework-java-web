package br.com.scandura.dao;

/*
 Data Acess Object
 */

import br.com.scandura.model.Categoria;
import br.com.scandura.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private final Connection con;

    public ProdutoDAO(Connection connection) throws SQLException {
        this.con = connection;
    }

    public void create(Produto produto){
        try(PreparedStatement stm = this.con.prepareStatement("INSERT INTO PRODUTO (nome, descricao, CATEGORIA_ID) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)){
            stm.setString(1, produto.getNome());
            stm.setString(2, produto.getDescricao());
            stm.setInt(3, produto.getIdCategoria());
            stm.execute();
            try (ResultSet generatedKeys = stm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    produto.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Produto produto, String novoNome) {
        try (PreparedStatement stm = this.con.prepareStatement("UPDATE PRODUTO SET nome=? WHERE id=?")) {
            stm.setInt(2, produto.getId());
            stm.setString(1, novoNome);
            stm.execute();
            produto.setNome(novoNome);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Produto produto){
        try(PreparedStatement stm = this.con.prepareStatement("DELETE FROM PRODUTO WHERE id = ?")){
            stm.setString(1, String.valueOf(produto.getId()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Produto retrieve(Produto produto) {
        try(PreparedStatement stm = this.con.prepareStatement("SELECT id, nome, descricao, CATEGORIA_ID FROM PRODUTO WHERE id=?", Statement.RETURN_GENERATED_KEYS)){
            stm.setString(1, String.valueOf(produto.getId()));
            stm.execute();

            ResultSet rst = stm.getResultSet();

            rst.next();

            Integer id = rst.getInt("id");
            String nome = rst.getString("nome");
            String descricao = rst.getString("descricao");
            Integer idCategoria = rst.getInt("CATEGORIA_ID");
            Produto temp = new Produto(nome, descricao, idCategoria);
            temp.setId(id);

            return temp;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public List<Produto> retrieveAll(){
        try(PreparedStatement stm = this.con.prepareStatement("SELECT id, nome, descricao, CATEGORIA_ID FROM PRODUTO", Statement.RETURN_GENERATED_KEYS)){
            stm.execute();
            ResultSet rst = stm.getResultSet();

            List<Produto> produtos = new ArrayList<>();

            while(rst.next()){
                Integer id = rst.getInt("id");
                String nome = rst.getString("nome");
                String descricao = rst.getString("descricao");
                Integer idCategoria = rst.getInt("CATEGORIA_ID");
                Produto temp = new Produto(nome, descricao, idCategoria);
                temp.setId(id);
                produtos.add(temp);
            }
            return produtos;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void clearTable(){
        try(PreparedStatement stm = this.con.prepareStatement("DELETE FROM PRODUTO")){
            stm.execute();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
