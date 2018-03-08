/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@rocketti.com.br ( http://www.rocketti.com.br )
 * 
 * @copyright  	Copyright 2017 RocketTi Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.util;

import java.util.InputMismatchException;

public class CPFUtils {

	public static boolean isCPF(String CPF) {
		CPF = CPF.replace(".", "").replace("-", "");
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || 				// considera-se erro CPF's formados por uma sequencia de numeros iguais
				CPF.equals("22222222222") || CPF.equals("33333333333") ||
		        CPF.equals("44444444444") || CPF.equals("55555555555") ||
		        CPF.equals("66666666666") || CPF.equals("77777777777") ||
		        CPF.equals("88888888888") || CPF.equals("99999999999") ||
		        CPF.length() != 11){
			return false;
		}
		char dig10, dig11;
		int sm, i, r, num, peso;
		try {																		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
			sm = 0;																	// Calculo do 1o. Digito Verificador
			peso = 10;
			for (i=0; i<9; i++) {              
				num = CPF.charAt(i) - 48; 									// converte o i-esimo caractere do CPF em um numero: por exemplo, transforma o 
		        sm = sm + (num * peso);												// caractere '0' no inteiro 0 (48 eh a posicao de '0' na tabela ASCII) 
		        peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if (r == 10 || r == 11){
				dig10 = '0';
			}else{
				dig10 = (char)(r + 48); 											// converte no respectivo caractere numerico
			}
			sm = 0;																	// Calculo do 2o. Digito Verificador
		    peso = 11;
		    for(i=0; i<10; i++) {
		    	num = CPF.charAt(i) - 48;
		        sm = sm + (num * peso);
		        peso = peso - 1;
		    }
		    r = 11 - (sm % 11);
		    if (r == 10 || r == 11){
		         dig11 = '0';
		    }else{
		    	dig11 = (char)(r + 48);
		    }
		    if (dig10 == CPF.charAt(9) && dig11 == CPF.charAt(10)){      		// Verifica se os digitos calculados conferem com os digitos informados.
		         return true;
		    }else {
		    	return false;
		    }
		} catch (InputMismatchException erro) {
		    return false;
		}
	}
}
	

