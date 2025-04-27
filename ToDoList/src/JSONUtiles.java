


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class JSONUtiles {
    public static void uploadJSON(JSONArray jsonArray, String archive){
        try{
            BufferedWriter salida = new BufferedWriter(new FileWriter(archive+".json"));
            salida.write(jsonArray.toString());
            salida.flush();
            salida.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void uploadJSON(JSONObject jsonObject, String archive){
        try{
            BufferedWriter salida = new BufferedWriter(new FileWriter(archive + ".json"));
            salida.write(jsonObject.toString(4));
            salida.flush();
            salida.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String downloadJSON(String archive){
        StringBuilder contenido = new StringBuilder();
        String lectura= "";
        try
        {
            BufferedReader entrada = new BufferedReader(new FileReader(archive+".json"));
            while((lectura = entrada.readLine())!=null){
                contenido.append(lectura);
            }
            entrada.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }


        return contenido.toString();
    }


public static ArrayList<Task>TaskFromJSON(String nombreArchivo){
        JSONArray jsonArray = new JSONArray(downloadJSON(nombreArchivo));
        ArrayList<Task>tasks=new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject task = jsonArray.getJSONObject(i);
            int id = task.getInt("id");
            String description = task.getString("description");
            Status status = Status.valueOf(task.getString("status"));
            LocalDateTime created = LocalDateTime.parse(task.getString("creationDate"));
            LocalDateTime updated = LocalDateTime.parse(task.getString("updateDate"));
            Task task1=new Task(id, description, status, created, updated);

        tasks.add(task1);
        }
        return tasks;
}

}
