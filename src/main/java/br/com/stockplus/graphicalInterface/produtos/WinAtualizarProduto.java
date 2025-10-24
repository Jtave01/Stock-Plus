package br.com.stockplus.graphicalInterface.produtos;

import br.com.stockplus.connection.ConnectionUtil;
import br.com.stockplus.dao.FornecedorDAO;
import br.com.stockplus.dao.ProdutoDAO;
import br.com.stockplus.entity.FornecedorEntity;
import br.com.stockplus.entity.ProdutoEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WinAtualizarProduto extends JFrame {

    public JPanel contentPane;
    public JPanel panel;

    // Campos de texto
    public JTextField textId;
    public JTextField textCodigo;
    public JTextField textNome;
    public JTextField textDescricao;
    public JTextField textQuantidade;
    public JTextField textPreco;
    public JTextField textLocalizacao;
    public JTextField textFornecedor;

    // Botões
    public JButton btnBuscar;
    public JButton btnAtualizar;
    public JButton btnDeletar;

    private void buscarProduto(){

        ProdutoDAO DAO = new ProdutoDAO();
        ProdutoEntity produto = new ProdutoEntity();

        try {

            Long id = Long.valueOf(textId.getText());
            produto = DAO.findById(id);

            textCodigo.setText(produto.getCodIdent());
            textNome.setText(produto.getNome());
            textDescricao.setText(produto.getDescricao());
            textQuantidade.setText(String.valueOf(produto.getQuantidade()));
            textPreco.setText(String.valueOf(produto.getPreco()));
            textLocalizacao.setText(produto.getLocalizacao());

            FornecedorEntity fornecedor = new FornecedorEntity();
            fornecedor.setId(produto.getFornecedor().getId());
            FornecedorDAO DAOf = new FornecedorDAO();
            String fornecedorCnpj = DAOf.findByCnpjFromId(fornecedor.getId());

            textFornecedor.setText(fornecedorCnpj);

            liberarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "\"Produto não encontrado.\"");
        }

    }

    private void atualizarProduto(){



        try {
            ProdutoDAO DAO = new ProdutoDAO();
            ProdutoEntity produto  = new ProdutoEntity();

            Long id = Long.valueOf(textId.getText());
            String code = textCodigo.getText();
            String nome  = textNome.getText();
            String descricao = textDescricao.getText();
            Integer quantidade = Integer.valueOf(textQuantidade.getText());
            Double preco = Double.valueOf(textPreco.getText());
            String localizacao = textLocalizacao.getText();


            FornecedorDAO DAOF = new FornecedorDAO();
            Long fornecedorId = DAOF.findByIdCnpj(textFornecedor.getText());

            FornecedorEntity fornecedor = new FornecedorEntity();

            fornecedor = DAOF.findById(fornecedorId);

            produto.setCodIdent(code);
            produto.setNome(nome);
            produto.setDescricao(descricao);
            produto.setQuantidade(quantidade);
            produto.setPreco(preco);
            produto.setLocalizacao(localizacao);
            produto.setFornecedor(fornecedor);
            produto.setId(id);

            DAO.update(produto);

            JOptionPane.showMessageDialog(this, "Fornecedor atualizado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atulizar o produto");
        }

    }

    public void deletarProdutos(){
        Long id = Long.valueOf(textId.getText());
        try{
            ProdutoDAO DAO = new ProdutoDAO();


            DAO.delete(id);


            JOptionPane.showMessageDialog(this, "Produto deletado com suecesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void liberarCampos(){

        textCodigo.setEnabled(true);
        textNome.setEnabled(true);
        textDescricao.setEnabled(true);
        textQuantidade.setEnabled(true);
        textPreco.setEnabled(true);
        textLocalizacao.setEnabled(true);
        textFornecedor.setEnabled(true);

    }

    public WinAtualizarProduto() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 884, 540);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 102, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(102, 153, 204));
        panel.setBounds(133, 24, 547, 420);
        panel.setLayout(null);
        contentPane.add(panel);

        // Título
        JLabel lblTitulo = new JLabel("ATUALIZAR PRODUTO");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTitulo.setBounds(100, 10, 400, 44);
        panel.add(lblTitulo);

        // ID + Botão Buscar
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(112, 65, 30, 16);
        panel.add(lblId);

        textId = new JTextField();
        textId.setBounds(145, 62, 80, 22);
        panel.add(textId);

        btnBuscar = new JButton("BUSCAR");
        btnBuscar.setBackground(new Color(51, 153, 255));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBounds(235, 61, 100, 25);
        panel.add(btnBuscar);
        btnBuscar.addActionListener(e -> buscarProduto());

        // Código
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(85, 102, 60, 16);
        panel.add(lblCodigo);

        textCodigo = new JTextField();
        textCodigo.setColumns(10);
        textCodigo.setBounds(145, 99, 310, 22);
        textCodigo.setEnabled(false);
        panel.add(textCodigo);

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(95, 134, 50, 16);
        panel.add(lblNome);

        textNome = new JTextField();
        textNome.setColumns(10);
        textNome.setBounds(145, 131, 310, 22);
        textNome.setEnabled(false);
        panel.add(textNome);

        // Descrição
        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(73, 166, 70, 16);
        panel.add(lblDescricao);

        textDescricao = new JTextField();
        textDescricao.setColumns(10);
        textDescricao.setBounds(145, 163, 310, 22);
        textDescricao.setEnabled(false);
        panel.add(textDescricao);

        // Quantidade
        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(60, 198, 85, 16);
        panel.add(lblQuantidade);

        textQuantidade = new JTextField();
        textQuantidade.setColumns(10);
        textQuantidade.setBounds(145, 195, 100, 22);
        textQuantidade.setEnabled(false);
        panel.add(textQuantidade);

        // Preço
        JLabel lblPreco = new JLabel("Preço unitário:");
        lblPreco.setBounds(280, 198, 50, 16);
        panel.add(lblPreco);

        textPreco = new JTextField();
        textPreco.setColumns(10);
        textPreco.setBounds(325, 195, 130, 22);
        textPreco.setEnabled(false);
        panel.add(textPreco);

        // Localização
        JLabel lblLocalizacao = new JLabel("Localização:");
        lblLocalizacao.setBounds(60, 230, 85, 16);
        panel.add(lblLocalizacao);

        textLocalizacao = new JTextField();
        textLocalizacao.setColumns(10);
        textLocalizacao.setBounds(145, 227, 193, 22);
        textLocalizacao.setEnabled(false);
        panel.add(textLocalizacao);

        // Fornecedor
        JLabel lblFornecedor = new JLabel("Fornecedor(CNPJ):");
        lblFornecedor.setBounds(60, 262, 85, 16);
        panel.add(lblFornecedor);

        textFornecedor = new JTextField();
        textFornecedor.setColumns(10);
        textFornecedor.setBounds(145, 259, 310, 22);
        textFornecedor.setEnabled(false);
        panel.add(textFornecedor);

        // Aviso
        JLabel lblAviso = new JLabel("* Busque o produto pelo ID para atualizar ou deletar");
        lblAviso.setForeground(Color.WHITE);
        lblAviso.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblAviso.setBounds(145, 320, 300, 16);
        panel.add(lblAviso);

        // Botões
        btnDeletar = new JButton("DELETAR");
        btnDeletar.setForeground(new Color(248, 248, 255));
        btnDeletar.setBackground(new Color(220, 20, 60));
        btnDeletar.setBounds(254, 455, 135, 32);
        contentPane.add(btnDeletar);
        btnDeletar.addActionListener(e -> deletarProdutos());

        btnAtualizar = new JButton("ATUALIZAR");
        btnAtualizar.setForeground(new Color(248, 248, 255));
        btnAtualizar.setBackground(new Color(102, 204, 102));
        btnAtualizar.setBounds(428, 455, 135, 32);
        btnAtualizar.setEnabled(true);
        contentPane.add(btnAtualizar);
        btnAtualizar.addActionListener( e -> atualizarProduto() );
    }
}