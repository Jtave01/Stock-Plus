package br.com.stockplus.graphicalInterface.usuarios;

import br.com.stockplus.dao.UsuarioDAO;
import br.com.stockplus.entity.RoleEntitty;
import br.com.stockplus.entity.UsuarioEntity;
import br.com.stockplus.controllClasse.SessionControl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class WinAtualizarUsuario extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel contentPane;
    public JPanel panel;

    // Campos de texto
    public JTextField textId;
    public JTextField textUsuario;
    public JTextField textNome;
    public JTextField textEmail;
    public JPasswordField textSenha;
    public JPasswordField textRepitaSenha;
    public JComboBox<String> permicoes;

    // Botões
    public JButton btnBuscar;
    public JButton btnAtualizar;
    public JButton btnDeletar;

    private void atualizarUsuario() {

        try {

            String senha = new String(textSenha.getPassword());
            String repeteSenha = new String(textRepitaSenha.getPassword());

            UsuarioEntity entity = new UsuarioEntity();
            entity.setUsaername(textUsuario.getText());
            entity.setNome(textNome.getText());
            entity.setEmail(textEmail.getText());

            if(senha.isEmpty() || repeteSenha.isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor, preencha ambos os campos de senha");
                return;
            }
            if (!repeteSenha.equals(senha)){
                JOptionPane.showMessageDialog(null, "As senhas nao conferem");
                return;
            }
            entity.setPassword(String.valueOf(textSenha.getPassword()));
            Long idPermissao = (long) (permicoes.getSelectedIndex() + 1);
            RoleEntitty role = new RoleEntitty();
            role.setId(idPermissao);
            entity.setRole(role);
            entity.setId(Long.valueOf(textId.getText()));

            UsuarioDAO DAO = new UsuarioDAO();

            DAO.update(entity);
            limparCampos();



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void deletarUsuario(){
        Long id = Long.valueOf(textId.getText());

        try {

            UsuarioDAO DAO = new UsuarioDAO();
            DAO.delete(id);
            JOptionPane.showMessageDialog(this, "Usuario deletado com sucesso");
        } catch (Exception e) {

            e.printStackTrace();
        }

    }


    private void limparCampos() {
        textId.setText("");
        textUsuario.setText("");
        textNome.setText("");
        textEmail.setText("");
        textSenha.setText("");
        textRepitaSenha.setText("");
        permicoes.setSelectedIndex(0);
    }
    public WinAtualizarUsuario() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 884, 470);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 102, 153));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(102, 153, 204));
        panel.setBounds(133, 24, 547, 355);
        panel.setLayout(null);
        contentPane.add(panel);

        // Título
        JLabel lblTitulo = new JLabel("ATUALIZAR USUÁRIO");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblTitulo.setBounds(85, 10, 404, 44);
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
        btnBuscar.addActionListener(e -> buscarUsuario());

        // Usuário
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(83, 102, 63, 16);
        panel.add(lblUsuario);

        textUsuario = new JTextField();
        textUsuario.setColumns(10);
        textUsuario.setBounds(145, 99, 310, 22);
        textUsuario.setEnabled(false);
        panel.add(textUsuario);

        // Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(95, 134, 87, 16);
        panel.add(lblNome);

        textNome = new JTextField();
        textNome.setColumns(10);
        textNome.setBounds(145, 131, 310, 22);
        textNome.setEnabled(false);
        panel.add(textNome);

        // E-mail
        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(89, 166, 105, 16);
        panel.add(lblEmail);

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(145, 163, 310, 22);
        textEmail.setEnabled(false);
        panel.add(textEmail);

        // Senha
        JLabel lblSenha = new JLabel("Nova Senha:");
        lblSenha.setBounds(58, 198, 105, 16);
        panel.add(lblSenha);

        textSenha = new JPasswordField();
        textSenha.setBounds(145, 195, 193, 22);
        textSenha.setEnabled(false);
        panel.add(textSenha);

        // Repita a senha
        JLabel lblRepitaSenha = new JLabel("Repita a senha:");
        lblRepitaSenha.setBounds(28, 230, 105, 16);
        panel.add(lblRepitaSenha);

        textRepitaSenha = new JPasswordField();
        textRepitaSenha.setColumns(10);
        textRepitaSenha.setBounds(145, 227, 193, 22);
        textRepitaSenha.setEnabled(false);
        panel.add(textRepitaSenha);

        // Permissão
        JLabel lblPermissao = new JLabel("Permissão:");
        lblPermissao.setBounds(64, 262, 105, 16);
        panel.add(lblPermissao);

        permicoes = new JComboBox<>();
        permicoes.addItem("Administrador");
        permicoes.addItem("Usuário");
        permicoes.setBounds(145, 259, 193, 22);
        permicoes.setEnabled(false);
        panel.add(permicoes);

        // Aviso
        JLabel lblAviso = new JLabel("* ATENÇÂO nao deixe a senha em branco");
        lblAviso.setForeground(Color.WHITE);
        lblAviso.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblAviso.setBounds(145, 290, 300, 16);
        panel.add(lblAviso);

        // Botões
        btnDeletar = new JButton("DELETAR");
        btnDeletar.setForeground(new Color(248, 248, 255));
        btnDeletar.setBackground(new Color(220, 20, 60));
        btnDeletar.setBounds(254, 390, 135, 32);
        contentPane.add(btnDeletar);
        btnDeletar.addActionListener(e -> {
            UsuarioDAO DAO = new UsuarioDAO();
            DAO.findById(SessionControl.getUser().getId());

            if (SessionControl.getUser().getId().equals(Long.valueOf(textId.getText()))){
                JOptionPane.showMessageDialog(this, "Não e possivel deletar o propio usuario ");
                return;
            }


            deletarUsuario();
        });


        btnAtualizar = new JButton("ATUALIZAR");
        btnAtualizar.setForeground(new Color(248, 248, 255));
        btnAtualizar.setBackground(new Color(102, 204, 102));
        btnAtualizar.setBounds(428, 390, 135, 32);
        btnAtualizar.setEnabled(false);
        contentPane.add(btnAtualizar);
        btnAtualizar.addActionListener(e -> atualizarUsuario());
    }

    private void buscarUsuario() {

        UsuarioDAO DAO = new UsuarioDAO();

        try {
            Long idConvert = Long.parseLong(textId.getText());
            UsuarioEntity usuario = new UsuarioEntity();

            usuario   = DAO.findById(idConvert);
            textUsuario.setText(usuario.getUsaername());
            textNome.setText(usuario.getNome());
            textEmail.setText(usuario.getEmail());


            boolean habilitar = true;
            textUsuario.setEnabled(habilitar);
            textNome.setEnabled(habilitar);
            textEmail.setEnabled(habilitar);
            textSenha.setEnabled(habilitar);
            textRepitaSenha.setEnabled(habilitar);
            permicoes.setEnabled(habilitar);
            btnAtualizar.setEnabled(habilitar);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Usuario não encontrado");
        }

    }


}