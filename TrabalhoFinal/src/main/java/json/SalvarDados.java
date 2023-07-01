package json;

import com.google.gson.*;

import java.io.*;
import java.util.*;

public class SalvarDados {
     public static void saveToJsonFile(String nome, double pontuacao, String filePath) {

          ArrayList<Object[]> dados = CarregarDados.readFromJsonFile(filePath);
          Object[] novoDado = { nome, pontuacao };

          if (dados == null)
               dados = new ArrayList<>();

          dados.add(novoDado);

          if (dados != null) {
               Collections.sort(dados, Comparator.comparingDouble(o -> (double) o[1]));
               Collections.reverse(dados);
          }

          Gson gson = new Gson();
          String json = gson.toJson(dados);

          try {
               FileWriter fileWriter = new FileWriter(filePath, false);
               fileWriter.write(json);
               fileWriter.close();
          } catch (IOException e) {
               e.printStackTrace();
          }
     }
}
