/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@rocketti.com.br ( http://www.rocketti.com.br )
 * 
 * @copyright  	Copyright 2017 RocketTi Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.util;

import java.util.Random;

public class IntegerUtils {

	public static int randomInt(int min, int max){
		return new Random().nextInt(max - min + 1) + min;
	}

}
