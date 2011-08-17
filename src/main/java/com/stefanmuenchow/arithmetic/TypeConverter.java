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
import java.util.HashMap;
import java.util.Map;

/**
 * Converts objects from subclasses of {@link Number} to a specified target class.
 * The target class must be a subclass of {@link Number} likewise.
 * 
 * @author Stefan Münchow
 */
class TypeConverter {
	private static final Map<Class<?>, String> converterMethods;
	
	static {
		converterMethods = new HashMap<Class<?>, String>();
		converterMethods.put(Short.class, "shortValue");
		converterMethods.put(Byte.class, "byteValue");
		converterMethods.put(Integer.class, "intValue");
		converterMethods.put(Long.class, "longValue");
		converterMethods.put(Float.class, "floatValue");
		converterMethods.put(Double.class, "doubleValue");
	}
	
	private TypeConverter() {
	}
	
	@SuppressWarnings("unchecked")
	static <X extends Number> X convertNumber(Number n, Class<? extends Number> targetClass) {
		X result = null;
		
		if(n.getClass().equals(targetClass)) { // No conversion needed
			return (X) n;
		}
		
		if(targetClass.equals(BigInteger.class)) {
			result = (X) new BigInteger(Long.valueOf(n.longValue()).toString());
		} else if (targetClass.equals(BigDecimal.class)) {
			result = (X) new BigDecimal(n.doubleValue());
		} else {
			result = convertGenericType(n, targetClass);
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private static <X extends Number> X convertGenericType(Number n, Class<? extends Number> targetClass) {
		String converterMethod = converterMethods.get(targetClass);
		X result = null;
		
		try {
			result = (X) n.getClass().getMethod(converterMethod).invoke(n);
		} catch (Exception e) {
			throw new ArithmeticException("Error while converting types");
		}
		
		return result;
	}
}
