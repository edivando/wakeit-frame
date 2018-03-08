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

public class CNPJUtils {

	// 33.377.144/0001-10
	public static boolean isCNPJ(String CNPJ) {
		CNPJ = CNPJ.replace(".", "").replace("/", "").replace("-", "");
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||			// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
			CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
		    CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
		    CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
		    CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
		    CNPJ.length() != 14){
			return false;
		}
	    char dig13, dig14;
	    int sm, i, r, num, peso;

	    try {																			// "try" - protege o código para eventuais erros de conversao de tipo (int)
	    	sm = 0;																		// Calculo do 1o. Digito Verificador
	    	peso = 2;
	    	for (i=11; i>=0; i--) {														// converte o i-ésimo caractere do CNPJ em um número: por exemplo, transforma o 
	    		num = CNPJ.charAt(i) - 48;										// caractere '0' no inteiro 0 (48 eh a posição de '0' na tabela ASCII)
		        sm = sm + (num * peso);
		        peso = peso + 1;
		        if (peso == 10){
		        	peso = 2;
		        }
	    	}
	    	r = sm % 11;
	    	if (r == 0 || r == 1){
	    		dig13 = '0';
	    	}else{
	    		dig13 = (char)((11-r) + 48);
	    	}

	    	sm = 0;																		// Calculo do 2o. Digito Verificador
	    	peso = 2;
	    	for (i=12; i>=0; i--) {
	    		num = CNPJ.charAt(i)- 48;
	    		sm = sm + (num * peso);
	    		peso = peso + 1;
	    		if (peso == 10){
	    			peso = 2;
	    		}
	    	}
	    	r = sm % 11;
	    	if (r == 0 || r == 1){
	    		dig14 = '0';
	    	}else {
	    		dig14 = (char)((11-r) + 48);
	    	}
	    	if (dig13 == CNPJ.charAt(12) && dig14 == CNPJ.charAt(13)){					// Verifica se os dígitos calculados conferem com os dígitos informados.
	    		return true;
	    	}else{
	    		return false;
	    	}
	    } catch (InputMismatchException erro) {
		   return false;
	    }
	}

}
