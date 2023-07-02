//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package error;

import java.io.File;

public class VerificaArquivo {
     public static boolean validacao(String filePath) throws ArquivoException {

          File file = new File(filePath);
          if (file.length() != 0)
               return true;
          else
               throw new ArquivoException();
     }
}
