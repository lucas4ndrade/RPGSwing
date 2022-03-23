package telas;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import config.Config;
import controladores.ControladorGeral;

public class TelaSelecionarLinguagem extends JFrame{
    
    private JButton btPort;
    private JButton btEng;
    private JButton btEs;
    private TelaDeException telaAviso;
    
    public TelaSelecionarLinguagem(){
        super("WELCOME");
        
        setSize(512,384);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        btPort = new JButton();
        btPort.setText("Português (Brasil)");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        container.add(btPort, c);
        
        btEng = new JButton();
        btEng.setText("English (US)");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btEng, c);

        btEs = new JButton();
        btEs.setText("Español");
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        container.add(btEs, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btPort.addActionListener(btManager);
        btEng.addActionListener(btManager);
        btEs.addActionListener(btManager);
    }
    
    public void mostraTela(){
        setVisible(true);
    }
    
    public void ocultaTela(){
        setVisible(false);
    }
    
    private class GerenciadorDeBotoes implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
            if(e.getSource() == btPort){
                Config.getInstance().setLang("ptBR");
            }else if(e.getSource() == btEs){
                Config.getInstance().setLang("esMX");
            }else if(e.getSource() == btEng){
                Config.getInstance().setLang("usENG");
            }
            ocultaTela();
            ControladorGeral.getInstance().menuInicial();
          } catch (Exception exception) {
            telaAviso = new TelaDeException(exception.getMessage());
            telaAviso.mostraTela();
          }
        }
        
    }
}
