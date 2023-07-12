package org.bws.database;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import org.bws.model.DataFrame;
import org.bws.model.THL;

import com.google.gson.Gson;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;






@ApplicationScoped
public class ReadData {
@Inject
EntityManager entityManager;


/**
* This method read data from the brute database and convert the field "data" to
* DataFrame Format
*
* @return List of DataFrame
*/

@Transactional
public List<DataFrame> getServerIotFrames() {
String jpql = "SELECT a FROM THL a";
TypedQuery<THL> query = entityManager.createQuery(jpql, THL.class);

List<THL> archives = query.getResultList();

List<DataFrame> serverIotFrames = new ArrayList<>();

for (THL archive : archives) {
DataFrame dataFrame = new DataFrame();


JsonObject dataJson = Json.createReader(new StringReader(archive.getData())).readObject();
dataFrame.setGateway(dataJson.getInt("gateway"));
dataFrame.setApp(dataJson.getInt("app"));
dataFrame.setTypeGw(dataJson.getString("typeGw"));
String dateString = dataJson.getString("date");
LocalDateTime date = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
dataFrame.setDate(date);
String dateServerString = dataJson.getString("date_srv");
LocalDateTime dateServer = LocalDateTime.parse(dateServerString,
DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
dataFrame.setDate_srv(dateServer);
dataFrame.setData(dataJson.getString("data"));
dataFrame.setResp(dataJson.getInt("resp"));
dataFrame.setFID(dataJson.getString("FID"));
dataFrame.setSnr(dataJson.getInt("snr"));
dataFrame.setRssi(dataJson.getInt("rssi"));

serverIotFrames.add(dataFrame);
}

return serverIotFrames;
}
}


/* 
@ApplicationScoped
public class ReadData {
    @Inject
    EntityManager entityManager;

     
@Transactional
    public  List<DataFrame> convertThlData() {
    
     // executing parameterized queries against a relational database 
    String jpql = "select a from THL a";
    TypedQuery<THL> query = entityManager.createQuery(jpql , THL.class);
       
    List<THL>  brutData= query.getResultList();
    List<DataFrame> dataFrames = new ArrayList<>();


      for (THL sensor : brutData) {

       DataFrame dataFrame = new DataFrame();
       JsonObject dataJson =Json.createReader(new StringReader(sensor.getData())).readObject();

       dataFrame.setGateway(dataJson.getInt("Gateway"));
       dataFrame.setApp(dataJson.getInt("App"));
       dataFrame.setTypeGw(dataJson.getString("TypeGw"));
       String dateString = dataJson.getString("Date");
       String dateString_srv = dataJson.getString("Date_srv");
       
       //To transform a string to the LocalDate type
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       LocalDateTime Date = LocalDateTime.parse(dateString, formatter);
       dataFrame.setDate(Date);

       LocalDateTime Date_srv = LocalDateTime.parse(dateString_srv, formatter);
       dataFrame.setDate(Date_srv);
  


       dataFrame.setData(dataJson.getString("Data"));
       dataFrame.setFID(dataJson.getString("FID"));
       dataFrame.setResp(dataJson.getInt("Resp"));
       dataFrame.setSnr(dataJson.getInt("Snr"));
       dataFrame.setRssi(dataJson.getInt("Rssi"));

       dataFrames.add(dataFrame);
      
      }
      
      System.out.println("dataframes output "+ dataFrames);
      return dataFrames ;
    }
    
}*/


//represents an object in JSON format
       // we convert the JSON string back to a JsonObject using a JsonReader and Json.createReader().
       
      /*  StringReader jsonData = new StringReader(sensor.getData());
       JsonReader jsonreader = Json.createReader(jsonData);
        JsonObject dataJson = jsonreader.readObject();

       String sensorData = sensor.getData();

       System.out.println("json reader output "+sensorData);
       System.out.println("sensor ID output "+ sensor.getId());
        System.out.println("sensor Date output "+ sensor.getDate());

        String input = "{\'gateway'\:\221\,\'app'\:\1\,\'typeGw'\ :\'SCH'\,\'date'\ : \'2022-06-01 00:01:25'\,\'date_srv'\ : \'2022-06-01 00:01:27'\,
        \'data'\: \'FF030000080136096400000005EB063C'\,\'resp'\: \0\,\'FID'\: \'00'\, \'snr'\ : \-7\, 'rssi' : -100}";*/


        //Gson gson = new Gson();
      // DataFrame obj = gson.fromJson(sensorData, DataFrame.class);
          //System.out.println("Gson output " + obj.getGateway() );
        

          // System.out.println("sdataJson output "+ dataJson);

