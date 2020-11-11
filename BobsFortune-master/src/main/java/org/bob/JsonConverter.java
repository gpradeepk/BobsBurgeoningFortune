package org.bob;

import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JsonConverter {
  ScriptEngine engine;

  public static Double parseJson(String inputJsonString, String currencyType) {
    JsonConverter j = new JsonConverter();
    return j.read(inputJsonString, currencyType);
  }

  public Double read(String inputJsonString, String currencyType) {
    Double resultData = 0D;
    try {

      ScriptEngineManager sem = new ScriptEngineManager();
      this.engine = sem.getEngineByName("javascript");


      String script = "Java.asJSONCompatible(" + inputJsonString + ")";
      Object result = this.engine.eval(script);
      Map<String, Double> contents = (Map) result;
      resultData = contents.get(currencyType);
      contents.forEach((t, u) -> {
//        System.out.println(t.toString());
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
    return resultData;
  }
}
