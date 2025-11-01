package br.com.stockplus.graphicalInterface.usuarios;

import br.com.stockplus.dao.UsuarioDAO;
import br.com.stockplus.entity.UsuarioEntity;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class WinPesquisaUsuario extends JFrame {

    private JPanel contentPane;
    private JPanel panel;

    // Campos de texto
    private JTextField textUsuario;
    private JTextField textId;
    private JTextField textNome;
    private JTextField textEmail;
    private JTextField textPermissao;

    // Botões
    private JButton btnBuscar;
    private JButton btnLimpar;

    // Tabelas
    private DefaultTableModel tableModel;
    private JTable tabelaUsuarios;
    private JScrollPane scrollPane;

    private void buscarUsuario() {
        var DAO = new UsuarioDAO();
        String username = textUsuario.getText();

        try {
            UsuarioEntity usuario = DAO.findByUserName(username);
            String role = usuario.getRole().getId() == 1L ? "Administrador" : "Usuário";

            textId.setText(String.valueOf(usuario.getId()));
            textNome.setText(usuario.getNome());
            textEmail.setText(usuario.getEmail());
            textPermissao.setText(role);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Usuário não encontrado");
        }
    }

    private void limparCampos() {
        textUsuario.setText("");
        textId.setText("");
        textNome.setText("");
        textEmail.setText("");
        textPermissao.setText("");
    }

    public WinPesquisaUsuario() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 650, 430);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(102, 153, 204));
        panel.setBounds(10, 24, 610, 310);
        panel.setLayout(null);
        contentPane.add(panel);

        // Título
        JLabel lblTitulo = new JLabel("PESQUISAR USUÁRIO");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTitulo.setBounds(140, 10, 350, 44);
        panel.add(lblTitulo);

        // Usuário
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(30, 70, 63, 16);
        panel.add(lblUsuario);

        textUsuario = new JTextField();
        textUsuario.setColumns(10);
        textUsuario.setBounds(95, 67, 200, 22);
        panel.add(textUsuario);

        btnBuscar = new JButton("BUSCAR");
        btnBuscar.setBackground(new Color(51, 153, 255));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBounds(305, 66, 100, 25);
        panel.add(btnBuscar);
        btnBuscar.addActionListener(e -> buscarUsuario());

        btnLimpar = new JButton("LIMPAR");
        btnLimpar.setForeground(new Color(248, 248, 255));
        btnLimpar.setBackground(new Color(25, 79, 110));
        btnLimpar.setBounds(415, 66, 100, 25);
        btnLimpar.addActionListener(e -> limparCampos());
        panel.add(btnLimpar);

        // Separador
        JSeparator separator = new JSeparator();
        separator.setBounds(20, 105, 570, 2);
        panel.add(separator);

        JLabel lblResultados = new JLabel("Resultados da Pesquisa:");
        lblResultados.setForeground(Color.WHITE);
        lblResultados.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblResultados.setBounds(20, 115, 200, 20);
        panel.add(lblResultados);

        // ID
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(60, 145, 30, 16);
        panel.add(lblId);

        textId = new JTextField();
        textId.setColumns(10);
        textId.setBounds(95, 142, 80, 22);
        textId.setEditable(false);
        textId.setFocusable(false);
        textId.setBackground(Color.LIGHT_GRAY);
        panel.add(textId);

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(45, 177, 50, 16);
        panel.add(lblNome);

        textNome = new JTextField();
        textNome.setColumns(10);
        textNome.setBounds(95, 174, 420, 22);
        textNome.setEditable(false);
        textNome.setFocusable(false);
        textNome.setBackground(Color.WHITE);
        panel.add(textNome);

        // E-mail
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(37, 209, 60, 16);
        panel.add(lblEmail);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(95, 206, 420, 22);
        textEmail.setEditable(false);
        textEmail.setFocusable(false);
        textEmail.setBackground(Color.WHITE);
        panel.add(textEmail);

        // Permissão
        JLabel lblPermissao = new JLabel("Permissão:");
        lblPermissao.setBounds(14, 241, 80, 16);
        panel.add(lblPermissao);

        textPermissao = new JTextField();
        textPermissao.setColumns(10);
        textPermissao.setBounds(95, 238, 193, 22);
        textPermissao.setEditable(false);
        textPermissao.setFocusable(false);
        textPermissao.setBackground(Color.WHITE);
        panel.add(textPermissao);

        JPanel panelTabela = new JPanel();
        panelTabela.setBackground(new Color(102, 153, 204));
        panelTabela.setBounds(665, 24, 600, 450);
        panelTabela.setLayout(null);
        contentPane.add(panelTabela);

        String[] columns = {"Username", "Nome", "Email", "Permissão"};
        tableModel = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelaUsuarios = new JTable(tableModel);

        tabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabelaUsuarios.getColumnModel().getColumn(0).setMaxWidth(100);
        tabelaUsuarios.getColumnModel().getColumn(0).setMinWidth(100);

        tabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelaUsuarios.getColumnModel().getColumn(1).setMaxWidth(200);
        tabelaUsuarios.getColumnModel().getColumn(1).setMinWidth(200);

        tabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(250);
        tabelaUsuarios.getColumnModel().getColumn(2).setMaxWidth(250);
        tabelaUsuarios.getColumnModel().getColumn(2).setMinWidth(250);

        tabelaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(90);
        tabelaUsuarios.getColumnModel().getColumn(3).setMaxWidth(90);
        tabelaUsuarios.getColumnModel().getColumn(3).setMinWidth(90);

        tabelaUsuarios.getTableHeader().setResizingAllowed(false);
        tabelaUsuarios.getTableHeader().setReorderingAllowed(false);
        tabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {

        });
        scrollPane = new JScrollPane(tabelaUsuarios);
        tabelaUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(20, 50, 560, 380);
        panelTabela.add(scrollPane);
        carregarTodosUsuarios();


    }

    public void carregarTodosUsuarios(){
        try {
            tableModel.setRowCount(0);
            UsuarioDAO DAO = new UsuarioDAO();

            List<UsuarioEntity> usuarios = DAO.findAll();

            for(UsuarioEntity u: usuarios){
                String permicao = "";
                if(u.getRole().getId() == 1 ){
                    permicao += "ADMIN";
                }else{
                    permicao += "USUARIO";
                }
                Object[] linha = {
                  u.getUsaername(),
                  u.getNome(),
                  u.getEmail(),
                  permicao
                };
                tableModel.addRow(linha);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar fornecedores: ",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}