package edu.neu.cd5200.lovesport.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class NBAData {
	
	private String league;
	private String season;
	
	
}
