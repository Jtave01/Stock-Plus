package br.com.stockplus.graphicalInterface.login;

import br.com.stockplus.dao.UsuarioDAO;
import br.com.stockplus.graphicalInterface.home.WinPrincipal;
import br.com.stockplus.controllClasse.SessionControl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class WinLogin extends JFrame {

     JPanel contentPane;
     JPanel panel;

     JTextField textLogin;
     JPasswordField textSenha;

     JButton btnLogin;

     JLabel lblImg;

     JLabel lblLogin;
     JLabel lblSenha;

    private void realizarLogin() {
        try {

            String username =textLogin.getText();
            String password = String.valueOf(textSenha.getPassword());
            UsuarioDAO DAO = new UsuarioDAO();

            var usuario =  DAO.findByLogin(username, password);

            if(usuario != null){
                SessionControl.login(usuario);
                irParaHome();

            }
            else{
                JOptionPane.showMessageDialog(null,  "Usuario ou senha invalida");
                limpar();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro no login: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


    }

    private void limpar() {
        textLogin.setText("");
        textSenha.setText("");
    }

    private void irParaHome() {
        Timer timer = new Timer(50, e -> {
            setVisible(false);
            WinPrincipal principal = new WinPrincipal();
            principal.setLocationRelativeTo(null);
            principal.setVisible(true);
            dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }

    public WinLogin() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        setLocationRelativeTo(null);
        setTitle("Login - Sistema de Almoxarifado");

        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 102, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(102, 153, 204));
        panel.setBounds(390, 150, 500, 420);
        panel.setLayout(null);
        contentPane.add(panel);


        lblImg = new JLabel();
        lblImg.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/logo_pri.png"))));
        lblImg.setBounds(70, -70, 407, 250);
        panel.add(lblImg);


        lblLogin = new JLabel("Login:");
        lblLogin.setForeground(Color.WHITE);
        lblLogin.setBounds(80, 150, 60, 20);
        panel.add(lblLogin);

        textLogin = new JTextField();
        textLogin.setBounds(126, 155, 248, 25);
        panel.add(textLogin);


        lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setBounds(80, 220, 60, 20);
        panel.add(lblSenha);

        textSenha = new JPasswordField();
        textSenha.setBounds(126, 220, 248, 25);
        panel.add(textSenha);


        btnLogin = new JButton("LOGIN");
        btnLogin.setBackground(new Color(102, 204, 102));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setBounds(175, 270, 150, 35);
        btnLogin.addActionListener(e ->
                realizarLogin()
        );
        panel.add(btnLogin);
    }




}