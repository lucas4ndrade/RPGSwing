package entidades;

import config.Config;

public enum TipoEvento {
    FOGUEIRA,
    BATALHA,
    BAU;

    //@TODO implement and use this
    public String toString() {
        String s = "";
        switch(this){
            case FOGUEIRA: 
                s = Config.texts().bonfire;
                break;
            case BATALHA: 
                s = Config.texts().battle;
                break;
            case BAU: 
                s = Config.texts().chest;
                break;
        }
        return s;
    }
}
