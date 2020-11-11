package org.bob;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ReadTextFile {
  public static Map<String, Integer> read(String fileName){
    Map<String, Integer> data = null;
    try {
      InputStream is = ReadTextFile.class.getResourceAsStream(fileName);
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      String line;
      String s[];
      data = new HashMap<String, Integer>();
      while ((line = reader.readLine()) != null) {
//        System.out.println(line);
        if (line != null && line.length() > 0) {
          if (line.contains("=")) {
            s = line.split("=");
            if (s.length == 2) {
              if (data.containsKey(s[0])) {
                data.put(s[0], data.get(s[0]) + Integer.parseInt(s[1]));
              } else {
                data.put(s[0], Integer.parseInt(s[1]));
              }
            }
          }
        }
      }

    } catch (FileNotFoundException fileNotFoundException) {
      System.out.println("File not found");
      fileNotFoundException.printStackTrace();
    }catch (NullPointerException nullPointer) {
      System.out.println("File not found");
      nullPointer.printStackTrace();
    }catch (IOException ioException) {
      System.out.println("Exception occured while process the file");
      ioException.printStackTrace();
    } catch (NumberFormatException numberFormatException) {
      System.out.println("Data in the file inconsistent");
      numberFormatException.printStackTrace();
    }
//    System.out.println(data);
    return data;
  }
}
