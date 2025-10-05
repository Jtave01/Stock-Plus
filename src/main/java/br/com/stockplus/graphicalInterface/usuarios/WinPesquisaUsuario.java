package br.com.stockplus.graphicalInterface.usuarios;

import br.com.stockplus.dao.UsuarioDAO;
import br.com.stockplus.entity.UsuarioEntity;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WinPesquisaUsuario extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel contentPane;
    public JPanel panel;

    // Campos de texto
    public JTextField textUsuario;
    public JTextField textId;
    public JTextField textNome;
    public JTextField textEmail;
    public JTextField textPermissao;

    // Botões
    public JButton btnBuscar;
    public JButton btnLimpar;

    private void buscarUsuario() {
        var DAO = new UsuarioDAO();
        String username = textUsuario.getText();
        UsuarioEntity usuario = DAO.findByUserName(username);
        String role = usuario.getRole().getId() == 1L ? "Administrador" : "Usuário";

        textId.setText(String.valueOf(Long.parseLong(String.valueOf(usuario.getId()))));
        textUsuario.setText(usuario.getUsaername());
        textNome.setText(usuario.getNome());
        textEmail.setText(usuario.getEmail());
        textPermissao.setText(role);


        boolean habilitar = true;
        textUsuario.setEnabled(habilitar);
        textNome.setEnabled(habilitar);
        textEmail.setEnabled(habilitar);
        textPermissao.setEnabled(habilitar);


    }

    private void limparCampos() {
        textId.setText("");
        textUsuario.setText("");
        textNome.setText("");
        textEmail.setText("");
        textPermissao.setText("");
    }

    public WinPesquisaUsuario() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 884, 430);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 102, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(102, 153, 204));
        panel.setBounds(133, 24, 547, 310);
        panel.setLayout(null);
        contentPane.add(panel);

        // Título
        JLabel lblTitulo = new JLabel("PESQUISAR USUÁRIO");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTitulo.setBounds(100, 10, 404, 44);
        panel.add(lblTitulo);

        // Usuário (campo de busca)
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(83, 70, 63, 16);
        panel.add(lblUsuario);

        textUsuario = new JTextField();
        textUsuario.setColumns(10);
        textUsuario.setBounds(145, 67, 200, 22);
        panel.add(textUsuario);

        btnBuscar = new JButton("BUSCAR");
        btnBuscar.setBackground(new Color(51, 153, 255));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBounds(355, 66, 100, 25);
        panel.add(btnBuscar);
        btnBuscar.addActionListener(e -> buscarUsuario());

        // Separador
        JSeparator separator = new JSeparator();
        separator.setBounds(20, 105, 507, 2);
        panel.add(separator);

        JLabel lblResultados = new JLabel("Resultados da Pesquisa:");
        lblResultados.setForeground(Color.WHITE);
        lblResultados.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblResultados.setBounds(20, 115, 200, 20);
        panel.add(lblResultados);

        // ID (resultado)
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(112, 145, 30, 16);
        panel.add(lblId);

        textId = new JTextField();
        textId.setColumns(10);
        textId.setBounds(145, 142, 80, 22);
        textId.setEditable(false);
        textId.setBackground(Color.LIGHT_GRAY);
        panel.add(textId);

        // Nome (resultado)
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(95, 177, 87, 16);
        panel.add(lblNome);

        textNome = new JTextField();
        textNome.setColumns(10);
        textNome.setBounds(145, 174, 310, 22);
        textNome.setEditable(false);
        textNome.setBackground(Color.WHITE);
        panel.add(textNome);

        // E-mail (resultado)
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(89, 209, 105, 16);
        panel.add(lblEmail);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(145, 206, 310, 22);
        textEmail.setEditable(false);
        textEmail.setBackground(Color.WHITE);
        panel.add(textEmail);

        // Permissão (resultado)
        JLabel lblPermissao = new JLabel("Permissão:");
        lblPermissao.setBounds(64, 241, 105, 16);
        panel.add(lblPermissao);

        textPermissao = new JTextField();
        textPermissao.setColumns(10);
        textPermissao.setBounds(145, 238, 193, 22);
        textPermissao.setEditable(false);
        textPermissao.setBackground(Color.WHITE);
        panel.add(textPermissao);

        // Botão Limpar
        btnLimpar = new JButton("LIMPAR");
        btnLimpar.setForeground(new Color(248, 248, 255));
        btnLimpar.setBackground(new Color(255, 140, 0));
        btnLimpar.setBounds(350, 345, 135, 32);
        contentPane.add(btnLimpar);
        btnLimpar.addActionListener(e -> limparCampos());
    }

}