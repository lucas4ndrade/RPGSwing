package exceptions;

import config.Config;

public class NomeVazioException extends Exception{
    
    public NomeVazioException(){
        super(Config.texts().emptyNameWarning);
    }
    
}
