package org.wakeit.frame.util.validation;

import java.util.ArrayList;
import java.util.List;

import org.wakeit.frame.util.validation.exception.ValidationException;
import org.wakeit.frame.util.validation.exception.ValidatorException;;

public class Validation {

	private List<ValidatorException> excecoes = new ArrayList<ValidatorException>();

	public Validator nova(String mensagemErro){
		return new Validator(mensagemErro, this);
	}
	
	protected void adicionarExcecao(ValidatorException excecao){
		this.excecoes.add(excecao);
	}
	
	public boolean finalizarValidacao() throws ValidationException{
		if(excecoes.size() > 0){
			throw new ValidationException(excecoes);
		}
		return true;
	}
	
	
}
