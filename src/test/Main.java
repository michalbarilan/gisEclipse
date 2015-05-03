package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import routineProcess.Routin;
import SQL_DataBase.SQL_db;

public class Main {

	public static void main(String[] args) {
		SQL_db sqlDataBase = new SQL_db();
		Routin routintOb = new Routin();
//		try {
//			String filePath = new String("C:\\Users\\שלומי אלבז\\לימודים\\ג נוכחי\\eclipseLuna workspace\\gisEclipse\\document.json");
//			
//			// read the json file
//
//			FileReader reader = new FileReader(filePath);
//
//			JSONParser jsonParser = new JSONParser();
//
//			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
//
//			// get a String from the JSON object
//
//			String requestID = (String) jsonObject.get("RequestID");
//
//			System.out.println("RequestID: " + requestID);
//			if (requestID.equals("routineLocation"))
//			{
//				String cmid =  (String) jsonObject.get("ComunityMemberID");
//
//				System.out.println("The cmid is: " + cmid);
//				double x = Double.parseDouble(jsonObject.get("x").toString());
//				System.out.println("The X is: " + x);
//				double y = Double.parseDouble(jsonObject.get("y").toString());
//				System.out.println("The Y is: " + y);
//			}
		try {
			String filePath = new String("C:\\Users\\שלומי אלבז\\לימודים\\ג נוכחי\\eclipseLuna workspace\\gisEclipse\\document.json");
			
			// read the json file

			FileReader reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();

			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			// get a String from the JSON object

			//String requestID = (String) jsonObject.get("RequestID");

			//System.out.println("RequestID: " + requestID);
			JSONArray jsonArrayOb=(JSONArray) jsonObject.get("arrayOb");
			// take each value from the json array separately
			Iterator i = jsonArrayOb.iterator();
			JSONObject innerObj = (JSONObject) i.next();
            //{"RequestID":"routineLocation"}
            if (innerObj.get("RequestID").equals("routineLocation")){
            	//{"comunity_member_id":123456, "x":7.777, "y":8.999}
	            while (i.hasNext()) {
	                innerObj = (JSONObject) i.next();
                	System.out.println("comunity_member_id "+ innerObj.get("comunity_member_id") +
                            " with x cor. " + innerObj.get("x")+
                            " and y cor. " + innerObj.get("y"));
	            }
            }

		} catch (FileNotFoundException ex) {

			ex.printStackTrace();

		} catch (IOException ex) {

			ex.printStackTrace();

		} catch (ParseException ex) {

			ex.printStackTrace();

		} catch (NullPointerException ex) {

			ex.printStackTrace();

		}

	}

}
