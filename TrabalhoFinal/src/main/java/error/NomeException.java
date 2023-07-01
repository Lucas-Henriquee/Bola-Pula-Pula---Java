package error;

public class NomeException extends Exception {
    public NomeException(){
        super("Você Inseriu um caractere inválido");
    }
}
