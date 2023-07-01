package json;

import com.google.gson.*;
import com.google.gson.reflect.*;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class CarregarDados {
     public static ArrayList<Object[]> readFromJsonFile(String filePath) {
          ArrayList<Object[]> arrayList = new ArrayList<>();

          try {
               FileReader fileReader = new FileReader(filePath);
               BufferedReader bufferedReader = new BufferedReader(fileReader);

               StringBuilder jsonContent = new StringBuilder();
               String line;
               while ((line = bufferedReader.readLine()) != null) {
                    jsonContent.append(line);
               }

               Gson gson = new Gson();
               Type type = new TypeToken<ArrayList<Object[]>>() {
               }.getType();
               arrayList = gson.fromJson(jsonContent.toString(), type);

               bufferedReader.close();
          } catch (IOException e) {
               e.printStackTrace();
          }

          return arrayList;
     }
}
