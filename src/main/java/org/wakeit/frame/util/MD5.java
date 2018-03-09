/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author Edivando Alves
 * @date  10/02/2016
 * 
 */
public final class MD5 {
	  
	private MD5(){
		throw new AssertionError();
	}
	
	private static final String hexDigits = "0123456789abcdef";
	
	private static byte[] digest(byte[] input, String algoritmo)throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(algoritmo);
	    md.reset();
	    return md.digest(input);
	}
	
	private static String byteArrayToHexString(byte[] b) {
	    StringBuilder buf = new StringBuilder();	    
	    for (int i = 0; i < b.length; i++) {
	    	int j = (b[i]) & 0xFF; 
	    	buf.append(hexDigits.charAt(j / 16)); 
	    	buf.append(hexDigits.charAt(j % 16)); 
	    }	    
	    return buf.toString();
	}
	
	public static String md5(String value){
		try{
			byte[] en = MD5.digest(value.getBytes(),"MD5");
			return MD5.byteArrayToHexString(en);
		}catch (Exception e) {
			return null;
		}	
	}
}

