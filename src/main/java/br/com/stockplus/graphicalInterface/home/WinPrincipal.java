package br.com.stockplus.graphicalInterface.home;

import br.com.stockplus.controllClasse.SessionControl;
import br.com.stockplus.dao.FornecedorDAO;
import br.com.stockplus.dao.ProdutoDAO;
import br.com.stockplus.graphicalInterface.fornecedor.WinAtualizarFornecedor;
import br.com.stockplus.graphicalInterface.login.WinLogin;
import br.com.stockplus.graphicalInterface.produtos.WinAtualizarProduto;
import br.com.stockplus.graphicalInterface.produtos.WinCadastroProdutos;
import br.com.stockplus.graphicalInterface.fornecedor.WinCadastrodeFornecedor;
import br.com.stockplus.graphicalInterface.usuarios.WinCadastrodeUsuario;
import br.com.stockplus.graphicalInterface.fornecedor.WinPesquisaFornecedor;
import br.com.stockplus.graphicalInterface.produtos.WinPesquisaProdutos;
import br.com.stockplus.graphicalInterface.usuarios.WinPesquisaUsuario;
import br.com.stockplus.graphicalInterface.usuarios.WinAtualizarUsuario;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

import static java.awt.Font.ITALIC;

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

    private void abriAtualizarFornecedor(){
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            String titulo = this.getTitle();
            WinAtualizarFornecedor tempFrame = new WinAtualizarFornecedor();
            JPanel painelHome = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelHome.getLayout());

            while (painelHome.getComponentCount()> 0){
                Component comp = painelHome.getComponent(0);
                painelHome.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelHome.getBackground());
            this.setJMenuBar(menuBarHome);
            this.setTitle("Atualizar fornecedor");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();
        }catch (Exception e){

            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Erro: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void abrirAtualizarProduto(){
        try {
            JMenuBar menuHome = this.getJMenuBar();
            String titulo = this.getTitle();

            WinAtualizarProduto tempFrame = new WinAtualizarProduto();
            JPanel painelHome  =(JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelHome.getLayout());

            while (painelHome.getComponentCount() > 0 ){
                Component comp = painelHome.getComponent(0);
                painelHome.remove(comp);
                this.getContentPane().add(comp);
            }
            this.getContentPane().setBackground(painelHome.getBackground());
            this.setTitle("Atualizar produtos");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();
        } catch (Exception e) {
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



    JLabel lblPrecoTotal;
    JLabel lblTotalProdutos;
    JLabel lblTotalFornecedores;

    JTextField textTotalPreco;
    JTextField textTotalProdutos;
    JTextField textTotalFornecedorees;

    JPanel panelTituloResumo;
    JLabel lblResumoDoNegocio;

    public void carregarPrecoTotalEstoque(){
        ProdutoDAO DAO = new ProdutoDAO();

        try {

            Double totalBalance = DAO.findByTotalBalance();
            textTotalPreco.setText("R$ " + String.valueOf(totalBalance));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void carregarTotalFornecedores(){
        FornecedorDAO DAO = new FornecedorDAO();

        try{
            Integer total = DAO.findByTotalFornecedor();

            textTotalFornecedorees.setText(String.valueOf(total));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void carregatTotalDoEstoque(){
        ProdutoDAO DAO = new ProdutoDAO();

        try {
            Integer total = DAO.findByTotalProdutos();
            textTotalProdutos.setText(String.valueOf(total));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public WinPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);
        setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0, 102, 153));
        setJMenuBar(menuBar);
        ImageIcon rawIcon = new ImageIcon(Objects.requireNonNull(WinPrincipal.class.getResource("/imgs/iconHome2.png")));
        int larguraDesejada = 950;
        double proporcao = (double) rawIcon.getIconHeight() / (double) rawIcon.getIconWidth();
        int alturaProporcional = (int) (larguraDesejada * proporcao);
        Image scaledImg = rawIcon.getImage().getScaledInstance(larguraDesejada, alturaProporcional, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JLabel lblNewLabel = new JLabel(scaledIcon);
        int posX = (1280 - larguraDesejada) / 2;
        int posY = 150;
        lblNewLabel.setBounds(posX, posY, larguraDesejada, alturaProporcional);
        getContentPane().add(lblNewLabel);

        panelTituloResumo = new JPanel();
        panelTituloResumo.setBounds(110, 120, 1060, 40);
        panelTituloResumo.setBackground(new Color(0, 102, 153));
        panelTituloResumo.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102), 2));
        getContentPane().add(panelTituloResumo);
        panelTituloResumo.setLayout(null);

        lblResumoDoNegocio = new JLabel("Resumo do negicio");
        lblResumoDoNegocio.setBounds(130, 120, 1060, 40);
        lblResumoDoNegocio.setBackground(Color.BLACK);
        lblResumoDoNegocio.setFont(new Font("Segoe UI", Font.BOLD, 16));
        getContentPane().add(lblResumoDoNegocio);


        //Configura a ordem dos componentes
        getContentPane().setComponentZOrder(lblResumoDoNegocio, 0);
        getContentPane().setComponentZOrder(panelTituloResumo, 1);
        getContentPane().setComponentZOrder(lblNewLabel, 2);

        // Preço do estoque total
        lblPrecoTotal = new JLabel("Preco total do estoque");
        lblPrecoTotal.setBounds(560, 390, 200, 20);
        getContentPane().add(lblPrecoTotal);

        textTotalPreco = new JTextField();
        textTotalPreco.setColumns(7);
        textTotalPreco.setBounds(560, 415, 200, 30);
        textTotalPreco.setEditable(false);
        textTotalPreco.setEnabled(true);
        textTotalPreco.setVisible(true);
        textTotalPreco.setBackground(Color.WHITE);
        carregarPrecoTotalEstoque();
        getContentPane().add(textTotalPreco);

        //qunatidade de produtos no estoque
        lblTotalProdutos = new JLabel("Quanatidade total do estoque");
        lblTotalProdutos.setBounds(200, 390, 200, 20);
        getContentPane().add(lblTotalProdutos);

        textTotalProdutos = new JTextField(7);
        textTotalProdutos.setBounds(200, 415, 200, 30);
        textTotalProdutos.setVisible(true);
        textTotalProdutos.setEnabled(true);
        textTotalProdutos.setEditable(false);
        textTotalProdutos.setBackground(Color.WHITE);
        carregatTotalDoEstoque();
        getContentPane().add(textTotalProdutos);

        //Qunatidade total de fornecedores
        lblTotalFornecedores = new JLabel("Total de fornecedores");
        lblTotalFornecedores.setBounds(900, 390, 200, 20);
        getContentPane().add(lblTotalFornecedores);

        textTotalFornecedorees = new JTextField(7);
        textTotalFornecedorees.setBounds(900, 415, 200, 30);
        textTotalFornecedorees.setEditable(false);
        textTotalFornecedorees.setEnabled(true);
        textTotalFornecedorees.setVisible(true);
        textTotalFornecedorees.setBackground(Color.WHITE);
        carregarTotalFornecedores();
        getContentPane().add(textTotalFornecedorees);

        // home
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
        JMenuItem subMenuFPesquisar = new JMenuItem("Pesquisar fornecedor");
        JMenuItem subMenuFAtualizar = new JMenuItem("Atualizar fornecedor");
        menuFornecedores.add(subMenuFCadastrar);
        menuFornecedores.addSeparator();
        menuFornecedores.add(subMenuFPesquisar);
        menuFornecedores.addSeparator();
        menuFornecedores.add(subMenuFAtualizar);
        subMenuFCadastrar.addActionListener(e -> abrirCadastroFornecedor());
        subMenuFPesquisar.addActionListener(e -> abrirPesquisaFornecedor());
        subMenuFAtualizar.addActionListener(e -> abriAtualizarFornecedor());


        /// ----> usuaarios
		JMenu menuUsuarios = new JMenu("USUÁRIOS");
		menuUsuarios.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/ico_usuarios.png"))));
		menuUsuarios.setForeground(Color.WHITE);
		menuUsuarios.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuUsuarios.addActionListener(e -> {
            if(!SessionControl.isAdmin()){
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
        JMenuItem subMenuPAtualizar = new JMenuItem("Atualizar Produto");
        menuProdutos.add(subMenuPCadastar);
        menuProdutos.addSeparator();
        menuProdutos.add(subMenuPPesquisar);
        menuProdutos.addSeparator();
        menuProdutos.add(subMenuPAtualizar);
        subMenuPCadastar.addActionListener(e -> abrirCadastroProduto());
        subMenuPPesquisar.addActionListener(e -> abrirPesquisaProdutos());
        subMenuPAtualizar.addActionListener( e -> abrirAtualizarProduto());


        ///  ----> colocando menu sar ao canto direto
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

        setVisible(true);
    }
}
