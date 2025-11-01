package br.com.stockplus.graphicalInterface.usuarios;

import br.com.stockplus.dao.UsuarioDAO;
import br.com.stockplus.entity.RoleEntitty;
import br.com.stockplus.entity.UsuarioEntity;
import br.com.stockplus.controllClasse.SessionControl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GerenciarUsuarios extends JFrame {

    private static final long serialVersionUID = 1L;

    // Painéis
    public JPanel contentPane;
    public JPanel panelCadastro;
    public JPanel panelAtualizar;

    //  CAMPOS DO CADASTRO
    // Campos de texto - Cadastro
    public JTextField textUsuario;
    public JTextField textNome;
    public JTextField textEmail;
    public JPasswordField textSenha;
    public JPasswordField textRepitaSenha;
    public JComboBox<String> permicoes;

    // Botões - Cadastro
    public JButton btnCadastrar;
    public JButton btnCancelar;

    // ATUALIZAÇÃO
    // Campos de texto - Atualizar
    public JTextField textIdAut;
    public JTextField textUsuarioAut;
    public JTextField textNomeAut;
    public JTextField textEmailAut;
    public JPasswordField textSenhaAut;
    public JPasswordField textRepitaSenhaAut;
    public JComboBox<String> permicoesAut;

    // Botões - Atualizar
    public JButton btnBuscarAut;
    public JButton btnAtualizarAut;
    public JButton btnDeletarAut;

    //  MÉTODOS DE CADASTRO
    private void cadastroDeUsuario() {
        try {
            String senha = String.valueOf(textSenha.getPassword());
            String senhaRepete = String.valueOf(textRepitaSenha.getPassword());

            if (senha.isEmpty() || senhaRepete.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha ambos os campos de senha");
                return;
            }

            if (!senhaRepete.equals(senha)) {
                JOptionPane.showMessageDialog(this, "As senhas não coincidem!");
                return;
            }

            Long idPermissao = (long) (permicoes.getSelectedIndex() + 1);
            RoleEntitty role = new RoleEntitty();
            role.setId(idPermissao);

            UsuarioEntity entity = new UsuarioEntity();
            entity.setUsaername(textUsuario.getText());
            entity.setNome(textNome.getText());
            entity.setEmail(textEmail.getText());
            entity.setPassword(senha);
            entity.setRole(role);

            UsuarioDAO DAO = new UsuarioDAO();
            DAO.insert(entity);

            limparCamposCadastro();
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao cadastrar usuário: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void limparCamposCadastro() {
        textUsuario.setText("");
        textNome.setText("");
        textEmail.setText("");
        textSenha.setText("");
        textRepitaSenha.setText("");
        permicoes.setSelectedIndex(0);
    }

    //  MÉTODOS DE ATUALIZAÇÃO
    public void buscarUsuario() {
        try {
            UsuarioDAO DAO = new UsuarioDAO();
            Long idConvert = Long.parseLong(textIdAut.getText());

            UsuarioEntity usuario = DAO.findById(idConvert);

            textUsuarioAut.setText(usuario.getUsaername());
            textNomeAut.setText(usuario.getNome());
            textEmailAut.setText(usuario.getEmail());

            habilitarCamposAtualizacao();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao buscar usuário: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void atualizarUsuario() {
        try {
            String senha = new String(textSenhaAut.getPassword());
            String repeteSenha = new String(textRepitaSenhaAut.getPassword());

            if (senha.isEmpty() || repeteSenha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha ambos os campos de senha");
                return;
            }

            if (!repeteSenha.equals(senha)) {
                JOptionPane.showMessageDialog(this, "As senhas não conferem");
                return;
            }

            UsuarioEntity entity = new UsuarioEntity();
            entity.setId(Long.valueOf(textIdAut.getText()));
            entity.setUsaername(textUsuarioAut.getText());
            entity.setNome(textNomeAut.getText());
            entity.setEmail(textEmailAut.getText());
            entity.setPassword(senha);

            Long idPermissao = (long) (permicoesAut.getSelectedIndex() + 1);
            RoleEntitty role = new RoleEntitty();
            role.setId(idPermissao);
            entity.setRole(role);

            UsuarioDAO DAO = new UsuarioDAO();
            DAO.update(entity);

            JOptionPane.showMessageDialog(this, "Usuário atualizado com sucesso!");
            limparCamposAtualizacao();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao atualizar usuário: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void deletarUsuario() {
        try {
            Long id = Long.valueOf(textIdAut.getText());

            if (SessionControl.getUser().getId().equals(id)) {
                JOptionPane.showMessageDialog(this, "Não é possível deletar o próprio usuário");
                return;
            }

            UsuarioDAO DAO = new UsuarioDAO();

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Tem certeza que deseja deletar este usuário?",
                    "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                DAO.delete(id);
                limparCamposAtualizacao();
                JOptionPane.showMessageDialog(this, "Usuário deletado com sucesso!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao deletar usuário: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void habilitarCamposAtualizacao() {
        textUsuarioAut.setEnabled(true);
        textNomeAut.setEnabled(true);
        textEmailAut.setEnabled(true);
        textSenhaAut.setEnabled(true);
        textRepitaSenhaAut.setEnabled(true);
        permicoesAut.setEnabled(true);
    }

    public void limparCamposAtualizacao() {
        textIdAut.setText("");
        textUsuarioAut.setText("");
        textNomeAut.setText("");
        textEmailAut.setText("");
        textSenhaAut.setText("");
        textRepitaSenhaAut.setText("");
        permicoesAut.setSelectedIndex(0);

        textUsuarioAut.setEnabled(false);
        textNomeAut.setEnabled(false);
        textEmailAut.setEnabled(false);
        textSenhaAut.setEnabled(false);
        textRepitaSenhaAut.setEnabled(false);
        permicoesAut.setEnabled(false);
    }

    public GerenciarUsuarios() {

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
        JLabel lblTituloCadastro = new JLabel("CADASTRO DE USUÁRIO");
        lblTituloCadastro.setForeground(new Color(255, 255, 255));
        lblTituloCadastro.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTituloCadastro.setBounds(85, 10, 404, 44);
        panelCadastro.add(lblTituloCadastro);

        // Usuário
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(83, 102, 63, 16);
        panelCadastro.add(lblUsuario);

        textUsuario = new JTextField();
        textUsuario.setColumns(10);
        textUsuario.setBounds(145, 99, 310, 22);
        panelCadastro.add(textUsuario);

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(95, 134, 87, 16);
        panelCadastro.add(lblNome);

        textNome = new JTextField();
        textNome.setColumns(10);
        textNome.setBounds(145, 131, 310, 22);
        panelCadastro.add(textNome);

        // E-mail
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(89, 166, 105, 16);
        panelCadastro.add(lblEmail);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(145, 163, 310, 22);
        panelCadastro.add(textEmail);

        // Senha
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(88, 198, 105, 16);
        panelCadastro.add(lblSenha);

        textSenha = new JPasswordField();
        textSenha.setBounds(145, 195, 193, 22);
        panelCadastro.add(textSenha);

        // Repita a senha
        JLabel lblRepitaSenha = new JLabel("Repita a senha:");
        lblRepitaSenha.setBounds(28, 230, 105, 16);
        panelCadastro.add(lblRepitaSenha);

        textRepitaSenha = new JPasswordField();
        textRepitaSenha.setColumns(10);
        textRepitaSenha.setBounds(145, 227, 193, 22);
        panelCadastro.add(textRepitaSenha);

        // Permissão
        JLabel lblPermissao = new JLabel("Permissão:");
        lblPermissao.setBounds(64, 262, 105, 16);
        panelCadastro.add(lblPermissao);

        permicoes = new JComboBox<>();
        permicoes.addItem("Administrador");
        permicoes.addItem("Usuário");
        permicoes.setBounds(145, 259, 193, 22);
        panelCadastro.add(permicoes);

        // Botões Cadastro
        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setForeground(new Color(248, 248, 255));
        btnCancelar.setBackground(new Color(220, 20, 60));
        btnCancelar.setBounds(135, 480, 135, 32);
        btnCancelar.addActionListener(e -> limparCamposCadastro());
        contentPane.add(btnCancelar);

        btnCadastrar = new JButton("CADASTRAR +");
        btnCadastrar.setForeground(new Color(248, 248, 255));
        btnCadastrar.setBackground(new Color(25, 79, 110));;
        btnCadastrar.setBounds(290, 480, 135, 32);
        btnCadastrar.addActionListener(e -> cadastroDeUsuario());
        contentPane.add(btnCadastrar);

        // ===== PAINEL DE ATUALIZAÇÃO =====
        panelAtualizar = new JPanel();
        panelAtualizar.setBackground(new Color(102, 153, 204));
        panelAtualizar.setBounds(673, 24, 547, 450);
        panelAtualizar.setLayout(null);
        contentPane.add(panelAtualizar);

        // Título Atualizar
        JLabel lblTituloAtualizar = new JLabel("ATUALIZAR USUÁRIO");
        lblTituloAtualizar.setForeground(new Color(255, 255, 255));
        lblTituloAtualizar.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTituloAtualizar.setBounds(85, 10, 404, 44);
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
        btnBuscarAut.addActionListener(e -> buscarUsuario());

        // Usuário Atualizar
        JLabel lblUsuarioAut = new JLabel("Usuário:");
        lblUsuarioAut.setBounds(83, 102, 63, 16);
        panelAtualizar.add(lblUsuarioAut);

        textUsuarioAut = new JTextField();
        textUsuarioAut.setColumns(10);
        textUsuarioAut.setBounds(145, 99, 310, 22);
        textUsuarioAut.setEnabled(false);
        panelAtualizar.add(textUsuarioAut);

        // Nome Atualizar
        JLabel lblNomeAut = new JLabel("Nome:");
        lblNomeAut.setBounds(95, 134, 87, 16);
        panelAtualizar.add(lblNomeAut);

        textNomeAut = new JTextField();
        textNomeAut.setColumns(10);
        textNomeAut.setBounds(145, 131, 310, 22);
        textNomeAut.setEnabled(false);
        panelAtualizar.add(textNomeAut);

        // E-mail Atualizar
        JLabel lblEmailAut = new JLabel("E-mail:");
        lblEmailAut.setBounds(89, 166, 105, 16);
        panelAtualizar.add(lblEmailAut);

        textEmailAut = new JTextField();
        textEmailAut.setColumns(10);
        textEmailAut.setBounds(145, 163, 310, 22);
        textEmailAut.setEnabled(false);
        panelAtualizar.add(textEmailAut);

        // Senha Atualizar
        JLabel lblSenhaAut = new JLabel("Nova Senha:");
        lblSenhaAut.setBounds(58, 198, 105, 16);
        panelAtualizar.add(lblSenhaAut);

        textSenhaAut = new JPasswordField();
        textSenhaAut.setBounds(145, 195, 193, 22);
        textSenhaAut.setEnabled(false);
        panelAtualizar.add(textSenhaAut);

        // Repita a senha Atualizar
        JLabel lblRepitaSenhaAut = new JLabel("Repita a senha:");
        lblRepitaSenhaAut.setBounds(28, 230, 105, 16);
        panelAtualizar.add(lblRepitaSenhaAut);

        textRepitaSenhaAut = new JPasswordField();
        textRepitaSenhaAut.setColumns(10);
        textRepitaSenhaAut.setBounds(145, 227, 193, 22);
        textRepitaSenhaAut.setEnabled(false);
        panelAtualizar.add(textRepitaSenhaAut);

        // Permissão Atualizar
        JLabel lblPermissaoAut = new JLabel("Permissão:");
        lblPermissaoAut.setBounds(64, 262, 105, 16);
        panelAtualizar.add(lblPermissaoAut);

        permicoesAut = new JComboBox<>();
        permicoesAut.addItem("Administrador");
        permicoesAut.addItem("Usuário");
        permicoesAut.setBounds(145, 259, 193, 22);
        permicoesAut.setEnabled(false);
        panelAtualizar.add(permicoesAut);

        // Aviso
        JLabel lblAviso = new JLabel("* Busque o usuário pelo ID para editar");
        lblAviso.setForeground(Color.WHITE);
        lblAviso.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblAviso.setBounds(145, 300, 300, 16);
        panelAtualizar.add(lblAviso);

        JLabel lblAvisoSenha = new JLabel("* ATENÇÃO não deixe a senha em branco");
        lblAvisoSenha.setForeground(Color.WHITE);
        lblAvisoSenha.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblAvisoSenha.setBounds(145, 320, 300, 16);
        panelAtualizar.add(lblAvisoSenha);

        // Botões Atualização
        btnDeletarAut = new JButton("DELETAR");
        btnDeletarAut.setForeground(new Color(255,255,255));
        btnDeletarAut.setBackground(new Color(220, 20, 60));
        btnDeletarAut.setBounds(778, 480, 135, 32);
        btnDeletarAut.addActionListener(e -> deletarUsuario());
        contentPane.add(btnDeletarAut);

        btnAtualizarAut = new JButton("ATUALIZAR");
        btnAtualizarAut.setForeground(new Color(248, 248, 255));
        btnAtualizarAut.setBackground(new Color(25, 79, 110));;
        btnAtualizarAut.setBounds(933, 480, 135, 32);
        btnAtualizarAut.addActionListener(e -> atualizarUsuario());
        contentPane.add(btnAtualizarAut);
    }
}