package com.stefanmuenchow.arithmetic.converter;

import com.stefanmuenchow.arithmetic.TypeConverter;

public class FloatConverter implements TypeConverter<Float> {

	@Override
	public Float convertNumber(Number n) {
		return n.floatValue();
	}
}
