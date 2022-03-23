package exceptions;

import config.Config;

public class FeiticoNaoListadoException extends Exception {

    public FeiticoNaoListadoException(){
        super(Config.texts().notListedSpellWarning);
    }
    
}
