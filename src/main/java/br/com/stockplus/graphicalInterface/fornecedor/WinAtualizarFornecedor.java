package br.com.stockplus.graphicalInterface.fornecedor;

import br.com.stockplus.dao.FornecedorDAO;
import br.com.stockplus.entity.FornecedorEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WinAtualizarFornecedor extends JFrame {


    public JPanel contentPane;
    public JPanel panel;

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
    public JButton btnBuscar;
    public JButton btnAtualizar;
    public JButton btnDeletar;


    public void atualizarFornecedor() {
        FornecedorEntity entity = new FornecedorEntity();
        FornecedorDAO DAO = new FornecedorDAO();

        Long id = Long.valueOf(textId.getText());
        String cnpj = textCnpj.getText();
        String razaoSocial = textRazaoSocial.getText();
        String email = textEmail.getText();
        String endereco = textEndereco.getText();
        String numeroEndereco = textNumero.getText();
        String telefone = textTelefone.getText();
        String cidade = textCidade.getText();
        String uf = textUf.getText();
        String bairroEndereco = textBairro.getText();

        try {
            entity.setCnpj(cnpj);
            entity.setRazaoSocial(razaoSocial);
            entity.setEmail(email);
            entity.setEndereco(endereco);
            entity.setNumeroEndereco(numeroEndereco);
            entity.setTelefone(telefone);
            entity.setCidade(cidade);
            entity.setUf(uf);
            entity.setBairroEndereco(bairroEndereco);
            entity.setId(id);
            DAO.update(entity);


            JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarFornecedor(){
        FornecedorDAO DAO = new FornecedorDAO();
        FornecedorEntity fornecedor = new FornecedorEntity();

        try {

            Long idConvert = Long.parseLong(textId.getText());


            fornecedor =  DAO.findById(idConvert);


            textCnpj.setText(fornecedor.getCnpj());
            textRazaoSocial.setText(fornecedor.getRazaoSocial());
            textEmail.setText(fornecedor.getEmail());
            textEndereco.setText(fornecedor.getEndereco());
            textNumero.setText(fornecedor.getNumeroEndereco());
            textTelefone.setText(fornecedor.getTelefone());
            textCidade.setText(fornecedor.getCidade());
            textUf.setText(fornecedor.getUf());
            textBairro.setText(fornecedor.getBairroEndereco());

            habilitar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "\"Fornecedor não encontrado.\"");
        }

    }

    public void deetarFornecedor(){
        Long id = Long.valueOf(textId.getText());

        try {
            FornecedorDAO DAO = new FornecedorDAO();


            DAO.delete(id);

            limpar();
            JOptionPane.showMessageDialog(this, "Fornecedor deletado com sucesso");

        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public void habilitar(){


        textCnpj.setEnabled(true);
        textRazaoSocial.setEnabled(true);
        textEmail.setEnabled(true);
        textEndereco.setEnabled(true);
        textNumero.setEnabled(true);
        textTelefone.setEnabled(true);
        textCidade.setEnabled(true);
        textUf.setEnabled(true);
        textBairro.setEnabled(true);

    }

    public void limpar(){
        textId.setText("");
        textCnpj.setText("");
        textRazaoSocial.setText("");
        textEmail.setText("");
        textEndereco.setText("");
        textNumero.setText("");
        textTelefone.setText("");
        textCidade.setText("");
        textUf.setText("");
        textBairro.setText("");

    }

    public WinAtualizarFornecedor() {


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
        JLabel lblTitulo = new JLabel("ATUALIZAR FORNECEDOR");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTitulo.setBounds(70, 10, 450, 44);
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
        btnBuscar.setEnabled(true);
        panel.add(btnBuscar);
        btnBuscar.addActionListener( e -> buscarFornecedor());

        // CNPJ
        JLabel lblCnpj = new JLabel("CNPJ:");
        lblCnpj.setBounds(95, 102, 50, 16);
        panel.add(lblCnpj);

        textCnpj = new JTextField();
        textCnpj.setColumns(10);
        textCnpj.setBounds(145, 99, 310, 22);
        textCnpj.setEnabled(false);
        panel.add(textCnpj);

        // Razão Social
        JLabel lblRazaoSocial = new JLabel("Razão Social:");
        lblRazaoSocial.setBounds(53, 134, 90, 16);
        panel.add(lblRazaoSocial);

        textRazaoSocial = new JTextField();
        textRazaoSocial.setColumns(10);
        textRazaoSocial.setBounds(145, 131, 310, 22);
        textRazaoSocial.setEnabled(false);
        panel.add(textRazaoSocial);

        // E-mail
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(89, 166, 105, 16);
        panel.add(lblEmail);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(145, 163, 310, 22);
        textEmail.setEnabled(false);
        panel.add(textEmail);

        // Endereço
        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(73, 198, 70, 16);
        panel.add(lblEndereco);

        textEndereco = new JTextField();
        textEndereco.setColumns(10);
        textEndereco.setBounds(145, 195, 310, 22);
        textEndereco.setEnabled(false);
        panel.add(textEndereco);

        // Número
        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(80, 230, 65, 16);
        panel.add(lblNumero);

        textNumero = new JTextField();
        textNumero.setColumns(10);
        textNumero.setBounds(145, 227, 100, 22);
        textNumero.setEnabled(false);
        panel.add(textNumero);

        // Telefone
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(280, 230, 70, 16);
        panel.add(lblTelefone);

        textTelefone = new JTextField();
        textTelefone.setColumns(10);
        textTelefone.setBounds(345, 227, 110, 22);
        textTelefone.setEnabled(false);
        panel.add(textTelefone);

        // Bairro
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setBounds(90, 262, 55, 16);
        panel.add(lblBairro);

        textBairro = new JTextField();
        textBairro.setColumns(10);
        textBairro.setBounds(145, 259, 193, 22);
        textBairro.setEnabled(false);
        panel.add(textBairro);

        // Cidade
        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(87, 294, 60, 16);
        panel.add(lblCidade);

        textCidade = new JTextField();
        textCidade.setColumns(10);
        textCidade.setBounds(145, 291, 193, 22);
        textCidade.setEnabled(false);
        panel.add(textCidade);

        // UF
        JLabel lblUf = new JLabel("UF:");
        lblUf.setBounds(350, 294, 30, 16);
        panel.add(lblUf);

        textUf = new JTextField();
        textUf.setColumns(10);
        textUf.setBounds(375, 291, 80, 22);
        textUf.setEnabled(false);
        panel.add(textUf);

        // Aviso
        JLabel lblAviso = new JLabel("* Busque o fornecedor pelo ID para editar");
        lblAviso.setForeground(Color.WHITE);
        lblAviso.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblAviso.setBounds(145, 355, 300, 16);
        panel.add(lblAviso);

        // Botões
        btnDeletar = new JButton("DELETAR");
        btnDeletar.setForeground(new Color(248, 248, 255));
        btnDeletar.setBackground(new Color(220, 20, 60));
        btnDeletar.setBounds(254, 455, 135, 32);
        contentPane.add(btnDeletar);
        btnDeletar.addActionListener(e -> deetarFornecedor());


        btnAtualizar = new JButton("ATUALIZAR");
        btnAtualizar.setForeground(new Color(248, 248, 255));
        btnAtualizar.setBackground(new Color(102, 204, 102));
        btnAtualizar.setBounds(428, 455, 135, 32);
        btnAtualizar.setEnabled(true);
        contentPane.add(btnAtualizar);
        btnAtualizar.addActionListener(e -> atualizarFornecedor());
    }
}