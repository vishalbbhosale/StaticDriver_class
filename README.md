# StaticDriver_class

This project created to execute all API's by using RestAssured,TestNG,Apachepoi and JSsonPath


Features of static driverclass project:-
 1.Project is capebale to automate execution and validation; In Rest diffrent method are use like Post,Put,Patch,Get,Delete

 2.This project is done under this project we are use diffrent packages 
 *Req_Repository=in this package we are write the baseURI,Resourse,Requestbody
 *CommonApi method= in this package we are use Given,When,Then method 
 *Common Utility method= By using this class we are save the evidanvce of the execution into text file which contains Requestbody,Responsebody,Statuscode 
                         and also done the data driven we are passing the data from excel file  
 *Test class = this are same as postman Test Api. In this Package we arr dobe the parse requestbody,Parse Responsebody and also validate the Response body parameter
 *Driverclass= This are same as Postman Collection Runner .this are the main method by using this package we are give the result.
