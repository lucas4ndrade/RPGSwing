package exceptions;

import config.Config;

public class NomeMuitoGrandeException extends Exception{
    
    public NomeMuitoGrandeException(){
        super(Config.texts().nameTooLongWarning);
    }
    
}
