package com.mend.projects.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

import com.mend.projects.demo.APIConsumer;
import com.mend.projects.demo.models.Address;



/**
 * This class contains utility methods
 */
public class Utilities {

	private static Logger logger=Logger.getLogger(Utilities.class.getName());

	/**
	 * This method reads URL from properties file based on the key passed.
	 *
	 * @param key 
	 * @return string
	 */
	public static String readProperties(String key) {
		logger.info("In readProperties method");
		Properties properties = null ;
		try (InputStream input = APIConsumer.class.getClassLoader().getResourceAsStream("config.properties")) {
			properties = new Properties();
			properties.load(input);
			if(properties.containsKey(key)) {
				return properties.getProperty(key);
			}
		} catch (IOException ioException) {
			logger.log(Level.SEVERE, "IOException was thrown", ioException);
		}
		return null;
	}

	/**
	 * This method extracts the JSON value for a given key
	 *
	 * @param JSONObject object
	 * @param String key
	 * @return the JSON value 
	 */
	public static String getJSONValue(JSONObject object,String key) {
		//	logger.info("In getJSONValue method");
		if(object!=null) {
			String value = object.getString(key);
			if(value!=null) {
				return value;
			}
		}
		return null;
	}

	/**
	 * 
	 * This method extracts street and city value from the given address string
	 * @param address tokens in the form of an array
	 * @param Address address 
	 * @return Address address
	 */
	public static Address parseAddress(Address address,String[] addressTokens) {
		String[] states = {"Alaska", "Alabama", "Arkansas", "American Samoa", "Arizona", "California", "Colorado", "Connecticut", "District of Columbia", "Delaware", "Florida", "Georgia", "Guam", "Hawaii", "Iowa", "Idaho", "Illinois", "Indiana", "Kansas", "Kentucky", "Louisiana", "Massachusetts", "Maryland", "Maine", "Michigan", "Minnesota", "Missouri", "Mississippi", "Montana", "North Carolina", "North Dakota", "Nebraska", "New Hampshire", "New Jersey", "New Mexico", "Nevada", "New York", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Virginia", "Virgin Islands", "Vermont", "Washington DC", "Wisconsin", "West Virginia", "Wyoming"};
		List<String> listStates=Arrays.asList(states);
		String street="";

		for (int j =0; j < addressTokens.length-1; j++) {
			String token=addressTokens[j].toUpperCase().trim();
			if(token.length()>0) {
				Optional<String> temp = listStates.stream().
						filter(value -> value.toUpperCase().
								contains(token.trim())).findFirst();
				if(!temp.isEmpty()) {
					address.setCity(temp.get());
				}
				else {
					street=street+" "+token;
				}
			}
		}
		address.setStreet(street.trim());
		return address;
	}


}
