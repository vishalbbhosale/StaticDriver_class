package Req_Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_Api_Method.Common_Utility_Method;

public class Put_Req_Repository {
	
	public static String baseURI() {
		String baseURI="https://reqres.in/";
		return baseURI;
		
	}
	
	public static String Put_Resourse() {
		String Put_Resourse="api/users/2";
        return Put_Resourse;
	}
	
	public static String Put_TC1() throws IOException {
		ArrayList<String> Req_Data=Common_Utility_Method.ReadDataExcel("PutApi", "TC2");
		System.out.println(Req_Data);
		String Req_name=Req_Data.get(0);
		String Req_job=Req_Data.get(1);
		
		String Requestbody="{\r\n"
				+ "    \"name\": \""+Req_name+"\",\r\n"
				+ "    \"job\": \""+Req_job+"\"\r\n"
				+ "}";
		return Requestbody;
	}

}
