/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.util;

import java.util.Random;

public class IntegerUtils {

	public static int randomInt(int min, int max){
		return new Random().nextInt(max - min + 1) + min;
	}

}
