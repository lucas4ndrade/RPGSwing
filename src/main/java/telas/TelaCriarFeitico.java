package telas;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import config.Config;
import controladores.ControladorFogueira;

public class TelaCriarFeitico extends JFrame{
    
    private JButton btConfirmar;
    private JLabel lblNome;
    private JTextField nome;
    private JButton btVoltar;
    private JLabel lb1;
    private JButton btFogo;
    private JButton btAgua;
    private JButton btGrama;
    private JButton btPedra;
    private JLabel lblAviso;
    
    public TelaCriarFeitico(){
        super(Config.texts().createSpell);
        
        setSize(700,400);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        setLocationRelativeTo(null);
        
        c.ipadx = 200;
        
        lblNome = new JLabel();
        lblNome.setText(Config.texts().spellNameLabel);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lblNome, c);
        
        nome = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(nome, c);
        
        btConfirmar = new JButton(Config.texts().confim);
        btConfirmar.setActionCommand("CONFIRMAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(btConfirmar, c);
        
        btVoltar = new JButton(Config.texts().back);
        btVoltar.setActionCommand("VOLTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(btVoltar, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btConfirmar.addActionListener(btManager);
        btVoltar.addActionListener(btManager);
    }
    
    public TelaCriarFeitico(String titulo){
        super(titulo);
        
        setSize(400,300);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        setLocationRelativeTo(null);
        
        lb1 = new JLabel();
        lb1.setText(Config.texts().spellElementLabel);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lb1, c);
        
        btFogo = new JButton(Config.texts().fire);
        btFogo.setActionCommand("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btFogo, c);
        
        btAgua = new JButton(Config.texts().water);
        btAgua.setActionCommand("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        container.add(btAgua, c);
        
        btGrama = new JButton(Config.texts().grass);
        btGrama.setActionCommand("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        container.add(btGrama, c);
        
        btPedra = new JButton(Config.texts().rock);
        btPedra.setActionCommand("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        container.add(btPedra, c);
        
        btVoltar = new JButton(Config.texts().back);
        btVoltar.setActionCommand("VOLTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        container.add(btVoltar, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btFogo.addActionListener(btManager);
        btAgua.addActionListener(btManager);
        btGrama.addActionListener(btManager);
        btPedra.addActionListener(btManager);
        btVoltar.addActionListener(btManager);
    }
    
    public TelaCriarFeitico(boolean erroOuAcerto){
        super(Config.texts().warning);
        
        setSize(400,300);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        setLocationRelativeTo(null);
        
        if(erroOuAcerto == false){
            lblAviso = new JLabel();
            lblAviso.setText(Config.texts().noGrimoiresWarning);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            container.add(lblAviso, c);
        } else {
            lblAviso = new JLabel();
            lblAviso.setText(Config.texts().sucessCreateSpell);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            container.add(lblAviso, c);
        }
        
        btVoltar = new JButton(Config.texts().ok);
        btVoltar.setActionCommand("VOLTAR");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btVoltar, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btVoltar.addActionListener(btManager);
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
            if(e.getActionCommand().equals("CONFIRMAR")){
                ocultaTela();
                ControladorFogueira.getInstance().pegaNomeFeiticoNovo(nome.getText());
            } else if (e.getActionCommand().equals("VOLTAR")){
                ocultaTela();
            } else {
                ControladorFogueira.getInstance().criarFeitico(e.getActionCommand());
                ocultaTela();
            }
        }
        
    }
}
