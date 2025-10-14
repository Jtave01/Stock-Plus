package br.com.stockplus.dao;

import br.com.stockplus.connection.ConnectionUtil;
import br.com.stockplus.entity.FornecedorEntity;
import br.com.stockplus.entity.ProdutoEntity;
import br.com.stockplus.entity.RoleEntitty;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public static ProdutoEntity entity = new ProdutoEntity();

    /// Criar metodo a partir da query - >>>> SELECT produto.id, SUM(quantidade) * SUM(preco) FROM produto WHERE id = 6;

    public void insert(ProdutoEntity entity){
        var sql = "INSERT INTO produto (cod_ident, nome, descricao, quantidade, preco, localizacao, fornecedor_id,data_insercao) values(?,?,?,?,?,?,?,?) ";

        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement(sql);
        ) {

            statemente.setString(1, entity.getCodIdent());
            statemente.setString(2, entity.getNome());
            statemente.setString(3, entity.getDescricao());
            statemente.setInt(4, entity.getQuantidade());
            statemente.setDouble(5, entity.getPreco());
            statemente.setString(6, entity.getLocalizacao());
            statemente.setLong(7, entity.getFornecedor().getId());
            statemente.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
            statemente.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(ProdutoEntity entity){
        var sql = "UPDATE produto SET cod_ident = ?, nome = ?, descricao = ?, quantidade = ?, preco = ?, localizacao = ?, fornecedor_id =? WHERE id = ?";
        try(var connetion = ConnectionUtil.getConnection();
            var statemente = connetion.prepareStatement(sql);
        ) {
            statemente.setString(1, entity.getCodIdent());
            statemente.setString(2, entity.getNome());
            statemente.setString(3, entity.getDescricao());
            statemente.setInt(4, entity.getQuantidade());
            statemente.setDouble(5, entity.getPreco());
            statemente.setString(6, entity.getLocalizacao());
            statemente.setLong(7, entity.getFornecedor().getId());
            statemente.setLong(8, entity.getId());

            statemente.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void delete(Long id){
        var sql = "DELETE FROM produto WHERE id = ?";
        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement(sql);
        ) {
            statemente.setLong(1, id);
            statemente.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ProdutoEntity findByCode(String code){
        ProdutoEntity entity = new ProdutoEntity();
        var sql = "SELECT * FROM produto WHERE cod_ident=? ";
        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement(sql);
        ) {
            statemente.setString(1, code);
            statemente.executeQuery();
            var resultSet = statemente.getResultSet();

            if(resultSet.next()){
                entity.setId(resultSet.getLong("id"));
                entity.setNome(resultSet.getString("nome"));
                entity.setDescricao(resultSet.getString("descricao"));
                entity.setQuantidade(resultSet.getInt("quantidade"));
                entity.setPreco(resultSet.getDouble("preco"));
                entity.setLocalizacao(resultSet.getString("localizacao"));

                FornecedorEntity fornecedor = new FornecedorEntity();
                fornecedor.setId(resultSet.getLong("fornecedor_id"));
                entity.setFornecedor(fornecedor);
                entity.setDataInsercao(resultSet.getDate("data_insercao"));
                entity.setTotalPreco(resultSet.getDouble("total_preco"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return entity;
    }

    public List<ProdutoEntity> findAll(){
       List<ProdutoEntity> entities = new ArrayList<>();
       var sql = "SELECT * FROM produto ";
        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement(sql);
        ) {
            statemente.executeQuery();
            var resultSet = statemente.getResultSet();

            while (resultSet.next()){
                ProdutoEntity entity = new ProdutoEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setCodIdent(resultSet.getString("cod_ident"));
                entity.setNome(resultSet.getString("nome"));
                entity.setDescricao(resultSet.getString("descricao"));
                entity.setQuantidade(resultSet.getInt("quantidade"));
                entity.setPreco(resultSet.getDouble("preco"));
                entity.setLocalizacao(resultSet.getString("localizacao"));

                FornecedorEntity fornecedor = new FornecedorEntity();
                fornecedor.setId(resultSet.getLong("fornecedor_id"));

                entity.setFornecedor(fornecedor);
                entity.setDataInsercao(resultSet.getDate("data_insercao"));
                entity.setTotalPreco(resultSet.getDouble("total_preco"));
                entities.add(entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  entities;
    }

    public ProdutoEntity findById(Long id){
        ProdutoEntity entity = new ProdutoEntity();
        var sql = "SELECT * FROM produto WHERE id = ?";

        try( var connection = ConnectionUtil.getConnection();
             var statemente = connection.prepareStatement(sql)
        ) {
            statemente.setLong(1, id);
            statemente.executeQuery();
            var resultSet = statemente.getResultSet();
            if (resultSet.next()){
                FornecedorEntity fornecedor = new FornecedorEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setCodIdent(resultSet.getString("cod_ident"));
                entity.setNome(resultSet.getString("nome"));
                entity.setDescricao(resultSet.getString("descricao"));
                entity.setQuantidade(resultSet.getInt("quantidade"));
                entity.setPreco(resultSet.getDouble("preco"));
                entity.setLocalizacao(resultSet.getString("localizacao"));
                fornecedor.setId(resultSet.getLong("fornecedor_id"));
                entity.setFornecedor(fornecedor);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

         return entity;
    }
}
