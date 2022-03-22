package telas;

import java.util.Scanner;
import controladores.ControladorPrincipal;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaFim extends JFrame{
    
    private JLabel lb;
    private JButton bt;
    
    public TelaFim(){
        super("GAME OVER");
    
        setSize(900,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 200;
        
        lb = new JLabel();
        lb.setText("O seu herói não foi páreo para os poderosos monstros"
                    + " que habitam a masmorra!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb, c);
        
        bt = new JButton();
        bt.setText("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(bt, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        bt.addActionListener(btManager);
    }
    
    public void mostraTela(){
        setVisible(true);
        //System.out.println("Deseja tentar novamente ?");
        //System.out.println("1- TENTAR NOVAMENTE");
        //System.out.println("2- SAIR DO JOGO");
        //int opcao = this.teclado.nextInt();
    }
    
    public void ocultaTela(){
        setVisible(false);
    }
    
    private class GerenciadorDeBotoes implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ocultaTela();
        }
        
    }
}
