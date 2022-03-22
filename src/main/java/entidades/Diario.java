package entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Diario implements Serializable{
    
    private ArrayList<TipoEvento> eventos;
    
    public Diario(){
        this.eventos = new ArrayList<>();
    }
    
    public ArrayList<TipoEvento> verEventos(){
        return this.eventos;
    }

    public void addEvento(TipoEvento tipoEvento){
        this.eventos.add(tipoEvento);
    }

    public void delEventos(){
        this.eventos.clear();
    }
    
}