package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal implements ActionListener {
    // menu item - opções do menu - tudo oque for clicavel tem que ficar fora da janela principal
    JMenuItem finalizar,
            cadCategoria, consCategoria, altCategoria, excCategoria,
            cadClientes, consClientes, altClientes, excClientes, cadProdutos,
            consProduto, altProduto, excProduto;

    public JanelaPrincipal() {
        JFrame janela = new JFrame("Floricultura dica");
        janela.setSize(380, 250);
        janela.setLocationRelativeTo(null);

        janela.setLayout(new FlowLayout(1, 18, 100));
        JLabel lbTitulo = new JLabel("FLORICULTURA DICA");
        lbTitulo.setFont(new Font("Arial", Font.BOLD, 25));

        janela.getContentPane().setBackground(new Color(151, 151, 7));
        lbTitulo.setForeground(new Color(9, 41, 175));
        janela.add(lbTitulo);

        //barra menu
        JMenuBar jMenuBar = new JMenuBar();
        janela.setJMenuBar(jMenuBar);
        jMenuBar.setBackground(new Color(220, 205, 39));
        //criar os menus
        JMenu cadastrar = new JMenu("Cadastrar");
        JMenu consultar = new JMenu("Consultar");
        JMenu alterar = new JMenu("Alterar");
        JMenu excluir = new JMenu("Excluir");
        JMenu sair = new JMenu("Sair");
        //adcionar os menus a barra

        jMenuBar.add(cadastrar);
        jMenuBar.add(consultar);
        jMenuBar.add(alterar);
        jMenuBar.add(excluir);
        jMenuBar.add(sair);

        //ação ao botao
        finalizar = new JMenuItem("Finalizar");
        sair.add(finalizar);
        finalizar.addActionListener(this);

        cadCategoria = new JMenuItem("Categoria");
        cadastrar.add(cadCategoria);
        cadCategoria.addActionListener(this);

        consCategoria = new JMenuItem("Categoria");
        consultar.add(consCategoria);
        consCategoria.addActionListener(this);

        altCategoria = new JMenuItem("Categoria");
        alterar.add(altCategoria);
        altCategoria.addActionListener(this);

        excCategoria = new JMenuItem("Categoria");
        excluir.add(excCategoria);
        excCategoria.addActionListener(this);
        // clientes
        cadClientes = new JMenuItem("Clientes");
        cadastrar.add(cadClientes);
        cadClientes.addActionListener(this);

        consClientes = new JMenuItem("Clientes");
        consultar.add(consClientes);
        consClientes.addActionListener(this);

        altClientes = new JMenuItem("Clientes");
        alterar.add(altClientes);
        altClientes.addActionListener(this);

        excClientes = new JMenuItem("Clientes");
        excluir.add(excClientes);
        excClientes.addActionListener(this);
        // produtos
        cadProdutos = new JMenuItem("Produtos");
        cadastrar.add(cadProdutos);
        cadProdutos.addActionListener(this);

        consProduto = new JMenuItem("Produtos");
        consultar.add(consProduto);
        consProduto.addActionListener(this);

        altProduto = new JMenuItem("Produtos");
        alterar.add(altProduto);
        altProduto.addActionListener(this);

        excProduto = new JMenuItem("Produtos");
        excluir.add(excProduto);
        excProduto.addActionListener(this);

        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String resultado = "";
        JTextArea area;
        JScrollPane painel;

        if (e.getSource() == finalizar) {
            System.exit(0);
        } else if (e.getSource() == cadCategoria) {
            GerenciadorCategorias.cadastrarCategorias();
            JOptionPane.showMessageDialog(null, "Registro cadastrado com sucesso");
        } else if (e.getSource() == consCategoria) {
            resultado = GerenciadorCategorias.consultarCategorias();
            area = new JTextArea(10, 40);
            area.setText(resultado);
            area.setEditable(false);
            painel = new JScrollPane(area);
            JOptionPane.showMessageDialog(null, painel);
        } else if (e.getSource() == altCategoria) {
            resultado = GerenciadorCategorias.consultarCategorias();
            area = new JTextArea(10, 40);
            area.setText(resultado);
            area.setEditable(false);
            painel = new JScrollPane(area);
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, painel, "Digite o id que deseja alterar", 1));
            GerenciadorCategorias.alterarCategorias(id);
            JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso");
        } else if (e.getSource() == excCategoria) {
            resultado = GerenciadorCategorias.consultarCategorias();
            area = new JTextArea(10, 40);
            area.setText(resultado);
            area.setEditable(false);
            painel = new JScrollPane(area);
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, painel, "Digite o id que deseja excluir", 1));
            GerenciadorCategorias.excluirCategorias(id);
            JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso");
        } // clientes
        else if (e.getSource() == cadClientes) {
            GerenciadorClientes.cadastrarClientes();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
        } else if (e.getSource() == consClientes) {
            resultado = GerenciadorClientes.consultarClientes();
            area = new JTextArea(10, 40);
            area.setText(resultado);
            area.setEditable(false);
            painel = new JScrollPane(area);
            JOptionPane.showMessageDialog(null, painel);
        } else if (e.getSource() == altClientes) {
            resultado = GerenciadorClientes.consultarClientes();
            area = new JTextArea(10, 40);
            area.setText(resultado);
            area.setEditable(false);
            painel = new JScrollPane(area);
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, painel, "Digite o id que deseja alterar", 1));
            GerenciadorClientes.alterarClientes(id);
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
        } else if (e.getSource() == excClientes) {
            resultado = GerenciadorClientes.consultarClientes();
            area = new JTextArea(10, 40);
            area.setText(resultado);
            area.setEditable(false);
            painel = new JScrollPane(area);
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, painel, "Digite o id que deseja excluir", 1));
            GerenciadorClientes.excluirClientes(id);
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
        } //produtos
        else if (e.getSource() == cadProdutos) {
            GerenciadorProdutos.cadastrarProdutos();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
        } else if (e.getSource() == consProduto) {
            resultado = GerenciadorProdutos.consultarProdutos();
            area = new JTextArea(10, 40);
            area.setText(resultado);
            area.setEditable(false);
            painel = new JScrollPane(area);
            JOptionPane.showMessageDialog(null, painel);
        } else if (e.getSource() == altProduto) {
            resultado = GerenciadorProdutos.consultarProdutos();
            area = new JTextArea(10, 40);
            area.setText(resultado);
            area.setEditable(false);
            painel = new JScrollPane(area);
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, painel, "Digite o id que deseja alterar", 1));
            GerenciadorProdutos.alterarProdutos(id);
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
        } else if (e.getSource() == excProduto) {
            resultado = GerenciadorProdutos.consultarProdutos();
            area = new JTextArea(10, 40);
            area.setText(resultado);
            area.setEditable(false);
            painel = new JScrollPane(area);
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, painel, "Digite o id que deseja excluir", 1));
            GerenciadorProdutos.excluirProdutos(id);
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");
        }

    }
}
