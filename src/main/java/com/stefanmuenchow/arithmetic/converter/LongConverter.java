package com.stefanmuenchow.arithmetic.converter;

public class LongConverter implements TypeConverter<Long> {

	@Override
	public Long convertNumber(Number n) {
		return n.longValue();
	}
}
