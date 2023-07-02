package error;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificaNome {
    public static boolean Checagem(String Nome) throws NomeException {
        String NomeRegex = "^-?[A-Za-z]{3,}$";
        Pattern pattern = Pattern.compile(NomeRegex);
        Matcher matcher = pattern.matcher(Nome);
        if (matcher.matches()) {
            return true;
        } else {
            throw new NomeException();
        }
    }
}
