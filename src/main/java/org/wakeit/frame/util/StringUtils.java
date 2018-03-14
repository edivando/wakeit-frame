/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.util;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import org.wakeit.frame.model.PhoneFormatted;




public class StringUtils {

	private static String AUTHORIZATION_HEADER_BASIC = "Basic ";
	
	public static List<String> getEmailPasswordFromAuthorization(String authorization){
		StringTokenizer tokenizer = new StringTokenizer( new String(Base64.getDecoder().decode( authorization.replaceFirst(AUTHORIZATION_HEADER_BASIC, "") ) ), ":");
		
		String email = "";
		String password = "";
		
		if(tokenizer.hasMoreElements()){
			email = tokenizer.nextToken();
		}
		if(tokenizer.hasMoreElements()){
			password = tokenizer.nextToken();
		}
		return Arrays.asList(email, password);
	}
	
	public static String removeCaracteresEspeciais(String value) {    
        value = value.replaceAll("[aáàãâä]","a");  
        value = value.replaceAll("[AÁÀÃÂÄ]","A");  
        value = value.replaceAll("[eéèêë]","e");  
        value = value.replaceAll("[EÉÈÊË]","E");  
        value = value.replaceAll("[iíìîï]","i");  
        value = value.replaceAll("[IÍÌÎÏ]","I");  
        value = value.replaceAll("[oóòõôö]","o");  
        value = value.replaceAll("[OÓÒÕÔÖ]","O");  
        value = value.replaceAll("[uúùûü]","u"); 
        value = value.replaceAll("[UÚÙÛÜ]","U"); 
        value = value.replaceAll("[ç]","c"); 
        value = value.replaceAll("[Ç]","C"); 
        value = value.replaceAll("[#@!$%¨&*()\\;\\:°ºª§,¹²³£¢¬?~]","");
        value = value.replaceAll("\\[","");
        value = value.replaceAll("\\]","");
        value = value.replaceAll("\\{","");
        value = value.replaceAll("\\}","");
        value = value.replaceAll("\\>","");
        value = value.replaceAll("\\<","");
        value = value.replaceAll("/","");
        value = value.replaceAll("|","");
        value = value.replaceAll("\\=","");
        value = value.replaceAll("\\~","");
        value = value.replaceAll("\\^","");
        value = value.replaceAll("\\'","");
        value = value.replaceAll("\\-","");
        value = value.replaceAll("\"","");
        
        return value;  
    }
	

	public static PhoneFormatted formatPhone(String phone){
		phone = phone.replace("(", "").replace(")", "").replace("-", "")
				.replace(".", "").replaceAll(" ", "");
		String ddd = phone.substring(0, 2);
		String phoneNumber = phone.substring(2, phone.length());
		
		return new PhoneFormatted(ddd, phoneNumber);
	}
	
	public static String isCellPhoneNumber(String phone, String ddd){
		phone = phone.replace("(", "").replace(")", "").replace("-", "").replace(".", "").replaceAll(" ", "");
		
		if(phone.length() < 8 || phone.length() > 12){
			return null;
		}
		
		if(phone.charAt(0) == '0'){
			phone = phone.substring(1);
		}
		
		if(phone.length() == 8){ 			// 99776280 	-> [+55][DDD][9][phone]
			if(isCellPhone(phone)){
				return ddd+"9"+phone;
			}
		}else if(phone.length() == 9){		// 999776280 	-> [+55][DDD][phone]
			if(isCellPhone(phone)){
				return ddd+phone;
			}
		}else if(phone.length() == 10){		// 8599776280 	-> 10 dígitos
			if(isCellPhone(phone)){
				return phone.substring(0, 2)+"9"+phone.substring(2, phone.length());   //add 9
			}
		}else if(phone.length() == 11){   	// 85999776280	-> 11 dígitos
			if(isCellPhone(phone)){
				return phone;
			}
		}else if(phone.length() == 12 && isCellPhone(phone)){		// 085999776280	-> 12 dígitos
			return phone.substring(1);
		}
		return null;
	}
	
	private static boolean isCellPhone(String phone){
		int index = phone.length() - 8;
		return phone.charAt(index) == '6' || phone.charAt(index) == '7' || phone.charAt(index) == '8' || phone.charAt(index) == '9';
	}
	
}
