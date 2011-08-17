package com.stefanmuenchow.arithmetic.converter;

public class ByteConverter implements TypeConverter<Byte> {

	@Override
	public Byte convertNumber(Number n) {
		return n.byteValue();
	}
}