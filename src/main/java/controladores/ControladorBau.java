package controladores;
import telas.TelaBauSwing;
import entidades.TipoEvento;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import config.Config;
import entidades.Arma;
import entidades.Consumivel;
import entidades.Evento;
import telas.ConteudoTelaBau;
import telas.TelaDeAviso;
import telas.TelaTabelaArma;
import telas.TelaTabelaItens;

public class ControladorBau{
    private TelaBauSwing telaBauS;
    private Arma armaBau;
    private Consumivel consumivelBau;
    private boolean temGrimorio;
    private boolean temArma;
    private boolean temConsumivel;
    private static ControladorBau instance;

    private ControladorBau() {
        temGrimorio = false;
        temArma = false;
        temConsumivel = false;
    }
    
    public static ControladorBau getInstance(){
        if(instance == null){
            instance = new ControladorBau();
        }
        return instance;
    }
    
    public void iniciaEncontro() {      
        geraItens();
        telaBauS = new TelaBauSwing(this);
        telaBauS.mostraTelaBau();
    }
    
    public void geraItens(){
        Random randArma = new Random();
        int arma = randArma.nextInt(2);
        Random randConsumivel = new Random();
        int consumivel = randConsumivel.nextInt(2);
        Random randGrimorio = new Random();
        int grimorio = randGrimorio.nextInt(2);

        switch(arma){
            case 0: break;
            case 1: Arma armaBau = new Arma(15);
                    this.armaBau = armaBau;
                    this.temArma = true;
                    break;
        }
        
        switch(consumivel){
            case 0: break;
            case 1: Consumivel consumivelBau = new Consumivel();
                    this.consumivelBau = consumivelBau;
                    this.temConsumivel = true;
                    break;
        }
        
        switch(grimorio){
            case 0: break;
            case 1: temGrimorio = true;
                    break;
        }
        
        if(!temArma && !temConsumivel && !temGrimorio){
            Consumivel consumivelBau = new Consumivel();
            this.consumivelBau = consumivelBau;
            this.temConsumivel = true;
        }
    }

    public void executaOpcao(String escolha){
        try{
            switch(escolha){
                case "0": this.telaBauS.ocultaTelaBau();
                          this.finalizaBau();
                          break;
                case "1": mostraItensJogador(compactarItensJogador());
                          break;
                case "2": mostraArmaJogador(compactarArmaJogador());
                          break;
                case "3": if(temArma){
                            compararArmas(compactarArmas());
                          }
                            break;
                case "4": if(temConsumivel){
                            verItens(compactarItensJogador(), compactarConsumivelBau());
                          }
                            break;
                default: 
            }
        }catch(Exception e){
            TelaDeAviso erro = new TelaDeAviso(e.getMessage());
            erro.mostraTela();
        }

    }
    
    public void finalizaBau(){
        Evento evento = new Evento(TipoEvento.BAU, new Date());
        ControladorPrincipal.getInstance().getJogador().getDiario().addEvento(evento);
        ControladorPrincipal.getInstance().escolheEncontro();
        
    }
    
    public void verItens(ArrayList<ConteudoTelaBau> itensJogador, ConteudoTelaBau itemBau) {
        TelaTabelaItens tabela = new TelaTabelaItens(itensJogador, itemBau);
        
        tabela.mostraTela();
    }
    
    public void compararArmas(ConteudoTelaBau armas) {
       TelaTabelaArma tabela = new TelaTabelaArma(armas);
       tabela.mostraTela();
    }
    
    public void mostraItensJogador( ArrayList<ConteudoTelaBau> itens){
       TelaTabelaItens tabela = new TelaTabelaItens(itens); 
       tabela.mostraTela();
    }

    public void mostraArmaJogador(ConteudoTelaBau armaJogador) {
        TelaTabelaArma tabela = new TelaTabelaArma(armaJogador, true);
        tabela.mostraTela();
    }
    
    public void trocarArma(){
        ControladorPrincipal.getInstance().getJogador().setArma(armaBau);
        this.armaBau = null;
        this.temArma = false;
        telaBauS.updateAtributes(compactarItensBoolean());
    }
    
    public void pegarConsumivel(){
        ControladorPrincipal.getInstance().getJogador().addConsumivelBolsa(consumivelBau);
        this.consumivelBau = null;
        this.temConsumivel = false;
        telaBauS.updateAtributes(compactarItensBoolean());
    }
    
    public ConteudoTelaBau compactarItensBoolean(){
        ConteudoTelaBau conteudo = new ConteudoTelaBau();
        conteudo.temArma = this.temArma;
        conteudo.temConsumivel = this.temConsumivel;
        conteudo.temGrimorio = this.temGrimorio;
        return conteudo;
    }
    
    public ConteudoTelaBau compactarConsumivelBau(){
        ConteudoTelaBau conteudo = new ConteudoTelaBau();
        conteudo.item = consumivelBau;
        return conteudo;
    }
    
    public ArrayList<ConteudoTelaBau> compactarItensJogador(){
        ArrayList<ConteudoTelaBau> conteudos = new ArrayList<>();
        ArrayList<Consumivel> consumiveis = ControladorPrincipal.getInstance().getJogador().getConsumiveisBolsa();
        for(Consumivel consumivel: consumiveis){
            ConteudoTelaBau conteudo = new ConteudoTelaBau();
            conteudo.item = consumivel;
            conteudos.add(conteudo);
        }
        return conteudos;
    }
    
    public ConteudoTelaBau compactarArmas(){
        ConteudoTelaBau conteudo = new ConteudoTelaBau();
        conteudo.armaJogador = ControladorPrincipal.getInstance().getJogador().getArma();
        conteudo.armaBau = this.armaBau;
        return conteudo;
    }
    
    public ConteudoTelaBau compactarArmaJogador(){
        ConteudoTelaBau conteudo = new ConteudoTelaBau();
        conteudo.armaJogador = ControladorPrincipal.getInstance().getJogador().getArma();
        return conteudo;
    }
}














