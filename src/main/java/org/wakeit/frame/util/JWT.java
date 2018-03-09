/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.util;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * 
 * 
 * @author edivandoalves
 * @date Aug 14, 2017
 *
 */
public class JWT {
	
	private static final String secret = "Akadasjkda23aspf2350qldnqi4qwe4dqna*asd%assSda&23NsDsds054ksdASAWujasndsd234ksdr";
	private static final Long expiration = 259200000l;
	
	public static JwtBuilder create(String id) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Date now = DateUtils.localDate() ;
		System.out.println(now);
		 
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		 
		return Jwts.builder()
				.setId(id)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + expiration))
				.signWith(signatureAlgorithm, signingKey);
	}
	
	public static Claims parse(String jwt) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException{
		return Jwts.parser()         
		   .setSigningKey(DatatypeConverter.parseBase64Binary(secret))
		   .parseClaimsJws(jwt).getBody();
	}

}
