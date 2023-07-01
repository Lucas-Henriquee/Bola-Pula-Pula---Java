package json;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class SalvarDados {
     public static void saveToJsonFile(ArrayList<Object[]> arrayList, String filePath) {
          Gson gson = new Gson();
          String json = gson.toJson(arrayList);

          try {
               FileWriter fileWriter = new FileWriter(filePath, true);
               fileWriter.write(json);
               fileWriter.write(System.lineSeparator());
               fileWriter.close();
          } catch (IOException e) {
               e.printStackTrace();
          }
     }
}
