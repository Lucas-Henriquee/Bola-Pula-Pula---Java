//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package error;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificaNome {
    public static boolean checagem(String Nome) throws NomeException {
        String NomeRegex = "^-?[A-Z][A-Za-z]{2,9}$";
        Pattern pattern = Pattern.compile(NomeRegex);
        Matcher matcher = pattern.matcher(Nome);
        if (matcher.matches()) {
            return true;
        } else {
            throw new NomeException();
        }
    }
}
