package br.com.stockplus.dao;

import br.com.stockplus.connection.ConnectionUtil;
import br.com.stockplus.entity.FornecedorEntity;

/// -->
public class FornecedorDAO {

    public void insert(FornecedorEntity entity){
        var sql = "INSERT fornecedor (cnpj, razao_social, endereco, numero, telefone, bairro, cidade, uf, email ) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ? )";
        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement(sql)
        ){
            statemente.setString(1, entity.getCnpj());
            statemente.setString(2, entity.getRazaoSocial());
            statemente.setString(3, entity.getEndereco());
            statemente.setString(4, entity.getNumeroEndereco());
            statemente.setString(5, entity.getTelefone());
            statemente.setString(6, entity.getBairroEndereco());
            statemente.setString(7, entity.getCidade());
            statemente.setString(8, entity.getUf());
            statemente.setString(9, entity.getEmail());
            statemente.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadaastrar um fornecedor");
        }
    }
    public Long findByIdCnpj(String cnpj){
        Long idReturn = 0L;
        var sql = "SELECT id from fornecedor WHERE cnpj = ? ";
        try( var connection = ConnectionUtil.getConnection();
             var statemente = connection.prepareStatement(sql);
        ) {
            statemente.setString(1, cnpj);
            statemente.executeQuery();
            var resultSet = statemente.getResultSet();

            if(resultSet.next()){
                idReturn = resultSet.getLong("id");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return idReturn;
    }

    public FornecedorEntity findByCnpj(String cnpj){
        FornecedorEntity entity = new FornecedorEntity();
        var sql = "SELECT * FROM  fornecedor WHERE cnpj = ?";

        try(var conecction = ConnectionUtil.getConnection();
            var statemente = conecction.prepareStatement(sql)
        ){
            statemente.setString(1, cnpj);
            statemente.executeQuery();
            var resultSet = statemente.getResultSet();

            if (resultSet.next()){
                entity.setId(resultSet.getLong("id"));
                entity.setCnpj(resultSet.getString("cnpj"));
                entity.setRazaoSocial(resultSet.getString("razao_social"));
                entity.setEndereco(resultSet.getString("endereco"));
                entity.setNumeroEndereco(resultSet.getString("numero"));
                entity.setTelefone(resultSet.getString("telefone"));
                entity.setBairroEndereco(resultSet.getString("bairro"));
                entity.setCidade(resultSet.getString("cidade"));
                entity.setUf(resultSet.getString("uf"));
                entity.setEmail(resultSet.getString("email"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entity;
    }


}
