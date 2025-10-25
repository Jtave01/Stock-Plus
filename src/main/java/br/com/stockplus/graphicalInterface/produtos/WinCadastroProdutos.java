package br.com.stockplus.graphicalInterface.produtos;

import br.com.stockplus.dao.FornecedorDAO;
import br.com.stockplus.dao.ProdutoDAO;
import br.com.stockplus.entity.FornecedorEntity;
import br.com.stockplus.entity.ProdutoEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WinCadastroProdutos extends JFrame {

    private static final long serialVersionUID = 1L;

    // Painéis
    public JPanel contentPane;
    public JPanel panel;

    // Labels
    public JLabel lblTitulo;
    public JLabel lblId;
    public JLabel lblCodigoBarra;
    public JLabel lblNome;
    public JLabel lblDescricao;
    public JLabel lblQuantidade;
    public JLabel lblPreco;
    public JLabel lblLocalizacao;
    public JLabel lblCnpjFornecedor;
    // Campos de texto
    public JTextField textId;
    public JTextField textCodigoBarra;
    public JTextField textNome;
    public JTextArea textDescricao;
    public JTextField textQuantidade;
    public JTextField textPreco;
    public JTextField textLocalizacao;
    public JTextField textCnpjFornecedor;

    // Lista/ComboBox
    public JComboBox<String> comboFornecedor;

    // Botões
    public JButton btnCadastrar;
    public JButton btnCancelar;

    public void cadastroProdutos(){

        try {

            FornecedorDAO  DAOFornecedor = new FornecedorDAO();
            Long fornecedorID = DAOFornecedor.findByIdCnpj(textCnpjFornecedor.getText());
            ProdutoDAO DAOProduto = new ProdutoDAO();

            var produto = new ProdutoEntity();

            produto.setCodIdent(textCodigoBarra.getText());
            produto.setNome(textNome.getText());
            produto.setDescricao(textDescricao.getText());
            produto.setQuantidade(Integer.valueOf(textQuantidade.getText()));
            produto.setPreco(Double.valueOf(textPreco.getText()));
            produto.setLocalizacao(textLocalizacao.getText());

            FornecedorEntity fornecedor = new FornecedorEntity();
            fornecedor.setId(fornecedorID);
            produto.setFornecedor(fornecedor);


            DAOProduto.insert(produto);

            limpar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar produto: ",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public void limpar(){
        textCodigoBarra.setText("");
        textNome.setText("");
        textDescricao.setText("");
        textQuantidade.setText("");
        textPreco.setText("");
        textLocalizacao.setText("");
        textCnpjFornecedor.setText("");

    }

    public WinCadastroProdutos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 884, 502);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 102, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel
        panel = new JPanel();
        panel.setBackground(new Color(102, 153, 204));
        panel.setBounds(162, 25, 504, 335);
        panel.setLayout(null);
        contentPane.add(panel);

        // Título
        lblTitulo = new JLabel("CADASTRO DE PRODUTO");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTitulo.setBounds(73, 10, 404, 44);
        panel.add(lblTitulo);


        // Código de Barra
        lblCodigoBarra = new JLabel("Código de Barra:");
        lblCodigoBarra.setBounds(14, 91, 194, 16);
        panel.add(lblCodigoBarra);

        textCodigoBarra = new JTextField();
        textCodigoBarra.setColumns(10);
        textCodigoBarra.setBounds(121, 88, 252, 22);
        panel.add(textCodigoBarra);

        // Nome
        lblNome = new JLabel("Nome:");
        lblNome.setBounds(73, 120, 56, 16);
        panel.add(lblNome);

        textNome = new JTextField();
        textNome.setColumns(10);
        textNome.setBounds(121, 120, 310, 22);
        panel.add(textNome);

        // Descrição
        lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(45, 149, 105, 16);
        panel.add(lblDescricao);

        textDescricao = new JTextArea();
        textDescricao.setLineWrap(true);
        textDescricao.setWrapStyleWord(true);
        JScrollPane scrollDescricao = new JScrollPane(textDescricao);
        scrollDescricao.setBounds(121, 149, 310, 66);
        panel.add(scrollDescricao);

        // Quantidade
        lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(32, 228, 97, 16);
        panel.add(lblQuantidade);

        textQuantidade = new JTextField();
        textQuantidade.setColumns(10);
        textQuantidade.setBounds(121, 225, 116, 22);
        panel.add(textQuantidade);

        // Preço
        lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(280, 228, 97, 16);
        panel.add(lblPreco);

        textPreco = new JTextField();
        textPreco.setColumns(10);
        textPreco.setBounds(320, 225, 110, 22);
        panel.add(textPreco);

        // Localização
        lblLocalizacao = new JLabel("Localização:");
        lblLocalizacao.setBounds(34, 257, 114, 16);
        panel.add(lblLocalizacao);

        textLocalizacao = new JTextField();
        textLocalizacao.setColumns(10);
        textLocalizacao.setBounds(121, 254, 116, 22);
        panel.add(textLocalizacao);

        // Fornecedor
        lblCnpjFornecedor = new JLabel("CNPJ Fornecedor:");
        lblCnpjFornecedor.setBounds(7, 286, 114, 16);
        panel.add(lblCnpjFornecedor);

        textCnpjFornecedor = new JTextField();
        textCnpjFornecedor.setColumns(10);
        textCnpjFornecedor.setBounds(121, 285, 200, 22);
        panel.add(textCnpjFornecedor);

        /*
        // Botões
        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setForeground(new Color(248, 248, 255));
        btnCancelar.setBackground(new Color(220, 20, 60));
        btnCancelar.setBounds(267, 381, 135, 32);
        contentPane.add(btnCancelar);
         */

        btnCadastrar = new JButton("CADASTRAR +");
        btnCadastrar.setForeground(new Color(248, 248, 255));
        btnCadastrar.setBackground(new Color(102, 204, 102));
        btnCadastrar.setBounds(340, 365, 135, 32);
        contentPane.add(btnCadastrar);
        btnCadastrar.addActionListener(e -> cadastroProdutos());
    }
}