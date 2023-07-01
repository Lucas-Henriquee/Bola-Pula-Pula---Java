package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CarregarDados {
     public static ArrayList<Object[]> readFromJsonFile(String filePath) {
          ArrayList<Object[]> arrayList = new ArrayList<>();

          try {
               FileReader fileReader = new FileReader(filePath);
               BufferedReader bufferedReader = new BufferedReader(fileReader);
               String line;

               while ((line = bufferedReader.readLine()) != null) {
                    Gson gson = new Gson();
                    Type type = new TypeToken<ArrayList<Object[]>>() {
                    }.getType();
                    ArrayList<Object[]> items = gson.fromJson(line, type);
                    if (items != null) {
                         arrayList.addAll(items);
                    }
               }

               bufferedReader.close();
          } catch (IOException e) {
               e.printStackTrace();
          }

          return arrayList;
     }
}
