package controladores;

import telas.TelaMenuInicial;
import telas.TelaInicio;
import telas.TelaSavedGame;
import telas.TelaSelecionarLinguagem;

public class ControladorGeral {
    
    private TelaSelecionarLinguagem telaConfig;
    private TelaInicio telaInicio;
    private TelaMenuInicial telaMenuInicial;
    private TelaSavedGame telaSavedGame;
    private static ControladorGeral instancia;
    
    private ControladorGeral(){
        this.telaConfig = new TelaSelecionarLinguagem();
        telaConfig.mostraTela();
    }
    
    public static ControladorGeral getInstance(){
        if(instancia == null){
            instancia = new ControladorGeral();
        }
        return instancia;
    }
    
    public void continuarComJogador(int indiceJogador){
        ControladorPrincipal.getInstance().continuarComJogador(indiceJogador);
    }
    
    public void excluirJogador(int indiceJogador){
        ControladorPrincipal.getInstance().excluiJogador(indiceJogador);
        this.telaSavedGame = new TelaSavedGame(ControladorPrincipal.getInstance().getListaJogadoresSalvos());
        this.telaSavedGame.mostraTela();
    }
    
    public void continuar(){
        this.telaSavedGame = new TelaSavedGame(ControladorPrincipal.getInstance().getListaJogadoresSalvos());
        this.telaSavedGame.mostraTela();
    }
    
    public void menuInicial(){
        this.telaMenuInicial = new TelaMenuInicial();
        this.telaMenuInicial.mostraTelaMenuInicial();
    }
    
    public void inicio(){
        try{
            this.telaInicio = new TelaInicio();
            telaInicio.mostraTelaInicio();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void play(String nome){
        ControladorPrincipal.getInstance(nome, true);
        ControladorPrincipal.getInstance().escolheEncontro();
    }
    
}
