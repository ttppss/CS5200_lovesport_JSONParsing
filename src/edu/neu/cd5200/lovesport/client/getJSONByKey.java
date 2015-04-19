//This class is used to get the information of SEASON and LEAGUE of NBA




package edu.neu.cd5200.lovesport.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;


//DO NOT MIX JSONOBJECT with simple.JSONOBJECT!!!!!!
import org.json.JSONException;
//import org.json.*;
//import org.json.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class getJSONByKey {

	// public final String FIND_LEAGUE_BY_ID =
	// "http(s)://api.sportsdatallc.org/nba-t3/zh/league/hierarchy.json?api_key=smucb9h4a4bwey25cj9cwnd9";

	// public League findLeagueById(String leagueId)
	// {
	//
	// }
	final String FIND_SERIES_BY_SEASON = "http://api.sportsdatallc.org/nba-t3/zh/series/SEASON/NBA_SN/schedule.json?api_key=smucb9h4a4bwey25cj9cwnd9";
	final static String FIND_SCHEDULE_BY_SEASON = "http://api.sportsdatallc.org/nba-t3/zh/games/SEASON/NBA_SN/schedule.json?api_key=smucb9h4a4bwey25cj9cwnd9";

	public static String findScheduleBySeason(String season, String nbaseason) {
		String urlStr0 = FIND_SCHEDULE_BY_SEASON.replace("SEASON", season);
		String urlStr1 = urlStr0.replace("NBA_SN", nbaseason);
		NBAData nba = new NBAData();
		NBAClient client = new NBAClient();
		ObjectMapper mapper = new ObjectMapper();
		String json = client.getJsonStringForNBAUrl(urlStr1);
		return json;
	}

	// String is very difficult to manipulate, so we create an object so we can
	// handle it more easily.
	public String getJsonStringForNBAUrl(String urlStr1) {
		try {
			// create a url object to represent the string.
			URL url = new URL(urlStr1);
			// open a connection to the URL and convert it to a HTTP protocal
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			// We need to say what we want to do with this URL
			connection.setRequestMethod("GET");
			// give me back what I want, open a stream and steam back the data
			InputStream in = connection.getInputStream();
			// buffer the information
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isr);
			String out;
			StringBuffer json = new StringBuffer();
			while ((out = reader.readLine()) != null) {
				json.append(out);
			}
			// System.out.println(json);
			return json.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getInformationOfLeague(String parameter1, String parameter2) {

		// final String filePath =
		// "/Users/zinanxiong/Desktop/JsonParseTest.json";
		try {

			// FileReader reader = new FileReader(filePath);
			String json = findScheduleBySeason("2014", "reg");
			JSONParser jsonParser = new JSONParser();

			org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) jsonParser
					.parse(json);
			org.json.simple.JSONObject league0 = new org.json.simple.JSONObject(
					jsonObject);
			org.json.simple.JSONObject lea = (JSONObject) ((org.json.simple.JSONObject) league0)
					.get(parameter1);
			// System.out.println(lea);
			// org.json.simple.JSONArray league = lea.getJSONObject();
			return (String) lea.get(parameter2);


		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

public static String getInformationOfGames(String year, String season){
	try {
		 
		String json = findScheduleBySeason(year, season);
		JSONParser jsonParser = new JSONParser();
 
		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
 
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
		

 
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return null;
}
	
	
	public static void main(String[] args)
	{
	    System.out.println(getInformationOfLeague("season", "type"));
	    getInformationOfGames("2014", "reg");
	}
}