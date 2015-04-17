package edu.neu.cd5200.lovesport.client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;

//DO NOT MIX JSONOBJECT with simple.JSONOBJECT!!!!!!
import org.json.JSONException;
//import org.json.*;
//import org.json.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ObjectParse {
     public static void main(String[] args) {
 
	
 
	final String filePath = "/Users/zinanxiong/Desktop/JsonParseTest.json";
	try {

		FileReader reader = new FileReader(filePath);
		JSONParser jsonParser = new JSONParser();
 
		org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) jsonParser.parse(reader);
		org.json.simple.JSONObject league = new org.json.simple.JSONObject(jsonObject);
		Object lea = ((org.json.simple.JSONObject) league).get("league");
		System.out.println(lea);
		
		org.json.simple.JSONObject season = new org.json.simple.JSONObject(jsonObject);
		Object sea = ((org.json.simple.JSONObject) league).get("season");
		System.out.println(sea);
		//System.out.println(league);
		
		
		//Object Parse:
		
//		JSONObject season = jsonObject.getJSONObject("season");
//		JSONArray season = (JSONObject)Array.get(1);
		//Iterator i = season.iterator();
//		while(i.hasNext())
//			{
//				JSONObject innerObj = (JSONObject) i.next();
//				System.out.println(
//								   "id: " + innerObj.get("id") + 
//								   
//								   "; year: " + innerObj.get("year") + 
//								   "; type: " + innerObj.get("type"));
//			}
//		
		
		
		
		
		
		
		
		
		
 
//		String name = (String) jsonObject.get("name");
//		System.out.println(name);
// 
//		long age = (Long) jsonObject.get("age");
//		System.out.println(age);
 
		// loop array
		//JSONArray games = (JSONArray) jsonObject.get("games");
		//System.out.println(games);
		//JSONObject league = (JSONObject) jsonObject.get(1);
		//JSONObject msg = jsonObject.getJSONObject("season");
//		for(int i = 0; i < games.size(); i++)
//		{
//			System.out.println("The" + i + "element of the array: " + games.get(i));
//		}
		
		//
//		Iterator i = games.iterator();
//		
//		while(i.hasNext())
//		{
//			JSONObject innerObj = (JSONObject) i.next();
//			System.out.println(
//							   "status: " + innerObj.get("status") + 
//							   
//							   "; scheduled: " + innerObj.get("scheduled") + 
//							   "; venue: " + innerObj.get("venue") + 
//							   
//							   "; home: " + innerObj.get("home") + 
//							   "; away: " + innerObj.get("away"));
//		}
		
		
		
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