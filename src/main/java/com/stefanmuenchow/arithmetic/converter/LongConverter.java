package com.stefanmuenchow.arithmetic.converter;

import com.stefanmuenchow.arithmetic.TypeConverter;

public class LongConverter implements TypeConverter<Long> {

	@Override
	public Long convertNumber(Number n) {
		return n.longValue();
	}
}
