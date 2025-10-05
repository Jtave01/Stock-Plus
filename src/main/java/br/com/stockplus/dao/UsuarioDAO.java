package br.com.stockplus.dao;

import br.com.stockplus.connection.ConnectionUtil;
import br.com.stockplus.entity.RoleEntitty;
import br.com.stockplus.entity.UsuarioEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.*;

public class UsuarioDAO {
    public void insert(UsuarioEntity usuarioEntity){
        var sql = "INSERT INTO usuarios(username, nome, email, password, role_id) values(?, ?, ?, ?, ? )";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCripto = encoder.encode(usuarioEntity.getPassword());

        try(var connecction = ConnectionUtil.getConnection();
            var statemente = connecction.prepareStatement(sql);
        ) {
            statemente.setString(1, usuarioEntity.getUsaername());
            statemente.setString(2, usuarioEntity.getNome());
            statemente.setString(3, usuarioEntity.getEmail());
            statemente.setString(4, senhaCripto);
            statemente.setLong(5, usuarioEntity.getRole().getId());

            statemente.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar usuario !");
        }
    }


    public void update(UsuarioEntity usuarioEntity){
        var sql = "UPDATE ";
        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement(sql);
        ){


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public UsuarioEntity findById(Long id){
        var entity = new UsuarioEntity();
        var sql = "SELECT * FROM usuarios WHERE id = ?";

        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement(sql);
            ) {

            statemente.setLong(1, id);
            statemente.executeQuery();

            var resultSet = statemente.getResultSet();
            if(resultSet.next()){
                var role = new RoleEntitty();
                role.setId(resultSet.getLong("role_id"));

                entity.setId(resultSet.getLong("id"));
                entity.setUsaername(resultSet.getString("username"));
                entity.setNome(resultSet.getString("nome"));
                entity.setEmail(resultSet.getString("email"));
                entity.setPassword(resultSet.getString("password"));
                entity.setRole(role);

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return entity;
    }

    public UsuarioEntity findByUserName(String username){
        var entitty = new UsuarioEntity();
        var sql = "SELECT * FROM usuarios WHERE username = ?";

        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement(sql)
        ) {
            statemente.setString(1, username);
            statemente.executeQuery();
            var resultSet = statemente.getResultSet();


            while (resultSet.next()){
                var role = new RoleEntitty();
                role.setId(resultSet.getLong("role_id"));
              entitty.setId(resultSet.getLong("id"));
              entitty.setUsaername(resultSet.getString("username"));
              entitty.setNome(resultSet.getString("nome"));
              entitty.setEmail(resultSet.getString("email"));
              entitty.setPassword(resultSet.getString("password"));
              entitty.setRole(role);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return entitty;
    }

    public UsuarioEntity findByLogin(String user, String password){
        var encoder = new BCryptPasswordEncoder();
        var sql = "SELECT * FROM usuarios WHERE username = ? ";

        try(var connection = ConnectionUtil.getConnection();
            var statemente = connection.prepareStatement(sql);
          ) {
            statemente.setString(1, user);
            statemente.executeQuery();
            var resultSet = statemente.getResultSet();

            if (resultSet.next()){
                String senhaCript = resultSet.getString("password");
                if(encoder.matches(password,senhaCript )){

                    var entitty = new UsuarioEntity();
                    entitty.setId(resultSet.getLong("id"));
                    entitty.setUsaername(resultSet.getString("username"));
                    entitty.setNome(resultSet.getString("nome"));

                    var role = new RoleEntitty();
                    role.setId(resultSet.getLong("role_id"));
                    entitty.setRole(role);

                    return entitty;
                }else{
                    return  null;
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}



// Aux ---->
//WinCadastrodeUsuario cad = new WinCadastrodeUsuario();
//
//String username = cad.text;
//String nome = winLogin.getText();
//  String email = winLogin.getText();
// String password = winLogin.getText();
//String confirmarSenha = winLogin.getText();

//Long idPermissao = (long) (permicoes.getSelectedIndex() + 1);
