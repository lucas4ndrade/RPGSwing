package exceptions;

public class NadaSelecionadoException extends Exception{
    
    public NadaSelecionadoException(){
        super("Nada foi selecionado, por favor selecione algo da tabela para executar a ação...");
    }
    
}
