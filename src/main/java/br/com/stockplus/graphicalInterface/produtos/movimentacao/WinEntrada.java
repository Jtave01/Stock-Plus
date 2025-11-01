package br.com.stockplus.graphicalInterface.produtos.movimentacao;

import br.com.stockplus.dao.ProdutoDAO;
import br.com.stockplus.entity.ProdutoEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinEntrada extends JFrame {

    public JPanel contentPane;
    public JPanel panel;

    // Campos de texto
    public JTextField textNomeProduto;
    public JTextArea textDescricao;
    public JTextField textEstoqueAtual;
    public JTextField textQuantidade;
    public JTextField textCodigoBarra;

    // Labels
    private JLabel lblTitulo;
    private JLabel lblCodigoBarra;
    private JLabel lblNomeProduto;
    private JLabel lblDescricao;
    private JLabel lblEstoqueAtual;
    private JLabel lblQuantidade;

    // Botões
    private JButton btnPesquisar;
    private JButton btnAdicionar;

    // Scroll
    private JScrollPane scrollDescricao;

    public void auxPesquisr(){
        try {
            String codigoBarras = textCodigoBarra.getText();
            ProdutoDAO DAO = new ProdutoDAO();
            ProdutoEntity produto = new ProdutoEntity();

            produto = DAO.findByCode(codigoBarras);



            textNomeProduto.setText(produto.getNome());
            textDescricao.setText(produto.getDescricao());
            textEstoqueAtual.setText(String.valueOf(produto.getQuantidade()));
            textDescricao.setEnabled(true);
            textNomeProduto.setEnabled(true);
            textEstoqueAtual.setEnabled(true);
            textDescricao.setEditable(false);
            textNomeProduto.setEditable(false);
            textEstoqueAtual.setEditable(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao pesquisar produto: ",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public void limpar(){
        textCodigoBarra.setText("");
        textDescricao.setText("");
        textQuantidade.setText("");
        textNomeProduto.setText("");
        textEstoqueAtual.setText("");
    }

    public void auxEntrada(){
        try {

            String code = textCodigoBarra.getText();
            ProdutoEntity produto = new ProdutoEntity();
            ProdutoDAO DAO = new ProdutoDAO();

            Long id = DAO.findByCodeForId(code);

            Integer value = Integer.valueOf(textQuantidade.getText());

            produto = DAO.findByCode(code);

            produto.setQuantidade(produto.getQuantidade() + value);

            DAO.updateEntrda(produto);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao atualizar o produto: ",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


    }

    public WinEntrada() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        setLocationRelativeTo(null);
        setTitle("Entrada de Estoque");

        contentPane = new JPanel();
        contentPane.setBackground(Color.white);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel centralizado
        panel = new JPanel();
        panel.setBackground(new Color(102, 153, 204));
        panel.setBounds(284, 85, 713, 470);
        panel.setLayout(null);
        contentPane.add(panel);

        // Título
        lblTitulo = new JLabel("ENTRADA DE ESTOQUE");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setBounds(190, 20, 350, 40);
        panel.add(lblTitulo);

        // Código de Barra
        lblCodigoBarra = new JLabel("Código de Barra:");
        lblCodigoBarra.setForeground(Color.WHITE);
        lblCodigoBarra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblCodigoBarra.setBounds(50, 80, 120, 20);
        panel.add(lblCodigoBarra);

        textCodigoBarra = new JTextField();
        textCodigoBarra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textCodigoBarra.setBounds(170, 78, 280, 25);
        panel.add(textCodigoBarra);

        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBackground(new Color(51, 153, 255));
        btnPesquisar.setForeground(Color.WHITE);
        btnPesquisar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnPesquisar.setBounds(460, 78, 100, 25);
        btnPesquisar.addActionListener(e -> auxPesquisr());
        panel.add(btnPesquisar);

        // Nome do Produto (campo pequeno)
        lblNomeProduto = new JLabel("Nome do Produto:");
        lblNomeProduto.setForeground(Color.WHITE);
        lblNomeProduto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNomeProduto.setBounds(50, 120, 130, 20);
        panel.add(lblNomeProduto);

        textNomeProduto = new JTextField();
        textNomeProduto.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textNomeProduto.setBounds(180, 118, 380, 25);
        textNomeProduto.setEnabled(false);
        panel.add(textNomeProduto);

        // Descrição (campo grande com scroll)
        lblDescricao = new JLabel("Descrição:");
        lblDescricao.setForeground(Color.WHITE);
        lblDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDescricao.setBounds(50, 155, 80, 20);
        panel.add(lblDescricao);

        textDescricao = new JTextArea();
        textDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        textDescricao.setLineWrap(true);
        textDescricao.setWrapStyleWord(true);
        textDescricao.setEnabled(false);

        scrollDescricao = new JScrollPane(textDescricao);
        scrollDescricao.setBounds(50, 180, 610, 160);
        panel.add(scrollDescricao);

        // Estoque Atual
        lblEstoqueAtual = new JLabel("Estoque Atual:");
        lblEstoqueAtual.setForeground(Color.WHITE);
        lblEstoqueAtual.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblEstoqueAtual.setBounds(50, 360, 100, 20);
        panel.add(lblEstoqueAtual);

        textEstoqueAtual = new JTextField();
        textEstoqueAtual.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textEstoqueAtual.setBounds(160, 358, 100, 25);
        textEstoqueAtual.setEnabled(false);
        panel.add(textEstoqueAtual);

        // Quantidade
        lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setForeground(Color.WHITE);
        lblQuantidade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblQuantidade.setBounds(280, 360, 90, 20);
        panel.add(lblQuantidade);

        textQuantidade = new JTextField();
        textQuantidade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textQuantidade.setBounds(370, 358, 80, 25);
        panel.add(textQuantidade);

        btnAdicionar = new JButton("Adicionar +");
        btnAdicionar.setBackground(new Color(25, 79, 110));;
        btnAdicionar.setForeground(Color.WHITE);
        btnAdicionar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnAdicionar.addActionListener(e -> {
            if(Integer.parseInt(textQuantidade.getText()) < 0){
                JOptionPane.showMessageDialog(this, "Insiara um valor positivo maior que 0 " +
                        "para dar entrada ");
                textQuantidade.setText("");
            }else{

                auxEntrada();
            }
        } );
        btnAdicionar.setBounds(470, 358, 120, 25);
        panel.add(btnAdicionar);
    }
}