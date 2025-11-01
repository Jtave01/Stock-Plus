package br.com.stockplus.graphicalInterface.login;

import br.com.stockplus.dao.UsuarioDAO;
import br.com.stockplus.graphicalInterface.home.WinHome;
import br.com.stockplus.controlClasse.SessionControl;

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
            WinHome principal = new WinHome();
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
        contentPane.setBackground(new Color(25, 79, 110));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(102, 153, 204));
        panel.setBounds(340, 100, 600, 520);
        panel.setLayout(null);
        contentPane.add(panel);


        int larguraDoPainel = 600;
        int novaLarguraDaLogo = 540;
        lblImg = new JLabel();
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/FundoFinal.png")));
        Image img = icon.getImage().getScaledInstance(novaLarguraDaLogo, -1, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(img);
        int novaAlturaDaLogo = newIcon.getIconHeight();
        int xLogoCentralizado = (larguraDoPainel - novaLarguraDaLogo) / 2;
        lblImg.setIcon(newIcon);
        lblImg.setBounds(xLogoCentralizado, -50, novaLarguraDaLogo, novaAlturaDaLogo);
        panel.add(lblImg);

        lblLogin = new JLabel("Login:");
        lblLogin.setForeground(Color.WHITE);
        lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblLogin.setBounds(100, 220, 60, 20);
        panel.add(lblLogin);
        lblLogin = new JLabel("Login:");
        lblLogin.setForeground(Color.WHITE);
        lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblLogin.setBounds(100, 220, 60, 20);
        panel.add(lblLogin);

        textLogin = new JTextField();
        textLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textLogin.setBounds(165, 218, 300, 30);
        panel.add(textLogin);



        lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSenha.setBounds(100, 280, 60, 20);
        panel.add(lblSenha);

        textSenha = new JPasswordField();
        textSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textSenha.setBounds(165, 278, 300, 30);
        panel.add(textSenha);

        btnLogin = new JButton("LOGIN");
        btnLogin.setBackground(new Color(25, 79, 110));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnLogin.setBounds(225, 340, 150, 40);
        btnLogin.addActionListener(e ->
                realizarLogin()
        );
        panel.add(btnLogin);
    }




}