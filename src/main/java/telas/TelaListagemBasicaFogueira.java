package telas;

import entidades.Evento;
import entidades.Item;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import config.Config;


public class TelaListagemBasicaFogueira extends JFrame{

    private ArrayList<Evento> diario;
    private JTable tabelaDiario;
    private JScrollPane spBaseTabela;
    private JButton btOk;
    private ArrayList<Item> itensTabelaJogador;
    private JTable tabelaBolsa;
    
    public TelaListagemBasicaFogueira(ArrayList<ConteudoTelaFogueira> eventos){
        super(Config.texts().diary);
        this.diario = new ArrayList<>();
        for(ConteudoTelaFogueira evento: eventos){
            diario.add(evento.evento);
        }
        this.atualizaDadosDiario();
        setSize(600, 330);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        tabelaDiario.setPreferredScrollableViewportSize(new Dimension(500, 70));
        
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 4;
        
        spBaseTabela = new JScrollPane(tabelaDiario);
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

    public TelaListagemBasicaFogueira(ArrayList<ConteudoTelaFogueira> itens, boolean contexto) {
        super(Config.texts().bag);
        this.itensTabelaJogador = new ArrayList<>();
        for(ConteudoTelaFogueira item: itens){
            itensTabelaJogador.add(item.item);
        }
        this.atualizaDadosItens();
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

    public void ocultaTela() {
        super.setVisible(false);
    }

    public void mostraTela() {
       super.setVisible(true);
    }
    
    private void atualizaDadosDiario(){
        DateFormat dateFormater = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Config.locale());

        String[] nomeColunas = {"", Config.texts().event, Config.texts().date};
        Object[][] tabelaParaPorNaTabela = new Object[diario.size()][2];

        int i = 0;
        for(Evento evento: diario){
            Object[] infos = {i+1, evento.getTipo(), dateFormater.format(evento.getData())};
            tabelaParaPorNaTabela[i] = infos;
            i++;
        }
        this.tabelaDiario = new JTable(tabelaParaPorNaTabela, nomeColunas);
    }

    private void atualizaDadosItens(){
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
    
    private class GerenciadorDeBotoes implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ocultaTela();
        }
    }
    
}
