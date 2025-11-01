package br.com.stockplus.graphicalInterface.produtos;

import br.com.stockplus.dao.FornecedorDAO;
import br.com.stockplus.dao.ProdutoDAO;
import br.com.stockplus.entity.FornecedorEntity;
import br.com.stockplus.entity.ProdutoEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GerenciarProdutos extends JFrame {

    // Painéis
    public JPanel contentPane;
    public JPanel panelCadastro;
    public JPanel panelAtualizar;

    // CAMPOS DO CADASTRO
    // Campos de texto - Cadastro
    public JTextField textCodigoBarra;
    public JTextField textNome;
    public JTextArea textDescricao;
    public JTextField textQuantidade;
    public JTextField textPreco;
    public JTextField textLocalizacao;
    public JTextField textCnpjFornecedor;

    // Botões - Cadastro
    public JButton btnCadastrar;
    public JButton btnCancelar;

    // CAMPOS DA ATUALIZAÇÃO
    // Campos de texto - Atualizar
    public JTextField textIdAut;
    public JTextField textCodigoAut;
    public JTextField textNomeAut;
    public JTextField textDescricaoAut;
    public JTextField textQuantidadeAut;
    public JTextField textPrecoAut;
    public JTextField textLocalizacaoAut;
    public JTextField textFornecedorAut;

    // Botões - Atualizar
    public JButton btnBuscarAut;
    public JButton btnAtualizarAut;
    public JButton btnDeletarAut;

    //  MÉTODOS DE CADASTRO
    private void cadastroDeProduto() {
        try {
            FornecedorDAO DAOFornecedor = new FornecedorDAO();
            Long fornecedorID = DAOFornecedor.findByIdCnpj(textCnpjFornecedor.getText());
            ProdutoDAO DAOProduto = new ProdutoDAO();

            ProdutoEntity produto = new ProdutoEntity();

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

            limparCamposCadastro();
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar produto: ",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void limparCamposCadastro() {
        textCodigoBarra.setText("");
        textNome.setText("");
        textDescricao.setText("");
        textQuantidade.setText("");
        textPreco.setText("");
        textLocalizacao.setText("");
        textCnpjFornecedor.setText("");
    }

    // MÉTODOS DE ATUALIZAÇÃO
    public void buscarProduto() {
        try {
            ProdutoDAO DAO = new ProdutoDAO();
            Long id = Long.valueOf(textIdAut.getText());

            ProdutoEntity produto = DAO.findById(id);

            textCodigoAut.setText(produto.getCodIdent());
            textNomeAut.setText(produto.getNome());
            textDescricaoAut.setText(produto.getDescricao());
            textQuantidadeAut.setText(String.valueOf(produto.getQuantidade()));
            textPrecoAut.setText(String.valueOf(produto.getPreco()));
            textLocalizacaoAut.setText(produto.getLocalizacao());

            FornecedorEntity fornecedor = new FornecedorEntity();
            fornecedor.setId(produto.getFornecedor().getId());
            FornecedorDAO DAOf = new FornecedorDAO();
            String fornecedorCnpj = DAOf.findByCnpjFromId(fornecedor.getId());

            textFornecedorAut.setText(fornecedorCnpj);

            habilitarCamposAtualizacao();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao buscar produto: ", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void atualizarProduto() {
        try {
            ProdutoDAO DAO = new ProdutoDAO();
            ProdutoEntity produto = new ProdutoEntity();

            Long id = Long.valueOf(textIdAut.getText());
            produto.setId(id);
            produto.setCodIdent(textCodigoAut.getText());
            produto.setNome(textNomeAut.getText());
            produto.setDescricao(textDescricaoAut.getText());
            produto.setQuantidade(Integer.valueOf(textQuantidadeAut.getText()));
            produto.setPreco(Double.valueOf(textPrecoAut.getText()));
            produto.setLocalizacao(textLocalizacaoAut.getText());

            FornecedorDAO DAOF = new FornecedorDAO();
            Long fornecedorId = DAOF.findByIdCnpj(textFornecedorAut.getText());
            FornecedorEntity fornecedor = DAOF.findById(fornecedorId);
            produto.setFornecedor(fornecedor);

            DAO.update(produto);

            JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
            limparCamposAtualizacao();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao atualizar produto: " ,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void deletarProduto() {
        try {
            Long id = Long.valueOf(textIdAut.getText());
            ProdutoDAO DAO = new ProdutoDAO();

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja deletar este produto?",
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                DAO.delete(id);
                limparCamposAtualizacao();
                JOptionPane.showMessageDialog(this, "Produto deletado com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao deletar produto: " ,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void habilitarCamposAtualizacao() {
        textCodigoAut.setEnabled(true);
        textNomeAut.setEnabled(true);
        textDescricaoAut.setEnabled(true);
        textQuantidadeAut.setEnabled(true);
        textPrecoAut.setEnabled(true);
        textLocalizacaoAut.setEnabled(true);
        textFornecedorAut.setEnabled(true);
    }

    public void limparCamposAtualizacao() {
        textIdAut.setText("");
        textCodigoAut.setText("");
        textNomeAut.setText("");
        textDescricaoAut.setText("");
        textQuantidadeAut.setText("");
        textPrecoAut.setText("");
        textLocalizacaoAut.setText("");
        textFornecedorAut.setText("");
        textCodigoAut.setEnabled(false);
        textNomeAut.setEnabled(false);
        textDescricaoAut.setEnabled(false);
        textQuantidadeAut.setEnabled(false);
        textPrecoAut.setEnabled(false);
        textLocalizacaoAut.setEnabled(false);
        textFornecedorAut.setEnabled(false);
    }

    public GerenciarProdutos() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1250, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // PAINEL DE CADASTRO
        panelCadastro = new JPanel();
        panelCadastro.setBackground(new Color(102, 153, 204));
        panelCadastro.setBounds(30, 24, 547, 450);
        panelCadastro.setLayout(null);
        contentPane.add(panelCadastro);

        // Título Cadastro
        JLabel lblTituloCadastro = new JLabel("CADASTRO DE PRODUTO");
        lblTituloCadastro.setForeground(new Color(255, 255, 255));
        lblTituloCadastro.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTituloCadastro.setBounds(100, 10, 400, 44);
        panelCadastro.add(lblTituloCadastro);

        // Código de Barra
        JLabel lblCodigoBarra = new JLabel("Código de Barra:");
        lblCodigoBarra.setBounds(30, 70, 115, 16);
        panelCadastro.add(lblCodigoBarra);

        textCodigoBarra = new JTextField();
        textCodigoBarra.setColumns(10);
        textCodigoBarra.setBounds(145, 67, 310, 22);
        panelCadastro.add(textCodigoBarra);

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(95, 102, 50, 16);
        panelCadastro.add(lblNome);

        textNome = new JTextField();
        textNome.setColumns(10);
        textNome.setBounds(145, 99, 310, 22);
        panelCadastro.add(textNome);

        // Descrição
        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(73, 134, 70, 16);
        panelCadastro.add(lblDescricao);

        textDescricao = new JTextArea();
        textDescricao.setLineWrap(true);
        textDescricao.setWrapStyleWord(true);
        JScrollPane scrollDescricao = new JScrollPane(textDescricao);
        scrollDescricao.setBounds(145, 131, 310, 50);
        panelCadastro.add(scrollDescricao);

        // Quantidade
        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(60, 196, 85, 16);
        panelCadastro.add(lblQuantidade);

        textQuantidade = new JTextField();
        textQuantidade.setColumns(10);
        textQuantidade.setBounds(145, 193, 100, 22);
        panelCadastro.add(textQuantidade);

        // Preço
        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(280, 196, 50, 16);
        panelCadastro.add(lblPreco);

        textPreco = new JTextField();
        textPreco.setColumns(10);
        textPreco.setBounds(325, 193, 130, 22);
        panelCadastro.add(textPreco);

        // Localização
        JLabel lblLocalizacao = new JLabel("Localização:");
        lblLocalizacao.setBounds(60, 228, 85, 16);
        panelCadastro.add(lblLocalizacao);

        textLocalizacao = new JTextField();
        textLocalizacao.setColumns(10);
        textLocalizacao.setBounds(145, 225, 193, 22);
        panelCadastro.add(textLocalizacao);

        // CNPJ Fornecedor
        JLabel lblCnpjFornecedor = new JLabel("CNPJ Fornecedor:");
        lblCnpjFornecedor.setBounds(40, 260, 105, 16);
        panelCadastro.add(lblCnpjFornecedor);

        textCnpjFornecedor = new JTextField();
        textCnpjFornecedor.setColumns(10);
        textCnpjFornecedor.setBounds(145, 257, 310, 22);
        panelCadastro.add(textCnpjFornecedor);

        // Botões Cadastro
        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setForeground(new Color(248, 248, 255));
        btnCancelar.setBackground(new Color(220, 20, 60));
        btnCancelar.setBounds(135, 480, 135, 32);
        btnCancelar.addActionListener(e ->{limparCamposCadastro(); } );
        contentPane.add(btnCancelar);

        btnCadastrar = new JButton("CADASTRAR +");
        btnCadastrar.setForeground(new Color(248, 248, 255));
        btnCadastrar.setBackground(new Color(25, 79, 110));
        btnCadastrar.setBounds(290, 480, 135, 32);
        btnCadastrar.addActionListener(e -> cadastroDeProduto());
        contentPane.add(btnCadastrar);

        // ===== PAINEL DE ATUALIZAÇÃO =====
        panelAtualizar = new JPanel();
        panelAtualizar.setBackground(new Color(102, 153, 204));
        panelAtualizar.setBounds(673, 24, 547, 450);
        panelAtualizar.setLayout(null);
        contentPane.add(panelAtualizar);

        // Título Atualizar
        JLabel lblTituloAtualizar = new JLabel("ATUALIZAR PRODUTO");
        lblTituloAtualizar.setForeground(new Color(255, 255, 255));
        lblTituloAtualizar.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTituloAtualizar.setBounds(100, 10, 400, 44);
        panelAtualizar.add(lblTituloAtualizar);

        // ID + Botão Buscar
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(112, 65, 30, 16);
        panelAtualizar.add(lblId);

        textIdAut = new JTextField();
        textIdAut.setBounds(145, 62, 80, 22);
        panelAtualizar.add(textIdAut);

        btnBuscarAut = new JButton("BUSCAR");
        btnBuscarAut.setBackground(new Color(51, 153, 255));
        btnBuscarAut.setForeground(Color.WHITE);
        btnBuscarAut.setBounds(235, 61, 100, 25);
        panelAtualizar.add(btnBuscarAut);
        btnBuscarAut.addActionListener(e -> buscarProduto());

        // Código Atualizar
        JLabel lblCodigoAut = new JLabel("Código:");
        lblCodigoAut.setBounds(85, 102, 60, 16);
        panelAtualizar.add(lblCodigoAut);

        textCodigoAut = new JTextField();
        textCodigoAut.setColumns(10);
        textCodigoAut.setBounds(145, 99, 310, 22);
        textCodigoAut.setEnabled(false);
        panelAtualizar.add(textCodigoAut);

        // Nome Atualizar
        JLabel lblNomeAut = new JLabel("Nome:");
        lblNomeAut.setBounds(95, 134, 50, 16);
        panelAtualizar.add(lblNomeAut);

        textNomeAut = new JTextField();
        textNomeAut.setColumns(10);
        textNomeAut.setBounds(145, 131, 310, 22);
        textNomeAut.setEnabled(false);
        panelAtualizar.add(textNomeAut);

        // Descrição Atualizar
        JLabel lblDescricaoAut = new JLabel("Descrição:");
        lblDescricaoAut.setBounds(73, 166, 70, 16);
        panelAtualizar.add(lblDescricaoAut);

        textDescricaoAut = new JTextField();
        textDescricaoAut.setColumns(10);
        textDescricaoAut.setBounds(145, 163, 310, 22);
        textDescricaoAut.setEnabled(false);
        panelAtualizar.add(textDescricaoAut);

        // Quantidade Atualizar
        JLabel lblQuantidadeAut = new JLabel("Quantidade:");
        lblQuantidadeAut.setBounds(60, 198, 85, 16);
        panelAtualizar.add(lblQuantidadeAut);

        textQuantidadeAut = new JTextField();
        textQuantidadeAut.setColumns(10);
        textQuantidadeAut.setBounds(145, 195, 100, 22);
        textQuantidadeAut.setEnabled(false);
        panelAtualizar.add(textQuantidadeAut);

        // Preço Atualizar
        JLabel lblPrecoAut = new JLabel("Preço unitário:");
        lblPrecoAut.setBounds(248, 198, 80, 16);
        panelAtualizar.add(lblPrecoAut);

        textPrecoAut = new JTextField();
        textPrecoAut.setColumns(10);
        textPrecoAut.setBounds(325, 195, 130, 22);
        textPrecoAut.setEnabled(false);
        panelAtualizar.add(textPrecoAut);

        // Localização Atualizar
        JLabel lblLocalizacaoAut = new JLabel("Localização:");
        lblLocalizacaoAut.setBounds(60, 230, 85, 16);
        panelAtualizar.add(lblLocalizacaoAut);

        textLocalizacaoAut = new JTextField();
        textLocalizacaoAut.setColumns(10);
        textLocalizacaoAut.setBounds(145, 227, 193, 22);
        textLocalizacaoAut.setEnabled(false);
        panelAtualizar.add(textLocalizacaoAut);

        // Fornecedor Atualizar
        JLabel lblFornecedorAut = new JLabel("Fornecedor(CNPJ):");
        lblFornecedorAut.setBounds(40, 262, 105, 16);
        panelAtualizar.add(lblFornecedorAut);

        textFornecedorAut = new JTextField();
        textFornecedorAut.setColumns(10);
        textFornecedorAut.setBounds(145, 259, 310, 22);
        textFornecedorAut.setEnabled(false);
        panelAtualizar.add(textFornecedorAut);

        // Aviso
        JLabel lblAviso = new JLabel("* Busque o produto pelo ID para editar");
        lblAviso.setForeground(Color.WHITE);
        lblAviso.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblAviso.setBounds(145, 355, 300, 16);
        panelAtualizar.add(lblAviso);

        // Botões Atualização
        btnDeletarAut = new JButton("DELETAR");
        btnDeletarAut.setForeground(Color.WHITE);
        btnDeletarAut.setBackground(new Color(220, 20, 60));
        btnDeletarAut.setBounds(778, 480, 135, 32);
        btnDeletarAut.addActionListener(e -> deletarProduto());
        contentPane.add(btnDeletarAut);

        btnAtualizarAut = new JButton("ATUALIZAR");
        btnAtualizarAut.setForeground(new Color(248, 248, 255));
        btnAtualizarAut.setBackground(new Color(25, 79, 110));;
        btnAtualizarAut.setBounds(933, 480, 135, 32);
        btnAtualizarAut.addActionListener(e -> atualizarProduto());
        contentPane.add(btnAtualizarAut);
    }

}