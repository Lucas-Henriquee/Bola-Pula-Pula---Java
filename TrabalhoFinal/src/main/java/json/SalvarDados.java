package json;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class SalvarDados {
     public static void saveToJsonFile(String text, long number, String filePath) {
          // Cria um ArrayList<Object[]> com a string e o long
          Object[] data = { text, number };
          ArrayList<Object[]> arrayList = new ArrayList<>();
          arrayList.add(data);

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
