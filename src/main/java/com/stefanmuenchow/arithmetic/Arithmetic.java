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
import com.stefanmuenchow.arithmetic.converter.TypeConverter;
import com.stefanmuenchow.arithmetic.operation.OperationsRepository;
import com.stefanmuenchow.arithmetic.operation.Operations;

/**
 * Provides generic arithmetic for all subclasses of class {@link Number}.
 *  
 * @author Stefan Münchow
 */
public class Arithmetic<X extends Number> {
	private Class<? extends Number> targetClass;
	private X value;
	
	public static <Y extends Number> void addTargetType(Class<Y> targetType, 
			TypeConverter<Y> converter, Operations<Y> operations) {
		ConverterRepository.getInstance().addConverter(targetType, converter);
		OperationsRepository.getInstance().addOperations(targetType, operations);
	}
	
	public Arithmetic(X value) {
		this.targetClass = value.getClass();
		this.value = value;
	}
	
	public X value() {
		return value;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> add(A operand) {
		value = getOperations().add(value, convertNumber(operand));
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> sub(A operand) {
		value = getOperations().sub(value, convertNumber(operand));
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> div(A operand) {
		value = getOperations().div(value, convertNumber(operand));
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> mul(A operand) {
		value = getOperations().mul(value, convertNumber(operand));
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> max(A operand) {
		value = getOperations().max(value, convertNumber(operand));
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> min(A operand) {
		value = getOperations().min(value, convertNumber(operand));
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> abs() {
		value = getOperations().abs(value);
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> neg() {
		value = getOperations().neg(value);
		return this;
	}
	
	@SuppressWarnings("unchecked")
	private X convertNumber(Number n) {
		return (X) ConverterRepository.getInstance().getConverter(targetClass).convertNumber(n);
	}
	
	@SuppressWarnings("unchecked")
	private Operations<X> getOperations() {
		return (Operations<X>) OperationsRepository.getInstance().getOperations(targetClass);
	}
}
