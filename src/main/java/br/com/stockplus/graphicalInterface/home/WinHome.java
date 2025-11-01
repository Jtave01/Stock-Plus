package br.com.stockplus.graphicalInterface.home;

import br.com.stockplus.controllClasse.SessionControl;
import br.com.stockplus.graphicalInterface.login.WinLogin;
import br.com.stockplus.graphicalInterface.produtos.movimentacao.WinEntrada;
import br.com.stockplus.graphicalInterface.produtos.movimentacao.WinSaida;
import br.com.stockplus.graphicalInterface.produtos.GerenciarProdutos;
import br.com.stockplus.graphicalInterface.fornecedor.GerenciarFonecedores;
import br.com.stockplus.graphicalInterface.usuarios.GerenciarUsuarios;
import br.com.stockplus.graphicalInterface.fornecedor.WinPesquisaFornecedor;
import br.com.stockplus.graphicalInterface.produtos.WinPesquisaProdutos;
import br.com.stockplus.graphicalInterface.usuarios.WinPesquisaUsuario;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class WinHome extends JFrame {

    // Imagem
    public ImageIcon rawIcon;

    // Menus
    public JMenu menuFornecedores;
    public JMenu menuUsuarios;
    public JMenu menuLogin;
    public JMenu menuProdutos;
    public JMenu menuMovimentacao;

    public WinHome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);
        setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(0, 102, 153));
        setJMenuBar(menuBar);

        rawIcon = new ImageIcon(Objects.requireNonNull(WinHome.class.getResource("/imgs/FundoFinal.png")));
        int larguraDesejada = 950;
        double proporcao = (double) rawIcon.getIconHeight() / (double) rawIcon.getIconWidth();
        int alturaProporcional = (int) (larguraDesejada * proporcao);
        Image scaledImg = rawIcon.getImage().getScaledInstance(larguraDesejada, alturaProporcional, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JLabel lblNewLabel = new JLabel(scaledIcon);
        int larguraJanela = 1280;
        int alturaJanela = 720;
        int posX = (larguraJanela - larguraDesejada) / 2;
        int posY = (alturaJanela - alturaProporcional) / 2;
        lblNewLabel.setBounds(posX, posY, larguraDesejada, alturaProporcional);
        getContentPane().add(lblNewLabel);
        SwingUtilities.invokeLater(() -> {
            int novaPosX = (getContentPane().getWidth() - larguraDesejada) / 2;
            int novaPosY = (getContentPane().getHeight() - alturaProporcional) / 2;
            lblNewLabel.setBounds(novaPosX, novaPosY, larguraDesejada, alturaProporcional);
        });

        // Fornecedores
        menuFornecedores = new JMenu("FORNECEDORES");
        menuFornecedores.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/ico_fornecedores.png"))));
        menuFornecedores.setForeground(Color.WHITE);
        menuFornecedores.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(menuFornecedores);
        JMenuItem subMenuFCadastrar = new JMenuItem("Gerenciar fornecedores");
        JMenuItem subMenuFPesquisar = new JMenuItem("Pesquisar fornecedor");
        menuFornecedores.add(subMenuFCadastrar);
        menuFornecedores.addSeparator();
        menuFornecedores.add(subMenuFPesquisar);
        subMenuFCadastrar.addActionListener(e -> abrirGerenciarFornecedores());
        subMenuFPesquisar.addActionListener(e -> abrirPesquisaFornecedor());

        // Produtos
        menuProdutos = new JMenu("PRODUTOS");
        menuProdutos.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/ico_produtos.png"))));
        menuProdutos.setForeground(Color.WHITE);
        menuProdutos.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(menuProdutos);
        JMenuItem subMenuPPesquisar = new JMenuItem("Pesquisar Produto");
        JMenuItem subMenuGerenciar = new JMenuItem("Gerenciar produtos");
        JMenuItem subMenuPEntrada = new JMenuItem("Entrada");
        JMenuItem subMenuPSaida = new JMenuItem("Saida");
        menuProdutos.add(subMenuPPesquisar);
        menuProdutos.addSeparator();
        menuProdutos.add(subMenuGerenciar);
        menuProdutos.addSeparator();
        menuProdutos.add(subMenuPEntrada);
        menuProdutos.addSeparator();
        menuProdutos.add(subMenuPSaida);
        subMenuPPesquisar.addActionListener(e -> abrirPesquisaProdutos());
        subMenuPEntrada.addActionListener(e -> abriEntrada());
        subMenuPSaida.addActionListener(e -> abriSaida());
        subMenuGerenciar.addActionListener(e -> abriGerenciarProdutos());
        menuProdutos.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/ico_produtos.png"))));

        // Usuários
        menuUsuarios = new JMenu("USUÁRIOS");
        menuUsuarios.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/imgs/ico_usuarios.png"))));
        menuUsuarios.setForeground(Color.WHITE);
        menuUsuarios.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuUsuarios.addActionListener(e -> {
            if (!SessionControl.isAdmin()) {
                JOptionPane.showMessageDialog(null, "Permição negada");
            }
        });
        menuBar.add(menuUsuarios);

        JMenuItem subMenuUGerenciar = new JMenuItem("Gerenciar usuario");
        menuUsuarios.add(subMenuUGerenciar);
        subMenuUGerenciar.addActionListener(e -> {
            if (SessionControl.isAdmin()) {
                abrirGerenciarUsuarios();
            } else {
                JOptionPane.showMessageDialog(null, "PErmição negada");
            }
        });

        menuUsuarios.addSeparator();
        JMenuItem subMenuUPesquisa = new JMenuItem("Pesquisa Usuario");
        menuUsuarios.add(subMenuUPesquisa);
        subMenuUPesquisa.addActionListener(e -> {
            if (SessionControl.isAdmin()) {
                abrirPesquisarUsuario();
            } else {
                JOptionPane.showMessageDialog(null, "Permição negada");
            }
        });

        // Colocando menu sair ao canto direito
        menuBar.add(Box.createHorizontalGlue());

        // Sair
        menuLogin = new JMenu("SAIR");
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


    /*
     * Interação de trocas de telas, metodo padrão a ser replicado
     * Estrutura que garente essas mudanças: JMenuBar menuBar = new JMenuBar();
     * que e nossa barra de menu da pagina inicial onde tem todos os outros menus e
     * sub menus
     */
    private void abrirPesquisarUsuario() {
        try {
            //Recolhemos o menu da "HOME" onde o mesmo tem os submenus que leva a outras paginas
            JMenuBar menuBarHome = this.getJMenuBar();
            String titulo = this.getTitle();

            //Frame temporario
            WinPesquisaUsuario tempFrame = new WinPesquisaUsuario();
            //Pega o painel com todos os componentes
            JPanel painelPesquisaU = (JPanel) tempFrame.getContentPane();
            //Removendo tods elementos da pagina atual
            this.getContentPane().removeAll();
            //Copia o layout para reorganizar as posições
            this.setLayout(painelPesquisaU.getLayout());
            //Transferindo os componentes
            while (painelPesquisaU.getComponentCount() > 0) {
                //"Roubando" os componetes de painelPesquisaU
                Component comp = painelPesquisaU.getComponent(0);
                //Removemos o componente roubado do frame temporario
                painelPesquisaU.remove(comp);
                //Adicionamos o componente "roubado no frame atual
                this.getContentPane().add(comp);
            }
            //Setamos o background do frame temporario no frame atual
            this.getContentPane().setBackground(painelPesquisaU.getBackground());
            //Adicionamos o menu original da "HOME"
            this.setJMenuBar(menuBarHome);
            //Adicionamos o titulo
            this.setTitle("Pesquisa usuario");
            //Recaucula o layout e organiza os componentes
            this.revalidate();
            //Limpa e ajustas as cores
            this.repaint();
            //Fechamos a janela do Frame temporario
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

    private void abrirPesquisaProdutos() {
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            String tituloAtual = this.getTitle();
            WinPesquisaProdutos tempFrame = new WinPesquisaProdutos();
            JPanel painelPesquisaP = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelPesquisaP.getLayout());

            while (painelPesquisaP.getComponentCount() > 0) {

                Component comp = painelPesquisaP.getComponent(0);
                painelPesquisaP.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelPesquisaP.getBackground());
            this.setJMenuBar(menuBarHome);
            this.setTitle("Pesquisa produtos");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void abrirGerenciarFornecedores() {
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            String tituloAtual = this.getTitle();
            GerenciarFonecedores tempFrame = new GerenciarFonecedores();
            JPanel painelGerenciarF = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelGerenciarF.getLayout());

            while (painelGerenciarF.getComponentCount() > 0) {
                Component comp = painelGerenciarF.getComponent(0);
                painelGerenciarF.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelGerenciarF.getBackground());
            this.setJMenuBar(menuBarHome);
            this.setTitle("Gerenciar fornecedor");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void abrirPesquisaFornecedor() {
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            String tituloAtual = this.getTitle();
            WinPesquisaFornecedor tempFrame = new WinPesquisaFornecedor();
            JPanel painelPesquisaF = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();
            this.setLayout(painelPesquisaF.getLayout());

            while (painelPesquisaF.getComponentCount() > 0) {
                Component comp = painelPesquisaF.getComponent(0);
                painelPesquisaF.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelPesquisaF.getBackground());
            this.setJMenuBar(menuBarHome);
            this.setTitle("Pesquisa de fornecedor");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void abriEntrada() {
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            WinEntrada tempFrame = new WinEntrada();
            JPanel painelEntrada = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();

            this.setLayout(painelEntrada.getLayout());

            while (painelEntrada.getComponentCount() > 0) {
                Component comp = painelEntrada.getComponent(0);
                painelEntrada.remove(comp);
                this.getContentPane().add(comp);
            }

            this.getContentPane().setBackground(painelEntrada.getBackground());
            this.setJMenuBar(menuBarHome);
            this.setTitle("Entrada");
            this.revalidate();
            this.repaint();
            tempFrame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void abriSaida() {
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            WinSaida tempFrame = new WinSaida();
            JPanel painelSaida = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();

            while (painelSaida.getComponentCount() > 0) {
                Component comp = painelSaida.getComponent(0);
                painelSaida.remove(comp);
                this.getContentPane().add(comp);
            }
            this.setTitle("Saida");
            this.setJMenuBar(menuBarHome);
            this.getContentPane().setBackground(painelSaida.getBackground());
            this.repaint();
            this.revalidate();
            tempFrame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void abriGerenciarProdutos() {
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            GerenciarProdutos tempFrame = new GerenciarProdutos();
            JPanel painelGerenciarP = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();

            while (painelGerenciarP.getComponentCount() > 0) {
                Component comp = painelGerenciarP.getComponent(0);
                painelGerenciarP.remove(comp);
                this.getContentPane().add(comp);
            }
            this.setTitle("Saida");
            this.getContentPane().setBackground(painelGerenciarP.getBackground());
            this.repaint();
            this.revalidate();

            tempFrame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void abrirGerenciarUsuarios() {
        try {
            JMenuBar menuBarHome = this.getJMenuBar();
            GerenciarUsuarios tempFrame = new GerenciarUsuarios();
            JPanel painelGerenciarU = (JPanel) tempFrame.getContentPane();
            this.getContentPane().removeAll();

            while (painelGerenciarU.getComponentCount() > 0) {
                Component comp = painelGerenciarU.getComponent(0);
                painelGerenciarU.remove(comp);

                this.getContentPane().add(comp);
            }
            this.setTitle("Gerenciar usuarios");
            this.getContentPane().setBackground(painelGerenciarU.getBackground());
            this.repaint();
            this.revalidate();
            tempFrame.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro: ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}