package org.wakeit.frame.util.validation;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.wakeit.frame.util.validation.exception.ValidationException;
import org.wakeit.frame.util.validation.exception.ValidatorException;

/**
 * s548-Proagro2EJB - Validator
 *
 * @author Edivando Alves D001166
 * @date 05/01/2018 09:45:05
 *
 */
public class Validator {
	
	private final String mensageError;
	
	private Validation validation;
	private boolean deveAgruparErros = false;
	
	public Validator(final String mensageError) {
		this.mensageError = mensageError;
	}
	
	public Validator(final String mensagemErro, Validation validation) {
		this.mensageError = mensagemErro;
		this.validation = validation;
		this.deveAgruparErros = true;
	}
	
	public StringValidador se(final String value) {
		return new StringValidador(mensageError, value);
	}
	
	public IntegerValidador se(final Integer value) {
		return new IntegerValidador(mensageError, value);
	}
	
	public BigDecimalValidador se(final BigDecimal value) {
		return new BigDecimalValidador(mensageError, value);
	}
	
	public LongValidador se(final Long value) {
		return new LongValidador(mensageError, value);
	}
	
	public DateValidador se(final Date value) {
		return new DateValidador(mensageError, value);
	}
	
	public ObjectValidador se(Object value){
		return new ObjectValidador(mensageError, value);
	}
	
	
	interface BaseValidador<E, T> {
		T naoEVazio() throws ValidatorException;
		T eIgualA(final E valueEquals) throws ValidatorException;
	}
	
	interface NumerosValidador<E, T> extends BaseValidador<E, T> {
		T eMaiorQue(final E value) throws ValidatorException;
		T eMaiorOuIgualA(final E value) throws ValidatorException;
		T eMenorQue(final E value) throws ValidatorException;
		T eMenorOuIgualA(final E value) throws ValidatorException;
	}
	
	interface CalculoValidador<E, T> extends NumerosValidador<E, T> {
		T menos(final E menosValor);
		T mais(final E maisValor);
		T vezes(final E vezesValor);
		T dividido(final E divididoValor);
	}
	
	interface DataValidador<E, T> extends NumerosValidador<E, T> {
		T menos(final E menosData);
		LongValidador emHoras();
		LongValidador emDias();
	}
	
	abstract class AbstractValidador<E, T> implements BaseValidador<E, T>{
		
		private static final String ERRO_ATRIBUTO_NULO = "Campo Nulo!";
		protected E valor;
		private final String mensagemErro;
		
		public AbstractValidador(final String mensagemErro, final E valor) {
			this.mensagemErro = mensagemErro;
			this.valor = valor;
		}
		
		@SuppressWarnings("unchecked")
		public T throwException(final boolean valid) throws ValidatorException {
			if(valid){
				ValidatorException exception = new ValidatorException(mensagemErro);
				
				if(deveAgruparErros){
					validation.adicionarExcecao(exception);
				}else{
					throw exception;
				}
			}
			return (T) this;
		}
		
		protected boolean isNotNull(final Object...objs) throws ValidatorException {
			for (Object object : objs) {
				if(object == null){
					throw new ValidatorException(ERRO_ATRIBUTO_NULO);
				}
			}
			return true;
		}
		
		public E getValor() {
			return valor;
		}
		
		public Validator nova(String mensagemErro){
			return validation.nova(mensagemErro);
		}
		
		public boolean finalizarValidacao() throws ValidationException{
			return validation.finalizarValidacao();
		}
	}
	

		
	public class IntegerValidador extends AbstractValidador<Integer, IntegerValidador> 
		implements CalculoValidador<Integer, IntegerValidador> {

		public IntegerValidador(final String mensagemErro, final Integer valor) {
			super(mensagemErro, valor);
		}
		
		@Override
		public IntegerValidador naoEVazio() throws ValidatorException {
			return throwException(isNotNull(valor) && valor != 0);
		}
		
		@Override
		public IntegerValidador eIgualA(final Integer valueEquals) throws ValidatorException {
			return throwException(isNotNull(valor, valueEquals) && valor == valueEquals);
		}
		
		@Override
		public IntegerValidador eMaiorQue(final Integer value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor > value);
		}
		
