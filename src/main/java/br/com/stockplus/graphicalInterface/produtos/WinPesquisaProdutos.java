package br.com.stockplus.graphicalInterface.produtos;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WinPesquisaProdutos extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel contentPane;
    public JPanel panel;

    // Campos de texto
    public JTextField textCodigo;
    public JTextField textId;
    public JTextField textNome;
    public JTextField textDescricao;
    public JTextField textQuantidade;
    public JTextField textPreco;
    public JTextField textLocalizacao;

    // Botões
    public JButton btnBuscar;
    public JButton btnLimpar;

    // Tabela
    public JTable tableProdutos;
    public DefaultTableModel tableModel;
    public JScrollPane scrollPane;

    public WinPesquisaProdutos() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1250, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 102, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(102, 153, 204));
        panel.setBounds(30, 24, 547, 450);
        panel.setLayout(null);
        contentPane.add(panel);

        // Título
        JLabel lblTitulo = new JLabel("PESQUISAR PRODUTO");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTitulo.setBounds(100, 10, 400, 44);
        panel.add(lblTitulo);

        // Código (campo de busca)
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(85, 70, 60, 16);
        panel.add(lblCodigo);

        textCodigo = new JTextField();
        textCodigo.setColumns(10);
        textCodigo.setBounds(145, 67, 200, 22);
        panel.add(textCodigo);

        btnBuscar = new JButton("BUSCAR");
        btnBuscar.setBackground(new Color(51, 153, 255));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBounds(355, 66, 100, 25);
        panel.add(btnBuscar);

        // Separador
        JSeparator separator = new JSeparator();
        separator.setBounds(20, 105, 507, 2);
        panel.add(separator);

        JLabel lblResultados = new JLabel("Resultados da Pesquisa:");
        lblResultados.setForeground(Color.WHITE);
        lblResultados.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblResultados.setBounds(20, 115, 200, 20);
        panel.add(lblResultados);

        // ID
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(112, 145, 30, 16);
        panel.add(lblId);

        textId = new JTextField();
        textId.setColumns(10);
        textId.setBounds(145, 142, 80, 22);
        textId.setEditable(false);
        textId.setBackground(Color.LIGHT_GRAY);
        panel.add(textId);

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(95, 177, 50, 16);
        panel.add(lblNome);

        textNome = new JTextField();
        textNome.setColumns(10);
        textNome.setBounds(145, 174, 310, 22);
        textNome.setEditable(false);
        textNome.setBackground(Color.WHITE);
        panel.add(textNome);

        // Descrição
        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(73, 209, 70, 16);
        panel.add(lblDescricao);

        textDescricao = new JTextField();
        textDescricao.setColumns(10);
        textDescricao.setBounds(145, 206, 310, 22);
        textDescricao.setEditable(false);
        textDescricao.setBackground(Color.WHITE);
        panel.add(textDescricao);

        // Quantidade
        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(60, 241, 85, 16);
        panel.add(lblQuantidade);

        textQuantidade = new JTextField();
        textQuantidade.setColumns(10);
        textQuantidade.setBounds(145, 238, 100, 22);
        textQuantidade.setEditable(false);
        textQuantidade.setBackground(Color.WHITE);
        panel.add(textQuantidade);

        // Preço
        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(280, 241, 50, 16);
        panel.add(lblPreco);

        textPreco = new JTextField();
        textPreco.setColumns(10);
        textPreco.setBounds(325, 238, 130, 22);
        textPreco.setEditable(false);
        textPreco.setBackground(Color.WHITE);
        panel.add(textPreco);

        // Localização
        JLabel lblLocalizacao = new JLabel("Localização:");
        lblLocalizacao.setBounds(60, 273, 85, 16);
        panel.add(lblLocalizacao);

        textLocalizacao = new JTextField();
        textLocalizacao.setColumns(10);
        textLocalizacao.setBounds(145, 270, 193, 22);
        textLocalizacao.setEditable(false);
        textLocalizacao.setBackground(Color.WHITE);
        panel.add(textLocalizacao);

        btnLimpar = new JButton("LIMPAR");
        btnLimpar.setForeground(new Color(248, 248, 255));
        btnLimpar.setBackground(new Color(255, 140, 0));
        btnLimpar.setBounds(225, 480, 135, 32);
        contentPane.add(btnLimpar);

        // PAINEL DIREITO - Tabela com todos os produtos
        JPanel panelTabela = new JPanel();
        panelTabela.setBackground(new Color(102, 153, 204));
        panelTabela.setBounds(600, 24, 600, 450);
        panelTabela.setLayout(null);
        contentPane.add(panelTabela);

        JLabel lblTodosProdutos = new JLabel("TODOS OS PRODUTOS");
        lblTodosProdutos.setForeground(Color.WHITE);
        lblTodosProdutos.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTodosProdutos.setBounds(180, 10, 300, 30);
        panelTabela.add(lblTodosProdutos);

        String[] colunas = {"Código", "Nome", "Descrição", "Quantidade", "Preço", "Localização", "Fornecedor"};
        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableProdutos = new JTable(tableModel);
        tableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Larguras das colunas
        tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableProdutos.getColumnModel().getColumn(0).setMaxWidth(100);
        tableProdutos.getColumnModel().getColumn(0).setMinWidth(100);

        tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(200);
        tableProdutos.getColumnModel().getColumn(1).setMaxWidth(200);
        tableProdutos.getColumnModel().getColumn(1).setMinWidth(200);

        tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(250);
        tableProdutos.getColumnModel().getColumn(2).setMaxWidth(250);
        tableProdutos.getColumnModel().getColumn(2).setMinWidth(250);

        tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(90);
        tableProdutos.getColumnModel().getColumn(3).setMaxWidth(90);
        tableProdutos.getColumnModel().getColumn(3).setMinWidth(90);

        tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(100);
        tableProdutos.getColumnModel().getColumn(4).setMaxWidth(100);
        tableProdutos.getColumnModel().getColumn(4).setMinWidth(100);

        tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(120);
        tableProdutos.getColumnModel().getColumn(5).setMaxWidth(120);
        tableProdutos.getColumnModel().getColumn(5).setMinWidth(120);

        tableProdutos.getColumnModel().getColumn(6).setPreferredWidth(150);
        tableProdutos.getColumnModel().getColumn(6).setMaxWidth(150);
        tableProdutos.getColumnModel().getColumn(6).setMinWidth(150);

        tableProdutos.getTableHeader().setResizingAllowed(false);
        tableProdutos.getTableHeader().setReorderingAllowed(false);

        scrollPane = new JScrollPane(tableProdutos);
        tableProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(20, 50, 560, 380);
        panelTabela.add(scrollPane);
    }
}