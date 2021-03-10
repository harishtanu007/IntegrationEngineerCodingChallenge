package com.mend.projects.demo.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.mend.projects.demo.APIConsumer;

/**
 * The Class APIConsumerTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class APIConsumerTest {
	
	@Spy
    APIConsumer apiConsumer;
	
	String jsonContent;	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	
		jsonContent="{\"contact_information\": {\r\n"
				+ "    \"last_updated\": \"2021-03-04T10:06-05:00\",\r\n"
				+ "    \"member\": [\r\n"
				+ "        {\r\n"
				+ "            \"bioguide_id\": \"B001230\",\r\n"
				+ "            \"website\": \"http://www.baldwin.senate.gov/\",\r\n"
				+ "            \"address\": \"709 Hart Senate Office Building Washington DC 20510\",\r\n"
				+ "            \"phone\": \"(202) 224-5653\",\r\n"
				+ "            \"last_name\": \"Baldwin\",\r\n"
				+ "            \"state\": \"WI\",\r\n"
				+ "            \"member_full\": \"Baldwin (D-WI)\",\r\n"
				+ "            \"first_name\": \"Tammy\",\r\n"
				+ "            \"class\": \"Class I\",\r\n"
				+ "            \"party\": \"D\",\r\n"
				+ "            \"email\": \"https://www.baldwin.senate.gov/feedback\"\r\n"
				+ "            }"
				+ "]"
				+ "}"
				+ "}";

	}

	
	/**
	  This method test whether our JSON content has a given key
	 */
	@Test                                               
	public void testKeyInJSON() throws IOException {
		JSONObject object=new  JSONObject(jsonContent);	
	    Mockito.when(apiConsumer.getJSONContent(ArgumentMatchers.anyString())).thenReturn(object);
		JSONObject output=  apiConsumer.getURLData(); 
		assertTrue(output.has("members"));
	}


}
