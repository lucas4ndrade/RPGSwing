package telas;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import controladores.ControladorGeral;

public class TelaMenuInicial extends JFrame{
    
    private JButton btNewGame;
    private JButton btContinue;
    
    public TelaMenuInicial(){
        super("MENU INICIAL");
        
        setSize(512,384);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        btNewGame = new JButton();
        btNewGame.setText("NEW GAME");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btNewGame, c);
        
        btContinue = new JButton();
        btContinue.setText("CONTINUE");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        container.add(btContinue, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btNewGame.addActionListener(btManager);
        btContinue.addActionListener(btManager);
    }
    
    public void mostraTelaMenuInicial(){
        setVisible(true);
    }
    
    public void ocultaTelaMenuInicial(){
        setVisible(false);
    }
    
    private class GerenciadorDeBotoes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btNewGame){
                ocultaTelaMenuInicial();
                ControladorGeral.getInstance().inicio();
            }else if(e.getSource() == btContinue){
                ocultaTelaMenuInicial();
                ControladorGeral.getInstance().continuar();
            }
        }
        
    }
}
