/**
 * Copyright (c) Stefan Münchow. All rights reserved.
 * 
 * The use and distribution terms for this software are covered by the
 * Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 * which can be found in the file epl-v10.html at the root of this distribution.
 * By using this software in any fashion, you are agreeing to be bound by
 * the terms of this license.
 * You must not remove this notice, or any other, from this software.
 **/

package com.stefanmuenchow.arithmetic;

import com.stefanmuenchow.arithmetic.converter.ConverterRepository;
import com.stefanmuenchow.arithmetic.operation.OperationsRepository;

/**
 * Provides generic arithmetic for all subclasses of class {@link Number}.
 *  
 * @author Stefan Münchow
 * @author Matthias Stevens
 *
 * @param <X> target type
 */
public class Arithmetic<X extends Number> {
	private Class<X> targetClass;
	private X value;
	
	/**
	 * Adds a new target type for generic Arithmetic. After this method is called once,
	 * the new target type is known by all newly created {@link Arithmetic} instances.
	 * 
	 * @param <Y>			Target type
	 * @param targetType	Class object of target type
	 * @param converter		{@link TypeConverter} for target type
	 * @param operations	{@link Operations} for target type
	 */
	public static <Y extends Number> void addTargetType(Class<Y> targetType, 
			TypeConverter<Y> converter, Operations<Y> operations) {
		ConverterRepository.getInstance().addConverter(targetType, converter);
		OperationsRepository.getInstance().addOperations(targetType, operations);
	}
	
	/**
	 * Create a new instance with initial value.
	 * 
	 * @param value	Initial value
	 */
    @SuppressWarnings("unchecked")
	public Arithmetic(X value) {
		this.targetClass = (Class<X>) value.getClass();
		this.value = value;
	}
	
	/**
	 * Return current value of this instance.
	 * @return	Current value of type X.
	 */
	public X value() {
		return value;
	}
	
	/**
	 * Add operand to current value of this instance.
	 * 
	 * @param <A>		Operand type
	 * @param operand	Operand value
	 * @return			{@link Arithmetic} with modified value
	 */
	public <A extends Number> Arithmetic<X> add(A operand) {
		value = getOperations().add(value, convertNumber(operand));
		return this;
	}
	
	/**
	 * Subtract operand from current value of this instance.
	 * 
	 * @param <A>		Operand type
	 * @param operand	Operand value
	 * @return			{@link Arithmetic} with modified value
	 */
	public <A extends Number> Arithmetic<X> sub(A operand) {
		value = getOperations().sub(value, convertNumber(operand));
		return this;
	}
	
	/**
	 * Divide current value of this instance by operand.
	 * 
	 * @param <A>		Operand type
	 * @param operand	Operand value
	 * @return			{@link Arithmetic} with modified value
	 */
	public <A extends Number> Arithmetic<X> div(A operand) {
		value = getOperations().div(value, convertNumber(operand));
		return this;
	}
	
	/**
	 * Multiply current value of this instance with operand.
	 * 
	 * @param <A>		Operand type
	 * @param operand	Operand value
	 * @return			{@link Arithmetic} with modified value
	 */
	public <A extends Number> Arithmetic<X> mul(A operand) {
		value = getOperations().mul(value, convertNumber(operand));
		return this;
	}
	
	/**
	 * Return maximum value of current value of this instance and operand.
	 * 
	 * @param <A>		Operand type
	 * @param operand	Operand value
	 * @return			{@link Arithmetic} with maximum as new value
	 */
	public <A extends Number> Arithmetic<X> max(A operand) {
		value = getOperations().max(value, convertNumber(operand));
		return this;
	}
	
	/**
	 * Return minimum value of current value of this instance and operand.
	 * 
	 * @param <A>		Operand type
	 * @param operand	Operand value
	 * @return			{@link Arithmetic} with minimum as new value
	 */
	public <A extends Number> Arithmetic<X> min(A operand) {
		value = getOperations().min(value, convertNumber(operand));
		return this;
	}
	
	/**
	 * Create absolute of the current value of this instance.
	 * 
	 * @return			{@link Arithmetic} with absolute value
	 */
	public Arithmetic<X> abs() {
		value = getOperations().abs(value);
		return this;
	}
	
	/**
	 * Negate the current value of this instance.
	 * 
	 * @return			{@link Arithmetic} with negated value
	 */
	public Arithmetic<X> neg() {
		value = getOperations().neg(value);
		return this;
	}

	private transient TypeConverter<X> converter;
	
	private X convertNumber(Number n) {
		if(converter == null)
			converter = ConverterRepository.getInstance().getConverter(targetClass);
		return converter.convertNumber(n);
	}
	
	private transient Operations<X> operations;
	
	private Operations<X> getOperations() {
		if(operations == null)
			operations = OperationsRepository.getInstance().getOperations(targetClass);
		return operations;
	}
	
}
