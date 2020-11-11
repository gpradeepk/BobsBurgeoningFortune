package org.bob;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExternalServiceCall {
  public static String callService(String cryptoType, String currencyType) {
    String result = null;
    try {
      String u =
          String.format("https://min-api.cryptocompare.com/data/price?fsym=%s&tsyms=%s", cryptoType, currencyType);

      URL url = new URL(u);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");
      if (conn.getResponseCode() != 200) {
        throw new RuntimeException("Failed : HTTP Error code : "
            + conn.getResponseCode());
      }
      InputStreamReader in = new InputStreamReader(conn.getInputStream());
      BufferedReader br = new BufferedReader(in);
      result = br.readLine();

      conn.disconnect();
      return result;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return result;
  }
}
