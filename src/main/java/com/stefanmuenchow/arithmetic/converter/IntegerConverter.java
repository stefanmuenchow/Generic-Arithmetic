package com.stefanmuenchow.arithmetic.converter;

import com.stefanmuenchow.arithmetic.TypeConverter;

public class IntegerConverter implements TypeConverter<Integer> {

	@Override
	public Integer convertNumber(Number n) {
		return n.intValue();
	}
}
