package json;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class SalvarDados {
     public static void saveToJsonFile(ArrayList<Object[]> arrayList, String filePath) {
          ArrayList<Object[]> convertedArrayList = new ArrayList<>();

          for (Object[] item : arrayList) {
               if (item.length > 0 && item[0] instanceof Float) {
                    Float floatValue = (Float) item[0];
                    Long longValue = floatValue.longValue();
                    item[0] = longValue;
               }
               convertedArrayList.add(item);
          }

          Gson gson = new Gson();
          String json = gson.toJson(convertedArrayList);

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
