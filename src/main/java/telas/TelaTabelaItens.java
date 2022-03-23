package telas;

import controladores.ControladorBatalha;
import controladores.ControladorBatalhaBoss;
import controladores.ControladorBau;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import config.Config;
import entidades.Item;
import javax.swing.JLabel;

public class TelaTabelaItens extends JFrame{
    
    private JTable tabelaBolsa;
    private JTable tabelaBau;
    private JScrollPane spBaseTabela;
    private ArrayList<Item> itensTabelaJogador;
    private Item itemTabelaBau;
    private JButton btOk;
    private JButton btPegar;
    private JButton btUsar;
    private JLabel txtBolsa;
    private JLabel txtBau;
    private int indiceItem;
    private boolean ehBoss;
    
    public TelaTabelaItens(ArrayList<ConteudoTelaBau> itens){
        super(Config.texts().bag);
        this.itensTabelaJogador = new ArrayList<>();
        for(ConteudoTelaBau item: itens){
            itensTabelaJogador.add(item.item);
        }
        this.atualizaDadosSoParaJogador();
        setSize(600, 330);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        tabelaBolsa.setPreferredScrollableViewportSize(new Dimension(500, 70));
        
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 4;
        
        spBaseTabela = new JScrollPane(tabelaBolsa);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        btOk = new JButton(Config.texts().ok);
        btOk.setActionCommand("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btOk, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btOk.addActionListener(btManager);
    }
    
    public TelaTabelaItens(ArrayList<ConteudoTelaBau> itensJogador, ConteudoTelaBau itemBau){
        super(Config.texts().takeItem);
        this.itensTabelaJogador = new ArrayList<>();
        for(ConteudoTelaBau item: itensJogador){
            itensTabelaJogador.add(item.item);
        }
        
        this.itemTabelaBau = itemBau.item;
        this.atualizaDados();
        setSize(800, 500);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        tabelaBolsa.setPreferredScrollableViewportSize(new Dimension(350, 70));
        tabelaBolsa.setFillsViewportHeight(true); // tambem nao sei
        
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        
        spBaseTabela = new JScrollPane(tabelaBolsa);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        txtBolsa = new JLabel(Config.texts().bag);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(txtBolsa, c);
        
        tabelaBau.setPreferredScrollableViewportSize(new Dimension(350, 70));
        tabelaBau.setFillsViewportHeight(true); // tambem nao sei
        
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 1;
        
        spBaseTabela = new JScrollPane(tabelaBau);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        txtBau = new JLabel(Config.texts().chest);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        container.add(txtBau, c);
        
        btPegar = new JButton(Config.texts().take);
        btPegar.setActionCommand("PEGAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        container.add(btPegar, c);
        
        btOk = new JButton(Config.texts().back);
        btOk.setActionCommand("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(btOk, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btOk.addActionListener(btManager);
        btPegar.addActionListener(btManager);
    }

    TelaTabelaItens(ArrayList<ConteudoTelaBatalha> conteudoTelaS , boolean ehBoss) {
        super(Config.texts().playerItens);
        indiceItem = -1;
        setSize(600,330);
        this.ehBoss = ehBoss;
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        this.itensTabelaJogador = new ArrayList<>();
        for(ConteudoTelaBatalha conteudo: conteudoTelaS){
            itensTabelaJogador.add(conteudo.consumivel);
        }
        this.atualizaDadosSoParaJogador();
        
        tabelaBolsa.setPreferredScrollableViewportSize(new Dimension(500, 70));
        
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 4;
        
        spBaseTabela = new JScrollPane(tabelaBolsa);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        btUsar = new JButton(Config.texts().use);
        btUsar.setActionCommand("USAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btUsar, c);
        
        btOk = new JButton(Config.texts().back);
        btOk.setActionCommand("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btOk, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btOk.addActionListener(btManager);
        btUsar.addActionListener(btManager);
    }
    
    public void mostraTela(){
        super.setVisible(true);
    }
    
    public void ocultaTela(){
        super.setVisible(false);
    }
    
    private void atualizaDados(){
        String[] nomeColunas = {"", Config.texts().name};
        Object[][] tabelaParaPorNaTabelaBolsa = new Object[itensTabelaJogador.size()][2];
        int i = 0;
        for(Item item: itensTabelaJogador){
            Object[] infos = {i, item.getNome()};
            tabelaParaPorNaTabelaBolsa[i] = infos;
            i++;
        }
        this.tabelaBolsa = new JTable(tabelaParaPorNaTabelaBolsa, nomeColunas);
        
        Object[][] tabelaParaPorNaTabelaBau = new Object[1][2];
        Object[] infos = { 1, itemTabelaBau.getNome()};
        tabelaParaPorNaTabelaBau[0] = infos;
            
        this.tabelaBau = new JTable(tabelaParaPorNaTabelaBau, nomeColunas);
    }
    
    private void atualizaDadosSoParaJogador(){
        String[] nomeColunas = {"", Config.texts().name};
        Object[][] tabelaParaPorNaTabelaBolsa = new Object[itensTabelaJogador.size()][2];
        int i = 0;
        for(Item item: itensTabelaJogador){
            Object[] infos = {i, item.getNome()};
            tabelaParaPorNaTabelaBolsa[i] = infos;
            i++;
        }
        this.tabelaBolsa = new JTable(tabelaParaPorNaTabelaBolsa, nomeColunas);
    }
    
    public void setIndiceItem(){
        this.indiceItem = tabelaBolsa.getSelectedRow();
    }
    
    private class GerenciadorDeBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("USAR")){
                ocultaTela();
                setIndiceItem();
                if(ehBoss){
                    ControladorBatalhaBoss.getInstance().usarItem(indiceItem);
                }else{
                    ControladorBatalha.getInstance().usarItem(indiceItem);
                }
            }else if(!e.getActionCommand().equals("OK")){
                ocultaTela();
                ControladorBau.getInstance().pegarConsumivel();
            } else {
                ocultaTela();
            }
        }
    }
    
}
