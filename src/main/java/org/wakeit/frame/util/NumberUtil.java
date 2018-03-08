/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@rocketti.com.br ( http://www.rocketti.com.br )
 * 
 * @copyright  	Copyright 2017 RocketTi Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.util;

public class NumberUtil {
	
	public static Integer convertRealCentavos(Double number) {
		try {
			return (int) (number * 100);
		} catch (Exception e) {
			return 0;
		}
	}

}
