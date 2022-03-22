package exceptions;

public class NomeVazioException extends Exception{
    
    public NomeVazioException(){
        super("O nome não pode estar vazio...");
    }
    
}
