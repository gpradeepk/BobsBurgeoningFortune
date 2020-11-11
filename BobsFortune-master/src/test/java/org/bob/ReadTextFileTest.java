package org.bob;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ReadTextFileTest {

  @Test
  public void testRead_withInvalidFile_shouldReturnNull() throws Exception {
    Map<String, Integer> result = ReadTextFile.read("fileName");
    Assert.assertNull("With invalid file name",result);
  }

  @Test
  public void testRead_withValidFile_shouldReturnMap() throws Exception {
    Map<String, Integer> result = ReadTextFile.read(CommonConstants.FILE_NAME);
    Assert.assertNotNull("With valid file name",result);
    Assert.assertEquals(3,result.size());
  }
}
