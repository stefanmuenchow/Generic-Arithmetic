package com.stefanmuenchow.arithmetic.converter;

public class DoubleConverter implements TypeConverter<Double> {

	@Override
	public Double convertNumber(Number n) {
		return n.doubleValue();
	}
}
