package json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CarregarDados {
     public static ArrayList<Object[]> readFromJsonFile(String fileName) {
          ArrayList<Object[]> dataList = new ArrayList<>();

          try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
               StringBuilder jsonBuilder = new StringBuilder();
               String line;

               while ((line = bufferedReader.readLine()) != null) {
                    jsonBuilder.append(line);
               }

               String jsonString = jsonBuilder.toString().trim();

               jsonString = jsonString.substring(1, jsonString.length() - 1);

               String[] dataStrings = jsonString.split("\\],\\[");
               for (String dataString : dataStrings) {
                    String[] values = dataString.split(",");

                    Object[] data = new Object[values.length];
                    for (int i = 0; i < values.length; i++) {
                         data[i] = values[i].trim().replace("\"", "");
                    }

                    dataList.add(data);
               }

          } catch (IOException e) {
               System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
          }

          return dataList;
     }
}
