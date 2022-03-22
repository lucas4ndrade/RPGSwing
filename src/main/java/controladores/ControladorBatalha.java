package controladores;

import telas.TelaBatalha;
import java.util.ArrayList;
import entidades.Arma;
import entidades.Consumivel;
import telas.ConteudoTelaBatalha;
import entidades.Feitico;
import entidades.Monstro;
import entidades.Ser;
import entidades.TipoElemento;
import entidades.TipoEvento;
import entidades.Jogador;

public class ControladorBatalha {
    
    private Monstro monstro;
    private TelaBatalha telaBatalha;
    private int nivelInicial;
    private static ControladorBatalha instancia;

    private ControladorBatalha(){
        this.telaBatalha = new TelaBatalha();
    }
    
    public static ControladorBatalha getInstance(){
        if(instancia == null){
            instancia = new ControladorBatalha();
        }
        return instancia;
    }
    
    public void atacar(ConteudoTelaBatalha conteudoTela){
        ConteudoTelaBatalha conteudoTelaAtaqueJogador = new ConteudoTelaBatalha();
        Feitico feitico = ControladorPrincipal.getInstance().getJogador().getFeitico(conteudoTela.indiceFeitico);

        conteudoTelaAtaqueJogador.feitico = feitico;
        int danoDoJogador = feitico.getDano();
        danoDoJogador += ControladorPrincipal.getInstance().getJogador().getArma().getDano();
        TipoElemento elementoFeitico = feitico.getTipoElemento();
        TipoElemento elementoMonstro = this.monstro.getTipoElemento();
        if(!(elementoMonstro.equals(elementoFeitico))){
            if(elementoMonstro.equals(TipoElemento.PEDRA)){

            }else if((elementoMonstro.equals(TipoElemento.FOGO) && elementoFeitico.equals(TipoElemento.AGUA)) || (elementoMonstro.equals(TipoElemento.AGUA) && elementoFeitico.equals(TipoElemento.GRAMA)) || (elementoMonstro.equals(TipoElemento.GRAMA) && elementoFeitico.equals(TipoElemento.FOGO))){
                danoDoJogador = (int)(danoDoJogador*1.15);
            }else{
                danoDoJogador = (int)(danoDoJogador*0.85);
            }
        }
        conteudoTelaAtaqueJogador.danoAtaque = danoDoJogador;
        conteudoTelaAtaqueJogador.atacante = ControladorPrincipal.getInstance().getJogador();
        conteudoTelaAtaqueJogador.atacado = this.monstro;
        this.monstro.setVidaAtual(this.monstro.getVidaAtual()-danoDoJogador);
        if(this.monstro.getVidaAtual()<=0){
            this.finalizaBatalha(conteudoTelaAtaqueJogador);
        }else{
            ConteudoTelaBatalha conteudoTelaAtaqueMonstro = new ConteudoTelaBatalha();
            int danoDoMonstro = this.monstro.getForca();
            conteudoTelaAtaqueMonstro.danoAtaque = danoDoMonstro;
            conteudoTelaAtaqueMonstro.atacado = ControladorPrincipal.getInstance().getJogador();
            conteudoTelaAtaqueMonstro.atacante = this.monstro;
            ControladorPrincipal.getInstance().getJogador().setVidaAtual(ControladorPrincipal.getInstance().getJogador().getVidaAtual()-danoDoMonstro);
            this.atualizaDadosTela();
            this.telaBatalha.mostraAtaque(conteudoTelaAtaqueJogador, conteudoTelaAtaqueMonstro);
        }
    }
    
    public void finalizaBatalha(ConteudoTelaBatalha conteudoTelaAtaqueJogador){
        conteudoTelaAtaqueJogador.ganhouChave = false;
        int rand = (int)(Math.random() * (100 + 1));
        //com nivel 13 a chance de receber a chave é 100%
        if((!(ControladorPrincipal.getInstance().getJogador().getPossuiChave())) && rand <= 100*ControladorPrincipal.getInstance().getJogador().getNivelInt()/13){
            ControladorPrincipal.getInstance().getJogador().setPossuiChave(true);
        conteudoTelaAtaqueJogador.ganhouChave = true;
        }
        ControladorPrincipal.getInstance().getJogador().ganhaExperiencia();
        if(this.nivelInicial<ControladorPrincipal.getInstance().getJogador().getNivelInt()){
            conteudoTelaAtaqueJogador.passouDeNivel = true;
        }
        this.telaBatalha.mostraFimBatalha(conteudoTelaAtaqueJogador);
        ControladorPrincipal.getInstance().getJogador().getDiario().addEvento(TipoEvento.BATALHA);
    }
    
    public void saiDaBatalha(){
        ControladorPrincipal.getInstance().escolheEncontro();
    }

    public void analisarMonstro(){
        ConteudoTelaBatalha conteudoTela = compactar(this.monstro);
        this.telaBatalha.mostraAnalise(conteudoTela);
    }

