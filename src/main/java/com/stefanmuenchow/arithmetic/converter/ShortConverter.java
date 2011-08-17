package com.stefanmuenchow.arithmetic.converter;

public class ShortConverter implements TypeConverter<Short> {

	@Override
	public Short convertNumber(Number n) {
		return n.shortValue();
	}
}
