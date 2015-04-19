package edu.neu.cd5200.lovesport.client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ArrayParse {
     public static void main(String[] args) {
 
	
 
	final String filePath = "/Users/zinanxiong/Desktop/JsonParseTest.json";
	try {
 
		FileReader reader = new FileReader(filePath);
		JSONParser jsonParser = new JSONParser();
 
		JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
 
//		String name = (String) jsonObject.get("name");
//		System.out.println(name);
// 
//		long age = (Long) jsonObject.get("age");
//		System.out.println(age);
 
		// loop array
		JSONArray games = (JSONArray) jsonObject.get("games");
		//System.out.println(games);
		//JSONObject league = (JSONObject) jsonObject.get(1);
		//JSONObject msg = jsonObject.getJSONObject("season");
//		for(int i = 0; i < games.size(); i++)
//		{
//			System.out.println("The" + i + "element of the array: " + games.get(i));
//		}
		
		
		//Iterate games ARRAY and print out the values in the ARRAY, so this is for ARRAYPARSE
		Iterator i = games.iterator();
		
		while(i.hasNext())
		{
			JSONObject innerObj = (JSONObject) i.next();
			System.out.println(
							   "status: " + innerObj.get("status") + 
							   
							   "; scheduled: " + innerObj.get("scheduled") + 
							   "; venue: " + innerObj.get("venue") + 
							   
							   "; home: " + innerObj.get("home") + 
							   "; away: " + innerObj.get("away"));
		}
		
//		Iterator<String> iterator = games.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
 
     }
 
}