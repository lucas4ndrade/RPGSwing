package controladores;

import telas.TelaFim;
import entidades.Jogador;
import mapeadores.MapeadorJogador;
import java.util.ArrayList;

public class ControladorPrincipal {
    
    private Jogador jogador;
    private TelaFim telaFim;
    private int teste;
    private MapeadorJogador mapJog;
    private static ControladorPrincipal instancia;
    
    public static void getInstance(String nome, boolean novoJogo) {
        if(instancia == null && novoJogo){
            instancia = new ControladorPrincipal(nome, 1);
        }else if(instancia == null){
            instancia = new ControladorPrincipal(nome);
        }
    }
    
    public static ControladorPrincipal getInstance(){
        if(instancia == null){
            instancia = new ControladorPrincipal("");
        }
        return instancia;
    }
    
    private ControladorPrincipal(String nome, int i){
        criaJogador(nome, 10);
        mapJog = new MapeadorJogador();
        telaFim = new TelaFim();
        this.teste = 0;
    }

    private ControladorPrincipal(String nome){
        mapJog = new MapeadorJogador();
    }
    
    public Jogador getJogador() {
        return this.jogador;
    }
    
    public void salvar(){
        this.mapJog.load();
        this.mapJog.put(jogador);
        this.mapJog.persist();
    }
    
    public ArrayList<Jogador> getListaJogadoresSalvos(){
        this.mapJog.load();
        return this.mapJog.getList();
    }
    
    public void excluiJogador(int indiceJogador){
        this.mapJog.load();
        this.mapJog.exclude(indiceJogador);
        this.mapJog.persist();
    }
    
    public void continuarComJogador(int indiceJogador){
        this.mapJog.load();
        this.jogador = this.mapJog.get(indiceJogador);
        this.teste = 2;
        this.escolheEncontro();
    }

    public void escolheEncontro(){
        /*VERSAO TESTE*/
        switch(this.teste){
            case 0:
                    this.teste++;
                    ControladorBau.getInstance().iniciaEncontro();
                    break;
            case 1: 
                    this.teste++;
                    ControladorFogueira.getInstance().iniciaEncontro();
                    break;
            case 2: 
                    this.teste++;
                    ControladorBatalha.getInstance().iniciaEncontro();
                    break;
            case 3: 
                    this.teste++;
                    ControladorFogueira.getInstance().iniciaEncontro();
                    break;
        }
        /*
        VERSÃO RANDOMICA
        Random rand = new Random();
        int escolha = rand.nextInt(3);
        switch(escolha){
            case 0:
                    ctrlBatalha.iniciaEncontro();
                    break;
            case 1: 
                    ctrlFogueira.iniciaEncontro();
                    break;
            case 2: 
                    ctrlBau.iniciaEncontro();
                    break;
        }
        */
    }

    public void irParaBoss() {
        ControladorBatalhaBoss.getInstance().iniciaEncontro();
    }
    
    public void gameOver(){
        telaFim.mostraTela();
    }
    
    public void criaJogador(String nome){
        Jogador jogador = new Jogador(nome);
        this.jogador = jogador;
    }
    
    public void criaJogador(String nome, int nivel){
        Jogador jogador = new Jogador(nivel, nome);
        this.jogador = jogador;
    }
}
