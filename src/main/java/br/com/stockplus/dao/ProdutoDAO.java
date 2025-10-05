package br.com.stockplus.dao;

import br.com.stockplus.connection.ConnectionUtil;
import br.com.stockplus.entity.FornecedorEntity;
import br.com.stockplus.entity.ProdutoEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
public class ProdutoDAO {
    public static ProdutoEntity entity = new ProdutoEntity();


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

    private void update(String code){
        try(var connetion = ConnectionUtil.getConnection();
            var statemente = connetion.prepareStatement("null");
        ) {


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void delete(String code){
        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement("null");
        ) {

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private ProdutoEntity readOneProduc(String code){
        ProdutoEntity entity = new ProdutoEntity();

        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement("null");
        ) {

        }catch (Exception e){
            e.printStackTrace();
        }

        return entity;
    }

    private ProdutoEntity readAlL(){
        ProdutoEntity entity = new ProdutoEntity();

        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement("null");
        ) {



        }catch (Exception e){
            e.printStackTrace();
        }

        return  entity;
    }
}