    public void verFeiticos(ConteudoTelaBatalha conteudoTela){
        try{
            TipoElemento tipoElemento;
            switch(conteudoTela.tipoString){
                case "1" :
                    tipoElemento = TipoElemento.FOGO;
                    break;
                case "2" :
                    tipoElemento = TipoElemento.AGUA;
                    break;
                case "3" :
                    tipoElemento = TipoElemento.GRAMA;
                    break;
                case "4" :
                    tipoElemento = TipoElemento.PEDRA;
                    break;
                default :
                    tipoElemento = TipoElemento.PEDRA;
            }
            ArrayList<Feitico> feiticos = ControladorPrincipal.getInstance().getJogador().verFeiticos(tipoElemento);
            ArrayList<ConteudoTelaBatalha> conteudoTelaS = this.compactar(feiticos);
            telaBatalha.mostraFeiticos(conteudoTelaS);
        }catch(Exception e){
            telaBatalha.mostraTela();
        }
    }

    public void executaOpcao(String opcao){
        try{
            switch(opcao){
                case "1" :
                    this.telaBatalha.mostraMenuAtaque(compactar(ControladorPrincipal.getInstance().getJogador().getFeiticos()));
                    break;
                case "2" :
                    this.analisarMonstro();
                    break;
                case "3" :
                    this.telaBatalha.mostraMenuFeitico();
                    break;
                case "4" :
                    break;
                case "5" :
                    this.telaBatalha.mostraMenuItens(compactar(ControladorPrincipal.getInstance().getJogador().getConsumiveisBolsa(),1));
                    break;
                case "6" :
                    this.verMeusAtributos();
                    break;
                default:
                    
            }
        }catch(Exception e){
            this.telaBatalha.mostraTela();
        }
    }

    public void iniciaEncontro(){
        this.geraMonstro();
        this.nivelInicial = ControladorPrincipal.getInstance().getJogador().getNivelInt();
        this.atualizaDadosTela();
        this.telaBatalha.mostraTela();
    }

    public ConteudoTelaBatalha compactar(Ser atacado, Ser atacante, int danoAtaque) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.atacado = atacado;
        conteudoTela.atacante = atacante;
        return conteudoTela;
    }

    public ConteudoTelaBatalha compactar(Consumivel consumivel) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.consumivel = consumivel;
        return conteudoTela;
    }
    
    public ConteudoTelaBatalha compactar(Arma arma) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.arma = arma;
        return conteudoTela;
    }
    
    public ConteudoTelaBatalha compactar(Monstro monstro) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.monstro = monstro;
        return conteudoTela;
    }
    
    public void usarItem(int indice){
        try{
            if(indice < ControladorPrincipal.getInstance().getJogador().getConsumiveisBolsa().size() && indice != -1){
                ControladorPrincipal.getInstance().getJogador().usarItem(indice);
                this.atualizaDadosTela();
                this.telaBatalha.mostraTela();
            }else{
            }
        }catch(Exception e){
            this.telaBatalha.mostraTela();
        }
    }
    
    public void verMeusAtributos(){
        Jogador jogador = ControladorPrincipal.getInstance().getJogador();
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.jogador = jogador;
        this.telaBatalha.mostraMeusAtributos(jogador);
    }

    public void gameOver() {
        ControladorPrincipal.getInstance().gameOver();
    }

    private ArrayList<ConteudoTelaBatalha> compactar(ArrayList<Feitico> feiticos) {
        ArrayList<ConteudoTelaBatalha> conteudoTelaS = new ArrayList<>();
        for(Feitico feitico : feiticos){
            ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
            conteudoTela.feitico = feitico;
            conteudoTelaS.add(conteudoTela);
        }
        return conteudoTelaS;
    }
    
    private ArrayList<ConteudoTelaBatalha> compactar(ArrayList<Consumivel> consumiveis, int i) {
        ArrayList<ConteudoTelaBatalha> conteudoTelaS = new ArrayList<>();
        for(Consumivel consumivel : consumiveis){
            ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
            conteudoTela.consumivel = consumivel;
            conteudoTelaS.add(conteudoTela);
        }
        return conteudoTelaS;
    }

    private void geraMonstro() {
        int aleatorio = (int)(Math.random() * ((4 - 1) + 1)) + 1;
        TipoElemento tipoElemento;
        switch(aleatorio){
            case 1:
                tipoElemento = TipoElemento.AGUA;
                break;
            case 2: 
                tipoElemento = TipoElemento.FOGO;
                break;
            case 3: 
                tipoElemento = TipoElemento.GRAMA;
                break;
            default:
                tipoElemento = TipoElemento.PEDRA;
                break;
        }
        /*CORRIGIR PROBABILIDADE DO TIPO ELEMENTO*/
        this.monstro = new Monstro(ControladorPrincipal.getInstance().getJogador().getNivelInt(), tipoElemento);
    }
    
    public void atualizaDadosTela(){
        if(ControladorPrincipal.getInstance().getJogador() != null){
            ConteudoTelaBatalha dadosTelaCompactados = new ConteudoTelaBatalha();
            dadosTelaCompactados.jogador = ControladorPrincipal.getInstance().getJogador();
            dadosTelaCompactados.monstro = this.monstro;
            this.telaBatalha.atualizaDados(dadosTelaCompactados);
        }
    }
    
}
