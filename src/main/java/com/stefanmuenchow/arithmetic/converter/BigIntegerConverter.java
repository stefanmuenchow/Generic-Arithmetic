package com.stefanmuenchow.arithmetic.converter;

import java.math.BigInteger;

public class BigIntegerConverter implements TypeConverter<BigInteger> {

	@Override
	public BigInteger convertNumber(Number n) {
		return new BigInteger(Long.valueOf(n.longValue()).toString());
	}
}
