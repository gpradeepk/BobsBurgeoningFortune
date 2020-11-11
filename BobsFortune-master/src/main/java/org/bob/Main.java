package org.bob;

import static org.bob.CommonConstants.CURRENCY_TYPE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String a[]){
    System.out.println("******************************The dashboard is******************************");
    Map<String, Integer>  data = ReadTextFile.read(CommonConstants.FILE_NAME);
    String externalServiceOutput;
    List<String> finalDashBoard = new ArrayList<>();
    for(Map.Entry<String, Integer> d:data.entrySet()){
      externalServiceOutput = ExternalServiceCall.callService(d.getKey(), CURRENCY_TYPE);
      Double price = JsonConverter.parseJson(externalServiceOutput, CURRENCY_TYPE);
      finalDashBoard.add(String.format("Current value of %s of %s quantity value is %s",d.getKey(),d.getValue(),price*d.getValue()));
    }
    for(String s: finalDashBoard){
      System.out.println(s);
    }
  }
}
