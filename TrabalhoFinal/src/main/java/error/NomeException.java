//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package error;

public class NomeException extends Exception {
    public NomeException() {
        super("Você Inseriu um caractere inválido");
    }
}
