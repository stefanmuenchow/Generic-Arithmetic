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
import com.stefanmuenchow.arithmetic.operation.OperationRepository;
import com.stefanmuenchow.arithmetic.operation.UnaryOperation;

/**
 * Provides generic arithmetic for all subclasses of class {@link Number}.
 *  
 * @author Stefan Münchow
 */
public class Arithmetic<X extends Number> {
	private Class<X> targetClass;
	
	private Arithmetic(Class<X> targetClass) {
		this.targetClass = targetClass;
	}
	
	public static <Y extends Number> Arithmetic<Y> create(Class<Y> targetClass) {
		return new Arithmetic<Y>(targetClass);
	}
	
	public <A extends Number, B extends Number> X add(A a, B b) {
		return binaryOperation(a, b, OperationRepository.getAddition());
	}
	
	public <A extends Number, B extends Number> X sub(A a, B b) {
		return binaryOperation(a, b, OperationRepository.getSubtraction());
	}
	
	public <A extends Number, B extends Number> X div(A a, B b) {
		return binaryOperation(a, b, OperationRepository.getDivision());
	}
	
	public <A extends Number, B extends Number> X mul(A a, B b) {
		return binaryOperation(a, b, OperationRepository.getMultiplication());
	}
	
	public <A extends Number, B extends Number> X max(A a, B b) {
		return binaryOperation(a, b, OperationRepository.getMaximum());
	}
	
	public <A extends Number, B extends Number> X min(A a, B b) {
		return binaryOperation(a, b, OperationRepository.getMinimum());
	}
	
	public <A extends Number, B extends Number> X abs(A a) {
		return unaryOperation(a, OperationRepository.getAbsolute());
	}
	
	public <A extends Number, B extends Number> X neg(A a) {
		return unaryOperation(a, OperationRepository.getNegation());
	}
	
	@SuppressWarnings({ "unchecked" })
	private <A extends Number, B extends Number> X binaryOperation(A a, B b, BinaryOperation op) {
		X value1 = convertNumber(a);
		X value2 = convertNumber(b);
		
		if (targetClass.equals(Integer.class)) {
			return (X) op.apply((Integer) value1, (Integer) value2);
		} else if (targetClass.equals(Long.class)) {
			return (X) op.apply((Long) value1, (Long) value2);
		} else if (targetClass.equals(Short.class)) {
			return (X) op.apply((Short) value1, (Short) value2);
		} else if (targetClass.equals(Byte.class)) {
			return (X) op.apply((Byte) value1, (Byte) value2);
		} else if (targetClass.equals(Double.class)) {
			return (X) op.apply((Double) value1, (Double) value2);
		} else if (targetClass.equals(Float.class)) {
			return (X) op.apply((Float) value1, (Float) value2);
		} else if (targetClass.equals(BigInteger.class)) {
			return (X) op.apply((BigInteger) value1, (BigInteger) value2);
		} else if (targetClass.equals(BigDecimal.class)) {
			return (X) op.apply((BigDecimal) value1, (BigDecimal) value2);
		} else {
			throw new InvalidParameterException("One of the parameters is of an invalid class");
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	private <A extends Number> X unaryOperation(A a, UnaryOperation op) {
		X value1 = convertNumber(a);
		
		if (targetClass.equals(Integer.class)) {
			return (X) op.apply((Integer) value1);
		} else if (targetClass.equals(Long.class)) {
			return (X) op.apply((Long) value1);
		} else if (targetClass.equals(Short.class)) {
			return (X) op.apply((Short) value1);
		} else if (targetClass.equals(Byte.class)) {
			return (X) op.apply((Byte) value1);
		} else if (targetClass.equals(Double.class)) {
			return (X) op.apply((Double) value1);
		} else if (targetClass.equals(Float.class)) {
			return (X) op.apply((Float) value1);
		} else if (targetClass.equals(BigInteger.class)) {
			return (X) op.apply((BigInteger) value1);
		} else if (targetClass.equals(BigDecimal.class)) {
			return (X) op.apply((BigDecimal) value1);
		} else {
			throw new InvalidParameterException("One of the parameters is of an invalid class");
		}
	}
	
	private X convertNumber(Number n) {
		return TypeConverter.convertNumber(n, targetClass);
	}
}
