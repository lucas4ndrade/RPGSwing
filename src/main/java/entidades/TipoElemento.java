package entidades;

import config.Config;

public enum TipoElemento {
    FOGO,
    AGUA,
    GRAMA,
    PEDRA;

    //@TODO implement and use this
    public String toString() {
        String s = "";
        switch(this){
            case FOGO: 
                s = Config.texts().fire;
                break;
            case AGUA: 
                s = Config.texts().water;
                break;
            case GRAMA: 
                s = Config.texts().grass;
                break;
            case PEDRA: 
                s = Config.texts().rock;
                break;
        }
        return s;
    }
}
