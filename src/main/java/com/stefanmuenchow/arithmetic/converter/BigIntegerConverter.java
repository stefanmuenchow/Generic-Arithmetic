package com.stefanmuenchow.arithmetic.converter;

import java.math.BigInteger;

import com.stefanmuenchow.arithmetic.TypeConverter;

public class BigIntegerConverter implements TypeConverter<BigInteger> {

	@Override
	public BigInteger convertNumber(Number n) {
		return new BigInteger(Long.valueOf(n.longValue()).toString());
	}
}
