/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
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
