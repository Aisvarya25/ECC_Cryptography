/**
 * 
 */
package com.aspose.cloud.storage;

/**
 * @author Mudassir
 *
 */
import com.google.gson.*;
import java.util.Date;

public class GsonDateParser {

	  public static Gson createWcfGson() {
	        GsonBuilder gsonb = new GsonBuilder();
	        gsonb.registerTypeAdapter(Date.class, new JsonDateDeserializer());
	        //gsonb.registerTypeAdapter(Date.class, new WcfCalendarDeserializer());
	     
		 Gson gson = gsonb.create();
	        return gson;
	    }
}
