package com.mend.projects.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.mend.projects.demo.models.Address;
import com.mend.projects.demo.models.Member;
import com.mend.projects.demo.models.Response;
import com.mend.projects.demo.utils.Utilities;

// TODO: Auto-generated Javadoc
/**
 * APIConsumer class to make REST API request and convert XML to custom JSON format.
 */
public class APIConsumer {

	/** The rest url. */
	private static String REST_URL;
	
	/** The logger. */
	private static Logger logger=Logger.getLogger(APIConsumer.class.getName());

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		new APIConsumer().getURLData();
	}

	/**
	 * This method makes a HTTP get request to get the XML data.
	 *
	 * @return the URL data
	 */
	public JSONObject getURLData() {
		try {
			/* Uses PropertyReader utility method to get url value from property value */
			REST_URL=Utilities.readProperties("url");
			URL url=new URL(REST_URL);
			logger.info("In getURLData method");
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			int responseCode=connection.getResponseCode();
			
			/*checks for success response code */
			if(responseCode==HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(connection.getInputStream()));
				String output;
				StringBuffer content = new StringBuffer();
				/*reads response from the rest api */
				while ((output = reader.readLine()) != null) {
					content.append(output);

					
				}
				//logger.info("Printing content "+content);
				reader.close();
				JSONObject jsonContent = getJSONContent(content.toString());
				return XMLConverter(jsonContent);
			}

		} catch (MalformedURLException malformedException) {
			logger.log(Level.SEVERE, "MalformedURLException was thrown", malformedException);
		} catch (IOException ioException) {
			logger.log(Level.SEVERE, "IOException was thrown", ioException);

		}
		return null;

	}

	/**
	 * This method converts XML to JSON format
	 *
	 * @param String content
	 * @return JSONObject
	 */
	public  JSONObject getJSONContent(String content) {
		return XML.toJSONObject(content);
	}


	/**
	 * This class modifies the json content to our required JSON format.
	 *
	 * @param JSONObject jsonContent 
	 * @return JSONObject
	 */
	public static JSONObject XMLConverter(JSONObject jsonContent) {
		logger.info("In XMLConverter method");
		//logger.info("Printing converted json "+jsonContent.toString(4));
		Response response=new Response();
		ArrayList<Member> tempMemberList=new ArrayList<Member>();
		JSONArray arr = jsonContent.getJSONObject("contact_information").getJSONArray("member");

		for (int i = 0; i < arr.length(); i++) {
			Member member=new Member();
			String firstName=Utilities.getJSONValue(arr.getJSONObject(i),"first_name");
			String lastName=Utilities.getJSONValue(arr.getJSONObject(i),"last_name");
			member.setFirstName(firstName);
			member.setLastName(lastName);
			member.setLastName(Utilities.getJSONValue(arr.getJSONObject(i),"last_name"));
			member.setFullName(firstName+" "+lastName);
			member.setChartId(Utilities.getJSONValue(arr.getJSONObject(i),"bioguide_id"));
			member.setMobile(Utilities.getJSONValue(arr.getJSONObject(i),"phone"));


			Address address=new Address();
			String tempAddress = arr.getJSONObject(i).getString("address");	
			String[] result = tempAddress.split(" ");
			address.setStreet(result[0]);
			address.setPostal(result[result.length-1]);
			address.setState(Utilities.getState(result));
			member.setAddress(address);

			tempMemberList.add(member);
			
		}
		response.setMembers(tempMemberList);
		String outputData = new JSONObject(response).toString(4);
	    System.out.println(outputData);  
		return new JSONObject(outputData);
	}




}
