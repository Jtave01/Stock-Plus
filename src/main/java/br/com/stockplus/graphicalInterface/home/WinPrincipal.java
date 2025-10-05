package br.com.stockplus.graphicalInterface.home;

import br.com.stockplus.graphicalInterface.controllClasse.SessionControl;
import br.com.stockplus.graphicalInterface.login.WinLogin;
import br.com.stockplus.graphicalInterface.produtos.WinCadastroProdutos;
import br.com.stockplus.graphicalInterface.fornecedor.WinCadastrodeFornecedor;
import br.com.stockplus.graphicalInterface.usuarios.WinCadastrodeUsuario;
import br.com.stockplus.graphicalInterface.fornecedor.WinPesquisaFornecedor;
import br.com.stockplus.graphicalInterface.produtos.WinPesquisaProdutos;
import br.com.stockplus.graphicalInterface.usuarios.WinPesquisaUsuario;
import br.com.stockplus.graphicalInterface.usuarios.WinAtualizarUsuario;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class WinPrincipal extends JFrame {

    private void irParoLogin() {
        this.getContentPane().setEnabled(false);

        Timer timer = new Timer(50, e -> {
            setVisible(false);

            WinLogin login = new WinLogin();
            login.setLocationRelativeTo(null);
            login.setVisible(true);

            dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void abrirAtuaulizarUsuario(){
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            String titulo = this.getTitle();

            WinAtualizarUsuario tempFrame = new WinAtualizarUsuario();
            JPanel painelHome = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelHome.getLayout());


            while (painelHome.getComponentCount() > 0 ){
                Component comp = painelHome.getComponent(0);
                painelHome.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelHome.getBackground());

            this.setJMenuBar(menuBarHome);
            this.setTitle("Atualizar usuario");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void abrirPesquisarUsuario(){
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            String titulo = this.getTitle();

            WinPesquisaUsuario tempFrame = new WinPesquisaUsuario();
            JPanel painelHome = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelHome.getLayout());


            while (painelHome.getComponentCount() > 0 ){
                Component comp = painelHome.getComponent(0);
                painelHome.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelHome.getBackground());

            this.setJMenuBar(menuBarHome);
            this.setTitle("Atualizar usuario");
            this.revalidate();
            this.repaint();


        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

	/** ---> Home */
    private void voltarParaHome() {
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            String titulo = this.getTitle();

            WinPrincipal tempFrame = new WinPrincipal();
            JPanel painelHome = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelHome.getLayout());


            while (painelHome.getComponentCount() > 0 ){
                Component comp = painelHome.getComponent(0);
                painelHome.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelHome.getBackground());

            this.setJMenuBar(menuBarHome);
            this.setTitle("Home");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    /** ---> Menu produtos */
    private void abrirCadastroProduto() {
        try {
            /// salva menuBar principal
            JMenuBar menuBarHome = this.getJMenuBar();
            String tituloAtual = this.getTitle();
            ///Tela temporaria
            WinCadastroProdutos tempFrame = new WinCadastroProdutos();
            /// extrai o painel e retorna o container principal
            JPanel painelCadastro = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelCadastro.getLayout());

            while (painelCadastro.getComponentCount() > 0) {
                Component comp = painelCadastro.getComponent(0);
                painelCadastro.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelCadastro.getBackground());
            this.setJMenuBar(menuBarHome);
            this.setTitle("Cadastro de Produtos");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    private void abrirPesquisaProdutos(){
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            String tituloAtual = this.getTitle();
            /// ---> Frame temporario
            WinPesquisaProdutos tempFrame = new WinPesquisaProdutos();
            JPanel painelpesquisa = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelpesquisa.getLayout());

            while (painelpesquisa.getComponentCount() > 0){
                Component comp = painelpesquisa.getComponent(0);
                painelpesquisa.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelpesquisa.getBackground());
            this.setJMenuBar(menuBarHome);
            this.setTitle("Pesquisa produtos");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /** ---> Menu fornecedor */
    private void abrirCadastroFornecedor(){
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            String tituloAtual = this.getTitle();
            WinCadastrodeFornecedor tempFrame = new WinCadastrodeFornecedor();
            JPanel painelCadastro = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelCadastro.getLayout());


            while (painelCadastro.getComponentCount() > 0){
                Component comp = painelCadastro.getComponent(0);
                painelCadastro.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelCadastro.getBackground());
            this.setJMenuBar(menuBarHome);
            this.setTitle("Cadastro de fornecedor");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    private void abrirPesquisaFornecedor(){
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            String tituloAtual = this.getTitle();
            WinPesquisaFornecedor tempFrame = new WinPesquisaFornecedor();
            JPanel painelPesquisa = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelPesquisa.getLayout());

            /// ---> transferindo componeentes um por um
            while (painelPesquisa.getComponentCount() > 0){
                Component comp = painelPesquisa.getComponent(0);
                painelPesquisa.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelPesquisa.getBackground());
            this.setJMenuBar(menuBarHome);
            this.setTitle("Pesquisa de fornecedor");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /** ---> Menu usuario */
    private void abrirCadastroUsuario(){
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            String tituloAtual = this.getTitle();
            WinCadastrodeUsuario tempFrame = new WinCadastrodeUsuario();
            JPanel cadastroUsuario = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(cadastroUsuario.getLayout());

            while (cadastroUsuario.getComponentCount() > 0){
                Component comp = cadastroUsuario.getComponent(0);
                cadastroUsuario.remove(comp);
                this.getContentPane().add(comp);
            }
            this.getContentPane().setBackground(cadastroUsuario.getBackground());
            this.setJMenuBar(menuBarHome);
            this.setTitle("Cadastro usuario");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    

	public WinPrincipal() {

        setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(204, 204, 204));
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Objects.requireNonNull(WinPrincipal.class.getResource("/imgs/dash_new.png"))));
		lblNewLabel.setBounds(115, 50, 1151, 466);
		getContentPane().add(lblNewLabel);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 102, 153));
		setJMenuBar(menuBar);


        /// --- home
        JMenu menuHome = new JMenu("HOME");
        menuHome.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/ico_sair.png"))));
        menuHome.setForeground(Color.WHITE);
        menuHome.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(menuHome);
        menuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                voltarParaHome();
            }
        });

        /// -----> fornecedores
		JMenu menuFornecedores = new JMenu("FORNECEDORES");
		menuFornecedores.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/ico_fornecedores.png"))));
		menuFornecedores.setForeground(Color.WHITE);
		menuFornecedores.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(menuFornecedores);
        JMenuItem subMenuFCadastrar = new JMenuItem("Cadastrar fornecedor");
        JMenuItem subMenuFPEsquisar = new JMenuItem("Pesquisar fornecedor");
        menuFornecedores.add(subMenuFCadastrar);
        menuFornecedores.addSeparator();
        menuFornecedores.add(subMenuFPEsquisar);
        subMenuFCadastrar.addActionListener(e -> abrirCadastroFornecedor());
        subMenuFPEsquisar.addActionListener(e -> abrirPesquisaFornecedor());

        /// ----> usuaarios
		JMenu menuUsuarios = new JMenu("USUÁRIOS");
		menuUsuarios.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/ico_usuarios.png"))));
		menuUsuarios.setForeground(Color.WHITE);
		menuUsuarios.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuUsuarios.addActionListener(e -> {
            if(SessionControl.isAdmin() == false){
                JOptionPane.showMessageDialog(null, "Permição negada");
            }
        });
		menuBar.add(menuUsuarios);
        JMenuItem subMenuUCadastro = new JMenuItem("Cadastro de usuarios");
        menuUsuarios.add(subMenuUCadastro);
        subMenuUCadastro.addActionListener(e ->{
            if(SessionControl.isAdmin()){
                abrirCadastroUsuario();
            }else{
                JOptionPane.showMessageDialog(null,"Permição negada");
            }

        } );
        menuUsuarios.addSeparator();
        JMenuItem subMenuUAtualizar = new JMenuItem("Atualizar usuario");
        menuUsuarios.add(subMenuUAtualizar);
        subMenuUAtualizar.addActionListener(e ->{
            if(SessionControl.isAdmin()){
                abrirAtuaulizarUsuario();
            }else{
                JOptionPane.showMessageDialog(null,"Permição negada");
            }

        } );
        menuUsuarios.addSeparator();
        JMenuItem subMenuUPesquisa = new JMenuItem("Pesquisa Usuario");
        menuUsuarios.add(subMenuUPesquisa);
        subMenuUPesquisa.addActionListener(e ->{

            if(SessionControl.isAdmin()){
                abrirPesquisarUsuario();
            }
            else{
                JOptionPane.showMessageDialog(null, "Permição negada");
            }
        });

        /// ----> produtos
        JMenu menuProdutos = new JMenu("PRODUTOS");
        menuProdutos.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/ico_produtos.png"))));
        menuProdutos.setForeground(Color.WHITE);
        menuProdutos.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(menuProdutos);
        JMenuItem subMenuPCadastar = new JMenuItem("Cadastrar Produto");
        JMenuItem subMenuPPesquisar = new JMenuItem("Pesquisar Produto");
        menuProdutos.add(subMenuPCadastar);
        menuProdutos.addSeparator();
        menuProdutos.add(subMenuPPesquisar);
        subMenuPCadastar.addActionListener(e -> abrirCadastroProduto());
        subMenuPPesquisar.addActionListener(e -> abrirPesquisaProdutos());

        menuBar.add(Box.createHorizontalGlue());


        ///  ---> sair
        JMenu menuLogin = new JMenu("SAIR");
        menuLogin.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/ico_sair.png"))));
        menuLogin.setForeground(Color.WHITE);
        menuLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(menuLogin);
        menuLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                irParoLogin();
            }
        });


    }
}