		@Override
		public IntegerValidador eMaiorOuIgualA(final Integer value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor >= value);
		}
		
		@Override
		public IntegerValidador eMenorQue(final Integer value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor < value);
		}
		
		@Override
		public IntegerValidador eMenorOuIgualA(final Integer value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor <= value);
		}
		
		@Override
		public IntegerValidador mais(final Integer maisValor) {
			this.valor = this.valor + maisValor;
			return this;
		}
		
		@Override
		public IntegerValidador menos(final Integer menosValor) {
			this.valor = this.valor - menosValor;
			return this;
		}
		
		@Override
		public IntegerValidador vezes(final Integer vezesValor) {
			this.valor = this.valor * vezesValor;
			return this;
		}
		
		@Override
		public IntegerValidador dividido(final Integer divididoValor) {
			this.valor = this.valor * divididoValor;
			return this;
		}
	}
		
	public class BigDecimalValidador extends AbstractValidador<BigDecimal, BigDecimalValidador> 
		implements NumerosValidador<BigDecimal, BigDecimalValidador> {

		public BigDecimalValidador(final String mensagemErro, final BigDecimal value) {
			super(mensagemErro, value);
		}

		@Override
		public BigDecimalValidador naoEVazio() throws ValidatorException {
			return throwException(isNotNull(valor) && valor != BigDecimal.ZERO);
		}

		@Override
		public BigDecimalValidador eIgualA(final BigDecimal valueEquals) throws ValidatorException {
			return throwException(isNotNull(valor, valueEquals) && valor.compareTo(valueEquals) == 0);
		}
		
		@Override
		public BigDecimalValidador eMaiorQue(final BigDecimal value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor.doubleValue() > value.doubleValue());
		}

		@Override
		public BigDecimalValidador eMaiorOuIgualA(final BigDecimal value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor.doubleValue() >= value.doubleValue());
		}

		@Override
		public BigDecimalValidador eMenorQue(final BigDecimal value)
				throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor.doubleValue() < value.doubleValue());
		}

		@Override
		public BigDecimalValidador eMenorOuIgualA(final BigDecimal value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor.doubleValue() <= value.doubleValue());
		}
	}
	
	public class LongValidador extends AbstractValidador<Long, LongValidador> 
		implements NumerosValidador<Long, LongValidador> {

		public LongValidador(final String mensagemErro, final Long value) {
			super(mensagemErro, value);
		}
		
		@Override
		public LongValidador naoEVazio() throws ValidatorException {
			return throwException(isNotNull(valor) && valor != 0);
		}

		@Override
		public LongValidador eIgualA(final Long valueEquals) throws ValidatorException {
			return throwException(isNotNull(valor, valueEquals) && valor == valueEquals);
		}
		
		@Override
		public LongValidador eMaiorQue(final Long value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor > value);
		}

		@Override
		public LongValidador eMaiorOuIgualA(final Long value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor >= value);
		}

		@Override
		public LongValidador eMenorQue(final Long value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor < value);
		}

		@Override
		public LongValidador eMenorOuIgualA(final Long value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor <= value);
		}
	}
	
	public class DateValidador extends AbstractValidador<Date, DateValidador> 
		implements DataValidador<Date, DateValidador> {

		private long menosTime = 0;
		
		public DateValidador(final String mensagemErro, final Date value) {
			super(mensagemErro, value);
		}
		
		@Override
		public DateValidador naoEVazio() throws ValidatorException {
			return throwException(valor != null);
		}

		@Override
		public DateValidador eIgualA(final Date valueEquals) throws ValidatorException {
			return throwException(isNotNull(valor, valueEquals) && valor.getTime() == valueEquals.getTime());
		}
		
		@Override
		public DateValidador eMaiorQue(final Date value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor.getTime() > value.getTime());
		}

		@Override
		public DateValidador eMaiorOuIgualA(final Date value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor.getTime() >= value.getTime());
		}

		@Override
		public DateValidador eMenorQue(final Date value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor.getTime() < value.getTime());
		}

		@Override
		public DateValidador eMenorOuIgualA(final Date value) throws ValidatorException {
			return throwException(isNotNull(valor, value) && valor.getTime() <= value.getTime());
		}
		
		@Override
		public DateValidador menos(Date menosData) {
			this.menosTime = this.valor.getTime() - menosData.getTime();
			return this;
		}
		
		@Override
		public LongValidador emHoras() {
			return new LongValidador(mensageError, menosTime / 3600000L);
		}
		
		@Override
		public LongValidador emDias() {
			return new LongValidador(mensageError, menosTime / 86400000L);
		}
	}
	
	public class StringValidador extends AbstractValidador<String, StringValidador> 
		implements BaseValidador<String, StringValidador>{

		public StringValidador(final String mensagemErro, final String valor) {
			super(mensagemErro, valor);
		}
		
		@Override
		public StringValidador naoEVazio() throws ValidatorException {
			return throwException(!StringUtils.isEmpty(valor));
		}
		
		@Override
		public StringValidador eIgualA(final String valueEquals) throws ValidatorException {
			return throwException(isNotNull(valor, valueEquals) && valor.equals(valueEquals));
		}
	}
	
	public class ObjectValidador extends AbstractValidador<Object, ObjectValidador> 
		implements BaseValidador<Object, ObjectValidador>{
		
		public ObjectValidador(final String mensagemErro, final Object valor) {
			super(mensagemErro, valor);
		}
		
		@Override
		public ObjectValidador naoEVazio() throws ValidatorException {
			Field[] fields = valor.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				try {
					throwException(field.get(valor) == null);
				} catch (IllegalArgumentException e) {
					continue;
				} catch (IllegalAccessException e) {
					continue;
				}
			}
			return this;
		}
		
		@Override
		public ObjectValidador eIgualA(final Object valueEquals) throws ValidatorException {
			return this;
		}
		
	}
	
	
}
