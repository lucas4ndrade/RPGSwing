package telas;

import entidades.Ser;
import entidades.Arma;
import entidades.Consumivel;
import entidades.Feitico;
import entidades.Jogador;
import entidades.Monstro;

public class ConteudoTelaBatalha {
    
    public Monstro monstro;
    public Jogador jogador;
    public String tipoString;
    public int indiceFeitico;
    public int danoAtaque;
    public Feitico feitico;
    public int indiceItem;
    public Consumivel consumivel;
    public Arma arma;
    public Ser atacante;
    public Ser atacado;
    public boolean ganhouChave = false;
    public boolean passouDeNivel = false;
    
}
