package kr.or.connect.payment.main;

import java.io.DataOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.net.MalformedURLException;  
import java.net.URL;  
import java.net.URLConnection;  
import java.net.URLEncoder;  
import java.util.Scanner;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kr.or.connect.payment.fun.Tokenfun;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
  

public class restapi {
	
	public static void main(String[] args) {
		Tokenfun token = new Tokenfun();
		
		String a = token.token();
		System.out.println(a);
		/*String ttt = "";
		try {  
            String param = "{ \"imp_key\" : \"6489248355826102\", \"imp_secret\" : \"aqfcTwHAWyx9ZmxvRpNsBTJOEVyx5lTgL9sFFagBJNKI9ie1I1tkUc8z8H6d2ZuO8WtO7JpQxazHtNIb\"}";
    		
            URL url = new URL("https://api.iamport.kr/users/getToken");  
            URLConnection conn = url.openConnection();  
              
            conn.setDoOutput(true);  
            conn.setUseCaches(false); 
            conn.setRequestProperty("Content-Type", "application/json");  
              
            DataOutputStream out = null;  
              
            try {  
                out = new DataOutputStream(conn.getOutputStream());  
                out.writeBytes(param);  
                out.flush();  
            } finally {  
                if (out != null) out.close();  
            }  
              
            InputStream is = conn.getInputStream();  
            Scanner scan = new Scanner(is);  
              
           
                String str = scan.nextLine();  
                ttt += str;
               
              
            
        } catch (MalformedURLException e) {  
            System.out.println("The URL address is incorrect.");  
            e.printStackTrace();  
        } catch (IOException e) {  
            System.out.println("It can't connect to the web page.");  
            e.printStackTrace();  
        }  
		
		
	
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(ttt);
            JSONObject jsonObj2 = (JSONObject) jsonObj.get("response");
            String m =(String) jsonObj2.get("access_token");
            System.out.println(m);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		
		
		
		
		
		
		*/
		
	
	
       
	    }  
	    }  
        


	


