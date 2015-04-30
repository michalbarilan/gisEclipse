package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import routineProcess.Routin;
import SQL_DataBase.SQL_db;

public class Main {

	public static void main(String[] args) {
		SQL_db sqlDataBase = new SQL_db();
		Routin routintOb = new Routin();
		try {
			String filePath = new String("C:\\Users\\שלומי אלבז\\לימודים\\ג נוכחי\\eclipseLuna workspace\\gisEclipse\\document.json");
			
			// read the json file

			FileReader reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();

			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			// get a String from the JSON object

			String requestID = (String) jsonObject.get("RequestID");

			System.out.println("RequestID: " + requestID);
			if (requestID.equals("routineLocation"))
			{
				String cmid =  (String) jsonObject.get("ComunityMemberID");

				System.out.println("The cmid is: " + cmid);
				double x = Double.parseDouble(jsonObject.get("x").toString());
				System.out.println("The X is: " + x);
				double y = Double.parseDouble(jsonObject.get("y").toString());
				System.out.println("The Y is: " + y);
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
