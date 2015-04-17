package edu.neu.cd5200.lovesport.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class NBAClient {

	public final String FIND_SERIES_BY_SEASON = "http://api.sportsdatallc.org/nba-t3/zh/series/SEASON/NBA_SN/schedule.json?api_key=smucb9h4a4bwey25cj9cwnd9";
	public final String FIND_SCHEDULE_BY_SEASON = "http://api.sportsdatallc.org/nba-t3/zh/games/SEASON/NBA_SN/schedule.json?api_key=smucb9h4a4bwey25cj9cwnd9";	
	//public final String FIND_LEAGUE_BY_ID = "http(s)://api.sportsdatallc.org/nba-t3/zh/league/hierarchy.json?api_key=smucb9h4a4bwey25cj9cwnd9";
	

//		public League findLeagueById(String leagueId)
//		{
//			
//		}

	
	public NBAData findScheduleBySeason(String season, String nbaseason){
		String urlStr0 = FIND_SCHEDULE_BY_SEASON.replace("SEASON", season);
		String urlStr1 = urlStr0.replace("NBA_SN", nbaseason);
		NBAData nba = new NBAData();
		NBAClient client = new NBAClient();
		ObjectMapper mapper = new ObjectMapper();
		String json = client.getJsonStringForNBAUrl(urlStr1);
		//System.out.println(getJsonStringForNBAUrl(urlStr1));
		try {
			nba = mapper.readValue(json, NBAData.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nba;
	}

	
	//String is very difficult to manipulate, so we create an object so we can handle it more easily.
	private String getJsonStringForNBAUrl(String urlStr1) {
		try {
			//create a url object to represent the string.
			URL url = new URL(urlStr1);
			//open a connection to the URL and convert it to a HTTP protocal
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//We need to say what we want to do with this URL
			connection.setRequestMethod("GET");
			//give me back what I want, open a stream and steam back the data
			InputStream in = connection.getInputStream();
			//buffer the information 
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(isr);
			String out;
			StringBuffer json = new StringBuffer();
			while((out = reader.readLine()) != null)
			{
				json.append(out);
			}
			//System.out.println(json);
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
	
	
	
	
	
	public static void main(String[] args) {
		NBAClient client = new NBAClient();
		//client.findScheduleBySeason("2014", "reg");
		//System.out.println(client.findSeriesBySeason("2014", "reg"));
		//System.out.println(nba.getGames());
		NBAData str = client.findScheduleBySeason("2014", "reg");
		//System.out.println(client.getJsonStringForNBAUrl(str));
		String filePath = "/Users/zinanxiong/Desktop/JsonParseTest.json";
		try {
			// read the json file
			
			JSONParser jsonParser = new JSONParser();
			Object reader = jsonParser.parse(filePath);

			JSONObject jsonObject = (JSONObject) reader;
			//System.out.println(reader);
			// get a String from the JSON object
//			String firstName = (String) jsonObject.get("league");
//			System.out.println("The league is: " + firstName);
//
//			// get a number from the JSON object
//			Long id =  (Long) jsonObject.get("id");
//			System.out.println("The id is: " + id);

			// get an array from the JSON object
			JSONArray leag= (JSONArray) jsonObject.get("games");
			
			// take the elements of the json array
//			for(int i=0; i<leag.size(); i++){
//				System.out.println("The " + i + " element of the array: "+leag.get(i));
//			}
			Iterator<String> i = leag.iterator();

			// take each value from the json array separately
			while (i.hasNext()) {
				//JSONObject innerObj = (JSONObject) i.next();
				System.out.println(i.next());
			}
			// handle a structure into the json object
//			JSONObject structure = (JSONObject) jsonObject.get("season");
//			System.out.println("The year of the season is: " + structure.get("year"));

		} /*catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} */catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		
	}

}
































