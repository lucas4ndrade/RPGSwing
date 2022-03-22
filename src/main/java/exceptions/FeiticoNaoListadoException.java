package exceptions;

public class FeiticoNaoListadoException extends Exception {

    public FeiticoNaoListadoException(){
        super("Feitiço pedido não está listado");
    }
    
}
