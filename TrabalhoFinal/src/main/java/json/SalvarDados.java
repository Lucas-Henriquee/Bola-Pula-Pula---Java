package json;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class SalvarDados {
     public static void saveToJsonFile(String nome, long pontos, String filePath) {
          // Criação do objeto que será salvo no arquivo JSON
          Object[] dados = new Object[] { nome, pontos };

          // Criação do ArrayList e adição do objeto
          ArrayList<Object[]> arrayList = new ArrayList<>();
          arrayList.add(dados);

          // Conversão do ArrayList para JSON
          Gson gson = new Gson();
          String json = gson.toJson(arrayList);

          try {
               FileWriter fileWriter = new FileWriter(filePath, true);
               fileWriter.write(json);
               fileWriter.write(System.lineSeparator()); // Adicionar uma nova linha para a próxima execução
               fileWriter.close();
          } catch (IOException e) {
               e.printStackTrace();
          }
     }
}
