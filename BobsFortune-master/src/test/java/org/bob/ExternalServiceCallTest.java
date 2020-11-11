package org.bob;

import org.junit.Assert;
import org.junit.Test;

public class ExternalServiceCallTest {

  @Test
  public void testCallService() throws Exception {
    String result = ExternalServiceCall.callService("BTC", CommonConstants.CURRENCY_TYPE);
    Assert.assertNotNull("current value of BTC", result);
  }
}
