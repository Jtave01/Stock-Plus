package br.com.stockplus.graphicalInterface.controllClasse;

import br.com.stockplus.connection.ConnectionUtil;
import br.com.stockplus.entity.UsuarioEntity;
import br.com.stockplus.graphicalInterface.login.WinLogin;

import java.awt.*;

public class SessionControl {
    ///  --> Run
    public static void runApp(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WinLogin frame = new WinLogin() ;
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /// --> Controle de acesso  de usuario logado
    private static UsuarioEntity usuarioLogado;

    public static void login(UsuarioEntity user){
        usuarioLogado = user;
    }

    public static UsuarioEntity getUser(){

        return usuarioLogado ;
    }

    public static boolean isAdmin(){
        return usuarioLogado != null && usuarioLogado.getRole().getId() == 1;
    }

    /// ---> Teste conect
    public static void testeConnection(){
        try(var connection = ConnectionUtil.getConnection()) {
            System.out.println("Conection status ---> \n" +
                    "Conectado ao mysql");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
