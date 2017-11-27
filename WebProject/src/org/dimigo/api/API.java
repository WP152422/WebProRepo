package org.dimigo.api;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.HashMap;

import java.util.Map;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.JSONArray;




public class API {
	
	private static final Map<String, String> teamId = new HashMap<String, String>();
	static
	{
		teamId.put("Utah Jazz","583ece50-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Portland Trail Blazers","583ed056-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Los Angeles Lakers","583ecae2-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Los Angeles Clippers","583ecdfb-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Sacramento Kings","583ed0ac-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Houston Rockets","583ecb3a-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Miami Heat","583ecea6-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Toronto Raptors","583ecda6-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Boston Celtics","583eccfa-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Brooklyn Nets","583ec9d6-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Orlando Magic","583ed157-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Washington Wizards","583ec8d4-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Oklahoma City Thunder","583ecfff-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Memphis Grizzlies","583eca88-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Cleveland Cavaliers","583ec773-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("New York Knicks","583ec70e-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("New Orleans Pelicans","583ecc9a-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("San Antonio Spurs","583ecd4f-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Chicago Bulls","583ec5fd-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Detroit Pistons","583ec928-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Philadelphia 76ers","583ec87d-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Milwaukee Bucks","583ecefd-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Minnesota Timberwolves","583eca2f-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Denver Nuggets","583ed102-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Golden State Warriors","583ec825-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Phoenix Suns","583ecfa8-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Dallas Mavericks","583ecf50-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Atlanta Hawks","583ecb8f-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Indiana Pacers","583ec7cd-fb46-11e1-82cb-f4ce4684ea4c");
		teamId.put("Charlotte Hornets","583ec97e-fb46-11e1-82cb-f4ce4684ea4c");

	}
	
	public static void main(String[] args) throws Exception {
		API api = new API();
		api.getJsonTeamProfile("Boston Celtics");
	}
	
    private static String getJsonSchedule() {
        
        try {
            String apiURL = "https://api.sportradar.us/nba/trial/v4/en/games/2017/REG/schedule.json?api_key=sdakmxjufheq82thgcc4wxft"; // json 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response);
            return response.toString();
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e);
        }
		return null;
    }
    
    public static String parseSchedule(String teamName) throws Exception {
    	try {
    		
    		System.out.println("aaa" + teamName);
    		String jsonResult = getJsonSchedule();
    		
			JSONParser parser = new JSONParser();
			Object obj = parser.parse( jsonResult );
			JSONObject jsonObject = (JSONObject) obj;
			
			
			JSONArray games = (JSONArray) (jsonObject.get("games"));
			
			
			JSONArray result = new JSONArray();
			
			for(int i=0; i<games.size(); i++)
			{
				JSONObject info = (JSONObject) games.get(i);
				String date = (String) info.get("scheduled");
				String home = (String) ((JSONObject) info.get("home")).get("name");
				String away = (String) ((JSONObject) info.get("away")).get("name");
				
				
				if(home.equals(teamName))
				{
					JSONObject calInfo = new JSONObject();
					calInfo.put("title", "vs " + away);
					calInfo.put("start", date.substring(0, 10));
					result.add(calInfo);
				}
				else if(away.equals(teamName))
				{
					JSONObject calInfo = new JSONObject();
					calInfo.put("title", "vs " + home);
					calInfo.put("start", date.substring(0, 10));
					result.add(calInfo);
				}
			}
			System.out.println(result);
			return result.toString();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
    }
    
    private static String getJsonTeamProfile(String teamName)
    {
    	try {
            String apiURL = "https://api.sportradar.us/nba/trial/v4/en/teams/" + teamId.get(teamName) +  "/profile.json?api_key=sdakmxjufheq82thgcc4wxft"; // json 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response);
            return response.toString();
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println(e);
        }
		return null;
    }
    
    public static Map<String, String> parseRosters(String teamName) throws Exception
    {
    	try {
    		
    		Map<String, String> result = new HashMap<>();
    		
    		System.out.println("rosters : " + teamName);
    		String jsonResult = getJsonTeamProfile(teamName);
    		
			JSONParser parser = new JSONParser();
			Object obj = parser.parse( jsonResult );
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray coaches = (JSONArray) (jsonObject.get("coaches"));
			StringBuffer coachNames = new StringBuffer();
			coachNames.append((String)((JSONObject)coaches.get(0)).get("full_name"));
			for(int i=1; i<coaches.size(); i++)
			{
				coachNames.append(", ");
				coachNames.append((String)((JSONObject)coaches.get(i)).get("full_name"));
			}
			result.put("coaches", coachNames.toString());
			
			JSONArray players = (JSONArray)(jsonObject.get("players"));
			StringBuffer PG = new StringBuffer();
			StringBuffer SG = new StringBuffer();
			StringBuffer SF = new StringBuffer();
			StringBuffer PF = new StringBuffer();
			StringBuffer C = new StringBuffer();
			for(int i=0; i<players.size(); i++)
			{
				JSONObject player = (JSONObject) players.get(i);
				switch((String)player.get("primary_position"))
				{
					case "PG":
						PG.append((String)player.get("full_name") + ", ");
						break;
					case "SG":
						SG.append((String)player.get("full_name") + ", ");
						break;
					case "PF":
						PF.append((String)player.get("full_name") + ", ");
						break;
					case "SF":
						SF.append((String)player.get("full_name") + ", ");
						break;
					case "C":
						C.append((String)player.get("full_name") + ", ");
						break;
					default:
						throw new Exception((String)player.get("primary_position") + "은 없는 포지션입니다.");
				}
			}
			result.put("PG", PG.toString());
			result.put("SG", SG.toString());
			result.put("PF", PF.toString());
			result.put("SF", SF.toString());
			result.put("C", C.toString());
			
			
			System.out.println(result);
			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
    }

}