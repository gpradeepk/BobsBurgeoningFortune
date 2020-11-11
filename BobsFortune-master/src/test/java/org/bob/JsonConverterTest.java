package org.bob;

import org.junit.Assert;
import org.junit.Test;


public class JsonConverterTest {

  @Test
  public void testParseJson() throws Exception {
    Double result = JsonConverter.parseJson("{'EUR': 123.0}", "EUR");
    Assert.assertEquals(Double.valueOf(123.0), result);
  }
}