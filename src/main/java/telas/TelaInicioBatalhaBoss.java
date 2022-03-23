package telas;

import controladores.ControladorBatalhaBoss;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import config.Config;

public class TelaInicioBatalhaBoss extends JFrame{
    
    private JLabel lb1;
    private JButton bt;
    private boolean continuar;
    
    public TelaInicioBatalhaBoss(){
        super(Config.texts().battle);
        
        setSize(1024,384);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        lb1 = new JLabel();
        lb1.setText(Config.texts().finalBossNarration1);
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb1, c);
        
        lb1 = new JLabel();
        lb1.setText(Config.texts().finalBossNarration2);
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        container.add(lb1, c);
        
        lb1 = new JLabel();
        lb1.setText(Config.texts().finalBossNarration3);
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        container.add(lb1, c);
        
        
        lb1 = new JLabel();
        lb1.setText(Config.texts().finalBossNarration4);
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        container.add(lb1, c);
        
        bt = new JButton();
        lb1.setText(Config.texts().ready);
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        container.add(bt, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        bt.addActionListener(btManager);
        
        
    }
    
    public void mostraTela(){
        setVisible(true);
    }
    
    public void ocultaTela(){
        setVisible(false);
    }
    
    public boolean getContinuar(){
        return this.continuar;
    }
    
    private class GerenciadorDeBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ocultaTela();
            ControladorBatalhaBoss.getInstance().irParaTelaBatalha();
        }
        
    }
}
