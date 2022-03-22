package telas;

import controladores.ControladorBatalha;
import controladores.ControladorBatalhaBoss;
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
import entidades.Feitico;

public class TelaTabelaFeiticos extends JFrame{
    
    private JTable tabela;
    private JScrollPane spBaseTabela;
    private ArrayList<Feitico> feiticos;
    private JButton btAtaque;
    private int indiceFeitico;
    private boolean boss;
    
    public TelaTabelaFeiticos(ArrayList<ConteudoTelaBatalha> conteudos){
        super("ATAQUE");
        feiticos = new ArrayList<>();
        for(ConteudoTelaBatalha cont : conteudos){
            feiticos.add(cont.feitico);
        }
        this.atualizaDados();
        setSize(1024,768);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabela.setFillsViewportHeight(true);
        

        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 4;
        
        spBaseTabela = new JScrollPane(tabela);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        btAtaque = new JButton("ATACAR!!");
        btAtaque.setActionCommand("ATAQUE");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btAtaque, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btAtaque.addActionListener(btManager);
    }
    
    public TelaTabelaFeiticos(ArrayList<ConteudoTelaBatalha> conteudos, boolean b){
        super("FEITICOS");
        feiticos = new ArrayList<>();
        for(ConteudoTelaBatalha cont : conteudos){
            feiticos.add(cont.feitico);
        }
        this.atualizaDados();
        setSize(1024,768);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabela.setFillsViewportHeight(true);
        

        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 4;
        
        spBaseTabela = new JScrollPane(tabela);
        container.add(spBaseTabela, c);
        
        setLocationRelativeTo(null);
        
        btAtaque = new JButton("VOLTAR");
        btAtaque.setActionCommand("VOLTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btAtaque, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btAtaque.addActionListener(btManager);
    }
    
    public void mostraTela(){
        super.setVisible(true);
    }
    
    public void ocultaTela(){
        super.setVisible(false);
    }
    
    private void atualizaDados(){
        String[] nomeColunas = {"INDICE", "NOME", "DANO", "TIPO ELEMENTO"};
        Object[][] tabelaParaPorNaTabela = new Object[feiticos.size()][4];
        int i = 0;
        for(Feitico feitico: feiticos){
            Object[] infos = {i, feitico.getNome(), feitico.getDano(), feitico.getTipoElemento()};
            tabelaParaPorNaTabela[i] = infos;
            i++;
        }
        this.tabela = new JTable(tabelaParaPorNaTabela, nomeColunas);
    }    
    
    public void setIndiceFeitico(){
        this.indiceFeitico = tabela.getSelectedRow();
    }
    
    public int getIndiceFeitico(){
        return this.indiceFeitico; 
    }
    
    public void ehBoss(){
        this.boss = true;
    }
    
    private class GerenciadorDeBotoes implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("VOLTAR")){
                ocultaTela();
            }else{
                ocultaTela();
                setIndiceFeitico();
                int i = getIndiceFeitico();
                ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
                conteudoTela.indiceFeitico = i;
                if(boss){
                    ControladorBatalhaBoss.getInstance().atacar(conteudoTela);
                }else{
                    ControladorBatalha.getInstance().atacar(conteudoTela);
                }
            }
        }
        
    }
}