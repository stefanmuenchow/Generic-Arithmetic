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

package com.stefanmuenchow.arithmetic.converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.stefanmuenchow.arithmetic.TypeConverter;


/**
 * Converts objects from subclasses of {@link Number} to a specified target class.
 * The target class must be a subclass of {@link Number} likewise.
 * 
 * @author Stefan Münchow
 */
public class ConverterRepository {
	private static ConverterRepository instance;
	private final Map<Class<?>, TypeConverter<?>> converters;
	
	public static ConverterRepository getInstance() {
		if (instance == null) {
			instance = new ConverterRepository();
		}
		
		return instance;
	}
	
	private ConverterRepository() {
		converters = new HashMap<Class<?>, TypeConverter<?>>();
		converters.put(Short.class, new ShortConverter());
		converters.put(Byte.class, new ByteConverter());
		converters.put(Integer.class, new IntegerConverter());
		converters.put(Long.class, new LongConverter());
		converters.put(Float.class, new FloatConverter());
		converters.put(Double.class, new DoubleConverter());
		converters.put(BigInteger.class, new BigIntegerConverter());
		converters.put(BigDecimal.class, new BigDecimalConverter());
	}
	
	@SuppressWarnings("unchecked")
	public <X extends Number> TypeConverter<X> getConverter(Class<X> targetClass) {
		TypeConverter<X> result = (TypeConverter<X>) converters.get(targetClass);
		
		if (result == null) {
			throw new ArithmeticException("No converter for class " + targetClass + " found!");
		} else {
			return result;
		}
	}
	
	public <X extends Number> void addConverter(Class<X> targetClass, TypeConverter<X> converter) {
		converters.put(targetClass, converter);
	}
}
