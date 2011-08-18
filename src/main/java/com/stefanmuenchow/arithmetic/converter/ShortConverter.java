package com.stefanmuenchow.arithmetic.converter;

import com.stefanmuenchow.arithmetic.TypeConverter;

public class ShortConverter implements TypeConverter<Short> {

	@Override
	public Short convertNumber(Number n) {
		return n.shortValue();
	}
}
