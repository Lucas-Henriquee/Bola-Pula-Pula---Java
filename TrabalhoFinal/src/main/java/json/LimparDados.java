//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package json;

import java.io.FileWriter;
import java.io.IOException;

public class LimparDados {
     public static void cleanJsonFile(String file) {
          try {
               FileWriter fw = new FileWriter(file, false);
               fw.write("");
               fw.flush();
               fw.close();

          } catch (IOException e) {
               e.printStackTrace();
          }
     }
}
