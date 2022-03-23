package telas;

import controladores.ControladorBatalha;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import config.Config;

public class TelaFimBatalha extends JFrame{

    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JLabel lb4;
    private JLabel lb5;
    private JLabel lb6;
    private JLabel lb7;
    private JButton bt;
    
    public TelaFimBatalha(ConteudoTelaBatalha conteudoTela){
        super(Config.texts().congratulationExclamation);
    
        setSize(900,700);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 200;
        
        lb1 = new JLabel();
        lb1.setText(Config.texts().lastHitNarration);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb1, c);
        
        lb2 = new JLabel();
        lb2.setText(Config.texts().causedDamage + conteudoTela.danoAtaque);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(lb2, c);
        
        lb3 = new JLabel();
        lb3.setText(Config.texts().theMighty + conteudoTela.atacado.getNome() + Config.texts().finnalyFalls);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(lb3, c);
        
        lb4 = new JLabel();
        lb4.setText(Config.texts().keyFindNarration1);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(lb4, c);
        
        lb5 = new JLabel();
        lb5.setText(Config.texts().keyFindNarration2);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        container.add(lb5, c);
        
        lb6 = new JLabel();
        lb6.setText(Config.texts().keyFindNarration3);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        container.add(lb6, c);
        
        if(conteudoTela.passouDeNivel){
            lb7 = new JLabel();
            lb7.setText(Config.texts().leveUP);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 6;
            container.add(lb7, c);
        }
        
        bt = new JButton();
        bt.setText(Config.texts().ok);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        container.add(bt, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        bt.addActionListener(btManager);
    }
    
    
    public void mostraTela() {
        setVisible(true);
    }
    
    public void ocultaTela() {
        setVisible(false);
    }
    
    private class GerenciadorDeBotoes implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ocultaTela();
            ControladorBatalha.getInstance().saiDaBatalha();
        }
        
    }
}
