package json;

import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SalvarDados {
     public static void saveToJsonFile(ArrayList<Object[]> dataList, String fileName) {
          StringBuilder jsonBuilder = new StringBuilder();

          for (int i = 0; i < dataList.size(); i++) {
               Object[] data = dataList.get(i);

               jsonBuilder.append("[");
               for (int j = 0; j < data.length; j++) {
                    jsonBuilder.append("\"").append(data[j]).append("\"");
                    if (j < data.length - 1) {
                         jsonBuilder.append(",");
                    }
               }
               jsonBuilder.append("]");

               if (i < dataList.size() - 1) {
                    jsonBuilder.append(",");
               }
          }

          try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(fileName))) {
               bufferedWriter.write(jsonBuilder.toString());
          } catch (IOException e) {
               System.err.println("Erro ao salvar o arquivo JSON: " + e.getMessage());
          }
     }
}
