package com.stefanmuenchow.arithmetic.converter;

public class FloatConverter implements TypeConverter<Float> {

	@Override
	public Float convertNumber(Number n) {
		return n.floatValue();
	}
}
