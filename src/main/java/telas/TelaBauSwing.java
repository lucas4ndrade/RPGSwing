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
import controladores.ControladorBau;


public class TelaBauSwing extends JFrame{
    private JLabel text1;
    private JLabel txtItens;
    private JButton btSair;
    private JButton btMostraItens;
    private JButton btMostraArma;
    private JButton btComparaArmas;
    private JButton btVerItensBau;
    private JLabel espaco;

    
    private ControladorBau ctrlBau;
    private boolean temArma;
    private boolean temGrimorio;
    private boolean temConsumivel;
    
    public TelaBauSwing(ControladorBau aThis){
        super(Config.texts().chest);
        
        this.ctrlBau = aThis;
        
        this.updateAtributes(ctrlBau.compactarItensBoolean());
        
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.ipadx = 200;
        
        /*----------IMAGENS----------*/
        c.ipady = 200;
        JLabel lbImgJogador = new JLabel();
        lbImgJogador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Jogador.png")));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(lbImgJogador, c);
        
        espaco = new JLabel();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 0;
        container.add(espaco, c);
        
        JLabel lbImgAuxiliar = new JLabel();
        lbImgAuxiliar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Bau.PNG")));
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 2;
        c.gridy = 0;
        container.add(lbImgAuxiliar, c);
        c.ipady = 0;
        
        //-----------NARRACAO-----------\\
        text1 = new JLabel();
        text1.setText(Config.texts().chestFoundNarration);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        container.add(text1, c);
        
        
        if(temArma && !temGrimorio && !temConsumivel){
            txtItens = new JLabel();
            txtItens.setText(Config.texts().aWeapon);
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if(!temArma && temGrimorio && !temConsumivel){
            txtItens = new JLabel();
            txtItens.setText(Config.texts().aGrimoire);
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if(!temArma && !temGrimorio && temConsumivel){
            txtItens = new JLabel();
            txtItens.setText(Config.texts().aConsumable);
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if(temArma && !temGrimorio && temConsumivel){
            txtItens = new JLabel();
            txtItens.setText(Config.texts().aWeaponAndConsumable);
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if (!temArma && temGrimorio && temConsumivel){
            txtItens = new JLabel();
            txtItens.setText(Config.texts().aGrimoireAndConsumable);
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if (temArma && temGrimorio && !temConsumivel){
            txtItens = new JLabel();
            txtItens.setText(Config.texts().aWeaponAndGrimoire);
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        } else if (temArma && temGrimorio && temConsumivel){
            txtItens = new JLabel();
            txtItens.setText(Config.texts().aWeaponConsumableAndGrimoire);
            c.fill = GridBagConstraints.HORIZONTAL;
            //c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 3;
            container.add(txtItens, c);
        }
        
        //------------ESPACO-----------\\
        
        espaco = new JLabel();
        c.gridwidth = 1;
        c.fill = GridBagConstraints.VERTICAL;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 4;
        container.add(espaco, c);
        c.ipady = 0;
        
        
        //------------BOTOES-----------\\
        btMostraItens = new JButton(Config.texts().seeBagItens);
        btMostraItens.setActionCommand("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        container.add(btMostraItens, c);
        
        btMostraArma = new JButton(Config.texts().seePlayerWeapon);
        btMostraArma.setActionCommand("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        container.add(btMostraArma, c);
        
        btSair = new JButton(Config.texts().exit);
        if(!temGrimorio){
            btSair.setActionCommand("0");
        } else {
            btSair.setActionCommand("SAIR");
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 5;
        container.add(btSair, c);
        
        
        int i = 6;
        if(temArma){
            btComparaArmas = new JButton();
            btComparaArmas.setText(Config.texts().takeChestWeapon);
            btComparaArmas.setActionCommand("3");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 3;
            c.gridx = 0;
            c.gridy = i;
            container.add(btComparaArmas, c);
            c.gridwidth = 0;
            i++;
        }
        
        if(temConsumivel){
            btVerItensBau = new JButton();
            btVerItensBau.setText(Config.texts().takeChestConsumable);
            btVerItensBau.setActionCommand("4");
            c.gridwidth = 3;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = i;
            container.add(btVerItensBau, c);
            c.gridwidth = 0;
        }
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btSair.addActionListener(btManager);
        btMostraItens.addActionListener(btManager);
        btMostraArma.addActionListener(btManager);
        if(temArma){
            btComparaArmas.addActionListener(btManager);
        }
        if(temConsumivel){
            btVerItensBau.addActionListener(btManager);
        }
    }
    
    public TelaBauSwing(){
        super(Config.texts().warning);
        
        setSize(500,300);
        
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        setLocationRelativeTo(null);
        
        text1 = new JLabel();
        text1.setText(Config.texts().roomExitNarration);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        container.add(text1, c);
        
        
        btSair = new JButton(Config.texts().ok);
        btSair.setActionCommand("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        container.add(btSair, c);
        
        GerenciadorDeBotoes btManager = new GerenciadorDeBotoes();
        btSair.addActionListener(btManager);
    }
    
    public void mostraTelaBau(){
        setVisible(true);
    }
    
    public void ocultaTelaBau(){
        setVisible(false);
    }

    public void updateAtributes(ConteudoTelaBau itensBau) {
        this.temArma = itensBau.temArma;
        this.temConsumivel = itensBau.temConsumivel;
        this.temGrimorio = itensBau.temGrimorio;
        
        if(btComparaArmas != null && !temArma){
            btComparaArmas.setText("---");
        }
        
        if(btVerItensBau != null && !temConsumivel){
            btVerItensBau.setText("---");
        }
    }
    
    private class GerenciadorDeBotoes implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("SAIR")){
                ocultaTelaBau();
                TelaBauSwing telaDeSaida = new TelaBauSwing();
                telaDeSaida.mostraTelaBau();
            } else if (e.getActionCommand().equals("0")){
                ControladorBau.getInstance().executaOpcao(e.getActionCommand());
                ocultaTelaBau();
            } else {
                ControladorBau.getInstance().executaOpcao(e.getActionCommand());
            }
        }
        
    }
}

