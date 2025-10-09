package br.com.stockplus.graphicalInterface.fornecedor;

import br.com.stockplus.dao.FornecedorDAO;
import br.com.stockplus.entity.FornecedorEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WinCadastrodeFornecedor extends JFrame {

    private static final long serialVersionUID = 1L;

    // Painéis
    public JPanel contentPane;
    public JPanel panel;

    // Labels
    public JLabel lblTitulo;
    public JLabel lblId;
    public JLabel lblCnpj;
    public JLabel lblRazaoSocial;
    public JLabel lblEmail;
    public JLabel lblEndereco;
    public JLabel lblNumero;
    public JLabel lblTelefone;
    public JLabel lblBairro;
    public JLabel lblCidade;
    public JLabel lblUf;

    // Campos de texto
    public JTextField textId;
    public JTextField textCnpj;
    public JTextField textRazaoSocial;
    public JTextField textEmail;
    public JTextField textEndereco;
    public JTextField textNumero;
    public JTextField textTelefone;
    public JTextField textBairro;
    public JTextField textCidade;
    public JTextField textUf;

    // Botões
    public JButton btnCadastrar;
    public JButton btnCancelar;

    private void cadastroDeFornecedor(){

        FornecedorEntity entity = new FornecedorEntity();

        entity.setCnpj(textCnpj.getText());
        entity.setRazaoSocial(textRazaoSocial.getText());
        entity.setEmail(textEmail.getText());
        entity.setEndereco(textEndereco.getText());
        entity.setNumeroEndereco(textNumero.getText());
        entity.setTelefone(textTelefone.getText());
        entity.setBairroEndereco(textBairro.getText());
        entity.setCidade(textCidade.getText());
        entity.setUf(textUf.getText());

        FornecedorDAO DAO = new FornecedorDAO();

        DAO.insert(entity);

    }
    private void limparCampos() {
        textCnpj.setText("");
        textRazaoSocial.setText("");
        textEmail.setText("");
        textEndereco.setText("");
        textNumero.setText("");
        textTelefone.setText("");
        textBairro.setText("");
        textCidade.setText("");
    }
    public WinCadastrodeFornecedor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 884, 502);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 102, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel de fundo - deve ser adicionado primeiro
        panel = new JPanel();
        panel.setBackground(new Color(102, 153, 204));
        panel.setBounds(175, 27, 504, 372);
        panel.setLayout(null);
        contentPane.add(panel);

        // Título
        lblTitulo = new JLabel("CADASTRO DE FORNECEDOR");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTitulo.setBounds(60, 10, 404, 44);
        panel.add(lblTitulo);

        // CNPJ
        lblCnpj = new JLabel("CNPJ:");
        lblCnpj.setBounds(60, 89, 46, 16);
        panel.add(lblCnpj);

        textCnpj = new JTextField();
        textCnpj.setColumns(10);
        textCnpj.setBounds(108, 86, 252, 22);
        panel.add(textCnpj);

        // Razão Social
        lblRazaoSocial = new JLabel("Razão Social:");
        lblRazaoSocial.setBounds(8, 121, 87, 16);
        panel.add(lblRazaoSocial);

        textRazaoSocial = new JTextField();
        textRazaoSocial.setColumns(10);
        textRazaoSocial.setBounds(108, 118, 310, 22);
        panel.add(textRazaoSocial);

        // E-mail
        lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(47, 153, 105, 16);
        panel.add(lblEmail);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(108, 150, 310, 22);
        panel.add(textEmail);

        // Endereço
        lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(32, 185, 105, 16);
        panel.add(lblEndereco);

        textEndereco = new JTextField();
        textEndereco.setColumns(10);
        textEndereco.setBounds(108, 185, 310, 22);
        panel.add(textEndereco);

        // Número
        lblNumero = new JLabel("Numero:");
        lblNumero.setBounds(42, 218, 105, 16);
        panel.add(lblNumero);

        textNumero = new JTextField();
        textNumero.setColumns(10);
        textNumero.setBounds(108, 218, 87, 22);
        panel.add(textNumero);

        // Telefone
        lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(255, 221, 105, 16);
        panel.add(lblTelefone);

        textTelefone = new JTextField();
        textTelefone.setColumns(10);
        textTelefone.setBounds(320, 220, 87, 22);
        panel.add(textTelefone);

        // Bairro
        lblBairro = new JLabel("Bairro:");
        lblBairro.setBounds(52, 250, 105, 16);
        panel.add(lblBairro);

        textBairro = new JTextField();
        textBairro.setColumns(10);
        textBairro.setBounds(108, 250, 193, 22);
        panel.add(textBairro);

        // Cidade
        lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(42, 283, 105, 16);
        panel.add(lblCidade);

        textCidade = new JTextField();
        textCidade.setColumns(10);
        textCidade.setBounds(108, 280, 193, 22);
        panel.add(textCidade);

        // UF
        lblUf = new JLabel("UF:");
        lblUf.setBounds(313, 283, 105, 16);
        panel.add(lblUf);

        textUf = new JTextField();
        textUf.setColumns(10);
        textUf.setBounds(343, 280, 56, 22);
        panel.add(textUf);

        // Botões fora do panel
        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setForeground(new Color(248, 248, 255));
        btnCancelar.setBackground(new Color(220, 20, 60));
        btnCancelar.setBounds(267, 420, 135, 32);
        contentPane.add(btnCancelar);

        btnCadastrar = new JButton("CADASTRAR +");
        btnCadastrar.setForeground(new Color(248, 248, 255));
        btnCadastrar.setBackground(new Color(102, 204, 102));
        btnCadastrar.setBounds(431, 420, 135, 32);
        btnCadastrar.addActionListener(e ->{
                    cadastroDeFornecedor();
                    limparCampos();
        } );
        contentPane.add(btnCadastrar);


    }
}