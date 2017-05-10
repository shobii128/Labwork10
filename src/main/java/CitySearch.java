/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.City;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import org.lightcouch.CouchDbClient;

/**
 * @author Shoaib
 */
public class CitySearch {

    private static CityDAO cityDAO = new CityDAO();

    private static void populateDB() {
        try {
            
           CouchDbClient dbClient2 = new CouchDbClient("db-name", true, "http", "127.0.0.1", 5984, "shoaib", "seecs");
            

         
// dbClient.save(foo);   // save, ignore response 
// dbClient.batch(foo);  // saves batch



            // Open the input file
            FileInputStream fstream = new FileInputStream("src/main/resources/GeoLiteCity-Location.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            // Read file line by line
            String strLine;
            while ((strLine = br.readLine()) != null) {
                // Create a new city
                City city = new City();

                // TODO: Parse line to set City object
                city.setCode("abs");
                city.setRegion(6);
                
                
          Map<String, Object> map = new HashMap<>();
          map.put("_id", "doc-id");
          map.put("title", "value");
          dbClient2.save(map);
          
          
          Foo foo = dbClient2.find(Foo.class, "doc-id"); 
foo = dbClient2.find(Foo.class, "doc-id", "doc-rev"); 

foo = dbClient2.find(Foo.class, "doc-id", new Params().revsInfo().localSeq()); 

boolean found = dbClient2.contains("doc-id");

InputStream in = dbClient2.find("doc-id"); 
// ..
in.close();

// ..

                
                
                System.out.println(strLine);

                // Persist object
                cityDAO.save(city);
            }

            // Close the input stream
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // if (this-is-the-first-run) {
            // TODO: Populate database only if this is the first execution of program
            populateDB();
        // }

        // else {
            // TODO: Add other lab tasks here
        // }

    }

}
