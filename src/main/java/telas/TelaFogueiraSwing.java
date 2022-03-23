
package telas;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import config.Config;
import controladores.ControladorFogueira;
import javax.swing.ImageIcon;

public class TelaFogueiraSwing extends JFrame{
    private JButton btSair;
    private JButton btDiario;
    private JButton btVerBolsa;
    private JButton btDescartarItens;
    private JButton btVerFeiticos;
    private JButton btCriarFeiticos;
    private JButton btEsquecerFeiticos;
    private JButton btSalaBoss;
    private JLabel lbNome;
    private JLabel lbNivel;
    private JLabel lbVida;
    private JLabel lbDanoArma;
    private JLabel lbImgJogador;
    private JLabel lbVazia;
    private JLabel lbImgAuxiliar;
    private JLabel lbNarra1;
    private JLabel lbNarra2;
    private JLabel lbNarra3;
    private JLabel lbGrimorios;
    private final JButton btSalvar;
    
    public TelaFogueiraSwing(ConteudoTelaFogueira jogador){
        super(Config.texts().bonfire);
        
        setSize(900,735);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 180;
        
        /*----------DADOS JOGADOR----------*/
        lbNome = new JLabel();
        lbNome.setText(Config.texts().name + jogador.jogador.getNome());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbNome, c);

        lbNivel = new JLabel();
        lbNivel.setText(Config.texts().level + jogador.jogador.getNivelInt());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(lbNivel, c);

        lbVida = new JLabel();
        lbVida.setText(Config.texts().life + jogador.jogador.getVidaAtual() + "/" + jogador.jogador.getVidaTotal());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(lbVida, c);

        lbDanoArma = new JLabel();
        lbDanoArma.setText(Config.texts().weaponDamage + jogador.jogador.getArma().getDano());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(lbDanoArma, c);
        
        lbGrimorios = new JLabel();
        lbGrimorios.setText(Config.texts().grimoires + jogador.jogador.getGrimorios());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        container.add(lbGrimorios, c);
        
        /*----------IMAGENS----------*/

        c.ipady = 200;
        lbImgJogador = new JLabel();
        lbImgJogador.setIcon(new ImageIcon(getClass().getResource("/imagens/Jogador.png")));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 5;
        container.add(lbImgJogador, c);
        
        lbVazia = new JLabel();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 5;
        container.add(lbVazia, c);
        
        lbImgAuxiliar = new JLabel();
        lbImgAuxiliar.setIcon(new ImageIcon(getClass().getResource("/imagens/Fogueira.png")));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 2;
        c.gridy = 5;
        container.add(lbImgAuxiliar, c);
        c.ipady = 0;
        
        /*----------NARRACAO----------*/
        lbNarra1 = new JLabel();
        lbNarra1.setText(Config.texts().bonfireFindNarration1);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 6;
        container.add(lbNarra1, c);
        
        lbNarra2 = new JLabel();
        lbNarra2.setText(Config.texts().bonfireFindNarration2);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        container.add(lbNarra2, c);
        
        lbNarra3 = new JLabel();
        lbNarra3.setText(Config.texts().bonfireFindNarration3);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 8;
        container.add(lbNarra3, c);
               
        
        /*----------BOTOES----------*/
        btDiario = new JButton(Config.texts().seeDiary);
        btDiario.setActionCommand("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 9;
        container.add(btDiario, c);
        
        btVerBolsa = new JButton(Config.texts().seeBag);
        btVerBolsa.setActionCommand("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 9;
        container.add(btVerBolsa, c);
        
        btVerFeiticos = new JButton(Config.texts().seeSpells);
        btVerFeiticos.setActionCommand("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 9;
        container.add(btVerFeiticos, c);
        
        btDescartarItens = new JButton(Config.texts().discardItens);
        btDescartarItens.setActionCommand("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 10;
        container.add(btDescartarItens, c);
        
        btCriarFeiticos = new JButton(Config.texts().createSpell);
        btCriarFeiticos.setActionCommand("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 10;
        container.add(btCriarFeiticos, c);
        
        btEsquecerFeiticos = new JButton(Config.texts().forgetSpell);
        btEsquecerFeiticos.setActionCommand("6");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 10;
        container.add(btEsquecerFeiticos, c);
        
        btSair = new JButton(Config.texts().exitBonfire);
        btSair.setActionCommand("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 11;
        container.add(btSair, c);
        
        btSalvar = new JButton(Config.texts().saveGame);
        btSalvar.setActionCommand("7");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 12;
        container.add(btSalvar, c);
        
        if(jogador.jogador.getPossuiChave()){
            btSalaBoss = new JButton(Config.texts().goToBossRoom);
            btSalaBoss.setActionCommand("8");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 13;
            container.add(btSalaBoss, c);
        }
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btSair.addActionListener(btManager);
        btSalvar.addActionListener(btManager);
        btSalaBoss.addActionListener(btManager);
        btEsquecerFeiticos.addActionListener(btManager);
        btCriarFeiticos.addActionListener(btManager);
        btDiario.addActionListener(btManager);
        btVerBolsa.addActionListener(btManager);
        btDescartarItens.addActionListener(btManager);
        btVerFeiticos.addActionListener(btManager);
    }
    
    public void mostraTela(){
        super.setVisible(true);
    }
    
    public void ocultaTela(){
        super.setVisible(false);
    }

    public void updateData(ConteudoTelaFogueira jogador) {
        if(jogador.jogador != null){
            lbDanoArma.setText(Config.texts().weaponDamage + jogador.jogador.getArma().getDano());
            lbGrimorios.setText(Config.texts().grimoires + jogador.jogador.getGrimorios());
        }
    }
    
    private static class GerenciadorDeBotoes implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ControladorFogueira.getInstance().executaOpcao(e.getActionCommand());
        }
        
    }
}
