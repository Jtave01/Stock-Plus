package br.com.stockplus.graphicalInterface.usuarios;

import br.com.stockplus.dao.UsuarioDAO;
import br.com.stockplus.entity.RoleEntitty;
import br.com.stockplus.entity.UsuarioEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WinCadastrodeUsuario extends JFrame {

    public JPanel contentPane;
    public JPanel panel;

    // Labels
    public JLabel lblTitulo;
    public JLabel lblUsuario;
    public JLabel lblNome;
    public JLabel lblEmail;
    public JLabel lblSenha;
    public JLabel lblRepitaSenha;
    public JLabel lblPermissao;

    // Campos de texto
    public JTextField textUsuario;
    public JTextField textNome;
    public JTextField textEmail;
    public JPasswordField textSenha;
    public JPasswordField textRepitaSenha;

    // ComboBox
    public JComboBox<String> comboPermicoes;

    // Botões
    public JButton btnCancelar;
    public JButton btnCadastrar;

    public JComboBox<String> permicoes ;
	/**
	 * Create the frame.
	 */



    public void cadastroAux(){

        String senha = String.valueOf(textRepitaSenha.getPassword());
        String senhaRepete = String.valueOf(textRepitaSenha.getPassword());
        Long idPermissao = (long) (permicoes.getSelectedIndex() + 1);
        RoleEntitty role = new RoleEntitty();
        UsuarioDAO DAO = new UsuarioDAO();
        role.setId(idPermissao);

        if(!senhaRepete.equals(senha)){
            JOptionPane.showMessageDialog(null, "As senhas não coincidem !");
        }

        var entity = new UsuarioEntity();
        entity.setUsaername(textUsuario.getText());
        entity.setNome(textNome.getText());
        entity.setEmail(textEmail.getText());
        entity.setPassword(String.valueOf(textSenha.getPassword()));
        entity.setRole(role);
        DAO.insert(entity);

    }

    public void limpar(){
        textNome.setText("");
        textUsuario.setText("");
        textEmail.setText("");
        textSenha.setText("");
        textRepitaSenha.setText("");
    }
	public WinCadastrodeUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(102, 153, 204));
        panel.setBounds(133, 24, 547, 320);
        panel.setLayout(null);
        contentPane.add(panel);

        // Título
        JLabel lblNewLabel_1 = new JLabel("CADASTRO DE USUÁRIO");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblNewLabel_1.setBounds(85, 10, 404, 44);
        panel.add(lblNewLabel_1);


        // Usuário
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(83, 102, 63, 16);
        panel.add(lblUsuario);

        textUsuario = new JTextField();
        textUsuario.setColumns(10);
        textUsuario.setBounds(145, 99, 310, 22);
        panel.add(textUsuario);

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(95, 134, 87, 16);
        panel.add(lblNome);

        textNome = new JTextField();
        textNome.setColumns(10);
        textNome.setBounds(145, 131, 310, 22);
        panel.add(textNome);

        // E-mail
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(89, 166, 105, 16);
        panel.add(lblEmail);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(145, 163, 310, 22);
        panel.add(textEmail);

        // Senha
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(88, 198, 105, 16);
        panel.add(lblSenha);

        textSenha = new JPasswordField();
        textSenha.setBounds(145, 195, 193, 22);
        panel.add(textSenha);

        // Repita a senha
        JLabel lblRepitaSenha = new JLabel("Repita a senha:");
        lblRepitaSenha.setBounds(28, 230, 105, 16);
        panel.add(lblRepitaSenha);

        textRepitaSenha = new JPasswordField();
        textRepitaSenha.setColumns(10);
        textRepitaSenha.setBounds(145, 227, 193, 22);
        panel.add(textRepitaSenha);

        // Permissão
        JLabel lblPermissao = new JLabel("Permissão:");
        lblPermissao.setBounds(64, 262, 105, 16);
        panel.add(lblPermissao);

        permicoes = new JComboBox<>();
        permicoes.addItem("Administrador");
        permicoes.addItem("Usuário");
        permicoes.setBounds(145, 259, 193, 22);
        panel.add(permicoes);

        /*
        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setForeground(new Color(248, 248, 255));
        btnCancelar.setBackground(new Color(220, 20, 60));
        btnCancelar.setBounds(254, 355, 135, 32);
        contentPane.add(btnCancelar);
         */

        btnCadastrar = new JButton("CADASTRAR +");
        btnCadastrar.setForeground(new Color(248, 248, 255));
        btnCadastrar.setBackground(new Color(102, 204, 102));
        btnCadastrar.setBounds(340, 347, 135, 32);
        contentPane.add(btnCadastrar);
        btnCadastrar.addActionListener(e-> cadastroAux());

	}
}
