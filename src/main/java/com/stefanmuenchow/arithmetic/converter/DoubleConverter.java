package com.stefanmuenchow.arithmetic.converter;

import com.stefanmuenchow.arithmetic.TypeConverter;

public class DoubleConverter implements TypeConverter<Double> {

	@Override
	public Double convertNumber(Number n) {
		return n.doubleValue();
	}
}
