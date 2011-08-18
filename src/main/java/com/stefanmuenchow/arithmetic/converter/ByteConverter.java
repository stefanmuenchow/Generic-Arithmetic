package com.stefanmuenchow.arithmetic.converter;

import com.stefanmuenchow.arithmetic.TypeConverter;

public class ByteConverter implements TypeConverter<Byte> {

	@Override
	public Byte convertNumber(Number n) {
		return n.byteValue();
	}
}