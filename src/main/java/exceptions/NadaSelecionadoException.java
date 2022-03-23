package exceptions;

import config.Config;

public class NadaSelecionadoException extends Exception{
    
    public NadaSelecionadoException(){
        super(Config.texts().nothingSelectedWarning);
    }
    
}
