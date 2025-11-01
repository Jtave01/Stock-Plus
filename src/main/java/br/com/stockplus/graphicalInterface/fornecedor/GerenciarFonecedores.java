package br.com.stockplus.graphicalInterface.fornecedor;

import br.com.stockplus.dao.FornecedorDAO;
import br.com.stockplus.entity.FornecedorEntity;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class GerenciarFonecedores extends JFrame {

    private static final long serialVersionUID = 1L;

    // Painéis
    public JPanel contentPane;
    public JPanel panelCadastro;
    public JPanel panelAtualizar;

    // CAMPOS DO CADASTRO
    // Campos de texto - Cadastro
    public JTextField textCnpj;
    public JTextField textRazaoSocial;
    public JTextField textEmail;
    public JTextField textEndereco;
    public JTextField textNumero;
    public JTextField textTelefone;
    public JTextField textBairro;
    public JTextField textCidade;
    public JTextField textUf;

    // Botões - Cadastro
    public JButton btnCadastrar;
    public JButton btnCancelar;

    //  CAMPOS DA ATUALIZAÇÃO
    // Campos de texto - Atualizar
    public JTextField textIdAut;
    public JTextField textCnpjAut;
    public JTextField textRazaoSocialAut;
    public JTextField textEmailAut;
    public JTextField textEnderecoAut;
    public JTextField textNumeroAut;
    public JTextField textTelefoneAut;
    public JTextField textBairroAut;
    public JTextField textCidadeAut;
    public JTextField textUfAtu;

    // Botões - Atualizar
    public JButton btnBuscarAut;
    public JButton btnAtualizarAut;
    public JButton btnDeletarAut;

    // MÉTODOS DE CADASTRO
    private void cadastroDeFornecedor() {
        try {
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

            limparCamposCadastro();
            JOptionPane.showMessageDialog(this, "Fornecedor cadastrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar fornecedor: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void limparCamposCadastro() {
        textCnpj.setText("");
        textRazaoSocial.setText("");
        textEmail.setText("");
        textEndereco.setText("");
        textNumero.setText("");
        textTelefone.setText("");
        textBairro.setText("");
        textCidade.setText("");
        textUf.setText("");
    }

    //  MÉTODOS DE ATUALIZAÇÃO
    public void buscarFornecedor() {

        FornecedorEntity fornecedor = new FornecedorEntity();
        FornecedorDAO DAO = new FornecedorDAO();
        try {
            Long idConvert = Long.parseLong(textIdAut.getText());
            fornecedor = DAO.findById(idConvert);


                textCnpjAut.setText(fornecedor.getCnpj());
                textRazaoSocialAut.setText(fornecedor.getRazaoSocial());
                textEmailAut.setText(fornecedor.getEmail());
                textEnderecoAut.setText(fornecedor.getEndereco());
                textNumeroAut.setText(fornecedor.getNumeroEndereco());
                textTelefoneAut.setText(fornecedor.getTelefone());
                textCidadeAut.setText(fornecedor.getCidade());
                textUfAtu.setText(fornecedor.getUf());
                textBairroAut.setText(fornecedor.getBairroEndereco());
                if(textCnpjAut.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this,
                            "Fornecedor não encontrado .",
                            "Não Encontrado",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                habilitarCamposAtualizacao();



        }
        catch (Exception e) {
            limparCamposAtualizacao();
            JOptionPane.showMessageDialog(this,
                    " Fornecedor não encontrado: ",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void atualizarFornecedor() {
        try {
            FornecedorEntity entity = new FornecedorEntity();
            FornecedorDAO DAO = new FornecedorDAO();

            entity.setId(Long.valueOf(textIdAut.getText()));
            entity.setCnpj(textCnpjAut.getText());
            entity.setRazaoSocial(textRazaoSocialAut.getText());
            entity.setEmail(textEmailAut.getText());
            entity.setEndereco(textEnderecoAut.getText());
            entity.setNumeroEndereco(textNumeroAut.getText());
            entity.setTelefone(textTelefoneAut.getText());
            entity.setCidade(textCidadeAut.getText());
            entity.setUf(textUfAtu.getText());
            entity.setBairroEndereco(textBairroAut.getText());

            DAO.update(entity);

            JOptionPane.showMessageDialog(this, "Fornecedor atualizado com sucesso!");
            limparCamposAtualizacao();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao atualizar fornecedor: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void deletarFornecedor() {
        try {
            Long id = Long.valueOf(textIdAut.getText());
            FornecedorDAO DAO = new FornecedorDAO();

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja deletar este fornecedor?",
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                DAO.delete(id);
                limparCamposAtualizacao();
                JOptionPane.showMessageDialog(this, "Fornecedor deletado com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao deletar fornecedor: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void habilitarCamposAtualizacao() {
        textCnpjAut.setEnabled(true);
        textRazaoSocialAut.setEnabled(true);
        textEmailAut.setEnabled(true);
        textEnderecoAut.setEnabled(true);
        textNumeroAut.setEnabled(true);
        textTelefoneAut.setEnabled(true);
        textCidadeAut.setEnabled(true);
        textUfAtu.setEnabled(true);
        textBairroAut.setEnabled(true);
    }

    public void limparCamposAtualizacao() {
        textIdAut.setText("");
        textCnpjAut.setText("");
        textRazaoSocialAut.setText("");
        textEmailAut.setText("");
        textEnderecoAut.setText("");
        textNumeroAut.setText("");
        textTelefoneAut.setText("");
        textCidadeAut.setText("");
        textUfAtu.setText("");
        textBairroAut.setText("");


        textCnpjAut.setEnabled(false);
        textRazaoSocialAut.setEnabled(false);
        textEmailAut.setEnabled(false);
        textEnderecoAut.setEnabled(false);
        textNumeroAut.setEnabled(false);
        textTelefoneAut.setEnabled(false);
        textCidadeAut.setEnabled(false);
        textUfAtu.setEnabled(false);
        textBairroAut.setEnabled(false);
    }


    public GerenciarFonecedores() {


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1250, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //  PAINEL DE CADASTRO
        panelCadastro = new JPanel();
        panelCadastro.setBackground(new Color(102, 153, 204));
        panelCadastro.setBounds(30, 24, 547, 450);
        panelCadastro.setLayout(null);
        contentPane.add(panelCadastro);

        // Título Cadastro
        JLabel lblTituloCadastro = new JLabel("CADASTRO DE FORNECEDOR");
        lblTituloCadastro.setForeground(new Color(255, 255, 255));
        lblTituloCadastro.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTituloCadastro.setBounds(60, 10, 450, 44);
        panelCadastro.add(lblTituloCadastro);

        // CNPJ
        JLabel lblCnpj = new JLabel("CNPJ:");
        lblCnpj.setBounds(95, 70, 50, 16);
        panelCadastro.add(lblCnpj);

        textCnpj = new JTextField();
        textCnpj.setColumns(10);
        textCnpj.setBounds(145, 67, 252, 22);
        panelCadastro.add(textCnpj);

        // Razão Social
        JLabel lblRazaoSocial = new JLabel("Razão Social:");
        lblRazaoSocial.setBounds(50, 102, 95, 16);
        panelCadastro.add(lblRazaoSocial);

        textRazaoSocial = new JTextField();
        textRazaoSocial.setColumns(10);
        textRazaoSocial.setBounds(145, 99, 310, 22);
        panelCadastro.add(textRazaoSocial);

        // E-mail
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(85, 134, 60, 16);
        panelCadastro.add(lblEmail);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(145, 131, 310, 22);
        panelCadastro.add(textEmail);

        // Endereço
        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(65, 166, 80, 16);
        panelCadastro.add(lblEndereco);

        textEndereco = new JTextField();
        textEndereco.setColumns(10);
        textEndereco.setBounds(145, 163, 310, 22);
        panelCadastro.add(textEndereco);

        // Número
        JLabel lblNumero = new JLabel("Numero:");
        lblNumero.setBounds(75, 198, 70, 16);
        panelCadastro.add(lblNumero);

        textNumero = new JTextField();
        textNumero.setColumns(10);
        textNumero.setBounds(145, 195, 87, 22);
        panelCadastro.add(textNumero);

        // Telefone
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(260, 198, 70, 16);
        panelCadastro.add(lblTelefone);

        textTelefone = new JTextField();
        textTelefone.setColumns(10);
        textTelefone.setBounds(320, 195, 87, 22);
        panelCadastro.add(textTelefone);

        // Bairro
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setBounds(85, 230, 60, 16);
        panelCadastro.add(lblBairro);

        textBairro = new JTextField();
        textBairro.setColumns(10);
        textBairro.setBounds(145, 227, 193, 22);
        panelCadastro.add(textBairro);

        // Cidade
        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(80, 262, 65, 16);
        panelCadastro.add(lblCidade);

        textCidade = new JTextField();
        textCidade.setColumns(10);
        textCidade.setBounds(145, 259, 193, 22);
        panelCadastro.add(textCidade);

        // UF
        JLabel lblUf = new JLabel("UF:");
        lblUf.setBounds(360, 262, 30, 16);
        panelCadastro.add(lblUf);

        textUf = new JTextField();
        textUf.setColumns(10);
        textUf.setBounds(385, 259, 56, 22);
        panelCadastro.add(textUf);

        // Botões Cadastro
        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setForeground(new Color(248, 248, 255));
        btnCancelar.setBackground(new Color(220, 20, 60));
        btnCancelar.setBounds(135, 480, 135, 32);
        btnCancelar.addActionListener(e -> limparCamposCadastro());
        contentPane.add(btnCancelar);

        btnCadastrar = new JButton("CADASTRAR +");
        btnCadastrar.setForeground(new Color(248, 248, 255));
        btnCadastrar.setBackground(new Color(25, 79, 110));
        btnCadastrar.setBounds(290, 480, 135, 32);
        btnCadastrar.addActionListener(e -> cadastroDeFornecedor());
        contentPane.add(btnCadastrar);

        // ===== PAINEL DE ATUALIZAÇÃO =====
        panelAtualizar = new JPanel();
        panelAtualizar.setBackground(new Color(102, 153, 204));
        panelAtualizar.setBounds(673, 24, 547, 450);
        panelAtualizar.setLayout(null);
        contentPane.add(panelAtualizar);

        // Título Atualizar
        JLabel lblTituloAtualizar = new JLabel("ATUALIZAR FORNECEDOR");
        lblTituloAtualizar.setForeground(new Color(255, 255, 255));
        lblTituloAtualizar.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTituloAtualizar.setBounds(70, 10, 450, 44);
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
        btnBuscarAut.addActionListener(e -> buscarFornecedor());

        // CNPJ Atualizar
        JLabel lblCnpjAut = new JLabel("CNPJ:");
        lblCnpjAut.setBounds(95, 102, 50, 16);
        panelAtualizar.add(lblCnpjAut);

        textCnpjAut = new JTextField();
        textCnpjAut.setColumns(10);
        textCnpjAut.setBounds(145, 99, 310, 22);
        textCnpjAut.setEnabled(false);
        panelAtualizar.add(textCnpjAut);

        // Razão Social Atualizar
        JLabel lblRazaoSocialAut = new JLabel("Razão Social:");
        lblRazaoSocialAut.setBounds(53, 134, 90, 16);
        panelAtualizar.add(lblRazaoSocialAut);

        textRazaoSocialAut = new JTextField();
        textRazaoSocialAut.setColumns(10);
        textRazaoSocialAut.setBounds(145, 131, 310, 22);
        textRazaoSocialAut.setEnabled(false);
        panelAtualizar.add(textRazaoSocialAut);

        // E-mail Atualizar
        JLabel lblEmailAut = new JLabel("E-mail:");
        lblEmailAut.setBounds(89, 166, 105, 16);
        panelAtualizar.add(lblEmailAut);

        textEmailAut = new JTextField();
        textEmailAut.setColumns(10);
        textEmailAut.setBounds(145, 163, 310, 22);
        textEmailAut.setEnabled(false);
        panelAtualizar.add(textEmailAut);

        // Endereço Atualizar
        JLabel lblEnderecoAut = new JLabel("Endereço:");
        lblEnderecoAut.setBounds(73, 198, 70, 16);
        panelAtualizar.add(lblEnderecoAut);

        textEnderecoAut = new JTextField();
        textEnderecoAut.setColumns(10);
        textEnderecoAut.setBounds(145, 195, 310, 22);
        textEnderecoAut.setEnabled(false);
        panelAtualizar.add(textEnderecoAut);

        // Número Atualizar
        JLabel lblNumeroAut = new JLabel("Número:");
        lblNumeroAut.setBounds(80, 230, 65, 16);
        panelAtualizar.add(lblNumeroAut);

        textNumeroAut = new JTextField();
        textNumeroAut.setColumns(10);
        textNumeroAut.setBounds(145, 227, 100, 22);
        textNumeroAut.setEnabled(false);
        panelAtualizar.add(textNumeroAut);

        // Telefone Atualizar
        JLabel lblTelefoneAut = new JLabel("Telefone:");
        lblTelefoneAut.setBounds(280, 230, 70, 16);
        panelAtualizar.add(lblTelefoneAut);

        textTelefoneAut = new JTextField();
        textTelefoneAut.setColumns(10);
        textTelefoneAut.setBounds(345, 227, 110, 22);
        textTelefoneAut.setEnabled(false);
        panelAtualizar.add(textTelefoneAut);

        // Bairro Atualizar
        JLabel lblBairroAut = new JLabel("Bairro:");
        lblBairroAut.setBounds(90, 262, 55, 16);
        panelAtualizar.add(lblBairroAut);

        textBairroAut = new JTextField();
        textBairroAut.setColumns(10);
        textBairroAut.setBounds(145, 259, 193, 22);
        textBairroAut.setEnabled(false);
        panelAtualizar.add(textBairroAut);

        // Cidade Atualizar
        JLabel lblCidadeAut = new JLabel("Cidade:");
        lblCidadeAut.setBounds(87, 294, 60, 16);
        panelAtualizar.add(lblCidadeAut);

        textCidadeAut = new JTextField();
        textCidadeAut.setColumns(10);
        textCidadeAut.setBounds(145, 291, 193, 22);
        textCidadeAut.setEnabled(false);
        panelAtualizar.add(textCidadeAut);

        // UF Atualizar
        JLabel lblUfAut = new JLabel("UF:");
        lblUfAut.setBounds(350, 294, 30, 16);
        panelAtualizar.add(lblUfAut);

        textUfAtu = new JTextField();
        textUfAtu.setColumns(10);
        textUfAtu.setBounds(375, 291, 80, 22);
        textUfAtu.setEnabled(false);
        panelAtualizar.add(textUfAtu);

        // Aviso
        JLabel lblAviso = new JLabel("* Busque o fornecedor pelo ID para editar");
        lblAviso.setForeground(Color.WHITE);
        lblAviso.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblAviso.setBounds(145, 355, 300, 16);
        panelAtualizar.add(lblAviso);

        // Botões Atualização
        btnDeletarAut = new JButton("DELETAR");
        btnDeletarAut.setForeground(new Color(255,255,255));
        btnDeletarAut.setBackground(new Color(220, 20, 60));
        btnDeletarAut.setBounds(778, 480, 135, 32);
        btnDeletarAut.addActionListener(e -> deletarFornecedor());
        contentPane.add(btnDeletarAut);

        btnAtualizarAut = new JButton("ATUALIZAR");
        btnAtualizarAut.setForeground(new Color(248, 248, 255));
        btnAtualizarAut.setBackground(new Color(25, 79, 110));
        btnAtualizarAut.setBounds(933, 480, 135, 32);
        btnAtualizarAut.addActionListener(e -> atualizarFornecedor());
        contentPane.add(btnAtualizarAut);
    }
}