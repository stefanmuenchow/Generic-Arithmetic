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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidParameterException;

import com.stefanmuenchow.arithmetic.operation.BinaryOperation;
import com.stefanmuenchow.arithmetic.operation.Operations;
import com.stefanmuenchow.arithmetic.operation.UnaryOperation;

/**
 * Provides generic arithmetic for all subclasses of class {@link Number}.
 *  
 * @author Stefan Münchow
 */
public class Arithmetic<X extends Number> {
	private Class<? extends Number> targetClass;
	private X value;
	
	public Arithmetic(X value) {
		this.targetClass = value.getClass();
		this.value = value;
	}
	
	public X value() {
		return value;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> add(A operand) {
		value = binaryOperation(value, operand, Operations.getAddition());
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> sub(A operand) {
		value = binaryOperation(value, operand, Operations.getSubtraction());
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> div(A operand) {
		value = binaryOperation(value, operand, Operations.getDivision());
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> mul(A operand) {
		value = binaryOperation(value, operand, Operations.getMultiplication());
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> max(A operand) {
		value = binaryOperation(value, operand, Operations.getMaximum());
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> min(A operand) {
		value = binaryOperation(value, operand, Operations.getMinimum());
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> abs() {
		value = unaryOperation(value, Operations.getAbsolute());
		return this;
	}
	
	public <A extends Number, B extends Number> Arithmetic<X> neg() {
		value = unaryOperation(value, Operations.getNegation());
		return this;
	}
	
	@SuppressWarnings({ "unchecked" })
	private <A extends Number, B extends Number> X binaryOperation(A operand1, B operand2, BinaryOperation operation) {
		X value1 = convertNumber(operand1);
		X value2 = convertNumber(operand2);
		
		if (targetClass.equals(Integer.class)) {
			return (X) operation.apply((Integer) value1, (Integer) value2);
		} else if (targetClass.equals(Long.class)) {
			return (X) operation.apply((Long) value1, (Long) value2);
		} else if (targetClass.equals(Short.class)) {
			return (X) operation.apply((Short) value1, (Short) value2);
		} else if (targetClass.equals(Byte.class)) {
			return (X) operation.apply((Byte) value1, (Byte) value2);
		} else if (targetClass.equals(Double.class)) {
			return (X) operation.apply((Double) value1, (Double) value2);
		} else if (targetClass.equals(Float.class)) {
			return (X) operation.apply((Float) value1, (Float) value2);
		} else if (targetClass.equals(BigInteger.class)) {
			return (X) operation.apply((BigInteger) value1, (BigInteger) value2);
		} else if (targetClass.equals(BigDecimal.class)) {
			return (X) operation.apply((BigDecimal) value1, (BigDecimal) value2);
		} else {
			throw new InvalidParameterException("One of the parameters is of an invalid class");
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	private <A extends Number> X unaryOperation(A operand, UnaryOperation operation) {
		X value1 = convertNumber(operand);
		
		if (targetClass.equals(Integer.class)) {
			return (X) operation.apply((Integer) value1);
		} else if (targetClass.equals(Long.class)) {
			return (X) operation.apply((Long) value1);
		} else if (targetClass.equals(Short.class)) {
			return (X) operation.apply((Short) value1);
		} else if (targetClass.equals(Byte.class)) {
			return (X) operation.apply((Byte) value1);
		} else if (targetClass.equals(Double.class)) {
			return (X) operation.apply((Double) value1);
		} else if (targetClass.equals(Float.class)) {
			return (X) operation.apply((Float) value1);
		} else if (targetClass.equals(BigInteger.class)) {
			return (X) operation.apply((BigInteger) value1);
		} else if (targetClass.equals(BigDecimal.class)) {
			return (X) operation.apply((BigDecimal) value1);
		} else {
			throw new InvalidParameterException("One of the parameters is of an invalid class");
		}
	}
	
	private X convertNumber(Number n) {
		return TypeConverter.convertNumber(n, targetClass);
	}
}
