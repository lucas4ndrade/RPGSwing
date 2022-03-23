package entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Diario implements Serializable{
    
    private ArrayList<Evento> eventos;
    
    public Diario(){
        this.eventos = new ArrayList<>();
    }
    
    public ArrayList<Evento> verEventos(){
        return this.eventos;
    }

    public void addEvento(Evento tipoEvento){
        this.eventos.add(tipoEvento);
    }

    public void delEventos(){
        this.eventos.clear();
    }
    
}