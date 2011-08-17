package com.stefanmuenchow.arithmetic.converter;

public class IntegerConverter implements TypeConverter<Integer> {

	@Override
	public Integer convertNumber(Number n) {
		return n.intValue();
	}
}
