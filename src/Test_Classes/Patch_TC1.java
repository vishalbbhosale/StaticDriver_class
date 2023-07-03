package Test_Classes;
import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_Api_Method.Common_Utility_Method;
import Common_Api_Method.Patch_Api_Method;
import Req_Repository.Patch_Req_Repository;
import io.restassured.path.json.JsonPath;
public class Patch_TC1 {
	

	public static void extractor() throws IOException {
		for(int i=0;i<5;i++) {
		int statuscode= Patch_Api_Method.responsestatuscode(Patch_Req_Repository.baseURI(),Patch_Req_Repository.Patch_Resourse(),Patch_Req_Repository.Patch_TC1());
		System.out.println(statuscode);
		
		if(statuscode==200) {
			
			String Responsebody=Patch_Api_Method.Responsebody(Patch_Req_Repository.baseURI(),Patch_Req_Repository.Patch_Resourse(),Patch_Req_Repository.Patch_TC1());
			System.out.println(Responsebody);
			
			String Requestbody=Patch_Req_Repository.Patch_TC1();
			
			Common_Utility_Method.Evidancecreator("Patch_TC1", Requestbody, Responsebody, statuscode);
			
			validator(Requestbody,Responsebody);
			break;}
		else {
			System.out.println("status code is invalid");
			
		}
	}
}
	public static void validator(String Requestbody,String Responsebody) {
		
		
		//parse requestbody
		JsonPath jspReq=new JsonPath(Requestbody);
		String Req_name=jspReq.getString("name");
		String Req_job=jspReq.getString("job");
		LocalDateTime currentdate=LocalDateTime.now();
		String expecteddate=currentdate.toString().substring(0,11);
		
		//parse responsebody
		JsonPath jspRes = new JsonPath(Responsebody);
		String Res_name=jspRes.getString("name");
		String Res_job=jspRes.getString("job");
		String Res_updatedAt=jspRes.getString("updatedAt");
		Res_updatedAt=Res_updatedAt.substring(0,11);
		
		//validate responsebody Parameter
		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_job, Req_job);
		Assert.assertEquals(Res_updatedAt, expecteddate);
		
	}
}