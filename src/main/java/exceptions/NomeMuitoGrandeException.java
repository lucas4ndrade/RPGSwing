package exceptions;

public class NomeMuitoGrandeException extends Exception{
    
    public NomeMuitoGrandeException(){
        super("O nome escolhido é grande demais...");
    }
    
}
