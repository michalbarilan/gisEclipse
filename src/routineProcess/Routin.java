package routineProcess;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



 




public class Routin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Routin() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

//			if (requestID.equals("routineLocation"))
//			{
//				Iterator i = jsonArrayOb.iterator();
//
//				// take each value from the json array separately
//
//				while (i.hasNext())
//				{
//					JSONObject innerObj = (JSONObject) i.next();
//					String cmid =  (String) innerObj.get("comunity_member_id");
//					System.out.println("The cmid is: " + cmid);
//					double x = Double.parseDouble(innerObj.get("x").toString());
//					System.out.println("The X is: " + x);
//					double y = Double.parseDouble(innerObj.get("y").toString());
//					System.out.println("The Y is: " + y);
//	
//				}
//			}
			// get a number from the JSON object

		



			// get an array from the JSON object

			//JSONArray lang= (JSONArray) jsonObject.get("languages");



			// take the elements of the json array

			//for(int i=0; i<lang.size(); i++){

				//System.out.println("The " + i + " element of the array: "+lang.get(i));

			//}

			//Iterator i = lang.iterator();



			// take each value from the json array separately

		//	while (i.hasNext()) {

	//			JSONObject innerObj = (JSONObject) i.next();
//
	//			System.out.println("language "+ innerObj.get("lang") +
//
	//					" with level " + innerObj.get("knowledge"));
//
//			}

			// handle a structure into the json object

//			JSONObject structure = (JSONObject) jsonObject.get("job");

//			System.out.println("Into job structure, name: " + structure.get("name"));


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



